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

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "VOIDED_DOCUMENTS_LINE")
public class VoidedDocumentsLineEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

    @Column(name = "ID_UBL")
    protected String ID;
    
	@Column(name = "LINE_ID")
	protected String lineID;
	
	@Column(name = "DOCUMENT_TYPE_CODE")	
	protected String documentTypeCode;
	
	@Column(name = "DOCUMENT_SERIAL_ID")
	protected String documentSerialID;
	
	@Column(name = "DOCUMENT_NUMBER_ID")
	protected String documentNumberID;
	
	@Column(name = "VOID_REASON_DESCRIPTION")
	protected String voidReasonDescription;

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

	public String getLineID() {
		return lineID;
	}

	public void setLineID(String lineID) {
		this.lineID = lineID;
	}

	public String getDocumentTypeCode() {
		return documentTypeCode;
	}

	public void setDocumentTypeCode(String documentTypeCode) {
		this.documentTypeCode = documentTypeCode;
	}

	public String getDocumentSerialID() {
		return documentSerialID;
	}

	public void setDocumentSerialID(String documentSerialID) {
		this.documentSerialID = documentSerialID;
	}

	public String getDocumentNumberID() {
		return documentNumberID;
	}

	public void setDocumentNumberID(String documentNumberID) {
		this.documentNumberID = documentNumberID;
	}

	public String getVoidReasonDescription() {
		return voidReasonDescription;
	}

	public void setVoidReasonDescription(String voidReasonDescription) {
		this.voidReasonDescription = voidReasonDescription;
	}

}
