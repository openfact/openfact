/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "CREDIT_NOTE", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "ORGANIZATION_ID", "DOCUMENT_ID"})
})
@NamedQueries({
        @NamedQuery(name = "getAllCreditNotesByOrganization", query = "select c from CreditNoteEntity c where c.organizationId = :organizationId order by c.createdTimestamp"),
        @NamedQuery(name = "getAllCreditNotesByOrganizationDesc", query = "select c from CreditNoteEntity c where c.organizationId = :organizationId order by c.createdTimestamp desc"),
        @NamedQuery(name = "getAllCreditNoteIdsByOrganization", query = "select c.id from CreditNoteEntity c where c.organizationId = :organizationId order by c.issueDateTime"),
        @NamedQuery(name = "getAllCreditNotesByRequiredActionAndOrganization", query = "select c from CreditNoteEntity c inner join c.requiredActions r where c.organizationId = :organizationId and r.action in :requiredAction order by c.issueDateTime"),
        @NamedQuery(name = "getOrganizationCreditNoteById", query = "select c from CreditNoteEntity c where c.id = :id and c.organizationId = :organizationId"),
        @NamedQuery(name = "getOrganizationCreditNoteByDocumentId", query = "select c from CreditNoteEntity c where c.documentId = :documentId and c.organizationId = :organizationId"),
        @NamedQuery(name = "searchForCreditNote", query = "select c from CreditNoteEntity c where c.organizationId = :organizationId and lower(c.documentId) like :search order by c.issueDateTime"),
        @NamedQuery(name = "getOrganizationCreditNoteCount", query = "select count(c) from CreditNoteEntity c where c.organizationId = :organizationId"),
        @NamedQuery(name="deleteCreditNotesByOrganization", query="delete from CreditNoteEntity u where u.organizationId = :organizationId") })
public class CreditNoteEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @Column(name = "DOCUMENT_ID")
    private String documentId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "XML_DOCUMENT")
    private byte[] xmlDocument;

    @NotNull
    @Column(name = "ORGANIZATION_ID")
    private String organizationId;

    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @Column(name = "CREATED_TIMESTAMP")
    private LocalDateTime createdTimestamp;
   
    @Column(name = "DOCUMENT_CURRENCY_CODE")
    private String documentCurrencyCode;
    
    @Column(name = "ISSUE_DATE_TIME")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime issueDateTime;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MonetaryTotalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LEGALMONETARYTOTAL_CREDITNOTE")
    private MonetaryTotalEntity legalMonetaryTotal;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGSUPPLIERPARTY_CREDITNOTE")
    private SupplierPartyEntity accountingSupplierParty;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CustomerPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCUSTOMERPARTY_CREDITNOTE")
    private CustomerPartyEntity accountingCustomerParty;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ResponseEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DISCREPANCYRESPONSE_CREDITNOTE")
    private List<ResponseEntity> discrepancyResponse = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, targetEntity = AllowanceChargeEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ALLOWANCECHARGE_CREDITNOTE")
    private List<AllowanceChargeEntity> allowanceCharge = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, targetEntity = TaxTotalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXTOTAL_CREDITNOTE_ID")
    private List<TaxTotalEntity> taxTotal = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy="creditNote")
    private Collection<CreditNoteAttributeEntity> attributes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy="creditNote")
    private Collection<CreditNoteRequiredActionEntity> requiredActions = new ArrayList<>();

    @OneToMany(cascade = { CascadeType.REMOVE }, orphanRemoval = true, mappedBy = "creditNote", fetch = FetchType.LAZY)
    private Collection<CreditNoteSendEventEntity> sendEvents = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public byte[] getXmlDocument() {
        return xmlDocument;
    }

    public void setXmlDocument(byte[] xmlDocument) {
        this.xmlDocument = xmlDocument;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    /**
     * UBL
     */
    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    public void setDocumentCurrencyCode(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    public LocalDateTime getIssueDateTime() {
        return issueDateTime;
    }

    public void setIssueDateTime(LocalDateTime issueDateTime) {
        this.issueDateTime = issueDateTime;
    }

    public MonetaryTotalEntity getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    public void setLegalMonetaryTotal(MonetaryTotalEntity legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
    }

    public SupplierPartyEntity getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    public void setAccountingSupplierParty(SupplierPartyEntity accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }

    public CustomerPartyEntity getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    public void setAccountingCustomerParty(CustomerPartyEntity accountingCustomerParty) {
        this.accountingCustomerParty = accountingCustomerParty;
    }

    public List<ResponseEntity> getDiscrepancyResponse() {
        return discrepancyResponse;
    }

    public void setDiscrepancyResponse(List<ResponseEntity> discrepancyResponse) {
        this.discrepancyResponse = discrepancyResponse;
    }

    public List<AllowanceChargeEntity> getAllowanceCharge() {
        return allowanceCharge;
    }

    public void setAllowanceCharge(List<AllowanceChargeEntity> allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    public List<TaxTotalEntity> getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(List<TaxTotalEntity> taxTotal) {
        this.taxTotal = taxTotal;
    }

    /**
     * Openfact
     */
    public Collection<CreditNoteAttributeEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<CreditNoteAttributeEntity> attributes) {
        this.attributes = attributes;
    }

    public Collection<CreditNoteRequiredActionEntity> getRequiredActions() {
        return requiredActions;
    }

    public void setRequiredActions(Collection<CreditNoteRequiredActionEntity> requiredActions) {
        this.requiredActions = requiredActions;
    }

    public Collection<CreditNoteSendEventEntity> getSendEvents() {
        return sendEvents;
    }

    public void setSendEvents(Collection<CreditNoteSendEventEntity> sendEvents) {
        this.sendEvents = sendEvents;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
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
        CreditNoteEntity other = (CreditNoteEntity) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }
}
