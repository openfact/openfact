package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.CommunicationModel;

public class CommunicationAdapter implements CommunicationModel, JpaModel<CommunicationEntity> {

    protected static final Logger logger = Logger.getLogger(CommunicationAdapter.class);
    protected CommunicationEntity communication;
    protected EntityManager em;
    protected OpenfactSession session;

    public CommunicationAdapter(OpenfactSession session, EntityManager em,
            CommunicationEntity communication) {
        this.session = session;
        this.em = em;
        this.communication = communication;
    }

    @Override
    public String getChannelCode() {
        return this.communication.getChannelCode();
    }

    @Override
    public void setChannelCode(String value) {
        this.communication.setChannelCode(value);
    }

    @Override
    public String getChannel() {
        return this.communication.getChannel();
    }

    @Override
    public void setChannel(String value) {
        this.communication.setChannel(value);
    }

    @Override
    public String getValue() {
        return this.communication.getValue();
    }

    @Override
    public void setValue(String value) {
        this.communication.setValue(value);
    }

    @Override
    public String getId() {
        return this.communication.getId();
    }

    @Override
    public void setId(String value) {
        this.communication.setId(value);
    }

}
