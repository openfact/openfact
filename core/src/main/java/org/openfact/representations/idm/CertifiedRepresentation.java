package org.openfact.representations.idm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.FileInputStream;
import java.time.LocalDate;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 09/08/2016.
 */
public class CertifiedRepresentation {
    /**
     * The unique id.
     */
    private String id;

    /**
     * The alias of the certified
     */
    @NotNull
    @Size(min = 5, max = 100)
    private String alias;

    /**
     * The certificate of the certified
     */
    @NotNull
    private FileInputStream certificate;

    /**
     * The certificate of the certified
     */

    private String Urlcertificate;
    /**
     * The password of the certified
     */
    @NotNull
    @Size(min = 6, max = 100)
    private String password;

    /**
     * The password of the certified
     */
    @NotNull
    @Size(min = 6, max = 100)
    private String passwordConfirmation;

    /**
     * The validity of the certified(fecha vigencia)
     */
    @NotNull
    private LocalDate validity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public FileInputStream getCertificate() {
        return certificate;
    }

    public void setCertificate(FileInputStream certificate) {
        this.certificate = certificate;
    }

    public String getUrlcertificate() {
        return Urlcertificate;
    }

    public void setUrlcertificate(String urlcertificate) {
        Urlcertificate = urlcertificate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }
}
