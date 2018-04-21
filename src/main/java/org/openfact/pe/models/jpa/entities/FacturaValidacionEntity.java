package org.openfact.pe.models.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("factura")
public class FacturaValidacionEntity extends ValidacionEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "factura_id")
    private FacturaEntity factura;

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity boleta) {
        this.factura = boleta;
    }

}
