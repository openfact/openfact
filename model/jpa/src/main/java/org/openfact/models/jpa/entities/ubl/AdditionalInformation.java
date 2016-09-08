package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxpary on 08/09/16.
 */
public class AdditionalInformation {

    private List<AdditionalMonetaryTotal> additionalMonetaryTotals =new ArrayList<>();
    private  List<AdditionalProperty> additionalProperties=new ArrayList<>();

    public List<AdditionalMonetaryTotal> getAdditionalMonetaryTotals() {
        return additionalMonetaryTotals;
    }

    public void setAdditionalMonetaryTotals(List<AdditionalMonetaryTotal> additionalMonetaryTotals) {
        this.additionalMonetaryTotals = additionalMonetaryTotals;
    }

    public List<AdditionalProperty> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(List<AdditionalProperty> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
