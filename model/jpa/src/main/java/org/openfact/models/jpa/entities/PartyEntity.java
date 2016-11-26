package org.openfact.models.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PARTY")
public class PartyEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @ManyToOne(targetEntity = ContactEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONTACT")
    protected ContactEntity contact;
    
    @OneToMany(targetEntity = PartyLegalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PARTYLEGALENTITY")
    protected List<PartyLegalEntity> partyLegalEntity = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PartyLegalEntity> getPartyLegalEntity() {
        return partyLegalEntity;
    }

    public void setPartyLegalEntity(List<PartyLegalEntity> partyLegalEntity) {
        this.partyLegalEntity = partyLegalEntity;
    }

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

}