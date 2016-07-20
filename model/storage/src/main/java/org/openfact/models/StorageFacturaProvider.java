package org.openfact.models;

import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class StorageFacturaProvider implements FacturaProvider {

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public FacturaModel create(EmisorModel emisor, AdquirienteModel adquiriente, LocalDate fechaEmision,
                               NumeracionComprobantePagoModel numeracion, ResumenComprobantePagoModel resumen) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AdquirienteModel createAdquiriente(DocumentoIdentidadModel documento, String numeroDocumento,
                                              String razonSocial) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NumeracionComprobantePagoModel createNumeracion(String serie, String numero) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResumenComprobantePagoModel createResumenGravado(BigDecimal totalGravado, String moneda,
                                                            BigDecimal importeTotal) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResumenComprobantePagoModel createResumenInafecto(BigDecimal totalInafecto, String moneda,
                                                             BigDecimal importeTotal) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResumenComprobantePagoModel createResumenExonerado(BigDecimal totalExonerado, String moneda,
                                                              BigDecimal importeTotal) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FacturaModel findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FacturaModel> getAll(EmisorModel emisorModel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<FacturaModel> search(SearchCriteriaModel criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<FacturaModel> search(SearchCriteriaModel criteria, String filterText) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<FacturaModel> search(FacturaModel facturaModel, SearchCriteriaModel criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SearchResultsModel<FacturaModel> search(FacturaModel facturaModel, SearchCriteriaModel criteria,
                                                   String filterText) {
        // TODO Auto-generated method stub
        return null;
    }

}
