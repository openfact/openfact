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

package org.openfact.models.jpa.entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "getComponentConfig", query = "select attr from ComponentConfigEntity attr where attr.component = :component"),
        @NamedQuery(name = "deleteComponentConfigByComponent", query = "delete from  ComponentConfigEntity attr where attr.component = :component"),
        @NamedQuery(name = "deleteComponentConfigByOrganization", query = "delete from  ComponentConfigEntity attr where attr.component IN (select u from ComponentEntity u where u.organization=:organization)"),
        @NamedQuery(name = "deleteComponentConfigByParent", query = "delete from  ComponentConfigEntity attr where attr.component IN (select u from ComponentEntity u where u.parentId=:parentId)"),
})
@Table(name = "COMPONENT_CONFIG")
@Entity
public class ComponentConfigEntity {

    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    protected String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPONENT_ID")
    protected ComponentEntity component;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "VALUE", length = 4000)
    protected String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ComponentEntity getComponent() {
        return component;
    }

    public void setComponent(ComponentEntity component) {
        this.component = component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof ComponentConfigEntity)) return false;

        ComponentConfigEntity that = (ComponentConfigEntity) o;

        if (!id.equals(that.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
