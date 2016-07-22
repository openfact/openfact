package org.openfact.models.jpa.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.openfact.models.enums.AdditionalInformationType;
import org.openfact.models.enums.InvoiceType;
import org.openfact.models.enums.MonetaryTotalType;

@Entity(name = "INVOICE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
public class InvoiceEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    // Tipo BOLETA, FACTURA, NOTA
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private InvoiceType type;   
    
    //Fecha Emision
    @NotNull
    @Column(name = "ISSUE_DATE")
    private LocalDate issueDate;
    
    // Serie y numero
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "INVOICE_ID")
    private InvoiceIdEntity invoiceId;
    
    // Codigo de moneda
    @NotNull
    @NotBlank
    @Column(name = "CURRENCY_CODE")
    protected String currencyCode;
    
    // Emisor
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
    private OrganizationEntity organization;

    // Receptor
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "CUSTOMER_ID")
    private CustomerEntity customer;

    @ElementCollection
    @MapKeyColumn(name="NAME")
    @Column(name="VALUE")
    @CollectionTable(name="ADDITIONAL_INFORMATION", joinColumns={ @JoinColumn(name="ADDITIONAL_INFORMATION_ID") })
    private Map<AdditionalInformationType, BigDecimal> additionalInformation;
    
    @ElementCollection
    @MapKeyColumn(name="NAME")
    @Column(name="VALUE")
    @CollectionTable(name="LEGAL_MONETARY_TOTAL", joinColumns={ @JoinColumn(name="LEGAL_MONETARY_TOTAL_ID") })
    private Map<MonetaryTotalType, BigDecimal> legalMonetaryTotal;

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

    public Map<MonetaryTotalType, BigDecimal> getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    public void setLegalMonetaryTotal(Map<MonetaryTotalType, BigDecimal> legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
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
