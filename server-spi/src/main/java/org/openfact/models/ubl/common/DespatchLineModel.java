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
package org.openfact.models.ubl.common;

import java.util.List;

public interface DespatchLineModel {
    String getId();

    String getID();

    void setID(String iD);

    String getUuid();

    void setUuid(String uuid);

    List<String> getNote();

    void setNote(List<String> note);

    String getLineStatusCode();

    void setLineStatusCode(String lineStatusCode);

    QuantityModel getDeliveredQuantity();

    void setDeliveredQuantity(QuantityModel deliveredQuantity);

    QuantityModel getBackorderQuantity();

    void setBackorderQuantity(QuantityModel backorderQuantity);

    String getBackorderReason();

    void setBackorderReason(String backorderReason);

    QuantityModel getOutstandingQuantity();

    void setOutstandingQuantity(QuantityModel outstandingQuantity);

    String getOutstandingReason();

    void setOutstandingReason(String outstandingReason);

    QuantityModel getOversupplyQuantity();

    void setOversupplyQuantity(QuantityModel oversupplyQuantity);

    List<OrderLineReferenceModel> getOrderLineReference();

    void setOrderLineReference(List<OrderLineReferenceModel> orderLineReference);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    ItemModel getItem();

    void setItem(ItemModel item);

    MeasureModel getGrossWeightMeasure();

    void setGrossWeightMeasure(MeasureModel grossWeightMeasure);

    List<ShipmentModel> getShipment();

    void setShipment(List<ShipmentModel> shipment);

}
