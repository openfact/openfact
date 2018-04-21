package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.openfact.pe.models.ErrorType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "validacion")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_documento")
public abstract class ValidacionEntity {

    @Id
    @Column(name = "id")
    private String id;

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

    public void setError(ErrorType tipoError) {
        this.error = tipoError;
    }

    public String getErrorDescripcion() {
        return errorDescripcion;
    }

    public void setErrorDescripcion(String descripcion) {
        this.errorDescripcion = descripcion;
    }
}
