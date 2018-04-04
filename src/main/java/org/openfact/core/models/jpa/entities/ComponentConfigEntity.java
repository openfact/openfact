package org.openfact.core.models.jpa.entities;

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
