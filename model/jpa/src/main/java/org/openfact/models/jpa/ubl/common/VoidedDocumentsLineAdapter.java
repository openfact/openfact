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
package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.VoidedDocumentsLineEntity;
import org.openfact.models.ubl.common.VoidedDocumentsLineModel;

public class VoidedDocumentsLineAdapter implements VoidedDocumentsLineModel, JpaModel<VoidedDocumentsLineEntity> {

	protected static final Logger logger = Logger.getLogger(VoidedDocumentsLineAdapter.class);

	protected VoidedDocumentsLineEntity voidedDocumentsLine;
	protected EntityManager em;
	protected OpenfactSession session;

	public VoidedDocumentsLineAdapter(OpenfactSession session, EntityManager em,
			VoidedDocumentsLineEntity voidedDocumentsLine) {
		this.session = session;
		this.em = em;
		this.voidedDocumentsLine = voidedDocumentsLine;
	}

	@Override
	public VoidedDocumentsLineEntity getEntity() {
		return voidedDocumentsLine;
	}

	@Override
	public String getLineID() {
		return voidedDocumentsLine.getLineID();
	}

	@Override
	public void setLineID(String value) {
		voidedDocumentsLine.setLineID(value);
	}

	@Override
	public String getDocumentTypeCode() {
		return voidedDocumentsLine.getDocumentTypeCode();
	}

	@Override
	public void setDocumentTypeCode(String value) {
		voidedDocumentsLine.setDocumentTypeCode(value);
	}

	@Override
	public String getDocumentSerialID() {
		return voidedDocumentsLine.getDocumentSerialID();
	}

	@Override
	public void setDocumentSerialID(String value) {
		voidedDocumentsLine.setDocumentSerialID(value);
	}

	@Override
	public String getDocumentNumberID() {
		return voidedDocumentsLine.getDocumentNumberID();
	}

	@Override
	public void setDocumentNumberID(String value) {
		voidedDocumentsLine.setDocumentNumberID(value);
	}

	@Override
	public String getVoidReasonDescription() {
		return voidedDocumentsLine.getVoidReasonDescription();
	}

	@Override
	public void setVoidReasonDescription(String value) {
		voidedDocumentsLine.setVoidReasonDescription(value);
	}

	@Override
	public String getId() {
		return voidedDocumentsLine.getId();
	}

	public static VoidedDocumentsLineEntity toEntity(VoidedDocumentsLineModel model, EntityManager em) {
		if (model instanceof VoidedDocumentsLineAdapter) {
			return ((VoidedDocumentsLineAdapter) model).getEntity();
		}
		return em.getReference(VoidedDocumentsLineEntity.class, model.getId());
	}

	@Override
	public String getID() {
		return voidedDocumentsLine.getID();
	}

	@Override
	public void setID(String ID) {
		voidedDocumentsLine.setID(ID);
	}

}
