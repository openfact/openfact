package org.openfact.models.jpa.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "INVOICE")
@NamedQueries({
        @NamedQuery(name = "getOrganizationInvoiceById", query = "select invoice from InvoiceEntity invoice inner join invoice.organization organization where organization.id = :organizationId and invoice.id = :id"),
        @NamedQuery(name = "getOrganizationInvoiceBySetAndNumber", query = "select invoice from InvoiceEntity invoice inner join invoice.organization organization inner join invoice.invoiceId invoiceId where organization.id = :organizationId and invoiceId.series = :series and invoiceId.number = :number"),
        @NamedQuery(name = "getAllInvoicesByOrganization", query = "select invoice from InvoiceEntity invoice inner join invoice.organization organization where organization.id = :organizationId"),
        @NamedQuery(name = "searchForInvoice", query = "select invoice from InvoiceEntity invoice") })
public class InvoiceEntity {

    @Id
    @Column(name = "ID", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @Embedded
    @AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "TYPE_NAME")),
            @AttributeOverride(name = "documentId", column = @Column(name = "TYPE_ID")) })
    private DocumentSavedEntity type;

    @Column(name = "ISSUE_DATE")
    private LocalDate issueDate;

    @Column(name = "CURRENCY_CODE")
    protected String currencyCode;

    @OneToOne(mappedBy = "invoice", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private InvoiceIdEntity invoiceId;

    @OneToOne(mappedBy = "invoice", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_SAVED_ID")
    private OrganizationSavedEntity organizationSaved;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
    private OrganizationEntity organization;

    @Column(name = "ALOWANCE_TOTAL_AMOUNT")
    private BigDecimal allowanceTotalAmount;

    @Column(name = "CHARGE_TOTAL_AMOUNT")
    private BigDecimal chargeTotalAmount;

    @Column(name = "PAYABLE_AMOUNT")
    private BigDecimal payableAmount;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<InvoiceAdditionalInformationEntity> additionalInformation = new HashSet<>();

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<InvoiceTaxTotalEntity> taxTotals = new HashSet<>();

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<InvoiceLineEntity> invoiceLines = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DocumentSavedEntity getType() {
        return type;
    }

    public void setType(DocumentSavedEntity type) {
        this.type = type;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public InvoiceIdEntity getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(InvoiceIdEntity invoiceId) {
        this.invoiceId = invoiceId;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public OrganizationSavedEntity getOrganizationSaved() {
        return organizationSaved;
    }

    public void setOrganizationSaved(OrganizationSavedEntity organizationSaved) {
        this.organizationSaved = organizationSaved;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public BigDecimal getAllowanceTotalAmount() {
        return allowanceTotalAmount;
    }

    public void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount) {
        this.allowanceTotalAmount = allowanceTotalAmount;
    }

    public BigDecimal getChargeTotalAmount() {
        return chargeTotalAmount;
    }

    public void setChargeTotalAmount(BigDecimal chargeTotalAmount) {
        this.chargeTotalAmount = chargeTotalAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Set<InvoiceAdditionalInformationEntity> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(Set<InvoiceAdditionalInformationEntity> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Set<InvoiceTaxTotalEntity> getTaxTotals() {
        return taxTotals;
    }

    public void setTaxTotals(Set<InvoiceTaxTotalEntity> taxTotals) {
        this.taxTotals = taxTotals;
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