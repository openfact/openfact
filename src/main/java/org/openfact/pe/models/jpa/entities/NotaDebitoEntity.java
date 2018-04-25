package org.openfact.pe.models.jpa.entities;

import org.openfact.core.models.jpa.entities.OrganizationEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@DiscriminatorValue("debito")
@NamedQueries(value = {
        @NamedQuery(name = "getNotaDebitoPorId", query = "select b from NotaDebitoEntity b inner join b.organization o where o.id=:organizationId and b.id=:notaDebitoId"),
        @NamedQuery(name = "getDistinctNotasDebitoPorEstado", query = "select distinct b from NotaDebitoEntity b inner join b.organization o where o.id=:organizationId and b.estado =:estado")
})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "graph.ListNotasDebito", attributeNodes = {
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
public class NotaDebitoEntity extends NotaEntity {

}
