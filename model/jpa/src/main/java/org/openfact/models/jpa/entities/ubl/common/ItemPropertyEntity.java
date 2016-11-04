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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ITEMPROPERTY")
public class ItemPropertyEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "VALUE")
    protected String value;

    @ManyToOne(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "USABILITYPERIOD")
    protected PeriodEntity usabilityPeriod = new PeriodEntity();

    @OneToMany(targetEntity = ItemPropertyGroupEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ITEMPROPERTYGROUP")
    protected List<ItemPropertyGroupEntity> itemPropertyGroup = new ArrayList<>();

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
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the usabilityPeriod
     */
    public PeriodEntity getUsabilityPeriod() {
        return usabilityPeriod;
    }

    /**
     * @param usabilityPeriod
     *            the usabilityPeriod to set
     */
    public void setUsabilityPeriod(PeriodEntity usabilityPeriod) {
        this.usabilityPeriod = usabilityPeriod;
    }

    /**
     * @return the itemPropertyGroup
     */
    public List<ItemPropertyGroupEntity> getItemPropertyGroup() {
        return itemPropertyGroup;
    }

    /**
     * @param itemPropertyGroup
     *            the itemPropertyGroup to set
     */
    public void setItemPropertyGroup(List<ItemPropertyGroupEntity> itemPropertyGroup) {
        this.itemPropertyGroup = itemPropertyGroup;
    }

}
