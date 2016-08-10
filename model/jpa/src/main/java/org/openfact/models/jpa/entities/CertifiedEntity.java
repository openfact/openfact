package org.openfact.models.jpa.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 10/08/2016.
 */
@Table(name = "CERTIFIED")
@Entity
@NamedQueries({
        @NamedQuery(name = "getOrganizationCertifiedById", query = "select certified from CertifiedEntity certified inner join certified.organization organization where organization.id = :organizationId and certified.id = :id"),
        @NamedQuery(name = "getOrganizationCertifiedByAliasAndValidity", query = "select certified from CertifiedEntity certified inner join certified.organization organization where organization.id = :organizationId and certified.alias = :alias and  certified.validity=:validity"),
        @NamedQuery(name = "getAllCertifiedsByOrganization", query = "select certified from CertifiedEntity certified inner join certified.organization organization where organization.id = :organizationId"),
        @NamedQuery(name = "searchForCertified", query = "select certified from CertifiedEntity certified")})
public class CertifiedEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "CERTIFIED_ID", length = 36)
    protected String id;

    // Alias
    @NotNull
    @Column(name = "ALIAS_CERTIFICATE")
    protected String alias;

    // Certificate
    @NotNull
    @Column(name = "URL_CERTIFICATE")
    protected String certificate;

    // Certificate
    @NotNull
    @Column(name = "PASS_CERTIFICATE")
    protected String password;

    // Fecha Vigencia
    @NotNull
    @Column(name = "VALIDITY_DATE")
    protected LocalDate validity;

    @Column(name = "ENABLED")
    protected boolean enabled;

    @Column(name = "LOCAL")
    protected boolean local;

    // Organization
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
    protected OrganizationEntity organization;

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
}
