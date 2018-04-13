package org.openfact.core.models.jpa.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Cacheable
@Table(name = "memberships", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "role_id", "organization_id"})}
)
@NamedQueries(value = {
        @NamedQuery(name = "getRoleMembershipsByUserId", query = "select r from RoleMembershipEntity r inner join r.user u where u.id=:userId"),
        @NamedQuery(name = "getRoleMembershipsByUserUsername", query = "select r from RoleMembershipEntity r inner join r.user u where u.username=:username"),
        @NamedQuery(name = "getRoleMembershipsByUserIdentityId", query = "select r from RoleMembershipEntity r inner join r.user u where u.identityId=:identityId"),
        @NamedQuery(name = "getRoleMembershipsByOrganizationId", query = "select r from RoleMembershipEntity r inner join r.organization o where o.id=:organizationId"),
        @NamedQuery(name = "getRoleMembershipsByUserIdAndOrganizationId", query = "select r from RoleMembershipEntity r inner join r.user u inner join r.organization o where u.id=:userId and o.id=:organizationId"),
})
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "graph.EagerRoleMembership", attributeNodes = {
                @NamedAttributeNode(value = "id"),
                @NamedAttributeNode(value = "role", subgraph = "role"),
                @NamedAttributeNode(value = "user", subgraph = "user"),
                @NamedAttributeNode(value = "organization", subgraph = "organization"),
        }, subgraphs = {
                @NamedSubgraph(name = "role", attributeNodes = {
                        @NamedAttributeNode(value = "id")
                }),
                @NamedSubgraph(name = "user", attributeNodes = {
                        @NamedAttributeNode(value = "id")
                }),
                @NamedSubgraph(name = "organization", attributeNodes = {
                        @NamedAttributeNode(value = "id")
                })
        })
})
public class RoleMembershipEntity {

    @Id
    @Column(name = "id")
    @Access(AccessType.PROPERTY)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey)
    private RoleEntity role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id", foreignKey = @ForeignKey)
    private OrganizationEntity organization;

    @Column(name = "created_on")
    private Date createdOn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

}
