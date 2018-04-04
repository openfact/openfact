package org.openfact.pe.idm;

import org.openfact.pe.models.TipoInvoice;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BoletaFacturaPERepresentation {

    private String id;

    @Pattern(regexp = "[a-zA-Z]{1,}[0-9]{1,}")
    private String serie;

    @Min(value = 1)
    private Long numero;

    @NotNull
    private TipoInvoice tipo;

    @Valid
    private FechaPERepresentation fecha;

    @Valid
    private ClientePERepresentation cliente;

    @Valid
    private TotalPERepresentation total;

    @Valid
    private MonedaPERepresentation moneda;

    @Valid
    private TotalImpuestosPERepresentation totalImpuestos;

    @Valid
    private InformacionAdicionalTotalPERepresentation totalInformacionAdicional;

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

    public FechaPERepresentation getFecha() {
        return fecha;
    }

    public void setFecha(FechaPERepresentation fecha) {
        this.fecha = fecha;
    }

    public ClientePERepresentation getCliente() {
        return cliente;
    }

    public void setCliente(ClientePERepresentation cliente) {
        this.cliente = cliente;
    }

    public TotalPERepresentation getTotal() {
        return total;
    }

    public void setTotal(TotalPERepresentation total) {
        this.total = total;
    }

    public MonedaPERepresentation getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaPERepresentation moneda) {
        this.moneda = moneda;
    }

    public TotalImpuestosPERepresentation getTotalImpuestos() {
        return totalImpuestos;
    }

    public void setTotalImpuestos(TotalImpuestosPERepresentation totalImpuestos) {
        this.totalImpuestos = totalImpuestos;
    }

    public InformacionAdicionalTotalPERepresentation getTotalInformacionAdicional() {
        return totalInformacionAdicional;
    }

    public void setTotalInformacionAdicional(InformacionAdicionalTotalPERepresentation totalInformacionAdicional) {
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
