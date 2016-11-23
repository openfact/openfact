package org.openfact.models.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CUSTOMER_PARTY")
public class CustomerPartyEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "CUSTOMER_ASSIGNED_ACCOUNTID")
    protected String customerAssignedAccountId;

    @Column(name = "SUPPLIER_ASSIGNED_ACCOUNTID")
    protected String supplierAssignedAccountId;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "CUSTOMERPARTY_ADDITIONALACCOUNTID", joinColumns = { @JoinColumn(name = "CUSTOMERPARTY_ID") })
    protected List<String> additionalAccountId = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PARTY_CUSTOMERPARTY_ID")
    protected PartyEntity party;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerAssignedAccountId() {
        return customerAssignedAccountId;
    }

    public void setCustomerAssignedAccountId(String customerAssignedAccountId) {
        this.customerAssignedAccountId = customerAssignedAccountId;
    }

    public String getSupplierAssignedAccountId() {
        return supplierAssignedAccountId;
    }

    public void setSupplierAssignedAccountId(String supplierAssignedAccountId) {
        this.supplierAssignedAccountId = supplierAssignedAccountId;
    }

    public List<String> getAdditionalAccountId() {
        return additionalAccountId;
    }

    public void setAdditionalAccountId(List<String> additionalAccountId) {
        this.additionalAccountId = additionalAccountId;
    }

    public PartyEntity getParty() {
        return party;
    }

    public void setParty(PartyEntity party) {
        this.party = party;
    }

}
