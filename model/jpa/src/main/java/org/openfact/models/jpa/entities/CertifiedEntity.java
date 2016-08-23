package org.openfact.models.jpa.entities;

import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 10/08/2016.
 */
@Table(name = "CERTIFIED")
@Entity
@NamedQueries({
        @NamedQuery(name = "getOrganizationCertifiedById", query = "select certified from CertifiedEntity certified inner join certified.organization organization where organization.id = :organizationId and certified.id = :id"),
        @NamedQuery(name = "getOrganizationCertifiedByAliasAndValidity", query = "select certified from CertifiedEntity certified inner join certified.organization organization where organization.id = :organizationId and certified.alias = :alias and  certified.validity=:validity"),
        @NamedQuery(name = "getAllCertifiedsByOrganization", query = "select certified from CertifiedEntity certified inner join certified.organization organization where organization.id = :organizationId"),
        @NamedQuery(name = "getEnabledCertifiedByOrganization", query = "select certified from CertifiedEntity certified inner join certified.organization organization where organization.id = :organizationId and certified.enabled=:enabled"),
        @NamedQuery(name = "searchForCertified", query = "select certified from CertifiedEntity certified")})
public class CertifiedEntity {

    @Id
   
    @Column(name = "ID", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    // Alias
    @NotNull
    @Column(name = "ALIAS_CERTIFICATE")
    private String alias;

    // Certificate   
    @Column(name = "URL_CERTIFICATE")
    private String certificate;

    // Certificate
    @NotNull
    @Column(name = "PASS_CERTIFICATE")
    private String password;

    // Fecha Vigencia
    @NotNull
    @Column(name = "VALIDITY_DATE")
    private LocalDate validity;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Column(name = "LOCAL")
    private boolean local;
    
    @NotNull
    @Column(name = "HAS_CERTIFICATE")
    private boolean hasCertificate;

    // Organization
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        CertifiedEntity other = (CertifiedEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

	public boolean isHasCertificate() {
		return hasCertificate;
	}

	public void setHasCertificate(boolean hasCertificate) {
		this.hasCertificate = hasCertificate;
	}

}
