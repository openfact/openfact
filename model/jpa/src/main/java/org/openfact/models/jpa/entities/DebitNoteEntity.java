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
@Table(name = "DEBIT_NOTE", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "ORGANIZATION_ID", "DOCUMENT_ID" }) })
@NamedQueries({
        @NamedQuery(name = "getAllDebitNotesByOrganization", query = "select c from DebitNoteEntity c where c.organizationId = :organizationId order by c.issueDateTime"),
        @NamedQuery(name = "getAllDebitNoteIdsByOrganization", query = "select c.id from DebitNoteEntity c where c.organizationId = :organizationId order by c.issueDateTime"),
        @NamedQuery(name = "getAllDebitNotesByRequiredActionAndOrganization", query = "select c from DebitNoteEntity c inner join c.requiredActions r where c.organizationId = :organizationId and r.action in :requiredAction order by c.issueDateTime"),
        @NamedQuery(name = "getOrganizationDebitNoteById", query = "select d from DebitNoteEntity d where d.id = :id and d.organizationId = :organizationId"),
        @NamedQuery(name = "getOrganizationDebitNoteByDocumentId", query = "select d from DebitNoteEntity d where d.documentId = :documentId and d.organizationId = :organizationId"),
        @NamedQuery(name = "searchForDebitNote", query = "select d from DebitNoteEntity d where d.organizationId = :organizationId and lower(d.documentId) like :search order by d.issueDateTime"),
        @NamedQuery(name = "getOrganizationDebitNoteCount", query = "select count(d) from DebitNoteEntity d where d.organizationId = :organizationId"),
        @NamedQuery(name="deleteDebitNotesByOrganization", query="delete from DebitNoteEntity u where u.organizationId = :organizationId") })
public class DebitNoteEntity {

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
    
    @Column(name = "ISSUE_DATE")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime issueDateTime;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGSUPPLIERPARTY_DEBITNOTE")
    private SupplierPartyEntity accountingSupplierParty;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CustomerPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCUSTOMERPARTY_DEBITNOTE")
    private CustomerPartyEntity accountingCustomerParty;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MonetaryTotalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REQUESTEDMONETARYTOTAL_DEBITNOTE")
    private MonetaryTotalEntity requestedMonetaryTotal;
    
    @OneToMany(fetch = FetchType.LAZY, targetEntity = TaxTotalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXTOTAL_DEBITNOTE_ID")
    private List<TaxTotalEntity> taxTotal = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, targetEntity = AllowanceChargeEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ALLOWANCECHARGE_DEBITNOTE")
    private List<AllowanceChargeEntity> allowanceCharge = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy="debitNote")
    private Collection<DebitNoteAttributeEntity> attributes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy="debitNote")
    private Collection<DebitNoteRequiredActionEntity> requiredActions = new ArrayList<>();

    @OneToMany(cascade = { CascadeType.REMOVE }, orphanRemoval = true, mappedBy = "debitNote", fetch = FetchType.LAZY)
    private Collection<DebitNoteSendEventEntity> sendEvents = new ArrayList<>();

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

    public MonetaryTotalEntity getRequestedMonetaryTotal() {
        return requestedMonetaryTotal;
    }

    public void setRequestedMonetaryTotal(MonetaryTotalEntity requestedMonetaryTotal) {
        this.requestedMonetaryTotal = requestedMonetaryTotal;
    }

    public List<TaxTotalEntity> getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(List<TaxTotalEntity> taxTotal) {
        this.taxTotal = taxTotal;
    }

    public List<AllowanceChargeEntity> getAllowanceCharge() {
        return allowanceCharge;
    }

    public void setAllowanceCharge(List<AllowanceChargeEntity> allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    /**
     * Openfact
     */
    public Collection<DebitNoteAttributeEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<DebitNoteAttributeEntity> attributes) {
        this.attributes = attributes;
    }

    public Collection<DebitNoteRequiredActionEntity> getRequiredActions() {
        return requiredActions;
    }

    public void setRequiredActions(Collection<DebitNoteRequiredActionEntity> requiredActions) {
        this.requiredActions = requiredActions;
    }

    public Collection<DebitNoteSendEventEntity> getSendEvents() {
        return sendEvents;
    }

    public void setSendEvents(Collection<DebitNoteSendEventEntity> sendEvents) {
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
        DebitNoteEntity other = (DebitNoteEntity) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }
}
