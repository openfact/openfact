package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to define a reference to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:35 a. m.
 */
public class DocumentReference {

    /**
     * An indicator that the referenced document is a copy (true) or the
     * original (false).
     */
    private boolean copyIndicator;
    /**
     * Text describing the referenced document.
     */
    private String documentDescription;
    /**
     * A code signifying the status of the reference document with respect to
     * its original state.
     */
    private String documentStatusCode;
    /**
     * The type of document being referenced, expressed as text.
     */
    private String documentType;
    /**
     * The type of document being referenced, expressed as a code.
     */
    private String documentTypeCode;
    /**
     * An identifier for the referenced document.
     */
    private String ID;
    /**
     * The date, assigned by the sender of the referenced document, on which the
     * document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender of the referenced document, at which the
     * document was issued.
     */
    private LocalTime issueTime;
    /**
     * An identifier for the language used in the referenced document.
     */
    private String languageID;
    /**
     * A code signifying the locale in which the language in the referenced
     * document is used.
     */
    private String localeCode;
    /**
     * A universally unique identifier for this document reference.
     */
    private String UUID;
    /**
     * An identifier for the current version of the referenced document.
     */
    private String versionID;
    /**
     * A reference to another place in the same XML document instance in which
     * DocumentReference appears.
     */
    private String xPath;
    private Attachment m_Attachment;
    private Party issuerParty;
    private Period validityPeriod;
    private ResultOfVerification m_ResultOfVerification;

    /**
     * @return the copyIndicator
     */
    public boolean isCopyIndicator() {
        return copyIndicator;
    }

    /**
     * @param copyIndicator
     *            the copyIndicator to set
     */
    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    /**
     * @return the documentDescription
     */
    public String getDocumentDescription() {
        return documentDescription;
    }

    /**
     * @param documentDescription
     *            the documentDescription to set
     */
    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    /**
     * @return the documentStatusCode
     */
    public String getDocumentStatusCode() {
        return documentStatusCode;
    }

    /**
     * @param documentStatusCode
     *            the documentStatusCode to set
     */
    public void setDocumentStatusCode(String documentStatusCode) {
        this.documentStatusCode = documentStatusCode;
    }

    /**
     * @return the documentType
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * @param documentType
     *            the documentType to set
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * @return the documentTypeCode
     */
    public String getDocumentTypeCode() {
        return documentTypeCode;
    }

    /**
     * @param documentTypeCode
     *            the documentTypeCode to set
     */
    public void setDocumentTypeCode(String documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return issueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * @return the languageID
     */
    public String getLanguageID() {
        return languageID;
    }

    /**
     * @param languageID
     *            the languageID to set
     */
    public void setLanguageID(String languageID) {
        this.languageID = languageID;
    }

    /**
     * @return the localeCode
     */
    public String getLocaleCode() {
        return localeCode;
    }

    /**
     * @param localeCode
     *            the localeCode to set
     */
    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    /**
     * @return the uUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    /**
     * @return the versionID
     */
    public String getVersionID() {
        return versionID;
    }

    /**
     * @param versionID
     *            the versionID to set
     */
    public void setVersionID(String versionID) {
        this.versionID = versionID;
    }

    /**
     * @return the xPath
     */
    public String getxPath() {
        return xPath;
    }

    /**
     * @param xPath
     *            the xPath to set
     */
    public void setxPath(String xPath) {
        this.xPath = xPath;
    }

    /**
     * @return the m_Attachment
     */
    public Attachment getM_Attachment() {
        return m_Attachment;
    }

    /**
     * @param m_Attachment
     *            the m_Attachment to set
     */
    public void setM_Attachment(Attachment m_Attachment) {
        this.m_Attachment = m_Attachment;
    }

    /**
     * @return the issuerParty
     */
    public Party getIssuerParty() {
        return issuerParty;
    }

    /**
     * @param issuerParty
     *            the issuerParty to set
     */
    public void setIssuerParty(Party issuerParty) {
        this.issuerParty = issuerParty;
    }

    /**
     * @return the validityPeriod
     */
    public Period getValidityPeriod() {
        return validityPeriod;
    }

    /**
     * @param validityPeriod
     *            the validityPeriod to set
     */
    public void setValidityPeriod(Period validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    /**
     * @return the m_ResultOfVerification
     */
    public ResultOfVerification getM_ResultOfVerification() {
        return m_ResultOfVerification;
    }

    /**
     * @param m_ResultOfVerification
     *            the m_ResultOfVerification to set
     */
    public void setM_ResultOfVerification(ResultOfVerification m_ResultOfVerification) {
        this.m_ResultOfVerification = m_ResultOfVerification;
    }

}// end DocumentReference