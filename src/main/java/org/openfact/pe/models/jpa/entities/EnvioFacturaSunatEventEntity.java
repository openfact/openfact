package org.openfact.pe.models.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("factura")
@NamedQueries(value = {

})
public class EnvioFacturaSunatEventEntity extends EnvioSunatEventEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "factura_id")
    private FacturaEntity factura;

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

}
