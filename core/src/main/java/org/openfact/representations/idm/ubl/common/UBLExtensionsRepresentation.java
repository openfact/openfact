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

import java.util.ArrayList;
import java.util.List;

public class UBLExtensionsRepresentation {
    private List<UBLExtensionRepresentation> ublExtension;
    private String id;

    /**/
    public void addUBLExtension(UBLExtensionRepresentation representation) {
        if (ublExtension == null) {
            ublExtension = new ArrayList<>();
        }
        ublExtension.add(representation);
    }
    /**/

    public List<UBLExtensionRepresentation> getUblExtension() {
        return ublExtension;
    }

    public void setUblExtension(List<UBLExtensionRepresentation> ublExtension) {
        this.ublExtension = ublExtension;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}