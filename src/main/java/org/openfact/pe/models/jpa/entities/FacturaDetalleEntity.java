package org.openfact.pe.models.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "factura_detalle")
@DiscriminatorValue("factura")
@NamedQueries(value = {
        @NamedQuery(name = "deleteFacturaDetalle", query = "delete from FacturaDetalleEntity f where f.factura.id=:idFactura")
})
public class FacturaDetalleEntity extends InvoiceLineEntity {

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
