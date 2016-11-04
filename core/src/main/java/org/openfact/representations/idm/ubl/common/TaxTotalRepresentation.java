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
package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaxTotalRepresentation {
    private BigDecimal taxAmount;
    private BigDecimal roundingAmount;
    private Boolean taxEvidenceIndicator;
    private List<TaxSubtotalRepresentation> taxSubtotal;
    private String id;

    /**/
    public void addTaxSubtotal(TaxSubtotalRepresentation representation) {
        if (taxSubtotal == null) {
            taxSubtotal = new ArrayList<>();
        }
        taxSubtotal.add(representation);
    }
    /**/

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTaxAmount() {
        return this.taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Boolean getTaxEvidenceIndicator() {
        return this.taxEvidenceIndicator;
    }

    public void setTaxEvidenceIndicator(Boolean taxEvidenceIndicator) {
        this.taxEvidenceIndicator = taxEvidenceIndicator;
    }

    public List<TaxSubtotalRepresentation> getTaxSubtotal() {
        return this.taxSubtotal;
    }

    public void setTaxSubtotal(List<TaxSubtotalRepresentation> taxSubtotal) {
        this.taxSubtotal = taxSubtotal;
    }

    public BigDecimal getRoundingAmount() {
        return this.roundingAmount;
    }

    public void setRoundingAmount(BigDecimal roundingAmount) {
        this.roundingAmount = roundingAmount;
    }
}