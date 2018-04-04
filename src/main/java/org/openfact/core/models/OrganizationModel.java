package org.openfact.core.models;

import java.util.Map;
import java.util.TimeZone;

public interface OrganizationModel extends Model {

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    boolean getUseCustomCertificates();

    void setUseCustomCertificates(boolean useCustomCertificates);

    boolean getUseCustomSmtpConfig();

    void setUseCustomSmtpConfig(boolean useCustomSmtpConfig);

    Map<String, String> getSmtpConfig();

    void setSmtpConfig(Map<String, String> smtpConfig);

    UserModel getOwner();

    TimeZone getTimeZone();
}
