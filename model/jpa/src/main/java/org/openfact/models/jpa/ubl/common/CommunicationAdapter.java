package org.openfact.models.jpa.ubl.common;

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

    String getChannelCode() {
        return this.communication.getChannelCode();
    }

    void setChannelCode(String value) {
        this.communication.setChannelCode(value);
    }

    String getChannel() {
        return this.communication.getChannel();
    }

    void setChannel(String value) {
        this.communication.setChannel(value);
    }

    String getValue() {
        return this.communication.getValue();
    }

    void setValue(String value) {
        this.communication.setValue(value);
    }

    String getId() {
        return this.communication.getId();
    }

    void setId(String value) {
        this.communication.setId(value);
    }

}
