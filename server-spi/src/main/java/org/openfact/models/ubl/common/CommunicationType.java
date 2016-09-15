package org.openfact.models.ubl.common;

public interface CommunicationType {

    ChannelCodeTypeCommBas getChannelCode();

    void setChannelCode(ChannelCodeTypeCommBas value);

    ChannelType getChannel();

    void setChannel(ChannelType value);

    ValueType getValue();

    void setValue(ValueType value);

    String getId();

    void setId(String value);

}
