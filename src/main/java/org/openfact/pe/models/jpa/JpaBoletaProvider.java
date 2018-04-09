package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.BoletaProvider;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.jpa.entities.BoletaEntity;
import org.openfact.pe.models.types.TipoInvoice;
import org.openfact.pe.models.utils.SUNATUtils;
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
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class JpaBoletaProvider implements BoletaProvider {

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.numero_maximo_por_serie")
    private Optional<Integer> NUMERO_MAXIMO_POR_SERIE;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.boletas.prefijo")
    private Optional<String> PREFIJO_BOLETAS;

    private BoletaModel toModel(BoletaEntity boletaEntity) {
        EstadoComprobantePago estado = boletaEntity.getEstado();
        switch (estado) {
            case REGISTRADO:
                return new ReadOnlyBoletaAdapter(em, boletaEntity);
            default:
                return new BoletaAdapter(em, boletaEntity);
        }
    }

    private AbstractMap.SimpleEntry<String, Integer> siguienteSerieNumero(OrganizationModel organization, Optional<String> optionalSerie) {
        Optional<BoletaEntity> ultimoComprobante;
        if (!optionalSerie.isPresent()) {
            TypedQuery<BoletaEntity> query = em.createNamedQuery("getBoletasEmpezandoPorLasMasRecientes", BoletaEntity.class);
            query.setParameter("organizationId", organization.getId());
            query.setMaxResults(1);
            List<BoletaEntity> resultList = query.getResultList();
            ultimoComprobante = JpaUtils.getFirstResult(resultList);
        } else {
            TypedQuery<BoletaEntity> query = em.createNamedQuery("getBoletasConSerieEmpezandoPorLasMasRecientes", BoletaEntity.class);
            query.setParameter("organizationId", organization.getId());
            query.setParameter("serie", optionalSerie.get());
            query.setMaxResults(1);
            List<BoletaEntity> resultList = query.getResultList();
            ultimoComprobante = JpaUtils.getFirstResult(resultList);
        }

        if (ultimoComprobante.isPresent()) {
            BoletaEntity entity = ultimoComprobante.get();
            String ultimaSerie = entity.getSerie();
            int ultimoNumero = entity.getNumero();

            int siguienteNumero = ultimoNumero + 1;
            if (NUMERO_MAXIMO_POR_SERIE.orElse(99_999_999) > siguienteNumero) {
                boolean siguienteNumeroEsValido = false;
                while (!siguienteNumeroEsValido) {
                    TypedQuery<BoletaEntity> query = em.createNamedQuery("GetBoletaPorSerieYNumero", BoletaEntity.class);
                    query.setParameter("organizationId", organization.getId());
                    query.setParameter("serie", ultimaSerie);
                    query.setParameter("numero", siguienteNumero);
                    query.setMaxResults(1);
                    List<BoletaEntity> resultList = query.getResultList();
                    if (!resultList.isEmpty()) {
                        siguienteNumero++;
                    } else {
                        siguienteNumeroEsValido = true;
                    }
                }
                return new AbstractMap.SimpleEntry<>(ultimaSerie, siguienteNumero);
            } else {
                String nuevaSerie = SUNATUtils.incrementarSerie(ultimaSerie);
                return siguienteSerieNumero(organization, Optional.of(nuevaSerie));
            }
        } else {
            String serie;
            if (optionalSerie.isPresent()) {
                serie = optionalSerie.get();
            } else {
                serie = TipoInvoice.BOLETA.getPrefijo() + PREFIJO_BOLETAS.orElse("") + 1;
            }
            return new AbstractMap.SimpleEntry<>(serie, 1);
        }
    }

    @Override
    public synchronized BoletaModel createBoleta(OrganizationModel organization) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, Optional.empty());
        return createBoleta(organization, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public synchronized BoletaModel createBoleta(OrganizationModel organization, String serie) {
        AbstractMap.SimpleEntry<String, Integer> serieNumero = siguienteSerieNumero(organization, Optional.of(serie));
        return createBoleta(organization, serieNumero.getKey(), serieNumero.getValue());
    }

    @Override
    public BoletaModel createBoleta(OrganizationModel organization, String serie, int numero) {
        BoletaEntity entity = new BoletaEntity();
        entity.setId(ModelUtils.generateId());
        entity.setSerie(serie);
        entity.setNumero(numero);
        entity.setEstado(EstadoComprobantePago.NO_REGISTRADO);
        entity.setCreatedAt(Calendar.getInstance().getTime());
        entity.setOrganization(OrganizationAdapter.toEntity(organization, em));

        em.persist(entity);
        em.flush();
        return toModel(entity);
    }

    @Override
    public Optional<BoletaModel> getBoleta(OrganizationModel organization, String id) {
        TypedQuery<BoletaEntity> q = em.createNamedQuery("GetBoletaPorId", BoletaEntity.class);
        q.setParameter("organizationId", organization);
        q.setParameter("boletaId", id);
        List<BoletaEntity> resultList = q.getResultList();
        return JpaUtils.getFirstResult(resultList, this::toModel);
    }

    @Override
    public List<BoletaModel> getBoletas(OrganizationModel organization, EstadoComprobantePago estado) {
        return getBoletas(organization, estado, -1, -1);
    }

    @Override
    public List<BoletaModel> getBoletas(OrganizationModel organization, EstadoComprobantePago estado, int offset, int limit) {
        TypedQuery<BoletaEntity> query = em.createNamedQuery("GetBoletaPorEstado", BoletaEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("estado", estado);
        if (offset != -1) {
            query.setFirstResult(offset);
        }
        if (limit != -1) {
            query.setMaxResults(limit);
        }

        return query.getResultList().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public boolean remove(BoletaModel boleta) {
        if (boleta.getEstado().equals(EstadoComprobantePago.REGISTRADO)) return false;
        em.createNamedQuery("DeleteBoleta").setParameter("boletaId", boleta.getId()).executeUpdate();
        em.flush();
        return true;
    }
}
