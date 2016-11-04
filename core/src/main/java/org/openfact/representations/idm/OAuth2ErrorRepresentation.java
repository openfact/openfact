/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.representations.idm;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.openfact.OAuth2Constants;

/**
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public class OAuth2ErrorRepresentation {

    private String error;
    private String errorDescription;

    public OAuth2ErrorRepresentation() {
    }

    public OAuth2ErrorRepresentation(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
    }

    @JsonProperty(OAuth2Constants.ERROR)
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @JsonProperty(OAuth2Constants.ERROR_DESCRIPTION)
    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
