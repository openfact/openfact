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

package org.openfact.representations;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.openfact.Config;
import org.openfact.common.Version;
import org.openfact.util.JsonSerialization;
import org.w3c.dom.Document;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UblConfigRepresentation {

    public static final UblConfigRepresentation SINGLETON;

    private UblDocument[] ublDocuments;

    static {
        SINGLETON = new UblConfigRepresentation();

        String[] ublDocuments = Config.getUblConfig().getArray("ublDocuments");
        SINGLETON.ublDocuments = new UblDocument[ublDocuments.length];

        for (int i = 0; i < ublDocuments.length; i++) {
            String ublDocument = ublDocuments[i];
            if(ublDocument != null && !ublDocument.isEmpty()) {
                try {
                    SINGLETON.ublDocuments[i] = JsonSerialization.readValue(ublDocument, UblDocument.class);
                } catch (IOException e) {
                    throw new RuntimeException("Error while importing ubl document config [ublDocuments].", e);
                }
            }
        }
    }

    public UblDocument[] getUblDocuments() {
        return ublDocuments;
    }

    public static class UblDocument {
        private String denomination;
        private String[] documentTypeCode;

        public String getDenomination() {
            return denomination;
        }

        public void setDenomination(String denomination) {
            this.denomination = denomination;
        }

        public String[] getDocumentTypeCode() {
            return documentTypeCode;
        }

        public void setDocumentTypeCode(String[] documentTypeCode) {
            this.documentTypeCode = documentTypeCode;
        }
    }

}
