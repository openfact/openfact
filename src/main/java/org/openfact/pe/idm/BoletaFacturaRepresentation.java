package org.openfact.pe.idm;

import org.openfact.pe.models.TipoInvoice;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BoletaFacturaRepresentation {

    private String id;

    @Pattern(regexp = "[a-zA-Z]{1,}[0-9]{1,}")
    private String serie;

    @Min(value = 1)
    private Long numero;

    @NotNull
    private TipoInvoice tipo;

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

    private boolean enviarSUNAT;
    private boolean enviarCliente;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public TipoInvoice getTipo() {
        return tipo;
    }

    public void setTipo(TipoInvoice tipo) {
        this.tipo = tipo;
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

    public boolean isEnviarSUNAT() {
        return enviarSUNAT;
    }

    public void setEnviarSUNAT(boolean enviarSUNAT) {
        this.enviarSUNAT = enviarSUNAT;
    }

    public boolean isEnviarCliente() {
        return enviarCliente;
    }

    public void setEnviarCliente(boolean enviarCliente) {
        this.enviarCliente = enviarCliente;
    }
}
