package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.FacturaProvider;
import org.openfact.pe.models.types.TipoInvoice;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class JpaFacturaProvider implements FacturaProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    public FacturaModel createFactura(OrganizationModel organizacion) {
        return null;
    }

    @Override
    public FacturaModel createFactura(OrganizationModel organizacion, String serie) {
        return null;
    }

    @Override
    public FacturaModel createFactura(OrganizationModel organizacion, String serie, int numero) {
        return null;
    }

    @Override
    public Optional<FacturaModel> getBoletaFactura(OrganizationModel organizacion, String idDocumento) {
        return null;
    }

    @Override
    public boolean remove(OrganizationModel organizacion, FacturaModel factura) {
        return false;
    }
}
