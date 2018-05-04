package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.openfact.core.models.jpa.entities.OrganizationEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "resumen_diario")
public class ResumenDiarioEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "id")
    private String id;

    @NotNull
    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "enviar_sunat")
    private boolean enviarSunat;

    @OneToMany(mappedBy = "resumenDiario", fetch = FetchType.LAZY)
    private List<InvoiceEntity> invoices = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "cdr_id")
    private CdrEntity cdr;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "estado_sunat_id")
    private EstadoSunatEntity estadoSunat;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "organization_id")
    private OrganizationEntity organization;

    @ElementCollection
    @Column(name = "value")
    @CollectionTable(name = "resumen_diario_labels", joinColumns = {@JoinColumn(name = "resumen_diario_id")})
    private Set<String> labels = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isEnviarSunat() {
        return enviarSunat;
    }

    public void setEnviarSunat(boolean enviarSunat) {
        this.enviarSunat = enviarSunat;
    }

    public List<InvoiceEntity> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceEntity> invoices) {
        this.invoices = invoices;
    }

    public EstadoSunatEntity getEstadoSunat() {
        return estadoSunat;
    }

    public void setEstadoSunat(EstadoSunatEntity estadoSunat) {
        this.estadoSunat = estadoSunat;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    public CdrEntity getCdr() {
        return cdr;
    }

    public void setCdr(CdrEntity cdr) {
        this.cdr = cdr;
    }
}
