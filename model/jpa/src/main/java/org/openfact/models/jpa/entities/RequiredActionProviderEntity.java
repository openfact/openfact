package org.openfact.models.jpa.entities;

import javax.persistence.*;
import java.util.Map;

@Table(name = "REQUIRED_ACTION_PROVIDER")
@Entity
@NamedQueries({
        @NamedQuery(name = "deleteRequiredActionProviderByOrganization", query = "delete from RequiredActionProviderEntity action where action.organization = :organization")
})
public class RequiredActionProviderEntity {

    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "ALIAS")
    protected String alias;

    @Column(name = "NAME")
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey)
    protected OrganizationEntity organization;

    @Column(name = "PROVIDER_ID")
    protected String providerId;

    @Column(name = "ENABLED")
    protected boolean enabled;

    @Column(name = "DEFAULT_ACTION")
    protected boolean defaultAction;

    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "REQUIRED_ACTION_CONFIG", joinColumns = {@JoinColumn(name = "REQUIRED_ACTION_ID")})
    private Map<String, String> config;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDefaultAction() {
        return defaultAction;
    }

    public void setDefaultAction(boolean defaultAction) {
        this.defaultAction = defaultAction;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof RequiredActionProviderEntity)) return false;

        RequiredActionProviderEntity that = (RequiredActionProviderEntity) o;

        if (!id.equals(that.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
