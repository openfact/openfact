package org.openfact.models.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "deleteOrganizationAttributesByOrganization", query = "delete from OrganizationAttributeEntity attr where attr.organization = :organization")
})
@Table(name = "ORGANIZATION_ATTRIBUTE")
@Entity
@IdClass(OrganizationAttributeEntity.Key.class)
public class OrganizationAttributeEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    protected OrganizationEntity organization;

    @Id
    @Column(name = "NAME")
    protected String name;

    @Column(name = "VALUE")
    protected String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public static class Key implements Serializable {

        protected OrganizationEntity organization;

        protected String name;

        public Key() {
        }

        public Key(OrganizationEntity user, String name) {
            this.organization = user;
            this.name = name;
        }

        public OrganizationEntity getOrganization() {
            return organization;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (name != null ? !name.equals(key.name) : key.name != null) return false;
            if (organization != null ? !organization.getId().equals(key.organization != null ? key.organization.getId() : null) : key.organization != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = organization != null ? organization.getId().hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof OrganizationAttributeEntity)) return false;

        OrganizationAttributeEntity key = (OrganizationAttributeEntity) o;

        if (name != null ? !name.equals(key.name) : key.name != null) return false;
        if (organization != null ? !organization.getId().equals(key.organization != null ? key.organization.getId() : null) : key.organization != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = organization != null ? organization.getId().hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


}