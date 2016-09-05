package org.openfact.models;

import java.math.BigDecimal;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

import org.openfact.models.enums.DocumentType;
import org.openfact.provider.ProviderEvent;

public interface OrganizationModel {

	String NAME = "name";
	String DESCRIPTION = "description";
	String ASSIGNED_IDENTIFICATION_ID = "assignedIdentificationId";
	String SUPPLIER_NAME = "supplierName";
	String REGISTRATION_NAME = "registrationName";
	
	String PRIVATE_KEY = "privateKey";
	String PUBLIC_KEY = "publicKey";
	String X509CERTIFICATE = "X509Certificate";

    String getId();

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    boolean isEnabled();

    void setEnabled(boolean enabled);

    String getAssignedIdentificationId();

    void setAssignedIdentificationId(String assignedIdentificationId);

    SimpleDocumentModel getAdditionalAccountId();

    void setAdditionalAccountId(SimpleDocumentModel additionalAccount);

    String getSupplierName();

    void setSupplierName(String supplierName);

    String getRegistrationName();

    void setRegistrationName(String registrationName);

    /**
     * Postal address
     */
    String getPostalAddressId();

    void setPostalAddressId(String postalAddressId);
    
    String getStreetName();

    void setStreetName(String streetName);

    String getCitySubdivisionName();

    void setCitySubdivisionName(String citySubdivisionName);

    String getCityName();

    void setCityName(String cityName);

    String getCountrySubentity();

    void setCountrySubentity(String countrySubentity);

    String getDistrict();

    void setDistrict(String district);

    String getCountryIdentificationCode();

    void setCountryIdentificationCode(String countryIdentificationCode);

    /**
     * Themes
     */
    String getEmailTheme();

    void setEmailTheme(String name);

    /**
     * Internationalization
     */
    boolean isInternationalizationEnabled();

    void setInternationalizationEnabled(boolean enabled);

    Set<String> getSupportedLocales();

    void setSupportedLocales(Set<String> locales);

    String getDefaultLocale();

    void setDefaultLocale(String locale);

    /**
     * Task schedules
     */
    int getMaxInvoiceNumber();

    void setMaxInvoiceNumber(int maxInvoiceNumber);

    int getAttempNumber();

    void setAttempNumber(int attempNumber);

    long getLapseTime();

    void setLapseTime(long lapseTime);

    int getOnErrorAttempNumber();

    void setOnErrorAttempNumber(int OnErrorAttempNumber);

    long getOnErrorLapseTime();

    void setOnErrorLapseTime(long onErrorlapseTime);

    long getDelayTime();

    void setDelayTime(long delayTime);

    LocalTime getSubmitTime();

    void setSubmitTime(LocalTime submitTime);

    Set<DayOfWeek> getSubmitDays();

    void setSubmitDays(Set<DayOfWeek> submitDays);

    /**
     * Currencies
     */
    CurrencyModel addCurrency(String currencyCode);

    CurrencyModel addCurrency(String currencyCode, int priority);

    boolean removeCurrency(String currencyCode);

    Set<CurrencyModel> getCurrencies();

    /**
     * Documents
     */
    DocumentModel getDocumentById(String id);

    DocumentModel getDocumentByTymeAndName(DocumentType type, String documentName);

    SimpleDocumentModel addSimpleDocument(DocumentType type, String name, String documentId);

    ValuableDocumentModel addValuableDocument(DocumentType type, String name, String documentId, BigDecimal value);

    CheckableDocumentModel addCheckableDocument(DocumentType type, String name, String documentId, boolean check);

    ComposedDocumentModel addComposedDocument(DocumentType type, String name, String documentId);

    boolean removeDocument(DocumentModel document);

    Set<DocumentModel> getDocuments();

    Set<DocumentModel> getDocuments(DocumentType documentType);

    /**
     * Events
     */
    boolean isEventsEnabled();

    void setEventsEnabled(boolean enabled);

    Set<String> getEventsListeners();

    void setEventsListeners(Set<String> listeners);

    Set<String> getEnabledEventTypes();

    void setEnabledEventTypes(Set<String> enabledEventTypes);

    boolean isAdminEventsEnabled();

    void setAdminEventsEnabled(boolean enabled);

    boolean isAdminEventsDetailsEnabled();

    void setAdminEventsDetailsEnabled(boolean enabled);

    long getEventsExpiration();

    void setEventsExpiration(long expiration);

    /**
     * Smtp for email
     */
    Map<String, String> getSmtpConfig();

    void setSmtpConfig(Map<String, String> smtpConfig);

    /**
     * Certificate
     */
    String getKeyId();

    String getPublicKeyPem();

    void setPublicKeyPem(String publicKeyPem);

    String getPrivateKeyPem();

    void setPrivateKeyPem(String privateKeyPem);

    PublicKey getPublicKey();

    void setPublicKey(PublicKey publicKey);

    String getCodeSecret();

    Key getCodeSecretKey();

    void setCodeSecret(String codeSecret);

    X509Certificate getCertificate();

    void setCertificate(X509Certificate certificate);

    String getCertificatePem();

    void setCertificatePem(String certificate);

    PrivateKey getPrivateKey();

    void setPrivateKey(PrivateKey privateKey);

    /**
     * Attributes*/
    void setAttribute(String name, String value);

    void removeAttribute(String name);

    String getAttribute(String name);

    Map<String, String> getAttributes();
    
    /**
     * Events interfaces
     */
    interface OrganizationCreationEvent extends ProviderEvent {
        OrganizationModel getCreatedOrganization();
    }

    interface OrganizationPostCreateEvent extends ProviderEvent {
        OrganizationModel getCreatedOrganization();
        OpenfactSession getOpenfactSession();
    }

    interface OrganizationRemovedEvent extends ProviderEvent {
        OrganizationModel getOrganization();
        OpenfactSession getOpenfactSession();
    }

    interface DocumentCreationEvent extends ProviderEvent {
        DocumentModel getDocument();
    }

    interface DocumentRemovedEvent extends ProviderEvent {
        DocumentModel getDocument();
        OpenfactSession getOpenfactSession();
    }
   
}
