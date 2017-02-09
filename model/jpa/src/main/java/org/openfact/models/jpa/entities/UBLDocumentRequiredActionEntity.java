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
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "deleteDocumentRequiredActionsByOrganization", query = "delete from UBLDocumentRequiredActionEntity action where action.ublDocument IN (select u from UBLDocumentEntity u where u.organizationId=:organizationId)")
})
@Entity
@Table(name = "UBL_DOCUMENT_REQUIRED_ACTION")
@IdClass(UBLDocumentRequiredActionEntity.Key.class)
public class UBLDocumentRequiredActionEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "UBL_DOCUMENT_ID")
    protected UBLDocumentEntity ublDocument;

    @Id
    @Column(name = "REQUIRED_ACTION")
    protected String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public UBLDocumentEntity getUblDocument() {
        return ublDocument;
    }

    public void setUblDocument(UBLDocumentEntity invoice) {
        this.ublDocument = invoice;
    }

    public static class Key implements Serializable {

        protected UBLDocumentEntity ublDocument;

        protected String action;

        public Key() {
        }

        public Key(UBLDocumentEntity invoice, String action) {
            this.ublDocument = invoice;
            this.action = action;
        }

        public UBLDocumentEntity getUblDocument() {
            return ublDocument;
        }

        public String getAction() {
            return action;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (action != key.action) return false;
            if (ublDocument != null ? !ublDocument.getId().equals(key.ublDocument != null ? key.ublDocument.getId() : null) : key.ublDocument != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = ublDocument != null ? ublDocument.getId().hashCode() : 0;
            result = 31 * result + (action != null ? action.hashCode() : 0);
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof UBLDocumentRequiredActionEntity)) return false;

        UBLDocumentRequiredActionEntity key = (UBLDocumentRequiredActionEntity) o;

        if (action != key.action) return false;
        if (ublDocument != null ? !ublDocument.getId().equals(key.ublDocument != null ? key.ublDocument.getId() : null) : key.ublDocument != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ublDocument != null ? ublDocument.getId().hashCode() : 0;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

}
