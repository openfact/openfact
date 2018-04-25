package org.openfact.pe.models.jpa.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("factura")
@NamedQueries(value = {
        @NamedQuery(name = "getFacturasPorId", query = "select b from FacturaEntity b inner join b.organization o where o.id=:organizationId and b.id=:facturaId"),
        @NamedQuery(name = "getDistinctFacturasPorEstado", query = "select distinct b from FacturaEntity b inner join b.organization o where o.id=:organizationId and b.estado =:estado"),
        @NamedQuery(name = "getFacturasPorSerieYNumero", query = "select b from FacturaEntity b inner join b.organization o where o.id=:organizationId and b.serie=:serie and b.numero=:numero")
})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "graph.ListFacturas", attributeNodes = {
                @NamedAttributeNode("id"),
                @NamedAttributeNode(value = "organization", subgraph = "organizationn"),
                @NamedAttributeNode(value = "datosVenta", subgraph = "datosVenta"),
                @NamedAttributeNode(value = "validacion", subgraph = "validacion"),
        }, subgraphs = {
                @NamedSubgraph(name = "organization", attributeNodes = {
                        @NamedAttributeNode("id")
                }),
                @NamedSubgraph(name = "datosVenta", attributeNodes = {
                        @NamedAttributeNode("id")
                }),
                @NamedSubgraph(name = "validacion", attributeNodes = {
                        @NamedAttributeNode("id")
                })
        })
})
public class FacturaEntity extends InvoiceEntity {

}
