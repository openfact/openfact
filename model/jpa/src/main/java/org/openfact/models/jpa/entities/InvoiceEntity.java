package org.openfact.models.jpa.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.openfact.models.enums.AdditionalInformationType;
import org.openfact.models.enums.InvoiceType;
import org.openfact.models.enums.MonetaryTotalType;
import org.openfact.models.enums.TaxType;

@Table(name = "INVOICE")
@Entity
@NamedQueries({
        @NamedQuery(name = "getOrganizationInvoiceById", query = "select invoice from InvoiceEntity invoice inner join invoice.organization organization where organization.id = :organizationId and invoice.id = :id"),
        @NamedQuery(name = "getOrganizationInvoiceBySetAndNumber", query = "select invoice from InvoiceEntity invoice inner join invoice.organization organization inner join invoice.invoiceId invoiceId where organization.id = :organizationId and invoiceId.series = :series and invoiceId.number = :number"),
        @NamedQuery(name = "getAllInvoicesByOrganization", query = "select invoice from InvoiceEntity invoice inner join invoice.organization organization where organization.id = :organizationId"),
        @NamedQuery(name = "searchForInvoice", query = "select invoice from InvoiceEntity invoice") })
public class InvoiceEntity {

    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    private String id;

    // Tipo BOLETA, FACTURA, NOTA
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private InvoiceType type;

    // Fecha Emision
    @NotNull
    @Column(name = "ISSUE_DATE")
    private LocalDate issueDate;

    // Codigo de moneda
    @NotNull
    @NotBlank
    @Column(name = "CURRENCY_CODE")
    protected String currencyCode;

    // Serie y numero
    @OneToOne(mappedBy = "invoice", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private InvoiceIdEntity invoiceId;

    // Receptor
    @OneToOne(mappedBy = "invoice", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private CustomerEntity customer;

    // Emisor
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
    private OrganizationEntity organization;

    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "ADDITIONAL_INFORMATION", joinColumns = {@JoinColumn(name = "ADDITIONAL_INFORMATION_ID") })
    private Map<AdditionalInformationType, BigDecimal> additionalInformation = new HashMap<>();

    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "TAX_TOTAL", joinColumns = { @JoinColumn(name = "TAX_TOTAL_ID") })
    private Map<TaxType, BigDecimal> taxTotal = new HashMap<>();

    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "LEGAL_MONETARY_TOTAL", joinColumns = {@JoinColumn(name = "LEGAL_MONETARY_TOTAL_ID") })
    private Map<MonetaryTotalType, BigDecimal> legalMonetaryTotal = new HashMap<>();

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<InvoiceLineEntity> invoiceLines = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InvoiceType getType() {
        return type;
    }

    public void setType(InvoiceType type) {
        this.type = type;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public InvoiceIdEntity getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(InvoiceIdEntity invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public Map<AdditionalInformationType, BigDecimal> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Map<AdditionalInformationType, BigDecimal> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Map<TaxType, BigDecimal> getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(Map<TaxType, BigDecimal> taxTotal) {
        this.taxTotal = taxTotal;
    }

    public Map<MonetaryTotalType, BigDecimal> getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    public void setLegalMonetaryTotal(Map<MonetaryTotalType, BigDecimal> legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
    }

    public List<InvoiceLineEntity> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(List<InvoiceLineEntity> invoiceLines) {
        this.invoiceLines = invoiceLines;
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
        InvoiceEntity other = (InvoiceEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
