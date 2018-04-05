package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.ContadorSerieNumeroPEModel;
import org.openfact.pe.models.ContadorSerieNumeroPEProvider;
import org.openfact.pe.models.jpa.entities.ContadorSerieNumeroEntity;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Transactional
@ApplicationScoped
public class JpaContadorSerieNumeroProvider implements ContadorSerieNumeroPEProvider {

    private static final Pattern SERIE_PATTERN = Pattern.compile("[a-zA-Z]{1,}[0-9]{1,}");

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.numero_maximo")
    private Optional<Integer> NUMERO_MAXIMO;

    private Optional<ContadorSerieNumeroEntity> getPresente(OrganizationModel organizacion, String tipoDocumento, String serie) {
        TypedQuery<ContadorSerieNumeroEntity> q = em.createNamedQuery("getContadorByOrganizacionIdTipoDocumentoAndSerie", ContadorSerieNumeroEntity.class);
        q.setParameter("organizacionId", organizacion.getId());
        q.setParameter("tipoDocumento", tipoDocumento);
        q.setParameter("serie", serie);
        List<ContadorSerieNumeroEntity> resultList = q.getResultList();
        if (resultList.size() == 1) {
            return Optional.of(resultList.get(0));
        } else if (resultList.isEmpty()) {
            return Optional.empty();
        } else {
            throw new IllegalStateException("Mas de un contador organizacion:" + organizacion.getId() + " tipoDocumento:" + tipoDocumento + " serie:" + serie);
        }
    }

    @Override
    public ContadorSerieNumeroPEModel getSiguiente(OrganizationModel organization, String tipoDocumento, String serie) {
        if (!SERIE_PATTERN.matcher(serie).matches()) {
            throw new IllegalStateException("Serie no cumple patron:" + SERIE_PATTERN.toString());
        }

        Optional<ContadorSerieNumeroEntity> optional = getPresente(organization, tipoDocumento, serie);
        if (optional.isPresent()) {
            ContadorSerieNumeroEntity entity = optional.get();
            int numeroActual = entity.getNumero();
            if (NUMERO_MAXIMO.orElse(99_999_999) > numeroActual) {
                entity.setNumero(numeroActual + 1);
                em.merge(entity);
                em.flush();
                return new ContadorSerieNumeroAdapter(em, entity);
            } else {
                String prefijo = entity.getPrefijo();
                int nuevoNumeroSerie = entity.getNumeroSerie() + 1;
                String nuevaSerie = prefijo + nuevoNumeroSerie;
                return getSiguiente(organization, tipoDocumento, nuevaSerie);
            }
        } else {
            ContadorSerieNumeroEntity entity = new ContadorSerieNumeroEntity();
            entity.setId(ModelUtils.generateId());
            entity.setTipoDocumento(tipoDocumento);
            entity.setSerie(serie);
            entity.setNumero(1);
            entity.setOrganizacion(OrganizationAdapter.toEntity(organization, em));
            em.persist(entity);
            em.flush();
            return new ContadorSerieNumeroAdapter(em, entity);
        }
    }
}
