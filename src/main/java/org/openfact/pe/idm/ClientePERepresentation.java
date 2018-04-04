package org.openfact.pe.idm;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.openfact.core.types.TipoDocumentoEntidad;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClientePERepresentation {

    @NotNull
    private TipoDocumentoEntidad tipoDocumentoIdentidadCliente;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 20)
    private String numeroDocumentoIdentidadCliente;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 250)
    private String nombreCliente;

    @Email
    @Size(max = 250)
    private String emailCliente;

    @Size(max = 250)
    private String direccionCliente;

    public TipoDocumentoEntidad getTipoDocumentoIdentidadCliente() {
        return tipoDocumentoIdentidadCliente;
    }

    public void setTipoDocumentoIdentidadCliente(TipoDocumentoEntidad tipoDocumentoIdentidadCliente) {
        this.tipoDocumentoIdentidadCliente = tipoDocumentoIdentidadCliente;
    }

    public String getNumeroDocumentoIdentidadCliente() {
        return numeroDocumentoIdentidadCliente;
    }

    public void setNumeroDocumentoIdentidadCliente(String numeroDocumentoIdentidadCliente) {
        this.numeroDocumentoIdentidadCliente = numeroDocumentoIdentidadCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
}
