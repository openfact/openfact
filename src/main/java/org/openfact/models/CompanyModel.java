package org.openfact.models;

import java.util.Map;

public interface CompanyModel extends Model {

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    boolean getUseCustomSmtpConfig();

    void setUseCustomSmtpConfig(boolean useCustomSmtpConfig);

    Map<String, String> getSmtpConfig();

    void setSmtpConfig(Map<String, String> smtpConfig);

    UserModel getOwner();
}
