package org.openfact.pe.models.jpa;

import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.DatosVentaDetalleEntity;
import org.openfact.pe.models.jpa.entities.DatosVentaEntity;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DatosVentaAdapter implements DatosVentaModel {

    private final EntityManager em;
    private final DatosVentaEntity datosVenta;

    public DatosVentaAdapter(EntityManager em, DatosVentaEntity datosVenta) {
        this.em = em;
        this.datosVenta = datosVenta;
    }

    @Override
    public FechaModel getFecha() {
        return new FechaAdapter(datosVenta.getFecha());
    }

    @Override
    public ClienteModel getCliente() {
        return new ClienteAdapter(datosVenta.getCliente());
    }

    @Override
    public ImpuestosModel getImpuestos() {
        return new ImpuestosAdapter(datosVenta.getImpuestos());
    }

    @Override
    public MonedaModel getMoneda() {
        return new MonedaAdapter(datosVenta.getMoneda());
    }

    @Override
    public TotalModel getTotal() {
        return new TotalAdapter(datosVenta.getTotal());
    }

    @Override
    public TotalInformacionAdicionalModel getTotalInformacionAdicional() {
        return new TotalInformacionAdicionalAdapter(datosVenta.getTotalInformacionAdicional());
    }

    @Override
    public String getObservaciones() {
        return datosVenta.getObservaciones();
    }

    @Override
    public void setObservaciones(String observaciones) {
        datosVenta.setObservaciones(observaciones);
    }

    @Override
    public List<DatosVentaDetalleModel> getDetalle() {
        return datosVenta.getDetalle()
                .stream()
                .map(DatosVentaDetalleAdapter::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<DatosVentaDetalleModel> setDetalle(List<DatosVentaDetalleBean> beans) {
        List<DatosVentaDetalleModel> result = new ArrayList<>();

        em.createNamedQuery("deleteDatosVentaDetalle").setParameter("datosVentaId", datosVenta.getId()).executeUpdate();
        datosVenta.setDetalle(new ArrayList<>());

        for (DatosVentaDetalleBean bena : beans) {
            DatosVentaDetalleEntity detalleEntity = new DatosVentaDetalleEntity();

            detalleEntity.setId(ModelUtils.generateId());
            detalleEntity.setDatosVenta(datosVenta);

            detalleEntity.setUnidadMedida(bena.getUnidadMedida());
            detalleEntity.setDescripcion(bena.getDescripcion());
            detalleEntity.setTipoIgV(bena.getTipoIgv());
            detalleEntity.setCantidad(bena.getCantidad());
            detalleEntity.setValorUnitario(bena.getValorUnitario());
            detalleEntity.setPrecioUnitario(bena.getPrecioUnitario());
            detalleEntity.setSubtotal(bena.getSubtotal());
            detalleEntity.setTotal(bena.getTotal());
            detalleEntity.setTotalIgv(bena.getTotalIgv());
            detalleEntity.setTotalIsc(bena.getTotalIsc());

            em.persist(detalleEntity);
            datosVenta.getDetalle().add(detalleEntity);

            result.add(new DatosVentaDetalleAdapter(detalleEntity));
        }

        return result;
    }
}
