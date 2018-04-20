package org.openfact.pe.models.jpa.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("boleta")
public class BoletaValidacionEntity extends ValidacionEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "boleta_id")
    private BoletaEntity boleta;

    public BoletaEntity getBoleta() {
        return boleta;
    }

    public void setBoleta(BoletaEntity boleta) {
        this.boleta = boleta;
    }

}
