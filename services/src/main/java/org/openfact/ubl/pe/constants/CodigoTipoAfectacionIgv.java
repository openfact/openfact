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

public enum CodigoTipoAfectacionIgv {

    GRAVADO_OPERACION_ONEROSA("10"),
    GRAVADO_RETIRO_POR_PREMIO("11"),
    GRAVADO_RETIRO_POR_DONACION("12"),
    GRAVADO_RETIRO("13"),
    GRAVADO_RETIRO_POR_PUBLICIDAD("14"),
    GRAVADO_BONIFICACIONES("15"),
    GRAVADO_RETIRO_POR_ENTREGA_A_TRABAJADORES("16"),
    GRAVADO_IVAP("17"),
    EXONERADO_OPERACION_ONEROSA("20"),
    EXONERADO_TRANSFERENCIA_GRATUITA("21"),
    INAFECTO_OPERACION_ONEROSA("30"),
    INAFECTO_RETIRO_POR_BONIFICACION("31"),
    INAFECTO_RETIRO("32"),
    INAFECTO_RETIRO_POR_MUESTRAS_MEDICAS("33"),
    INAFECTO_RETIRO_POR_CONVENIO_COLECTIVO("34"),
    INAFECTO_RETIRO_POR_PREMIO("35"),
    INAFECTO_RETIRO_POR_PUBLICIDAD("36"),
    EXPORTACION("40");
    
    private final String codigo;

    private CodigoTipoAfectacionIgv(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
