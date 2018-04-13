package org.openfact.core.models.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "identity_id")
})
@NamedQueries(value = {
        @NamedQuery(name = "GetUserByUsername", query = "select u from UserEntity u where u.username=:username"),
        @NamedQuery(name = "GetUserByIdentityId", query = "select u from UserEntity u where u.identityId=:identityId")
})
public class UserEntity implements Serializable {

    @Id
    @Column(name = "id")
    @Access(AccessType.PROPERTY)
    private String id;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "identity_id")
    private String identityId;

    @NotNull
    @Column(name = "identity_provider")
    private String identityProvider;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Column(name = "joined_on")
    private Date joinedOn;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<OrganizationEntity> ownedOrganizations = new ArrayList<>();

    @Version
    @Column(name = "version")
    private int version;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) obj;
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
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getIdentityProvider() {
        return identityProvider;
    }

    public void setIdentityProvider(String identityProvider) {
        this.identityProvider = identityProvider;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public Date getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(Date joinedOn) {
        this.joinedOn = joinedOn;
    }

    public List<OrganizationEntity> getOwnedOrganizations() {
        return ownedOrganizations;
    }

    public void setOwnedOrganizations(List<OrganizationEntity> ownedOrganizations) {
        this.ownedOrganizations = ownedOrganizations;
    }
}