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
package org.openfact.ubl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.report.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class BasicUBLReportDataProvider implements UBLReportDataProvider {

    private static final Logger logger = Logger.getLogger(BasicUBLReportDataProvider.class);

    public enum PARAMETERS {
        OF_ORGANIZATION
    }

    public enum ATTRIBUTES {
        ID,
        ISSUE_DATE,
        INVOICE_TYPE_CODE,
        DOCUMENT_CURRENCY_CODE,

        /**
         * Supplier party SP
         */
        SP_ASSIGNED_ACCOUNT_ID,
        SP_ADDITIONAL_ACCOUNT_ID,

        SP_POSTAL_ADDRESS_ID,
        SP_POSTAL_ADDRESS_STREET_NAME,
        SP_POSTAL_ADDRESS_CITY_SUBDIVISION_NAME,
        SP_POSTAL_ADDRESS_CITY_NAME,
        SP_POSTAL_ADDRESS_CITY_SUBENTITY,
        SP_POSTAL_ADDRESS_DISTRICT,
        SP_POSTAL_ADDRESS_COUNTRY_IDENTIFICATION_CODE,

        SP_LEGAL_ENTITY_REGISTRATION_NAME,

        /**
         * Customer party CP
         */
        CP_ASSIGNED_ACCOUNT_ID,
        CP_ADDITIONAL_ACCOUNT_ID,

        CP_POSTAL_ADDRESS_ID,
        CP_POSTAL_ADDRESS_STREET_NAME,
        CP_POSTAL_ADDRESS_CITY_SUBDIVISION_NAME,
        CP_POSTAL_ADDRESS_CITY_NAME,
        CP_POSTAL_ADDRESS_CITY_SUBENTITY,
        CP_POSTAL_ADDRESS_DISTRICT,
        CP_POSTAL_ADDRESS_COUNTRY_IDENTIFICATION_CODE,

        CP_LEGAL_ENTITY_REGISTRATION_NAME,

        /**
         * Tax Total
         */
        TT_TAX_AMOUNT,

        /**
         * Legal Monetary Total
         */
        LMT_PAYABLE_AMOUNT,
        LMT_CHARGE_TOTAL_AMOUNT,
        LMT_ALLOWANCE_TOTAL_AMOUNT,

        /**
         * Invoice Line*/
         INVOICE_LINE;

        public static ATTRIBUTES fromString(String text) {
            if (text != null) {
                for (ATTRIBUTES b : ATTRIBUTES.values()) {
                    if (text.equalsIgnoreCase(b.toString())) {
                        return b;
                    }
                }
            }
            return null;
        }
    }

    public static class InvoiceLineReport {
        private BigDecimal invoiced_quantity;
        private String unit_code;
        private BigDecimal line_extension_amount;
        private BigDecimal tt_tax_amount;
        private String i_description;
        private BigDecimal pr_acp_price_amount;
        private BigDecimal p_price_amount;

        public BigDecimal getPr_acp_price_amount() {
            return pr_acp_price_amount;
        }

        public void setPr_acp_price_amount(BigDecimal pr_acp_price_amount) {
            this.pr_acp_price_amount = pr_acp_price_amount;
        }

        public BigDecimal getInvoiced_quantity() {
            return invoiced_quantity;
        }

        public void setInvoiced_quantity(BigDecimal invoiced_quantity) {
            this.invoiced_quantity = invoiced_quantity;
        }

        public String getUnit_code() {
            return unit_code;
        }

        public void setUnit_code(String unit_code) {
            this.unit_code = unit_code;
        }

        public BigDecimal getLine_extension_amount() {
            return line_extension_amount;
        }

        public void setLine_extension_amount(BigDecimal line_extension_amount) {
            this.line_extension_amount = line_extension_amount;
        }

        public BigDecimal getTt_tax_amount() {
            return tt_tax_amount;
        }

        public void setTt_tax_amount(BigDecimal tt_tax_amount) {
            this.tt_tax_amount = tt_tax_amount;
        }

        public String getI_description() {
            return i_description;
        }

        public void setI_description(String i_description) {
            this.i_description = i_description;
        }

        public BigDecimal getP_price_amount() {
            return p_price_amount;
        }

        public void setP_price_amount(BigDecimal p_price_amount) {
            this.p_price_amount = p_price_amount;
        }
    }

    protected OpenfactSession session;

    public BasicUBLReportDataProvider(OpenfactSession session) {
        this.session = session;
    }


    protected JsonNode findNode(JsonNode node, String... key) {
        for (String k : key) {
            node = node.get(k);
            if (node == null) break;
        }
        return node;
    }

    @Override
    public int getProviderPriority() {
        return 0;
    }

    @Override
    public ReportDataProvider<InvoiceModel> invoice() {
        return new ReportDataProvider<InvoiceModel>() {

            protected JsonNode jsonNode;

            @Override
            public Object getFieldValue(InvoiceModel invoice, String fieldName) {
                if (ATTRIBUTES.fromString(fieldName) == null) {
                    return null;
                }

                if (jsonNode == null) {
                    try {
                        jsonNode = new XmlMapper().readTree(invoice.getXmlDocument());
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to load xml", e);
                    }
                }

                ATTRIBUTES attr = ATTRIBUTES.fromString(fieldName);

                Object result = null;
                JsonNode node;
                switch (attr) {
                    case ID:
                        node = findNode(jsonNode, new String[]{"ID"});
                        if (node != null) result = node.textValue();
                        break;

                    case ISSUE_DATE:
                        node = findNode(jsonNode, new String[]{"IssueDate"});
                        if (node != null) result = node.textValue();
                        break;

                    case INVOICE_TYPE_CODE:
                        node = findNode(jsonNode, new String[]{"InvoiceTypeCode"});
                        if (node != null) result = node.textValue();
                        break;

                    case DOCUMENT_CURRENCY_CODE:
                        node = findNode(jsonNode, new String[]{"DocumentCurrencyCode"});
                        if (node != null) result = node.textValue();
                        break;

                    /**
                     * Supplier Party*/
                    case SP_ASSIGNED_ACCOUNT_ID:
                        node = findNode(jsonNode, new String[]{"AccountingSupplierParty", "CustomerAssignedAccountID"});
                        if (node != null) result = node.textValue();
                        break;

                    case SP_ADDITIONAL_ACCOUNT_ID:
                        node = findNode(jsonNode, new String[]{"AccountingSupplierParty", "AdditionalAccountID"});
                        if (node != null) {
                            if (node.isArray()) {
                                String[] a = new String[node.size()];
                                for (int i = 0; i < a.length; i++) {
                                    a[i] = node.get(i).textValue();
                                }
                                result = a.toString();
                            } else {
                                result = node.textValue();
                            }
                        }
                        break;

                    case SP_POSTAL_ADDRESS_ID:
                        node = findNode(jsonNode, new String[]{"AccountingSupplierParty", "Party", "PostalAddress", "ID"});
                        if (node != null) result = node.textValue();
                        break;

                    case SP_POSTAL_ADDRESS_STREET_NAME:
                        node = findNode(jsonNode, new String[]{"AccountingSupplierParty", "Party", "PostalAddress", "StreetName"});
                        if (node != null) result = node.textValue();
                        break;

                    case SP_POSTAL_ADDRESS_CITY_SUBDIVISION_NAME:
                        node = findNode(jsonNode, new String[]{"AccountingSupplierParty", "Party", "PostalAddress", "CitySubdivisionName"});
                        if (node != null) result = node.textValue();
                        break;

                    case SP_POSTAL_ADDRESS_CITY_NAME:
                        node = findNode(jsonNode, new String[]{"AccountingSupplierParty", "Party", "PostalAddress", "CityName"});
                        if (node != null) result = node.textValue();
                        break;

                    case SP_POSTAL_ADDRESS_CITY_SUBENTITY:
                        node = findNode(jsonNode, new String[]{"AccountingSupplierParty", "Party", "PostalAddress", "CountrySubentity"});
                        if (node != null) result = node.textValue();
                        break;

                    case SP_POSTAL_ADDRESS_DISTRICT:
                        node = findNode(jsonNode, new String[]{"AccountingSupplierParty", "Party", "PostalAddress", "District"});
                        if (node != null) result = node.textValue();
                        break;

                    case SP_POSTAL_ADDRESS_COUNTRY_IDENTIFICATION_CODE:
                        node = findNode(jsonNode, new String[]{"AccountingSupplierParty", "Party", "PostalAddress", "District", "Country", "IdentificationCode"});
                        if (node != null) result = node.textValue();
                        break;

                    case SP_LEGAL_ENTITY_REGISTRATION_NAME:
                        node = findNode(jsonNode, new String[]{"AccountingSupplierParty", "Party", "PartyLegalEntity"});
                        if (node != null) {
                            if (node.isArray()) {
                                List<String> list = new ArrayList<>();
                                for (int i = 0; i < node.size(); i++) {
                                    JsonNode n = node.get(i).get("RegistrationName");
                                    if (n != null) list.add(n.textValue());
                                }
                                result = list.toArray(new String[list.size()]).toString();
                            } else {
                                node = findNode(node, new String[]{"RegistrationName"});
                                if (node != null) result = node.textValue();
                            }
                        }
                        break;

                    /**
                     * Customer Party*/
                    case CP_ASSIGNED_ACCOUNT_ID:
                        node = findNode(jsonNode, new String[]{"AccountingCustomerParty", "CustomerAssignedAccountID"});
                        if (node != null) result = node.textValue();
                        break;

                    case CP_ADDITIONAL_ACCOUNT_ID:
                        node = findNode(jsonNode, new String[]{"AccountingCustomerParty", "AdditionalAccountID"});
                        if (node != null) {
                            if (node.isArray()) {
                                String[] a = new String[node.size()];
                                for (int i = 0; i < a.length; i++) {
                                    a[i] = node.get(i).textValue();
                                }
                                result = a.toString();
                            } else {
                                result = node.textValue();
                            }
                        }
                        break;

                    case CP_POSTAL_ADDRESS_ID:
                        node = findNode(jsonNode, new String[]{"AccountingCustomerParty", "Party", "PostalAddress", "ID"});
                        if (node != null) result = node.textValue();
                        break;

                    case CP_POSTAL_ADDRESS_STREET_NAME:
                        node = findNode(jsonNode, new String[]{"AccountingCustomerParty", "Party", "PostalAddress", "StreetName"});
                        if (node != null) result = node.textValue();
                        break;

                    case CP_POSTAL_ADDRESS_CITY_SUBDIVISION_NAME:
                        node = findNode(jsonNode, new String[]{"AccountingCustomerParty", "Party", "PostalAddress", "CitySubdivisionName"});
                        if (node != null) result = node.textValue();
                        break;

                    case CP_POSTAL_ADDRESS_CITY_NAME:
                        node = findNode(jsonNode, new String[]{"AccountingCustomerParty", "Party", "PostalAddress", "CityName"});
                        if (node != null) result = node.textValue();
                        break;

                    case CP_POSTAL_ADDRESS_CITY_SUBENTITY:
                        node = findNode(jsonNode, new String[]{"AccountingCustomerParty", "Party", "PostalAddress", "CountrySubentity"});
                        if (node != null) result = node.textValue();
                        break;

                    case CP_POSTAL_ADDRESS_DISTRICT:
                        node = findNode(jsonNode, new String[]{"AccountingCustomerParty", "Party", "PostalAddress", "District"});
                        if (node != null) result = node.textValue();
                        break;

                    case CP_POSTAL_ADDRESS_COUNTRY_IDENTIFICATION_CODE:
                        node = findNode(jsonNode, new String[]{"AccountingCustomerParty", "Party", "PostalAddress", "District", "Country", "IdentificationCode"});
                        if (node != null) result = node.textValue();
                        break;

                    case CP_LEGAL_ENTITY_REGISTRATION_NAME:
                        node = findNode(jsonNode, new String[]{"AccountingCustomerParty", "Party", "PartyLegalEntity"});
                        if (node != null) {
                            if (node.isArray()) {
                                List<String> list = new ArrayList<>();
                                for (int i = 0; i < node.size(); i++) {
                                    JsonNode n = node.get(i).get("RegistrationName");
                                    if (n != null) list.add(n.textValue());
                                }
                                result = list.toArray(new String[list.size()]).toString();
                            } else {
                                node = findNode(node, new String[]{"RegistrationName"});
                                if (node != null) result = node.textValue();
                            }
                        }
                        break;

                    /**
                     * Tax total*/
                    case TT_TAX_AMOUNT:
                        node = findNode(jsonNode, new String[]{"TaxTotal", "TaxAmount"});
                        if (node != null) result = new BigDecimal(node.get("").textValue());
                        break;

                    /**
                     * Legal Monetary Total*/
                    case LMT_PAYABLE_AMOUNT:
                        node = findNode(jsonNode, new String[]{"LegalMonetaryTotal", "PayableAmount"});
                        if (node != null) result = new BigDecimal(node.get("").textValue());
                        break;

                    case LMT_CHARGE_TOTAL_AMOUNT:
                        node = findNode(jsonNode, new String[]{"LegalMonetaryTotal", "ChargeTotalAmount"});
                        if (node != null) result = new BigDecimal(node.get("").textValue());
                        break;

                    case LMT_ALLOWANCE_TOTAL_AMOUNT:
                        node = findNode(jsonNode, new String[]{"LegalMonetaryTotal", "AllowanceTotalAmount "});
                        if (node != null) result = new BigDecimal(node.get("").textValue());
                        break;

                        /**
                         * Invoice Line*/
                    case INVOICE_LINE:
                        node = findNode(jsonNode, new String[]{"InvoiceLine"});
                        if (node != null) {
                            List<InvoiceLineReport> lines = new ArrayList<>();
                            if (node.isArray()) {
                                List<String> list = new ArrayList<>();
                                for (int i = 0; i < node.size(); i++) {
                                    JsonNode n = node.get(i).get("RegistrationName");
                                    if (n != null) list.add(n.textValue());
                                }
                                result = list.toArray(new String[list.size()]);
                            } else {
                                InvoiceLineReport line = new InvoiceLineReport();

                                JsonNode quantity = findNode(node, new String[]{"InvoicedQuantity"});
                                if(quantity != null) {
                                    line.setUnit_code(quantity.get("unitCode").textValue());
                                    line.setInvoiced_quantity(new BigDecimal(quantity.get("").textValue()));
                                }

                                JsonNode taxAmount = findNode(node, new String[]{"TaxTotal", "TaxAmount"});
                                if(taxAmount != null) {
                                    line.setTt_tax_amount(new BigDecimal(taxAmount.get("").textValue()));
                                }

                                JsonNode description = findNode(node, new String[]{"Item", "Description"});
                                if(description != null) {
                                    line.setI_description(description.textValue());
                                }

                                JsonNode princingReferencePriceAmount = findNode(node, new String[]{"PricingReference", "AlternativeConditionPrice", "PriceAmount"});
                                if(princingReferencePriceAmount != null) {
                                    line.setPr_acp_price_amount(new BigDecimal(princingReferencePriceAmount.get("").textValue()));
                                }

                                JsonNode priceAmount = findNode(node, new String[]{"Price", "PriceAmount"});
                                if(princingReferencePriceAmount != null) {
                                    line.setP_price_amount(new BigDecimal(priceAmount.get("").textValue()));
                                }

                                JsonNode lineExtensionAmount = findNode(node, new String[]{"LineExtensionAmount"});
                                if(lineExtensionAmount != null) {
                                    line.setLine_extension_amount(new BigDecimal(lineExtensionAmount.get("").textValue()));
                                }

                                lines.add(line);
                            }
                            result = lines;
                        };
                        break;

                    default:
                        result = null;
                        break;
                }
                return result;
            }

            @Override
            public Map<String, Object> getParameters(OrganizationModel organization, InvoiceModel invoiceModel) {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put(PARAMETERS.OF_ORGANIZATION.toString(), organization.getName());
                return parameters;
            }

            @Override
            public void close() {
            }

        };
    }

    @Override
    public ReportDataProvider<CreditNoteModel> creditNote() {
        return null;
    }

    @Override
    public ReportDataProvider<DebitNoteModel> debitNote() {
        return null;
    }

    @Override
    public void close() {
    }
}
