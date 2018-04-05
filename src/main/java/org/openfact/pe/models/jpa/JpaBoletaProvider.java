package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.BoletaProvider;
import org.openfact.pe.models.types.TipoInvoice;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class JpaBoletaProvider implements BoletaProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public BoletaModel createBoleta(OrganizationModel organizacion) {
        return null;
    }

    @Override
    public BoletaModel createBoleta(OrganizationModel organizacion, String serie) {
        return null;
    }

    @Override
    public BoletaModel createBoleta(OrganizationModel organizacion, String serie, int numero) {
        return null;
    }

    @Override
    public Optional<BoletaModel> getBoletaFactura(OrganizationModel organizacion, String idDocumento) {
        return null;
    }

    @Override
    public boolean remove(OrganizationModel organizacion, BoletaModel factura) {
        return false;
    }
}
