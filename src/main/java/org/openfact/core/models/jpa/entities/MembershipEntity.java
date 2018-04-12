package org.openfact.core.models.jpa.entities;

import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.Date;

@Indexed
@Entity
@Table(name = "memberships", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
@NamedQueries(value = {

})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "graph.OrganizationOwner", attributeNodes = {
                @NamedAttributeNode(value = "id"),
                @NamedAttributeNode(value = "owner", subgraph = "owner"),
        }, subgraphs = {
                @NamedSubgraph(name = "owner", attributeNodes = {
                        @NamedAttributeNode(value = "id")
                })
        })
})
public class MembershipEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "organization_id")
    private String organizationId;

    @Column(name = "created_on")
    private Date createdOn;

}
