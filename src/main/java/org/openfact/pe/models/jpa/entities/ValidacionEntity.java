package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "factura", fetch = FetchType.LAZY)
    private List<ErrorEntity> errores = new ArrayList<>();

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

    public List<ErrorEntity> getErrores() {
        return errores;
    }

    public void setErrores(List<ErrorEntity> errores) {
        this.errores = errores;
    }
}
