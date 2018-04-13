package org.openfact.core.models.jpa.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Indexed;
import org.openfact.core.models.OrganizationType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Indexed
@Entity
@Cacheable
@Table(name = "organization", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
@NamedQueries(value = {
        @NamedQuery(name = "ListOrganizations", query = "select o from OrganizationEntity o"),
        @NamedQuery(name = "FilterOrganizations", query = "select o from OrganizationEntity o where lower(o.name) like :filterText"),
})
public class OrganizationEntity implements Serializable {

    @Id
    @Column(name = "id")
    @Access(AccessType.PROPERTY)
    private String id;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private OrganizationType type;

    @NotNull
    @NaturalId(mutable = true)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "time_zone")
    private String timeZone;

    @NotNull
    @Type(type = "org.hibernate.type.TrueFalseType")
    @Column(name = "use_custom_certificates")
    private boolean useCustomCertificates;

    @NotNull
    @Type(type = "org.hibernate.type.TrueFalseType")
    @Column(name = "use_custom_smtp_config")
    private boolean useCustomSmtpConfig;

    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "organization_smtp_config", joinColumns = {@JoinColumn(name = "organization_id")})
    private Map<String, String> smtpConfig = new HashMap<>();

    @Version
    @Column(name = "version")
    private int version;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrganizationEntity)) {
            return false;
        }
        OrganizationEntity other = (OrganizationEntity) obj;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public Map<String, String> getSmtpConfig() {
        return smtpConfig;
    }

    public void setSmtpConfig(Map<String, String> smtpConfig) {
        this.smtpConfig = smtpConfig;
    }

    public boolean isUseCustomSmtpConfig() {
        return useCustomSmtpConfig;
    }

    public void setUseCustomSmtpConfig(boolean useAdminSmtpConfig) {
        this.useCustomSmtpConfig = useAdminSmtpConfig;
    }

    public boolean isUseCustomCertificates() {
        return useCustomCertificates;
    }

    public void setUseCustomCertificates(boolean useCustomCertificates) {
        this.useCustomCertificates = useCustomCertificates;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }
}