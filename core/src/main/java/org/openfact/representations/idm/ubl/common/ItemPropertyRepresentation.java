package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class ItemPropertyRepresentation {
    private String name;
    private String value;
    private PeriodRepresentation usabilityPeriod;
    private List<ItemPropertyGroupRepresentation> itemPropertyGroup;
    private String id;

    public List<ItemPropertyGroupRepresentation> getItemPropertyGroup() {
        return this.itemPropertyGroup;
    }

    public void setItemPropertyGroup(List<ItemPropertyGroupRepresentation> itemPropertyGroup) {
        this.itemPropertyGroup = itemPropertyGroup;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PeriodRepresentation getUsabilityPeriod() {
        return this.usabilityPeriod;
    }

    public void setUsabilityPeriod(PeriodRepresentation usabilityPeriod) {
        this.usabilityPeriod = usabilityPeriod;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}