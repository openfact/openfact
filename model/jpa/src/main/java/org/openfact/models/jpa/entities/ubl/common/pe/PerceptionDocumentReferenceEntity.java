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
package org.openfact.models.jpa.entities.ubl.common.pe;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.jpa.entities.ubl.common.PaymentEntity;

@Entity
@Table(name = "PERCEPTION_DOCUMENT_REFERENCE")
public class PerceptionDocumentReferenceEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;
	

	@Column(name = "ISSUE_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime issueDateTime;

	@Column(name = "TOTAL_INVOICE_AMOUNT")
	protected BigDecimal totalInvoiceAmount;

	@ManyToOne(targetEntity = PaymentEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PAYMENT_PERCEPTIONDOCUMENTREFERENCE")
	protected PaymentEntity payment = new PaymentEntity();

	@ManyToOne(targetEntity = PerceptionInformationEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PERCEPTIONINFORMATION_PERCEPTIONDOCUMENTREFERENCE")
	protected PerceptionInformationEntity sunatPerceptionInformation=new PerceptionInformationEntity();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public BigDecimal getTotalInvoiceAmount() {
		return totalInvoiceAmount;
	}

	public void setTotalInvoiceAmount(BigDecimal totalInvoiceAmount) {
		this.totalInvoiceAmount = totalInvoiceAmount;
	}

	public PaymentEntity getPayment() {
		return payment;
	}

	public void setPayment(PaymentEntity payment) {
		this.payment = payment;
	}

	public PerceptionInformationEntity getSunatPerceptionInformation() {
		return sunatPerceptionInformation;
	}

	public void setSunatPerceptionInformation(PerceptionInformationEntity sunatPerceptionInformation) {
		this.sunatPerceptionInformation = sunatPerceptionInformation;
	}
	
}
