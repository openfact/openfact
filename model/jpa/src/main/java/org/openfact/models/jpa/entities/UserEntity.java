package org.openfact.models.jpa.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = "getAllUsersByOrganization", query = "select u from UserEntity u where u.organization.id = :organizationId order by u.username"),
        @NamedQuery(name = "getOrganizationUserById", query = "select u from UserEntity u where u.id = :id and u.organization.id = :organizationId"),
        @NamedQuery(name = "getOrganizationUserByUsername", query = "select u from UserEntity u where u.username = :username and u.organization.id = :organizationId"),
        @NamedQuery(name = "getOrganizationUserCount", query = "select count(u) from UserEntity u where u.organization.id = :organizationId"),
        @NamedQuery(name = "deleteUsersByOrganization", query = "delete from UserEntity u where u.organization.id = :organizationId") })
@Entity
public class UserEntity {

    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "USERNAME")
    protected String username;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
    private OrganizationEntity organization;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserEntity other = (UserEntity) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

}
