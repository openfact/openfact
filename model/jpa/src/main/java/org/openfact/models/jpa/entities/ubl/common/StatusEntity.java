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
package org.openfact.models.jpa.entities.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "STATUS")
public class StatusEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "CONDITION_CODE")
	protected String conditionCode;

	@Column(name = "REFERENCE_DATE")
	@Type(type = "org.hibernate.type.LocalDateType")
	protected LocalDate referenceDate;

	@Column(name = "REFERENCE_TIME")
	@Type(type = "org.hibernate.type.LocalTimeType")
	protected LocalTime referenceTime;

	@Column(name = "DESCRIPTION")
	protected String description;

	@Column(name = "STATUS_REASON_CODE")
	protected String statusReasonCode;

	@Column(name = "STATUS_REASON")
	protected String statusReason;

	@Column(name = "SECUENCE_ID")
	protected String sequenceID;

	@Column(name = "TEXT")
	protected String text;

	@Column(name = "INDICATION_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean indicationIndicator;

	@Column(name = "PERCENT")
	protected BigDecimal percent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConditionCode() {
		return conditionCode;
	}

	public void setConditionCode(String conditionCode) {
		this.conditionCode = conditionCode;
	}

	public LocalDate getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(LocalDate referenceDate) {
		this.referenceDate = referenceDate;
	}

	public LocalTime getReferenceTime() {
		return referenceTime;
	}

	public void setReferenceTime(LocalTime referenceTime) {
		this.referenceTime = referenceTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatusReasonCode() {
		return statusReasonCode;
	}

	public void setStatusReasonCode(String statusReasonCode) {
		this.statusReasonCode = statusReasonCode;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public String getSequenceID() {
		return sequenceID;
	}

	public void setSequenceID(String sequenceID) {
		this.sequenceID = sequenceID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	

	public boolean isIndicationIndicator() {
		return indicationIndicator;
	}

	public void setIndicationIndicator(boolean indicationIndicator) {
		this.indicationIndicator = indicationIndicator;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

}
