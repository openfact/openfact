package org.openfact.models.ubl.common;

public interface UBLExtensionModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    ExtensionAgencyIDModel getExtensionAgencyID();

    void setExtensionAgencyID(ExtensionAgencyIDModel value);

    ExtensionAgencyNameModel getExtensionAgencyName();

    void setExtensionAgencyName(ExtensionAgencyNameModel value);

    ExtensionVersionIDModel getExtensionVersionID();

    void setExtensionVersionID(ExtensionVersionIDModel value);

    ExtensionAgencyURIModel getExtensionAgencyURI();

    void setExtensionAgencyURI(ExtensionAgencyURIModel value);

    ExtensionURIModel getExtensionURI();

    void setExtensionURI(ExtensionURIModel value);

    String getExtensionReasonCode();

    void setExtensionReasonCode(String value);

    ExtensionReasonModel getExtensionReason();

    void setExtensionReason(ExtensionReasonModel value);

    ExtensionContentModel getExtensionContent();

    void setExtensionContent(ExtensionContentModel value);

    String getId();

    void setId(String value);

}
