package org.openfact.pe.representations.idm;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.openfact.pe.models.types.TipoDocumentoEntidad;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClienteRepresentation {

    @NotNull
    private String tipoDocumento;

    private String tipoDocumentoAlias;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 20)
    private String numeroDocumento;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 250)
    private String nombre;

    @Email
    @Size(max = 250)
    private String email;

    @Size(max = 250)
    private String direccion;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoDocumentoAlias() {
        return tipoDocumentoAlias;
    }

    public void setTipoDocumentoAlias(String tipoDocumentoAlias) {
        this.tipoDocumentoAlias = tipoDocumentoAlias;
    }
}
