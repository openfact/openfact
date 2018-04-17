package org.openfact.pe.models.jpa.entities;

import org.openfact.core.models.jpa.entities.OrganizationEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("boleta")
@NamedQueries(value = {
        @NamedQuery(name = "deleteBoletaDetalle", query = "delete from BoletaDetalleEntity f where f.boleta.id=:idBoleta")
})
public class BoletaDetalleEntity extends InvoiceLineEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "boleta_id")
    private BoletaEntity boleta;

    public BoletaEntity getBoleta() {
        return boleta;
    }

    public void setBoleta(BoletaEntity boleta) {
        this.boleta = boleta;
    }
}
