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
package org.openfact.ubl.pe.constants;

public enum CodigoConceptosTributarios {

    TOTAL_VALOR_VENTA_OPERACIONES_GRAVADAS("1001"),
    TOTAL_VALOR_VENTA_OPERACIONES_INAFECTAS("1002"),
    TOTAL_VALOR_VENTA_OPERACIONES_EXONERADAS("1003"),
    TOTAL_VALOR_VENTA_OPERACIONES_GRATUITAS("1004"),
    SUB_TOTAL_VENTA("1005"),
    PERCEPCIONES("2001"),
    RETENCIONES("2002"),
    DETRACCIONES("2003"),
    BONIFICACIONES("2004"),
    TOTAL_DESCUENTO("2005"),
    FISE("3001");
    
    private final String codigo;

    private CodigoConceptosTributarios(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
