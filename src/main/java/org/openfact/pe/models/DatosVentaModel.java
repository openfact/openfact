package org.openfact.pe.models;

import java.util.List;

public interface DatosVentaModel {

    String getObservaciones();
    void setObservaciones(String observaciones);

    FechaModel getFecha();
    TotalModel getTotal();
    MonedaModel getMoneda();
    ClienteModel getCliente();
    ImpuestosModel getImpuestos();
    TotalInformacionAdicionalModel getTotalInformacionAdicional();

    List<DatosVentaDetalleModel> getDetalle();
    List<DatosVentaDetalleModel> setDetalle(List<DatosVentaDetalleBean> items);

}
