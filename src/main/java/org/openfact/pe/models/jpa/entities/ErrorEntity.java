package org.openfact.pe.models.jpa.entities;

import org.openfact.pe.models.ErrorType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "error")
public class ErrorEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private ErrorType tipo;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "validacion_id")
    private ValidacionEntity validacion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ErrorType getTipo() {
        return tipo;
    }

    public void setTipo(ErrorType tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ValidacionEntity getValidacion() {
        return validacion;
    }

    public void setValidacion(ValidacionEntity validacion) {
        this.validacion = validacion;
    }
}
