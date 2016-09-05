package org.openfact.models.jpa.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "INVOICE", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "ORGANIZATION_ID", "SERIES", "NUMBER" }) 
})
@NamedQueries({
		@NamedQuery(name = "getOrganizationInvoiceById", query = "select invoice from InvoiceEntity invoice inner join invoice.organization organization where organization.id = :organizationId and invoice.id = :id"),
		@NamedQuery(name = "getOrganizationInvoiceBySetAndNumber", query = "select invoice from InvoiceEntity invoice inner join invoice.organization organization where organization.id = :organizationId and invoice.series = :series and invoice.number = :number"),
		@NamedQuery(name = "getAllInvoicesByOrganization", query = "select invoice from InvoiceEntity invoice inner join invoice.organization organization where organization.id = :organizationId"),
		@NamedQuery(name = "getLastInvoiceIdSeriesByOrganization", query = "select max(invoice.series) from InvoiceEntity invoice inner join invoice.organization organization where organization.id = :organizationId"),
		@NamedQuery(name = "getLastInvoiceIdNumberOfSeriesByOrganization", query = "select max(invoice.number) from InvoiceEntity invoice inner join invoice.organization organization where organization.id = :organizationId and invoice.series = :series"),
		@NamedQuery(name = "searchForInvoice", query = "select invoice from InvoiceEntity invoice") })
public class InvoiceEntity {

	@Id
	@Column(name = "ID", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;

	@Embedded
	@AttributeOverrides({ 
	    @AttributeOverride(name = "name", column = @Column(name = "TYPE_NAME")),
		@AttributeOverride(name = "documentId", column = @Column(name = "TYPE_ID")) })
	private DocumentSnapshotEntity type;

	@Column(name = "ISSUE_DATE")
	private LocalDate issueDate;

	@Column(name = "CURRENCY_CODE")
	protected String currencyCode;

	@NotNull
	@Column(name = "SERIES")
	private int series;

	@NotNull
	@Column(name = "NUMBER")
	private int number;

	@Column(name = "ALOWANCE_TOTAL_AMOUNT")
	private BigDecimal allowanceTotalAmount;

	@Column(name = "CHARGE_TOTAL_AMOUNT")
	private BigDecimal chargeTotalAmount;

	@Column(name = "PAYABLE_AMOUNT")
	private BigDecimal payableAmount;	

	@OneToOne(mappedBy = "invoice", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private CustomerEntity customer;

	@Column(name = "CREATED_TIMESTAMP")
	protected Long createdTimestamp;
	 
	@Lob
	@Basic(fetch = FetchType.LAZY)
    @Column(name = "UBL_REPRESENTATION")
    private String ublRepresentation;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
	private OrganizationEntity organization;

	@OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Set<InvoiceAdditionalInformationEntity> additionalInformation = new HashSet<>();

	@OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Set<InvoiceTaxTotalEntity> taxTotals = new HashSet<>();

	@OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<InvoiceLineEntity> invoiceLines = new ArrayList<>();

	@OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	protected Collection<InvoiceRequiredActionEntity> requiredActions = new ArrayList<>();

	@OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	protected Collection<InvoiceAttributeEntity> attributes = new ArrayList<>();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public DocumentSnapshotEntity getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(DocumentSnapshotEntity type) {
        this.type = type;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * @param currencyCode the currencyCode to set
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * @return the series
     */
    public int getSeries() {
        return series;
    }

    /**
     * @param series the series to set
     */
    public void setSeries(int series) {
        this.series = series;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the allowanceTotalAmount
     */
    public BigDecimal getAllowanceTotalAmount() {
        return allowanceTotalAmount;
    }

    /**
     * @param allowanceTotalAmount the allowanceTotalAmount to set
     */
    public void setAllowanceTotalAmount(BigDecimal allowanceTotalAmount) {
        this.allowanceTotalAmount = allowanceTotalAmount;
    }

    /**
     * @return the chargeTotalAmount
     */
    public BigDecimal getChargeTotalAmount() {
        return chargeTotalAmount;
    }

    /**
     * @param chargeTotalAmount the chargeTotalAmount to set
     */
    public void setChargeTotalAmount(BigDecimal chargeTotalAmount) {
        this.chargeTotalAmount = chargeTotalAmount;
    }

    /**
     * @return the payableAmount
     */
    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    /**
     * @param payableAmount the payableAmount to set
     */
    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    /**
     * @return the ublRepresentation
     */
    public String getUblRepresentation() {
        return ublRepresentation;
    }

    /**
     * @param ublRepresentation the ublRepresentation to set
     */
    public void setUblRepresentation(String ublRepresentation) {
        this.ublRepresentation = ublRepresentation;
    }

    /**
     * @return the customer
     */
    public CustomerEntity getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    /**
     * @return the organization
     */
    public OrganizationEntity getOrganization() {
        return organization;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    /**
     * @return the additionalInformation
     */
    public Set<InvoiceAdditionalInformationEntity> getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * @param additionalInformation the additionalInformation to set
     */
    public void setAdditionalInformation(Set<InvoiceAdditionalInformationEntity> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    /**
     * @return the taxTotals
     */
    public Set<InvoiceTaxTotalEntity> getTaxTotals() {
        return taxTotals;
    }

    /**
     * @param taxTotals the taxTotals to set
     */
    public void setTaxTotals(Set<InvoiceTaxTotalEntity> taxTotals) {
        this.taxTotals = taxTotals;
    }

    /**
     * @return the invoiceLines
     */
    public List<InvoiceLineEntity> getInvoiceLines() {
        return invoiceLines;
    }

    /**
     * @param invoiceLines the invoiceLines to set
     */
    public void setInvoiceLines(List<InvoiceLineEntity> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    /**
     * @return the requiredActions
     */
    public Collection<InvoiceRequiredActionEntity> getRequiredActions() {
        return requiredActions;
    }

    /**
     * @param requiredActions the requiredActions to set
     */
    public void setRequiredActions(Collection<InvoiceRequiredActionEntity> requiredActions) {
        this.requiredActions = requiredActions;
    }

    /**
     * @return the attributes
     */
    public Collection<InvoiceAttributeEntity> getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(Collection<InvoiceAttributeEntity> attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the createdTimestamp
     */
    public Long getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     * @param createdTimestamp the createdTimestamp to set
     */
    public void setCreatedTimestamp(Long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
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