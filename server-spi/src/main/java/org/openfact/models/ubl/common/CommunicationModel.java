package org.openfact.models.ubl.common;

public interface CommunicationModel {

    ChannelCodeModelCommBas getChannelCode();

    void setChannelCode(ChannelCodeModelCommBas value);

    ChannelModel getChannel();

    void setChannel(ChannelModel value);

    ValueModel getValue();

    void setValue(ValueModel value);

    String getId();

    void setId(String value);

}
