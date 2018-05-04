package org.openfact.pe.representations.idm;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class DocumentoBaseRepresentation {

    private String id;
    private Boolean enviarSunat;
    private Boolean enviarCliente;

    @Size(min = 4, max = 4)
    @Pattern(regexp = "[B|F][A-Z]+[0-9]+")
    private String serie;

    @Min(value = 1)
    private Integer numero;

    @Valid
    private FechaRepresentation fecha;

    @Valid
    private TotalRepresentation total;

    @Valid
    private MonedaRepresentation moneda;

    @Valid
    private ClienteRepresentation cliente;

    @Valid
    private TotalImpuestosRepresentation totalImpuestos;

    @Valid
    private TotalInformacionAdicionalRepresentation totalInformacionAdicional;

    @Valid
    private EstadoSunatRepresentation validacion;

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

    public Boolean getEnviarSunat() {
        return enviarSunat;
    }

    public void setEnviarSunat(Boolean enviarSunat) {
        this.enviarSunat = enviarSunat;
    }

    public Boolean getEnviarCliente() {
        return enviarCliente;
    }

    public void setEnviarCliente(Boolean enviarCliente) {
        this.enviarCliente = enviarCliente;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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

    public ClienteRepresentation getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRepresentation cliente) {
        this.cliente = cliente;
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

    public EstadoSunatRepresentation getValidacion() {
        return validacion;
    }

    public void setValidacion(EstadoSunatRepresentation validacion) {
        this.validacion = validacion;
    }

    public List<ComprobanteDetalleRepresentation> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<ComprobanteDetalleRepresentation> detalle) {
        this.detalle = detalle;
    }
}
