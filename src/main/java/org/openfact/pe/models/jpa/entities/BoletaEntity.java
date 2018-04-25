package org.openfact.pe.models.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("boleta")
@NamedQueries(value = {
        @NamedQuery(name = "getBoletasPorId", query = "select b from BoletaEntity b inner join b.organization o where o.id=:organizationId and b.id=:boletaId"),
        @NamedQuery(name = "getDistinctBoletasPorEstado", query = "select distinct b from BoletaEntity b inner join b.organization o where o.id=:organizationId and b.estado =:estado"),
        @NamedQuery(name = "getBoletasPorSerieYNumero", query = "select b from BoletaEntity b inner join b.organization o where o.id=:organizationId and b.serie=:serie and b.numero=:numero")
})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "graph.ListBoletas", attributeNodes = {
                @NamedAttributeNode("id"),
                @NamedAttributeNode(value = "organization", subgraph = "organizationn"),
                @NamedAttributeNode(value = "datosVenta", subgraph = "datosVenta"),
                @NamedAttributeNode(value = "validacion", subgraph = "validacion"),
                @NamedAttributeNode(value = "resumenDiario", subgraph = "resumenDiario")
        }, subgraphs = {
                @NamedSubgraph(name = "organization", attributeNodes = {
                        @NamedAttributeNode("id")
                }),
                @NamedSubgraph(name = "datosVenta", attributeNodes = {
                        @NamedAttributeNode("id")
                }),
                @NamedSubgraph(name = "validacion", attributeNodes = {
                        @NamedAttributeNode("id")
                }),
                @NamedSubgraph(name = "resumenDiario", attributeNodes = {
                        @NamedAttributeNode("id")
                })
        })
})
public class BoletaEntity extends InvoiceEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "resumen_diario_id")
    private ResumenDiarioEntity resumenDiario;

    public ResumenDiarioEntity getResumenDiario() {
        return resumenDiario;
    }

    public void setResumenDiario(ResumenDiarioEntity resumenDiario) {
        this.resumenDiario = resumenDiario;
    }
}
