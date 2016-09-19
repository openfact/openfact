package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.CardAccountModel;

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

    @Override
    public String getPrimaryAccountNumberID() {
        return this.cardAccount.getPrimaryAccountNumberID();
    }

    @Override
    public void setPrimaryAccountNumberID(String value) {
        this.cardAccount.setPrimaryAccountNumberID(value);
    }

    @Override
    public String getNetworkID() {
        return this.cardAccount.getNetworkID();
    }

    @Override
    public void setNetworkID(String value) {
        this.cardAccount.setNetworkID(value);
    }

    @Override
    public String getCardModelCode() {
        return this.cardAccount.getCardModelCode();
    }

    @Override
    public void setCardAdapterCode(String value) {
        this.cardAccount.setCardAdapterCode(value);
    }

    @Override
    public LocalDate getValidityStartDate() {
        return this.cardAccount.getValidityStartDate();
    }

    @Override
    public void setValidityStartDate(LocalDate value) {
        this.cardAccount.setValidityStartDate(value);
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.cardAccount.getExpiryDate();
    }

    @Override
    public void setExpiryDate(LocalDate value) {
        this.cardAccount.setExpiryDate(value);
    }

    @Override
    public String getIssuerID() {
        return this.cardAccount.getIssuerID();
    }

    @Override
    public void setIssuerID(String value) {
        this.cardAccount.setIssuerID(value);
    }

    @Override
    public String getIssueNumberID() {
        return this.cardAccount.getIssueNumberID();
    }

    @Override
    public void setIssueNumberID(String value) {
        this.cardAccount.setIssueNumberID(value);
    }

    @Override
    public String getCV2ID() {
        return this.cardAccount.getCV2ID();
    }

    @Override
    public void setCV2ID(String value) {
        this.cardAccount.setCV2ID(value);
    }

    @Override
    public String getCardChipCode() {
        return this.cardAccount.getCardChipCode();
    }

    @Override
    public void setCardChipCode(String value) {
        this.cardAccount.setCardChipCode(value);
    }

    @Override
    public String getChipApplicationID() {
        return this.cardAccount.getChipApplicationID();
    }

    @Override
    public void setChipApplicationID(String value) {
        this.cardAccount.setChipApplicationID(value);
    }

    @Override
    public String getHolderName() {
        return this.cardAccount.getHolderName();
    }

    @Override
    public void setHolderName(String value) {
        this.cardAccount.setHolderName(value);
    }

    @Override
    public String getId() {
        return this.cardAccount.getId();
    }

    @Override
    public void setId(String value) {
        this.cardAccount.setId(value);
    }

}
