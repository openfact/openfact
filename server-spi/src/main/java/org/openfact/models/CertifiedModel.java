package org.openfact.models;

import java.io.FileInputStream;
import java.time.LocalDate;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public interface CertifiedModel {

    String getId();

    LocalDate getValidity();

    String getAlias();

    void setAlias(String alias);

    FileInputStream getCertificate();

    String getPassword();

    void setPassword(String password);

    String getPasswordConfirmation();

    void setPasswordConfirmation(String passwordConfirmation);

    OrganizationModel getOrganization();
}
