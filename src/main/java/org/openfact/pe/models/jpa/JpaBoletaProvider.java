package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.BoletaProvider;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.jpa.entities.BoletaEntity;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Transactional
@ApplicationScoped
public class JpaBoletaProvider implements BoletaProvider {

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.numero_maximo_por_serie")
    private Optional<Integer> NUMERO_MAXIMO_POR_SERIE;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.boletas.prefixo")
    private Optional<String> PREFIJO_BOLETAS;

    private BoletaModel toModel(BoletaEntity boletaEntity) {
        EstadoComprobantePago estado = boletaEntity.getEstado();
        switch (estado) {
            case BLOQUEADO:
                return new ReadOnlyBoletaAdapter(em, boletaEntity);
            default:
                return new BoletaAdapter(em, boletaEntity);
        }
    }

    private AbstractMap.SimpleEntry<String, Integer> siguienteSerieNumero(OrganizationModel organizacion, String serie) {
        TypedQuery<BoletaEntity> query1 = em.createNamedQuery("GetUltimaBoletaDeOrganizacionConSerie", BoletaEntity.class);
        query1.setParameter("organizacionId", organizacion);
        query1.setParameter("serie", serie);
        query1.setMaxResults(1);
        List<BoletaEntity> resultList1 = query1.getResultList();

        Optional<BoletaEntity> ultimo = JpaUtils.getFirstResult(resultList1);
        if (ultimo.isPresent()) {
            BoletaEntity entity = ultimo.get();
            int siguienteNumero = entity.getNumero() + 1;
            if (NUMERO_MAXIMO_POR_SERIE.orElse(99_999_999) > siguienteNumero) {
                boolean siguienteNumeroEsValido = false;
                while (!siguienteNumeroEsValido) {
                    TypedQuery<BoletaEntity> query2 = em.createNamedQuery("GetBoletaEnOrganizationConSerieYNumero", BoletaEntity.class);
                    query2.setParameter("organizacionId", organizacion);
                    query2.setParameter("serie", serie);
                    query2.setParameter("numero", siguienteNumero);
                    query2.setMaxResults(1);
                    List<BoletaEntity> resultList2 = query2.getResultList();
                    if (!resultList1.isEmpty()) {
                        siguienteNumero++;
                    } else {
                        siguienteNumeroEsValido = true;
                    }
                }
                return new AbstractMap.SimpleEntry<>(serie, siguienteNumero);
            } else {
                Pattern pattern = Pattern.compile("[0-9]{1,}");
                Matcher matcher = pattern.matcher(serie);
                String numeroSerie = null;
                while (matcher.find()) {
                    numeroSerie = matcher.group();
                }
                if (numeroSerie == null) {
                    throw new IllegalStateException("Serie Invalida, no se pudo extraer el Numero de Serie");
                }

                String prefijoSerie = serie.replaceFirst(serie, "");
                String nuevaSerie = prefijoSerie + (Integer.parseInt(numeroSerie) + 1);
                return siguienteSerieNumero(organizacion, nuevaSerie);
            }
        } else {
            return new AbstractMap.SimpleEntry<>(serie, 1);
        }
    }

    @Override
    public synchronized BoletaModel createBoleta(OrganizationModel organizacion) {
        return null;
    }

    @Override
    public synchronized BoletaModel createBoleta(OrganizationModel organizacion, String serie) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organizacion, serie);
        return createBoleta(organizacion, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public BoletaModel createBoleta(OrganizationModel organizacion, String serie, int numero) {
        BoletaEntity entity = new BoletaEntity();
        entity.setId(ModelUtils.generateId());
        entity.setSerie(serie);
        entity.setNumero(numero);
        entity.setEstado(EstadoComprobantePago.DESBLOQUEADO);
        entity.setCreatedAt(Calendar.getInstance().getTime());
        entity.setOrganizacion(OrganizationAdapter.toEntity(organizacion, em));

        em.persist(entity);
        em.flush();
        return toModel(entity);
    }

    @Override
    public Optional<BoletaModel> getBoletaFactura(OrganizationModel organizacion, String id) {
        TypedQuery<BoletaEntity> q = em.createNamedQuery("GetBoletaByOrganizationIdAndBoletaId", BoletaEntity.class);
        q.setParameter("organizacionId", organizacion);
        q.setParameter("boletaId", id);
        List<BoletaEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public boolean remove(OrganizationModel organizacion, BoletaModel boleta) {
        if (boleta.getEstado().equals(EstadoComprobantePago.BLOQUEADO)) return false;
        return false;
    }
}
