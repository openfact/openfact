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
package org.openfact.models.jpa.entities.catalog;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CODE_CATALOG")
@NamedQueries({
        @NamedQuery(name = "getAllCodeCatalogs", query = "select codeCatalog from CodeCatalogEntity codeCatalog"),
        @NamedQuery(name = "getCodeCatalogById", query = "select codeCatalog from CodeCatalogEntity codeCatalog where codeCatalog.id =:id"),
        @NamedQuery(name = "searchForCodeCatalog", query = "select codeCatalog from CodeCatalogEntity codeCatalog where codeCatalog.type like :filterText or codeCatalog.code like :filterText or codeCatalog.description like :filterText"),
        @NamedQuery(name = "getCodesCatalogCount", query = "select count(codeCatalog.id) from CodeCatalogEntity codeCatalog") })
public class CodeCatalogEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "ID", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    protected String id;

    @Column(name = "TYPE")
    protected String type;

    @Column(name = "CODE")
    protected String code;

    @NotNull
    @Column(name = "DESCRIPTION")
    protected String description;

    @Column(name = "LOCALE")
    protected String locale;

    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "CODE_CATALOG_ATTRIBUTES", joinColumns = {
            @JoinColumn(name = "CODE_CATALOG_ID") })
    private Map<String, String> attributes = new HashMap<String, String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

}
