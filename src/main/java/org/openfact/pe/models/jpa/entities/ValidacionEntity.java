package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.openfact.pe.models.ErrorType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "validacion")
public class ValidacionEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "id")
    private String id;

    @NotNull
    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "estado")
    private boolean estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "error")
    private ErrorType error;

    @Column(name = "descripcion", length = 450)
    private String errorDescripcion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ErrorType getError() {
        return error;
    }

    public void setError(ErrorType error) {
        this.error = error;
    }

    public String getErrorDescripcion() {
        return errorDescripcion;
    }

    public void setErrorDescripcion(String errorDescripcion) {
        this.errorDescripcion = errorDescripcion;
    }
}
