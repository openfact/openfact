package org.openfact.pe.models.jpa;

import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.BoletaEntity;

import javax.persistence.EntityManager;

public class BoletaAdapter implements BoletaModel {

    private final EntityManager em;
    private final BoletaEntity boleta;

    public BoletaAdapter(EntityManager em, BoletaEntity boleta) {
        this.em = em;
        this.boleta = boleta;
    }

    @Override
    public String getId() {
        return boleta.getId();
    }

    @Override
    public String getSerie() {
        return boleta.getSerie();
    }

    @Override
    public Integer getNumero() {
        return boleta.getNumero();
    }

    @Override
    public boolean getEnviarSUNAT() {
        return boleta.isEnviarSUNAT();
    }

    @Override
    public void setEnviarSUNAT(boolean enviarSUNAT) {
        boleta.setEnviarSUNAT(enviarSUNAT);
    }

    @Override
    public boolean getEnviarCliente() {
        return boleta.isEnviarCliente();
    }

    @Override
    public void setEnviarCliente(boolean enviarCliente) {
        boleta.setEnviarCliente(enviarCliente);
    }

    @Override
    public String getObservaciones() {
        return boleta.getObservaciones();
    }

    @Override
    public void setObservaciones(String observaciones) {
        boleta.setObservaciones(observaciones);
    }

    @Override
    public EstadoComprobantePago getEstado() {
        return boleta.getEstado();
    }

    @Override
    public void setEstado(EstadoComprobantePago estado) {
        boleta.setEstado(estado);
    }

    @Override
    public String getError() {
        return boleta.getErrorDescription();
    }

    @Override
    public void setError(String error) {
        boleta.setErrorDescription(error);
    }

    @Override
    public String getFileId() {
        return boleta.getFileId();
    }

    @Override
    public void setFileId(String fileId) {
        boleta.setFileId(fileId);
    }

    @Override
    public String getFileProvider() {
        return boleta.getFileProvider();
    }

    @Override
    public void setFileProvider(String fileProvider) {
        boleta.setFileProvider(fileProvider);
    }

    @Override
    public FechaModel getFecha() {
        if (boleta.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyFechaAdapter(boleta.getFecha());
        } else {
            return new FechaAdapter(boleta.getFecha());
        }
    }

    @Override
    public ClienteModel getCliente() {
        if (boleta.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyClienteAdapter(boleta.getCliente());
        } else {
            return new ClienteAdapter(boleta.getCliente());
        }
    }

    @Override
    public ImpuestosModel getImpuestos() {
        if (boleta.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyImpuestosAdapter(boleta.getImpuestos());
        } else {
            return new ImpuestosAdapter(boleta.getImpuestos());
        }
    }

    @Override
    public MonedaModel getMoneda() {
        if (boleta.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyMonedaAdapter(boleta.getMoneda());
        } else {
            return new MonedaAdapter(boleta.getMoneda());
        }
    }

    @Override
    public TotalModel getTotal() {
        if (boleta.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyTotalAdapter(boleta.getTotal());
        } else {
            return new TotalAdapter(boleta.getTotal());
        }
    }

    @Override
    public TotalInformacionAdicionalModel getTotalInformacionAdicional() {
        if (boleta.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            return new ReadOnlyTotalInformacionAdicionalAdapter(boleta.getTotalInformacionAdicional());
        } else {
            return new TotalInformacionAdicionalAdapter(boleta.getTotalInformacionAdicional());
        }
    }
}
