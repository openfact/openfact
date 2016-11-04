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

import java.util.List;

public class ContactRepresentation {
    private String idUbl;
    private String name;
    private String telephone;
    private String telefax;
    private String electronicMail;
    private String note;
    private List<CommunicationRepresentation> otherCommunication;
    private String id;

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelefax() {
        return this.telefax;
    }

    public void setTelefax(String telefax) {
        this.telefax = telefax;
    }

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public List<CommunicationRepresentation> getOtherCommunication() {
        return this.otherCommunication;
    }

    public void setOtherCommunication(List<CommunicationRepresentation> otherCommunication) {
        this.otherCommunication = otherCommunication;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getElectronicMail() {
        return this.electronicMail;
    }

    public void setElectronicMail(String electronicMail) {
        this.electronicMail = electronicMail;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}