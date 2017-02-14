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
        @NamedQuery(name = "deleteDocumentRequiredActionsByOrganization", query = "delete from DocumentRequiredActionEntity action where action.document IN (select u from DocumentEntity u where u.organizationId=:organizationId)")
})
@Entity
@Table(name = "DOCUMENT_REQUIRED_ACTION")
@IdClass(DocumentRequiredActionEntity.Key.class)
public class DocumentRequiredActionEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "DOCUMENT_ID")
    protected DocumentEntity document;

    @Id
    @Column(name = "REQUIRED_ACTION")
    protected String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public DocumentEntity getDocument() {
        return document;
    }

    public void setDocument(DocumentEntity invoice) {
        this.document = invoice;
    }

    public static class Key implements Serializable {

        protected DocumentEntity document;

        protected String action;

        public Key() {
        }

        public Key(DocumentEntity invoice, String action) {
            this.document = invoice;
            this.action = action;
        }

        public DocumentEntity getDocument() {
            return document;
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
            if (document != null ? !document.getId().equals(key.document != null ? key.document.getId() : null) : key.document != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = document != null ? document.getId().hashCode() : 0;
            result = 31 * result + (action != null ? action.hashCode() : 0);
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof DocumentRequiredActionEntity)) return false;

        DocumentRequiredActionEntity key = (DocumentRequiredActionEntity) o;

        if (action != key.action) return false;
        if (document != null ? !document.getId().equals(key.document != null ? key.document.getId() : null) : key.document != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = document != null ? document.getId().hashCode() : 0;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

}
