package org.openfact.pe.models.jpa.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("credito")
@NamedQueries(value = {
        @NamedQuery(name = "getNotaCreditoPorId", query = "select b from NotaCreditoEntity b inner join b.organization o where o.id=:organizationId and b.id=:notaCreditoId"),
        @NamedQuery(name = "getDistinctNotasCreditoPorEstado", query = "select distinct b from NotaCreditoEntity b inner join b.organization o where o.id=:organizationId and b.estado =:estado")
})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "graph.ListNotasCredito", attributeNodes = {
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
public class NotaCreditoEntity extends NotaEntity {

}
