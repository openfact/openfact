//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "PARTY")
public class PartyEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "MARK_CARE_INDICATOR")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean markCareIndicator;

    @Column(name = "MARK_ATTENTION_INDICATOR")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean markAttentionIndicator;

    @Column(name = "WEBSITE_URI")
    protected String websiteURI;

    @Column(name = "LOGO_REFERENCE_ID")
    protected String logoReferenceID;

    @Column(name = "END_POINT_ID")
    protected String endpointID;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "PARTY_IDENTIFICATION", joinColumns = { @JoinColumn(name = "PARTY_ID") })
    protected List<String> partyIdentification = new ArrayList<>();

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "PARTY_NAME", joinColumns = { @JoinColumn(name = "PARTY_ID") })
    protected List<String> partyName = new ArrayList<>();

    @ManyToOne(targetEntity = LanguageEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LANGUAGE__PARTY_ID")
    protected LanguageEntity language = new LanguageEntity();

    @ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "POSTALADDRESS_PARTY_ID")
    protected AddressEntity postalAddress = new AddressEntity();

    @ManyToOne(targetEntity = LocationCommAggEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PHYSICALLOCATION")
    protected LocationCommAggEntity physicalLocation = new LocationCommAggEntity();

    @OneToMany(targetEntity = PartyTaxSchemeEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PARTYTAXSCHEME")
    protected List<PartyTaxSchemeEntity> partyTaxScheme = new ArrayList<>();

    @OneToMany(targetEntity = PartyLegalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PARTYLEGALENTITY")
    protected List<PartyLegalEntity> partyLegalEntity = new ArrayList<>();

    @ManyToOne(targetEntity = ContactEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONTACT")
    protected ContactEntity contact = new ContactEntity();

    @ManyToOne(targetEntity = PersonEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PERSON")
    protected PersonEntity person = new PersonEntity();

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "AGENTPARTY")
    protected PartyEntity agentParty = new PartyEntity();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the markCareIndicator
     */
    public boolean isMarkCareIndicator() {
        return markCareIndicator;
    }

    /**
     * @param markCareIndicator
     *            the markCareIndicator to set
     */
    public void setMarkCareIndicator(boolean markCareIndicator) {
        this.markCareIndicator = markCareIndicator;
    }

    /**
     * @return the markAttentionIndicator
     */
    public boolean isMarkAttentionIndicator() {
        return markAttentionIndicator;
    }

    /**
     * @param markAttentionIndicator
     *            the markAttentionIndicator to set
     */
    public void setMarkAttentionIndicator(boolean markAttentionIndicator) {
        this.markAttentionIndicator = markAttentionIndicator;
    }

    /**
     * @return the websiteURI
     */
    public String getWebsiteURI() {
        return websiteURI;
    }

    /**
     * @param websiteURI
     *            the websiteURI to set
     */
    public void setWebsiteURI(String websiteURI) {
        this.websiteURI = websiteURI;
    }

    /**
     * @return the logoReferenceID
     */
    public String getLogoReferenceID() {
        return logoReferenceID;
    }

    /**
     * @param logoReferenceID
     *            the logoReferenceID to set
     */
    public void setLogoReferenceID(String logoReferenceID) {
        this.logoReferenceID = logoReferenceID;
    }

    /**
     * @return the endpointID
     */
    public String getEndpointID() {
        return endpointID;
    }

    /**
     * @param endpointID
     *            the endpointID to set
     */
    public void setEndpointID(String endpointID) {
        this.endpointID = endpointID;
    }

    /**
     * @return the partyIdentification
     */
    public List<String> getPartyIdentification() {
        return partyIdentification;
    }

    /**
     * @param partyIdentification
     *            the partyIdentification to set
     */
    public void setPartyIdentification(List<String> partyIdentification) {
        this.partyIdentification = partyIdentification;
    }

    /**
     * @return the partyName
     */
    public List<String> getPartyName() {
        return partyName;
    }

    /**
     * @param partyName
     *            the partyName to set
     */
    public void setPartyName(List<String> partyName) {
        this.partyName = partyName;
    }

    /**
     * @return the language
     */
    public LanguageEntity getLanguage() {
        return language;
    }

    /**
     * @param language
     *            the language to set
     */
    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    /**
     * @return the postalAddress
     */
    public AddressEntity getPostalAddress() {
        return postalAddress;
    }

    /**
     * @param postalAddress
     *            the postalAddress to set
     */
    public void setPostalAddress(AddressEntity postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * @return the physicalLocation
     */
    public LocationCommAggEntity getPhysicalLocation() {
        return physicalLocation;
    }

    /**
     * @param physicalLocation
     *            the physicalLocation to set
     */
    public void setPhysicalLocation(LocationCommAggEntity physicalLocation) {
        this.physicalLocation = physicalLocation;
    }

    /**
     * @return the partyTaxScheme
     */
    public List<PartyTaxSchemeEntity> getPartyTaxScheme() {
        return partyTaxScheme;
    }

    /**
     * @param partyTaxScheme
     *            the partyTaxScheme to set
     */
    public void setPartyTaxScheme(List<PartyTaxSchemeEntity> partyTaxScheme) {
        this.partyTaxScheme = partyTaxScheme;
    }

    /**
     * @return the partyLegalEntity
     */
    public List<PartyLegalEntity> getPartyLegalEntity() {
        return partyLegalEntity;
    }

    /**
     * @param partyLegalEntity
     *            the partyLegalEntity to set
     */
    public void setPartyLegalEntity(List<PartyLegalEntity> partyLegalEntity) {
        this.partyLegalEntity = partyLegalEntity;
    }

    /**
     * @return the contact
     */
    public ContactEntity getContact() {
        return contact;
    }

    /**
     * @param contact
     *            the contact to set
     */
    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    /**
     * @return the person
     */
    public PersonEntity getPerson() {
        return person;
    }

    /**
     * @param person
     *            the person to set
     */
    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    /**
     * @return the agentParty
     */
    public PartyEntity getAgentParty() {
        return agentParty;
    }

    /**
     * @param agentParty
     *            the agentParty to set
     */
    public void setAgentParty(PartyEntity agentParty) {
        this.agentParty = agentParty;
    }

}
