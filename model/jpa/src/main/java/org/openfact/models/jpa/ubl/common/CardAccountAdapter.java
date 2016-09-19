package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;

public class CardAccountAdapter implements CardAccountModel, JpaModel<CardAccountEntity> {

    protected static final Logger logger = Logger.getLogger(CardAccountAdapter.class);
    protected CardAccountEntity cardAccount;
    protected EntityManager em;
    protected OpenfactSession session;

    public CardAccountAdapter(OpenfactSession session, EntityManager em, CardAccountEntity cardAccount) {
        this.session = session;
        this.em = em;
        this.cardAccount = cardAccount;
    }

    String getPrimaryAccountNumberID() {
        return this.cardAccount.getPrimaryAccountNumberID();
    }

    void setPrimaryAccountNumberID(String value) {
        this.cardAccount.setPrimaryAccountNumberID(value);
    }

    String getNetworkID() {
        return this.cardAccount.getNetworkID();
    }

    void setNetworkID(String value) {
        this.cardAccount.setNetworkID(value);
    }

    String getCardAdapterCode() {
        return this.cardAccount.getCardAdapterCode();
    }

    void setCardAdapterCode(String value) {
        this.cardAccount.setCardAdapterCode(value);
    }

    LocalDate getValidityStartDate() {
        return this.cardAccount.getValidityStartDate();
    }

    void setValidityStartDate(LocalDate value) {
        this.cardAccount.setValidityStartDate(value);
    }

    LocalDate getExpiryDate() {
        return this.cardAccount.getExpiryDate();
    }

    void setExpiryDate(LocalDate value) {
        this.cardAccount.setExpiryDate(value);
    }

    String getIssuerID() {
        return this.cardAccount.getIssuerID();
    }

    void setIssuerID(String value) {
        this.cardAccount.setIssuerID(value);
    }

    String getIssueNumberID() {
        return this.cardAccount.getIssueNumberID();
    }

    void setIssueNumberID(String value) {
        this.cardAccount.setIssueNumberID(value);
    }

    String getCV2ID() {
        return this.cardAccount.getCV2ID();
    }

    void setCV2ID(String value) {
        this.cardAccount.setCV2ID(value);
    }

    String getCardChipCode() {
        return this.cardAccount.getCardChipCode();
    }

    void setCardChipCode(String value) {
        this.cardAccount.setCardChipCode(value);
    }

    String getChipApplicationID() {
        return this.cardAccount.getChipApplicationID();
    }

    void setChipApplicationID(String value) {
        this.cardAccount.setChipApplicationID(value);
    }

    String getHolderName() {
        return this.cardAccount.getHolderName();
    }

    void setHolderName(String value) {
        this.cardAccount.setHolderName(value);
    }

    String getId() {
        return this.cardAccount.getId();
    }

    void setId(String value) {
        this.cardAccount.setId(value);
    }

}
