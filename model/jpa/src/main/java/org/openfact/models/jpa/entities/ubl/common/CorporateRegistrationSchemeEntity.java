/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CORPORATEREGISTRATIONSCHEME")
public class CorporateRegistrationSchemeEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "ID_UBL")
    protected String ID;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "COPORATE_REGISTRATION_CODE")
    protected String corporateRegistrationCode;

    @OneToMany(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "JURISDICTIONREGIONADDRESS_CORPORATEREGISTRATIONSCHEME")
    protected List<AddressEntity> jurisdictionRegionAddress = new ArrayList<>();

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the corporateRegistrationCode
     */
    public String getCorporateRegistrationCode() {
        return corporateRegistrationCode;
    }

    /**
     * @param corporateRegistrationCode
     *            the corporateRegistrationCode to set
     */
    public void setCorporateRegistrationCode(String corporateRegistrationCode) {
        this.corporateRegistrationCode = corporateRegistrationCode;
    }

    /**
     * @return the jurisdictionRegionAddress
     */
    public List<AddressEntity> getJurisdictionRegionAddress() {
        return jurisdictionRegionAddress;
    }

    /**
     * @param jurisdictionRegionAddress
     *            the jurisdictionRegionAddress to set
     */
    public void setJurisdictionRegionAddress(List<AddressEntity> jurisdictionRegionAddress) {
        this.jurisdictionRegionAddress = jurisdictionRegionAddress;
    }

}
