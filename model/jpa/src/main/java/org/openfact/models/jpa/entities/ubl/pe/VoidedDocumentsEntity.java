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
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.SupplierPartyEntity;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionsEntity;
import org.openfact.models.jpa.entities.ubl.common.VoidedDocumentsLineEntity;

@Entity
@Table(name = "VOIDED_DOCUMENTS", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "ORGANIZATION_ID", "ID_UBL" }) })
@NamedQueries({
	@NamedQuery(name = "getAllVoidedDocumentsByOrganization", query = "select i from VoidedDocumentsEntity i where i.organization.id = :organizationId order by i.issueDateTime"),
	@NamedQuery(name = "getOrganizationVoidedDocumentsById", query = "select i from VoidedDocumentsEntity i where i.id = :id and i.organization.id = :organizationId"),
	@NamedQuery(name = "getOrganizationVoidedDocumentsByID", query = "select i from VoidedDocumentsEntity i where i.ID = :ID and i.organization.id = :organizationId"),
	@NamedQuery(name = "searchForVoidedDocuments", query = "select i from VoidedDocumentsEntity i where i.organization.id = :organizationId and i.ID like :search order by i.issueDateTime"),
	@NamedQuery(name = "getOrganizationVoidedDocumentsCount", query = "select count(i) from VoidedDocumentsEntity i where i.organization.id = :organizationId"),
	@NamedQuery(name = "getLastVoidedDocumentsByOrganization", query = "select i from VoidedDocumentsEntity i where i.organization.id = :organizationId and length(i.ID)=:IDLength and i.ID like :formatter order by i.issueDateTime desc"), })
public class VoidedDocumentsEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "voidedDocuments")
	protected Collection<VoidedDocumentsAttributeEntity> attributes = new ArrayList<>();
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
	private OrganizationEntity organization;
	
	@ManyToOne(targetEntity = UBLExtensionsEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "UBLEXTENSIONS_VOIDED_DOCUMENTS_ID")
	protected UBLExtensionsEntity ublExtensions = new UBLExtensionsEntity();

	@Column(name = "UBL_VERSIONID")
	protected String ublVersionID;

	@Column(name = "CUSTOMIZATIONID")
	protected String customizationID;

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "REFERENCE_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime referenceDate;

	@Column(name = "ISSUE_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime issueDateTime;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "VOIDED_DOCUMENT_NOTE", joinColumns = { @JoinColumn(name = "VOIDED_DOCUMENT_ID") })
	protected List<String> note = new ArrayList<>();

	@OneToMany(targetEntity = SignatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SIGNATURE_VOIDEDDOCUMENT")
	protected List<SignatureEntity> signature = new ArrayList<>();

	@ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACCOUNTINGSUPPLIERPARTY_VOIDEDDOCUMENTS")
	protected SupplierPartyEntity accountingSupplierParty = new SupplierPartyEntity();

	@OneToMany(targetEntity = VoidedDocumentsLineEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "VOIDEDDOCUMENTSLINE_VOIDEDDOCUMENTS_ID")
	protected List<VoidedDocumentsLineEntity> voidedDocumentsLine = new ArrayList<>();

	@Lob
	@Column(name = "XML_DOCUMENT")
	protected Byte[] xmlDocument;

	@ElementCollection
	@Column(name = "REQUERID_ACTION")
	@CollectionTable(name = "VOIDEDDOCUMENTS_REQUERID_ACTION", joinColumns = {
			@JoinColumn(name = "VOIDED_DOCUMENTS_ID") })
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

	public Collection<VoidedDocumentsAttributeEntity> getAttributes() {
		return attributes;
	}

	public void setAttributes(Collection<VoidedDocumentsAttributeEntity> attributes) {
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

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public LocalDateTime getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(LocalDateTime referenceDate) {
		this.referenceDate = referenceDate;
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

	public List<SignatureEntity> getSignature() {
		return signature;
	}

	public void setSignature(List<SignatureEntity> signature) {
		this.signature = signature;
	}

	public SupplierPartyEntity getAccountingSupplierParty() {
		return accountingSupplierParty;
	}

	public void setAccountingSupplierParty(SupplierPartyEntity accountingSupplierParty) {
		this.accountingSupplierParty = accountingSupplierParty;
	}

	public List<VoidedDocumentsLineEntity> getVoidedDocumentsLine() {
		return voidedDocumentsLine;
	}

	public void setVoidedDocumentsLine(List<VoidedDocumentsLineEntity> voidedDocumentsLine) {
		this.voidedDocumentsLine = voidedDocumentsLine;
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