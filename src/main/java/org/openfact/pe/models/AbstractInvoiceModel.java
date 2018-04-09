package org.openfact.pe.models;

public interface AbstractInvoiceModel {
    String getId();
    String getSerie();
    Integer getNumero();

    boolean getEnviarSUNAT();
    void setEnviarSUNAT(boolean enviarSUNAT);

    boolean getEnviarCliente();
    void setEnviarCliente(boolean enviarCliente);

    String getObservaciones();
    void setObservaciones(String observaciones);

    EstadoComprobantePago getEstado();
    void setEstado(EstadoComprobantePago estado);

    String getError();
    void setError(String error);

    // XML
    String getFileId();
    void setFileId(String fileId);

    String getFileProvider();
    void setFileProvider(String fileProvider);

    FechaModel getFecha();
    ClienteModel getCliente();
    ImpuestosModel getImpuestos();
    MonedaModel getMoneda();
    TotalModel getTotal();
    TotalInformacionAdicionalModel getTotalInformacionAdicional();
}
