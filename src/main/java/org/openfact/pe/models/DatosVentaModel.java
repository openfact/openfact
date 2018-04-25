package org.openfact.pe.models;

import java.util.List;

public interface DatosVentaModel {

    FechaModel getFecha();
    ClienteModel getCliente();
    ImpuestosModel getImpuestos();
    MonedaModel getMoneda();
    TotalModel getTotal();
    TotalInformacionAdicionalModel getTotalInformacionAdicional();

    String getObservaciones();
    void setObservaciones(String observaciones);

    List<DatosVentaDetalleModel> getDetalle();
    List<DatosVentaDetalleModel> setDetalle(List<DatosVentaDetalleBean> items);

}
