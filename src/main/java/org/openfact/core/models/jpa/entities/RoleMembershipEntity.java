package org.openfact.core.models.jpa.entities;

import org.hibernate.annotations.CacheConcurrencyStrategy;

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

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey)
    private RoleEntity role;

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey)
    private UserEntity user;

    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id", foreignKey = @ForeignKey)
    private OrganizationEntity organization;

    @Column(name = "created_on")
    private Date createdOn;

    @Version
    @Column(name = "version")
    private int version;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoleMembershipEntity)) {
            return false;
        }
        RoleMembershipEntity other = (RoleMembershipEntity) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
