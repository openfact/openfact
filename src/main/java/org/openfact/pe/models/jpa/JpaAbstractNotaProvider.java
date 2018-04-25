package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.InvoiceModel;
import org.openfact.pe.models.jpa.entities.NotaEntity;
import org.openfact.pe.models.utils.SunatUtils;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.AbstractMap;
import java.util.List;
import java.util.Optional;

public abstract class JpaAbstractNotaProvider {

    @PersistenceContext
    private EntityManager em;

    @Inject
    @ConfigurationValue("openfact.pe.documentos.numero_maximo_por_serie")
    private Optional<Integer> NUMERO_MAXIMO_POR_SERIE;

    protected abstract String getPrefijo(InvoiceModel invoice);

    protected AbstractMap.SimpleEntry<String, Integer> siguienteSerieNumero(OrganizationModel organization, Class<? extends NotaEntity> classz, InvoiceModel invoice, Optional<String> optionalSerie) {
        Optional<NotaEntity> ultimoComprobante;
        if (!optionalSerie.isPresent()) {
            TypedQuery<NotaEntity> query = em.createNamedQuery("getNotasEmpezandoPorLasMasRecientes", NotaEntity.class);
            query.setParameter("organizationId", organization.getId());
            query.setParameter("subclass", classz);
            query.setMaxResults(1);
            List<NotaEntity> resultList = query.getResultList();
            ultimoComprobante = JpaUtils.getFirstResult(resultList);
        } else {
            TypedQuery<NotaEntity> query = em.createNamedQuery("getNotasConSerieEmpezandoPorLasMasRecientes", NotaEntity.class);
            query.setParameter("organizationId", organization.getId());
            query.setParameter("subclass", classz);
            query.setParameter("serie", optionalSerie.get());
            query.setMaxResults(1);
            List<NotaEntity> resultList = query.getResultList();
            ultimoComprobante = JpaUtils.getFirstResult(resultList);
        }

        if (ultimoComprobante.isPresent()) {
            NotaEntity entity = ultimoComprobante.get();
            String ultimaSerie = entity.getSerie();
            int ultimoNumero = entity.getNumero();

            int siguienteNumero = ultimoNumero + 1;
            if (NUMERO_MAXIMO_POR_SERIE.orElse(99_999_999) > siguienteNumero) {
                boolean siguienteNumeroEsValido = false;
                while (!siguienteNumeroEsValido) {
                    TypedQuery<NotaEntity> query = em.createNamedQuery("getNotasPorSerieYNumero", NotaEntity.class);
                    query.setParameter("organizationId", organization.getId());
                    query.setParameter("serie", ultimaSerie);
                    query.setParameter("numero", siguienteNumero);
                    query.setMaxResults(1);
                    List<NotaEntity> resultList = query.getResultList();
                    if (!resultList.isEmpty()) {
                        siguienteNumero++;
                    } else {
                        siguienteNumeroEsValido = true;
                    }
                }
                return new AbstractMap.SimpleEntry<>(ultimaSerie, siguienteNumero);
            } else {
                String nuevaSerie = SunatUtils.incrementarSerie(ultimaSerie);
                return siguienteSerieNumero(organization, classz, invoice, Optional.of(nuevaSerie));
            }
        } else {
            String serie = optionalSerie.orElseGet(() -> getPrefijo(invoice) + 1);
            return new AbstractMap.SimpleEntry<>(serie, 1);
        }
    }

    public long getTotalPorEstado(OrganizationModel organization, Class<? extends NotaEntity> classz, EstadoComprobantePago estado) {
        Query query = em.createNamedQuery("countNotasPorEstado");
        query.setParameter("organizationId", organization.getId());
        query.setParameter("subclass", classz);
        query.setParameter("estado", estado);
        return ((Long) query.getSingleResult());
    }

}
