package org.openfact.pe.models.jpa;

import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.BoletaDetalleEntity;
import org.openfact.pe.models.jpa.entities.BoletaEntity;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return boleta.isEnviarSunat();
    }

    @Override
    public void setEnviarSunat(boolean enviarSUNAT) {
        boleta.setEnviarSunat(enviarSUNAT);
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
    public String getEstadoDescripcion() {
        return boleta.getEstadoDescripcion();
    }

    @Override
    public void setEstadoDescripcion(String estadoDescripcion) {
        boleta.setEstadoDescripcion(estadoDescripcion);
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
    public String getCdrFileId() {
        return boleta.getCdrFileId();
    }

    @Override
    public void setCdrFileId(String fileId) {
        boleta.setCdrFileId(fileId);
    }

    @Override
    public FechaModel getFecha() {
        if (boleta.getEstado().equals(EstadoComprobantePago.ABIERTO)) {
            return new ReadOnlyFechaAdapter(boleta.getFecha());
        } else {
            return new FechaAdapter(boleta.getFecha());
        }
    }

    @Override
    public ClienteModel getCliente() {
        if (boleta.getEstado().equals(EstadoComprobantePago.ABIERTO)) {
            return new ReadOnlyClienteAdapter(boleta.getCliente());
        } else {
            return new ClienteAdapter(boleta.getCliente());
        }
    }

    @Override
    public ImpuestosModel getImpuestos() {
        if (boleta.getEstado().equals(EstadoComprobantePago.ABIERTO)) {
            return new ReadOnlyImpuestosAdapter(boleta.getImpuestos());
        } else {
            return new ImpuestosAdapter(boleta.getImpuestos());
        }
    }

    @Override
    public MonedaModel getMoneda() {
        if (boleta.getEstado().equals(EstadoComprobantePago.ABIERTO)) {
            return new ReadOnlyMonedaAdapter(boleta.getMoneda());
        } else {
            return new MonedaAdapter(boleta.getMoneda());
        }
    }

    @Override
    public TotalModel getTotal() {
        if (boleta.getEstado().equals(EstadoComprobantePago.ABIERTO)) {
            return new ReadOnlyTotalAdapter(boleta.getTotal());
        } else {
            return new TotalAdapter(boleta.getTotal());
        }
    }

    @Override
    public TotalInformacionAdicionalModel getTotalInformacionAdicional() {
        if (boleta.getEstado().equals(EstadoComprobantePago.ABIERTO)) {
            return new ReadOnlyTotalInformacionAdicionalAdapter(boleta.getTotalInformacionAdicional());
        } else {
            return new TotalInformacionAdicionalAdapter(boleta.getTotalInformacionAdicional());
        }
    }

    @Override
    public List<DetalleComprobantePagoModel> getDetalle() {
        if (boleta.getEstado().equals(EstadoComprobantePago.ABIERTO)) {
            return boleta.getDetalle()
                    .stream()
                    .map(ReadOnlyDetalleComprobantePagoAdapter::new)
                    .collect(Collectors.toList());
        } else {
            return boleta.getDetalle()
                    .stream()
                    .map(DetalleComprobantePagoAdapter::new)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<DetalleComprobantePagoModel> setDetalle(List<DetalleComprobantePagoBean> beans) {
        if (boleta.getEstado().equals(EstadoComprobantePago.ABIERTO)) {
            ReadOnlyUtils.throwException();
        }

        List<DetalleComprobantePagoModel> result = new ArrayList<>();

        em.createNamedQuery("deleteBoletaDetalle").setParameter("idBoleta", boleta.getId()).executeUpdate();

        for (DetalleComprobantePagoBean bean: beans) {
            BoletaDetalleEntity detalleEntity = new BoletaDetalleEntity();

            detalleEntity.setId(ModelUtils.generateId());
            detalleEntity.setBoleta(boleta);

            detalleEntity.setUnidadMedida(bean.getUnidadMedida());
            detalleEntity.setDescripcion(bean.getDescripcion());
            detalleEntity.setTipoIGV(bean.getTipoIGV());
            detalleEntity.setCantidad(bean.getCantidad());
            detalleEntity.setValorUnitario(bean.getValorUnitario());
            detalleEntity.setPrecioUnitario(bean.getPrecioUnitario());
            detalleEntity.setSubtotal(bean.getSubtotal());
            detalleEntity.setTotal(bean.getTotal());
            detalleEntity.setTotalIGV(bean.getTotalIGV());
            detalleEntity.setTotalISC(bean.getTotalISC());

            em.persist(detalleEntity);

            result.add(new DetalleComprobantePagoAdapter(detalleEntity));
        }

        return result;
    }

}
