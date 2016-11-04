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

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.TransportMeansEntity;
import org.openfact.models.ubl.common.AirTransportModel;
import org.openfact.models.ubl.common.MaritimeTransportModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.RailTransportModel;
import org.openfact.models.ubl.common.RoadTransportModel;
import org.openfact.models.ubl.common.StowageModel;
import org.openfact.models.ubl.common.TransportMeansModel;

public class TransportMeansAdapter implements TransportMeansModel, JpaModel<TransportMeansEntity> {

	protected static final Logger logger = Logger.getLogger(TransportMeansAdapter.class);

	protected TransportMeansEntity transportMeans;
	protected EntityManager em;
	protected OpenfactSession session;

	public TransportMeansAdapter(OpenfactSession session, EntityManager em, TransportMeansEntity transportMeans) {
		this.session = session;
		this.em = em;
		this.transportMeans = transportMeans;
	}

	@Override
	public TransportMeansEntity getEntity() {
		return transportMeans;
	}

	@Override
	public String getJourneyID() {
		return transportMeans.getJourneyID();
	}

	@Override
	public void setJourneyID(String value) {
		transportMeans.setJourneyID(value);
	}

	@Override
	public String getRegistrationNationalityID() {
		return transportMeans.getRegistrationNationalityID();
	}

	@Override
	public void setRegistrationNationalityID(String value) {
		transportMeans.setRegistrationNationalityID(value);
	}

	@Override
	public List<String> getRegistrationNationality() {
		return transportMeans.getRegistrationNationality();
	}

	@Override
	public void setRegistrationNationality(List<String> registrationNationality) {
		transportMeans.setRegistrationNationality(registrationNationality);
	}

	@Override
	public String getDirectionCode() {
		return transportMeans.getDirectionCode();
	}

	@Override
	public void setDirectionCode(String value) {
		transportMeans.setDirectionCode(value);
	}

	@Override
	public StowageModel getStowage() {
		return new StowageAdapter(session, em, transportMeans.getStowage());
	}

	@Override
	public void setStowage(StowageModel value) {
		transportMeans.setStowage(StowageAdapter.toEntity(value, em));
	}

	@Override
	public AirTransportModel getAirTransport() {
		return new AirTransportAdapter(session, em, transportMeans.getAirTransport());
	}

	@Override
	public void setAirTransport(AirTransportModel value) {
		transportMeans.setAirTransport(AirTransportAdapter.toEntity(value, em));
	}

	@Override
	public RoadTransportModel getRoadTransport() {
		return new RoadTransportAdapter(session, em, transportMeans.getRoadTransport());
	}

	@Override
	public void setRoadTransport(RoadTransportModel value) {
		transportMeans.setRoadTransport(RoadTransportAdapter.toEntity(value, em));
	}

	@Override
	public RailTransportModel getRailTransport() {
		return new RailTransportAdapter(session, em, transportMeans.getRailTransport());
	}

	@Override
	public void setRailTransport(RailTransportModel value) {
		transportMeans.setRailTransport(RailTransportAdapter.toEntity(value, em));
	}

	@Override
	public MaritimeTransportModel getMaritimeTransport() {
		return new MaritimeTransportAdapter(session, em, transportMeans.getMaritimeTransport());
	}

	@Override
	public void setMaritimeTransport(MaritimeTransportModel value) {
		transportMeans.setMaritimeTransport(MaritimeTransportAdapter.toEntity(value, em));
	}

	@Override
	public PartyModel getOwnerParty() {
		return new PartyAdapter(session, em, transportMeans.getOwnerParty());
	}

	@Override
	public void setOwnerParty(PartyModel value) {
		transportMeans.setOwnerParty(PartyAdapter.toEntity(value, em));
	}

	@Override
	public String getId() {
		return transportMeans.getId();
	}

	public static TransportMeansEntity toEntity(TransportMeansModel model, EntityManager em) {
		if (model instanceof TransportMeansAdapter) {
			return ((TransportMeansAdapter) model).getEntity();
		}
		return em.getReference(TransportMeansEntity.class, model.getId());
	}

}
