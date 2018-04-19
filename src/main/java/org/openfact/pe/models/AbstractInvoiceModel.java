package org.openfact.pe.models;

import java.util.List;

public interface AbstractInvoiceModel extends DocumentoModel {

    String getSerie();
    Integer getNumero();

    String getObservaciones();
    void setObservaciones(String observaciones);

    FechaModel getFecha();
    ClienteModel getCliente();
    ImpuestosModel getImpuestos();
    MonedaModel getMoneda();
    TotalModel getTotal();
    TotalInformacionAdicionalModel getTotalInformacionAdicional();

    List<DetalleComprobantePagoModel> getDetalle();
    List<DetalleComprobantePagoModel> setDetalle(List<DetalleComprobantePagoBean> bean);
}
