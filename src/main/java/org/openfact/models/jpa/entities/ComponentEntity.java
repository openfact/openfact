
package org.openfact.models.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = "getComponents", query = "select attr from ComponentEntity attr where attr.company = :organization"),
        @NamedQuery(name = "getComponentsByParentAndType", query = "select attr from ComponentEntity attr where attr.company = :organization and attr.providerType = :providerType and attr.parentId = :parentId"),
        @NamedQuery(name = "getComponentByParent", query = "select attr from ComponentEntity attr where attr.company = :organization and attr.parentId = :parentId"),
        @NamedQuery(name = "getComponentIdsByParent", query = "select attr.id from ComponentEntity attr where attr.company = :organization and attr.parentId = :parentId"),
        @NamedQuery(name = "deleteComponentByOrganization", query = "delete from  ComponentEntity c where c.company = :organization"),
        @NamedQuery(name = "deleteComponentByParent", query = "delete from  ComponentEntity c where c.parentId = :parentId")
})
@Entity
@Table(name = "COMPONENT")
public class ComponentEntity {

    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    protected String id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "company_id")
    protected CompanyEntity company;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "PROVIDER_TYPE")
    protected String providerType;

    @Column(name = "PROVIDER_ID")
    protected String providerId;

    @Column(name = "PARENT_ID")
    protected String parentId;

    @Column(name = "SUB_TYPE")
    protected String subType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity organization) {
        this.company = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ComponentEntity)) return false;

        ComponentEntity that = (ComponentEntity) o;

        if (!id.equals(that.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
