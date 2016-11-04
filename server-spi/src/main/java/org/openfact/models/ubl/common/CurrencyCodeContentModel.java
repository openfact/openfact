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
package org.openfact.models.ubl.common;

public enum CurrencyCodeContentModel {

    AED,

    AFN,

    ALL,

    AMD,

    ANG,

    AOA,

    ARS,

    AUD,

    AWG,

    AZM,

    BAM,

    BBD,

    BDT,

    BGN,

    BHD,

    BIF,

    BMD,

    BND,

    BOB,

    BRL,

    BSD,

    BTN,

    BWP,

    BYR,

    BZD,

    CAD,

    CDF,

    CHF,

    CLP,

    CNY,

    COP,

    CRC,

    CUP,

    CVE,

    CYP,

    CZK,

    DJF,

    DKK,

    DOP,

    DZD,

    EEK,

    EGP,

    ERN,

    ETB,

    EUR,

    FJD,

    FKP,

    GBP,

    GEL,

    GHC,

    GIP,

    GMD,

    GNF,

    GTQ,

    GYD,

    HKD,

    HNL,

    HRK,

    HTG,

    HUF,

    IDR,

    ILS,

    INR,

    IQD,

    IRR,

    ISK,

    JMD,

    JOD,

    JPY,

    KES,

    KGS,

    KHR,

    KMF,

    KPW,

    KRW,

    KWD,

    KYD,

    KZT,

    LAK,

    LBP,

    LKR,

    LRD,

    LSL,

    LTL,

    LVL,

    LYD,

    MAD,

    MDL,

    MGF,

    MKD,

    MMK,

    MNT,

    MOP,

    MRO,

    MTL,

    MUR,

    MVR,

    MWK,

    MXN,

    MYR,

    MZM,

    NAD,

    NGN,

    NIO,

    NOK,

    NPR,

    NZD,

    OMR,

    PAB,

    PEN,

    PGK,

    PHP,

    PKR,

    PLN,

    PYG,

    QAR,

    ROL,

    RUB,

    RWF,

    SAR,

    SBD,

    SCR,

    SDD,

    SEK,

    SGD,

    SHP,

    SIT,

    SKK,

    SLL,

    SOS,

    SRG,

    STD,

    SVC,

    SYP,

    SZL,

    THB,

    TJS,

    TMM,

    TND,

    TOP,

    TRL,

    TTD,

    TWD,

    TZS,

    UAH,

    UGX,

    USD,

    UYU,

    UZS,

    VEB,

    VND,

    VUV,

    WST,

    XAF,

    XAG,

    XAU,

    XCD,

    XDR,

    XOF,

    XPD,

    XPF,

    XPT,

    YER,

    YUM,

    ZAR,

    ZMK,

    ZWD;

    public static CurrencyCodeContentModel fromValue(String v) {
        return valueOf(v);
    }

    public String value() {
        return name();
    }

}
