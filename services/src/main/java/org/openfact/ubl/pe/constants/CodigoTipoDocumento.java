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

public enum CodigoTipoDocumento {

    FACTURA("01", "F%-%", 13),
    BOLETA("03", "B%-%", 13),
    NOTA_CREDITO("07", "%C%-%", 13),
    NOTA_DEBITO("08", "%D%-%", 13),
    GUIA_REMISION("09", "F%-%", 13),
    TICKET("12", "F%-%", 13),
    DOC_SBS("13", "F%-%", 13),
    DOC_AFP("18", "F%-%", 13),
    GUIA_TRANSPORTISTA("31", "F%-%", 13),
    SEAE("56", "F%-%", 13);
    
    private final String codigo;

    private String mask;
    private int lenght;
    
    private CodigoTipoDocumento(String codigo, String mask, int lenght) {
        this.codigo = codigo;
        this.mask = mask;
        this.lenght = lenght;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getMask() {
        return mask;
    }

    public int getLenght() {
        return lenght;
    }
    
}
