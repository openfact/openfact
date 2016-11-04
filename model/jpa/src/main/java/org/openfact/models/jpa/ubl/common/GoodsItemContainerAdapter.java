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

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.GoodsItemContainerEntity;
import org.openfact.models.jpa.entities.ubl.common.TransportEquipmentEntity;
import org.openfact.models.ubl.common.GoodsItemContainerModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.TransportEquipmentModel;

public class GoodsItemContainerAdapter implements GoodsItemContainerModel, JpaModel<GoodsItemContainerEntity> {

	protected static final Logger logger = Logger.getLogger(GoodsItemContainerAdapter.class);

	protected GoodsItemContainerEntity goodsItemContainer;
	protected EntityManager em;
	protected OpenfactSession session;

	public GoodsItemContainerAdapter(OpenfactSession session, EntityManager em,
			GoodsItemContainerEntity goodsItemContainer) {
		this.session = session;
		this.em = em;
		this.goodsItemContainer = goodsItemContainer;
	}

	@Override
	public GoodsItemContainerEntity getEntity() {
		return goodsItemContainer;
	}

	@Override
	public String getID() {
		return goodsItemContainer.getID();
	}

	@Override
	public void setID(String value) {
		goodsItemContainer.setID(value);
	}

	@Override
	public QuantityModel getQuantity() {
		return new QuantityAdapter(session, em, goodsItemContainer.getQuantity());
	}

	@Override
	public void setQuantity(QuantityModel value) {
		goodsItemContainer.setQuantity(QuantityAdapter.toEntity(value, em));
	}

	@Override
	public List<TransportEquipmentModel> getTransportEquipment() {
		return goodsItemContainer.getTransportEquipment().stream()
				.map(f -> new TransportEquipmentAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setTransportEquipment(List<TransportEquipmentModel> transportEquipment) {
		List<TransportEquipmentEntity> entities = transportEquipment.stream()
				.map(f -> TransportEquipmentAdapter.toEntity(f, em)).collect(Collectors.toList());
		goodsItemContainer.setTransportEquipment(entities);
	}

	@Override
	public String getId() {
		return goodsItemContainer.getId();
	}

	public static GoodsItemContainerEntity toEntity(GoodsItemContainerModel model, EntityManager em) {
		if (model instanceof GoodsItemContainerAdapter) {
			return ((GoodsItemContainerAdapter) model).getEntity();
		}
		return em.getReference(GoodsItemContainerEntity.class, model.getId());
	}
}
