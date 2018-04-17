package org.openfact.pe.idm;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public abstract class AbstractInvoiceRepresentation {

    private String id;

    @Min(value = 1)
    private Integer numero;

    @Valid
    private FechaRepresentation fecha;

    @Valid
    private ClienteRepresentation cliente;

    @Valid
    private TotalRepresentation total;

    @Valid
    private MonedaRepresentation moneda;

    @Valid
    private TotalImpuestosRepresentation totalImpuestos;

    @Valid
    private TotalInformacionAdicionalRepresentation totalInformacionAdicional;

    private Boolean enviarSUNAT;
    private Boolean enviarCliente;

    @NotNull
    @Valid
    @NotEmpty
    private List<ComprobanteDetalleRepresentation> detalle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public FechaRepresentation getFecha() {
        return fecha;
    }

    public void setFecha(FechaRepresentation fecha) {
        this.fecha = fecha;
    }

    public ClienteRepresentation getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRepresentation cliente) {
        this.cliente = cliente;
    }

    public TotalRepresentation getTotal() {
        return total;
    }

    public void setTotal(TotalRepresentation total) {
        this.total = total;
    }

    public MonedaRepresentation getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaRepresentation moneda) {
        this.moneda = moneda;
    }

    public TotalImpuestosRepresentation getTotalImpuestos() {
        return totalImpuestos;
    }

    public void setTotalImpuestos(TotalImpuestosRepresentation totalImpuestos) {
        this.totalImpuestos = totalImpuestos;
    }

    public TotalInformacionAdicionalRepresentation getTotalInformacionAdicional() {
        return totalInformacionAdicional;
    }

    public void setTotalInformacionAdicional(TotalInformacionAdicionalRepresentation totalInformacionAdicional) {
        this.totalInformacionAdicional = totalInformacionAdicional;
    }

    public Boolean getEnviarSUNAT() {
        return enviarSUNAT;
    }

    public void setEnviarSUNAT(Boolean enviarSUNAT) {
        this.enviarSUNAT = enviarSUNAT;
    }

    public Boolean getEnviarCliente() {
        return enviarCliente;
    }

    public void setEnviarCliente(Boolean enviarCliente) {
        this.enviarCliente = enviarCliente;
    }

    public List<ComprobanteDetalleRepresentation> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<ComprobanteDetalleRepresentation> detalle) {
        this.detalle = detalle;
    }
}
