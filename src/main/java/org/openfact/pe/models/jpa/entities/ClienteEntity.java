package org.openfact.pe.models.jpa.entities;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class ClienteEntity {

    @NotNull
    @Column(name = "cliente_tipo_documento")
    private String tipoDocumento;

    @NotNull
    @Column(name = "cliente_numero_documento")
    private String numeroDocumento;

    @NotNull
    @Column(name = "cliente_nombre")
    private String nombre;

    @Email
    @Column(name = "cliente_email")
    private String email;

    @Column(name = "cliente_direccion")
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
}
