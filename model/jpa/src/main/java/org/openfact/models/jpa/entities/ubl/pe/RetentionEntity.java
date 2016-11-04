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
package org.openfact.models.jpa.entities.ubl.pe;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.jpa.entities.ubl.common.PartyEntity;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionsEntity;
import org.openfact.models.jpa.entities.ubl.common.pe.RetentionDocumentReferenceEntity;

@Entity
@Table(name = "RETENTION", uniqueConstraints = { @UniqueConstraint(columnNames = { "ORGANIZATION_ID", "ID_UBL" }) })
@NamedQueries({
		@NamedQuery(name = "getAllRetentionsByOrganization", query = "select i from RetentionEntity i where i.organization.id = :organizationId order by i.issueDateTime"),
		@NamedQuery(name = "getOrganizationRetentionById", query = "select i from RetentionEntity i where i.id = :id and i.organization.id = :organizationId"),
		@NamedQuery(name = "getOrganizationRetentionByID", query = "select i from RetentionEntity i where i.ID = :ID and i.organization.id = :organizationId"),
		@NamedQuery(name = "searchForRetention", query = "select i from RetentionEntity i where i.organization.id = :organizationId and i.ID like :search order by i.issueDateTime"),
		@NamedQuery(name = "getOrganizationRetentionCount", query = "select count(i) from RetentionEntity i where i.organization.id = :organizationId"),
		@NamedQuery(name = "getLastRetentionByOrganization", query = "select i from RetentionEntity i where i.organization.id = :organizationId and length(i.ID)=:IDLength and i.ID like :formatter order by i.issueDateTime desc"), })
public class RetentionEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "retention")
	protected Collection<RetentionAttributeEntity> attributes = new ArrayList<>();

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
	private OrganizationEntity organization;

	@ManyToOne(targetEntity = UBLExtensionsEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "UBLEXTENSIONS_RETENTION_ID")
	protected UBLExtensionsEntity ublExtensions = new UBLExtensionsEntity();

	@Column(name = "UBL_VERSIONID")
	protected String ublVersionID;

	@Column(name = "CUSTOMIZATIONID")
	protected String customizationID;

	@OneToMany(targetEntity = SignatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SIGNATURE_RETENTION")
	protected List<SignatureEntity> signature = new ArrayList<>();

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "ISSUE_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime issueDateTime;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "RETENTION_NOTE", joinColumns = { @JoinColumn(name = "RETENTION_ID") })
	protected List<String> note = new ArrayList<>();

	@Column(name = "RETENTION_SYSTEM_CODE")
	protected String SUNATRetentionSystemCode;

	@Column(name = "RETENTION_PERCENT")
	protected BigDecimal SUNATRetentionPercent;

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "AGENTPARTY_RETENTION_ID")
	protected PartyEntity agentParty = new PartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "RECEIVERPARTY_RETENTION_ID")
	protected PartyEntity receiverParty = new PartyEntity();

	@Column(name = "TOTAL_INVOICE_AMOUNT")
	protected BigDecimal totalInvoiceAmount;

	@Column(name = "TOTAL_PAID")
	protected BigDecimal SUNATTotalPaid;

	@OneToMany(targetEntity = RetentionDocumentReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "RETENTIONDOCUMENTREFERECE_RETENTION_ID")
	protected List<RetentionDocumentReferenceEntity> SUNATRetentionDocumentReference = new ArrayList<>();

	@Lob
	@Column(name = "XML_DOCUMENT")
	protected Byte[] xmlDocument;

	@ElementCollection
	@Column(name = "REQUERID_ACTION")
	@CollectionTable(name = "RETENTION_REQUERID_ACTION", joinColumns = { @JoinColumn(name = "RETENTION_ID") })
	@Enumerated(EnumType.STRING)
	protected List<RequeridActionDocument> requeridAction = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	public Collection<RetentionAttributeEntity> getAttributes() {
		return attributes;
	}

	public void setAttributes(Collection<RetentionAttributeEntity> attributes) {
		this.attributes = attributes;
	}

	public UBLExtensionsEntity getUblExtensions() {
		return ublExtensions;
	}

	public void setUblExtensions(UBLExtensionsEntity ublExtensions) {
		this.ublExtensions = ublExtensions;
	}

	public String getUblVersionID() {
		return ublVersionID;
	}

	public void setUblVersionID(String ublVersionID) {
		this.ublVersionID = ublVersionID;
	}

	public String getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
	}

	public List<SignatureEntity> getSignature() {
		return signature;
	}

	public void setSignature(List<SignatureEntity> signature) {
		this.signature = signature;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public LocalDateTime getIssueDateTime() {
		return issueDateTime;
	}

	public void setIssueDateTime(LocalDateTime issueDateTime) {
		this.issueDateTime = issueDateTime;
	}

	public List<String> getNote() {
		return note;
	}

	public void setNote(List<String> note) {
		this.note = note;
	}

	public String getSUNATRetentionSystemCode() {
		return SUNATRetentionSystemCode;
	}

	public void setSUNATRetentionSystemCode(String sUNATRetentionSystemCode) {
		SUNATRetentionSystemCode = sUNATRetentionSystemCode;
	}

	public BigDecimal getSUNATRetentionPercent() {
		return SUNATRetentionPercent;
	}

	public void setSUNATRetentionPercent(BigDecimal sUNATRetentionPercent) {
		SUNATRetentionPercent = sUNATRetentionPercent;
	}

	public PartyEntity getAgentParty() {
		return agentParty;
	}

	public void setAgentParty(PartyEntity agentParty) {
		this.agentParty = agentParty;
	}

	public PartyEntity getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(PartyEntity receiverParty) {
		this.receiverParty = receiverParty;
	}

	public BigDecimal getTotalInvoiceAmount() {
		return totalInvoiceAmount;
	}

	public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
		this.totalInvoiceAmount = totalInvoiceAmount;
	}

	public BigDecimal getSUNATTotalPaid() {
		return SUNATTotalPaid;
	}

	public void setSUNATTotalPaid(BigDecimal sUNATTotalPaid) {
		SUNATTotalPaid = sUNATTotalPaid;
	}

	public List<RetentionDocumentReferenceEntity> getSUNATRetentionDocumentReference() {
		return SUNATRetentionDocumentReference;
	}

	public void setSUNATRetentionDocumentReference(
			List<RetentionDocumentReferenceEntity> sUNATRetentionDocumentReference) {
		SUNATRetentionDocumentReference = sUNATRetentionDocumentReference;
	}

	public Byte[] getXmlDocument() {
		return xmlDocument;
	}

	public void setXmlDocument(Byte[] xmlDocument) {
		this.xmlDocument = xmlDocument;
	}

	public List<RequeridActionDocument> getRequeridAction() {
		return requeridAction;
	}

	public void setRequeridAction(List<RequeridActionDocument> requeridAction) {
		this.requeridAction = requeridAction;
	}

}
