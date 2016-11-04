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

public class OrderLineReferenceRepresentation {
    private String lineID;
    private String salesOrderLineID;
    private String UUID;
    private String lineStatusCode;
    private OrderReferenceRepresentation orderReference;
    private String id;

    public String getLineStatusCode() {
        return this.lineStatusCode;
    }

    public void setLineStatusCode(String lineStatusCode) {
        this.lineStatusCode = lineStatusCode;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getLineID() {
        return this.lineID;
    }

    public void setLineID(String lineID) {
        this.lineID = lineID;
    }

    public String getSalesOrderLineID() {
        return this.salesOrderLineID;
    }

    public void setSalesOrderLineID(String salesOrderLineID) {
        this.salesOrderLineID = salesOrderLineID;
    }

    public OrderReferenceRepresentation getOrderReference() {
        return this.orderReference;
    }

    public void setOrderReference(OrderReferenceRepresentation orderReference) {
        this.orderReference = orderReference;
    }
}