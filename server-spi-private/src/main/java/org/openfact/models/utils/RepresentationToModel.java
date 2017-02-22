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
package org.openfact.models.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.component.ComponentModel;
import org.openfact.keys.KeyProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.representations.idm.ComponentExportRepresentation;
import org.openfact.representations.idm.ComponentRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;
import org.openfact.representations.idm.PostalAddressRepresentation;
import org.openfact.representations.idm.search.PagingRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterOperatorRepresentation;
import org.openfact.representations.idm.search.SearchCriteriaFilterRepresentation.FilterValueType;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;

public class RepresentationToModel {

    public static SearchCriteriaModel toModel(SearchCriteriaRepresentation rep) {
        SearchCriteriaModel model = new SearchCriteriaModel();

        // filters
        Function<SearchCriteriaFilterOperatorRepresentation, SearchCriteriaFilterOperator> operatorFunction = f -> {
            return SearchCriteriaFilterOperator.valueOf(f.toString());
        };

        BiFunction<Object, FilterValueType, Object> valueFunction = (value, type) -> {
            if (type == null) return value;
            Object result = null;
            switch (type) {
                case LONG:
                    result = (long) value;
                    break;
                case STRING:
                    result = (String) value;
                    break;
                case DATE:
                    result = LocalDateTime.parse((String) value, DateTimeFormatter.ISO_DATE);
                    break;
                case DATETIME:
                    result = LocalDateTime.parse((String) value, DateTimeFormatter.ISO_DATE_TIME);
                    break;
                default:
                    result = value;
                    break;
            }
            return result;
        };

        rep.getFilters().forEach(f -> {
            model.addFilter(f.getName(), valueFunction.apply(f.getValue(), f.getType()),
                    operatorFunction.apply(f.getOperator()));
        });

        // sorter
        rep.getOrders().forEach(f -> model.addOrder(f.getName(), f.isAscending()));

        // paging
        if (rep.getPaging() != null) {
            PagingRepresentation paging = rep.getPaging();
            model.setPageSize(paging.getPageSize());
            model.setPage(paging.getPage());
        }

        return model;
    }

    public static void importOrganization(OpenfactSession session, OrganizationRepresentation rep,
                                          OrganizationModel newOrganization) {

        newOrganization.setName(rep.getOrganization());

        /**
         * General information
         */
        if (rep.getDescription() != null) {
            newOrganization.setDescription(rep.getDescription());
        }
        if (rep.getEnabled() != null) {
            newOrganization.setEnabled(rep.getEnabled());
        }

        if (rep.getAssignedIdentificationId() != null) {
            newOrganization.setAssignedIdentificationId(rep.getAssignedIdentificationId());
        }
        if (rep.getAdditionalAccountId() != null) {
            newOrganization.setAdditionalAccountId(rep.getAdditionalAccountId());
        }
        if (rep.getSupplierName() != null) {
            newOrganization.setSupplierName(rep.getSupplierName());
        }
        if (rep.getRegistrationName() != null) {
            newOrganization.setRegistrationName(rep.getRegistrationName());
        }

        /**
         * Postal address
         */
        if (rep.getPostalAddress() != null) {
            PostalAddressRepresentation postalAddressRep = rep.getPostalAddress();
            if (postalAddressRep.getPostalAddressId() != null) {
                newOrganization.setPostalAddressId(postalAddressRep.getPostalAddressId());
            }
            if (postalAddressRep.getCountryIdentificationCode() != null) {
                newOrganization.setCountryIdentificationCode(postalAddressRep.getCountryIdentificationCode());
            }
            if (postalAddressRep.getCountrySubentity() != null) {
                newOrganization.setCountrySubentity(postalAddressRep.getCountrySubentity());
            }
            if (postalAddressRep.getCityName() != null) {
                newOrganization.setCityName(postalAddressRep.getCityName());
            }
            if (postalAddressRep.getCitySubdivisionName() != null) {
                newOrganization.setCitySubdivisionName(postalAddressRep.getCitySubdivisionName());
            }
            if (postalAddressRep.getDistrict() != null) {
                newOrganization.setDistrict(postalAddressRep.getDistrict());
            }
            if (postalAddressRep.getStreetName() != null) {
                newOrganization.setStreetName(postalAddressRep.getStreetName());
            }
        }

        /**
         * Themes
         */
        if (rep.getEmailTheme() != null) {
            newOrganization.setEmailTheme(rep.getEmailTheme());
        }
        if (rep.getReportTheme() != null) {
            newOrganization.setReportTheme(rep.getReportTheme());
        }

        /**
         * Internationalization
         */
        if (rep.getInternationalizationEnabled() != null) {
            newOrganization.setInternationalizationEnabled(rep.getInternationalizationEnabled());
        }
        if (rep.getSupportedLocales() != null) {
            newOrganization.setSupportedLocales(new HashSet<String>(rep.getSupportedLocales()));
        }
        if (rep.getDefaultLocale() != null) {
            newOrganization.setDefaultLocale(rep.getDefaultLocale());
        }

        /**
         * Tasks schedule
         */
        if (rep.getTaskFirstTime() != null) {
            newOrganization.setTaskFirstTime(rep.getTaskFirstTime());
        }
        if (rep.getTaskDelay() != null) {
            newOrganization.setTaskDelay(rep.getTaskDelay());
        }
        if (rep.isTasksEnabled() != null) {
            newOrganization.setTaskEnabled(rep.isTasksEnabled());
        } else {
            newOrganization.setTaskEnabled(false);
        }

        /**
         * Currencies
         */
        if (rep.getDefaultCurrency() != null) {
            newOrganization.setDefaultCurrency(rep.getDefaultCurrency());
        }
        if (rep.getSupportedCurrencies() != null) {
            newOrganization.setSupportedCurrencies(new HashSet<String>(rep.getSupportedCurrencies()));
        }

        /**
         * Events
         */
        if (rep.getEventsEnabled() != null) {
            newOrganization.setEventsEnabled(rep.getEventsEnabled());
        }
        if (rep.getEventsExpiration() != null) {
            newOrganization.setEventsExpiration(rep.getEventsExpiration());
        }
        if (rep.getEventsListeners() != null) {
            newOrganization.setEventsListeners(new HashSet<>(rep.getEventsListeners()));
        }
        if (rep.getAdminEventsEnabled() != null) {
            newOrganization.setAdminEventsEnabled(rep.getAdminEventsEnabled());
        }
        if (rep.getAdminEventsDetailsEnabled() != null) {
            newOrganization.setAdminEventsDetailsEnabled(rep.getAdminEventsDetailsEnabled());
        }

        /**
         * Smtp server
         */
        if (rep.getSmtpServer() != null) {
            newOrganization.setSmtpConfig(new HashMap<String, String>(rep.getSmtpServer()));
        }

        if (rep.getComponents() != null) {
            MultivaluedHashMap<String, ComponentExportRepresentation> components = rep.getComponents();
            String parentId = newOrganization.getId();
            importComponents(newOrganization, components, parentId);
        }

        /**
         * Certificate
         */
        if (newOrganization.getComponents(newOrganization.getId(), KeyProvider.class.getName()).isEmpty()) {
            if (rep.getPrivateKey() != null) {
                DefaultKeyProviders.createProviders(newOrganization, rep.getPrivateKey(),
                        rep.getCertificate());
            } else {
                DefaultKeyProviders.createProviders(newOrganization);
            }
        }

        /**
         * Attributes
         */
        if (rep.getAttributes() != null) {
            for (Map.Entry<String, String> attr : rep.getAttributes().entrySet()) {
                newOrganization.setAttribute(attr.getKey(), attr.getValue());
            }
        }
    }

    public static void updateOrganization(OrganizationRepresentation rep, OrganizationModel organization,
                                          OpenfactSession session) {
        if (rep.getOrganization() != null) {
            renameOrganization(organization, rep.getOrganization());
        }

        // Import attributes first, so the stuff saved directly on
        // representation (displayName, bruteForce etc) has bigger priority
        if (rep.getAttributes() != null) {
            Set<String> attrsToRemove = new HashSet<>(organization.getAttributes().keySet());
            attrsToRemove.removeAll(rep.getAttributes().keySet());

            for (Map.Entry<String, String> entry : rep.getAttributes().entrySet()) {
                organization.setAttribute(entry.getKey(), entry.getValue());
            }

            for (String attr : attrsToRemove) {
                organization.removeAttribute(attr);
            }
        }

        /**
         * General information
         */
        if (rep.getDescription() != null) {
            organization.setDescription(rep.getDescription());
        }
        if (rep.getEnabled() != null) {
            organization.setEnabled(rep.getEnabled());
        }

        if (rep.getAssignedIdentificationId() != null) {
            organization.setAssignedIdentificationId(rep.getAssignedIdentificationId());
        }
        if (rep.getAdditionalAccountId() != null) {
            organization.setAdditionalAccountId(rep.getAdditionalAccountId());
        }
        if (rep.getSupplierName() != null) {
            organization.setSupplierName(rep.getSupplierName());
        }
        if (rep.getRegistrationName() != null) {
            organization.setRegistrationName(rep.getRegistrationName());
        }

        /**
         * Postal address
         */
        if (rep.getPostalAddress() != null) {
            PostalAddressRepresentation postalAddressRep = rep.getPostalAddress();
            if (postalAddressRep.getPostalAddressId() != null) {
                organization.setPostalAddressId(postalAddressRep.getPostalAddressId());
            }
            if (postalAddressRep.getCountryIdentificationCode() != null) {
                organization.setCountryIdentificationCode(postalAddressRep.getCountryIdentificationCode());
            }
            if (postalAddressRep.getCountrySubentity() != null) {
                organization.setCountrySubentity(postalAddressRep.getCountrySubentity());
            }
            if (postalAddressRep.getCityName() != null) {
                organization.setCityName(postalAddressRep.getCityName());
            }
            if (postalAddressRep.getCitySubdivisionName() != null) {
                organization.setCitySubdivisionName(postalAddressRep.getCitySubdivisionName());
            }
            if (postalAddressRep.getDistrict() != null) {
                organization.setDistrict(postalAddressRep.getDistrict());
            }
            if (postalAddressRep.getStreetName() != null) {
                organization.setStreetName(postalAddressRep.getStreetName());
            }
        }

        /**
         * Themes
         */
        if (rep.getEmailTheme() != null) {
            organization.setEmailTheme(rep.getEmailTheme());
        }
        if (rep.getReportTheme() != null) {
            organization.setReportTheme(rep.getReportTheme());
        }

        /**
         * Internationalization
         */
        if (rep.getInternationalizationEnabled() != null) {
            organization.setInternationalizationEnabled(rep.getInternationalizationEnabled());
        }
        if (rep.getSupportedLocales() != null) {
            organization.setSupportedLocales(new HashSet<String>(rep.getSupportedLocales()));
        }
        if (rep.getDefaultLocale() != null) {
            organization.setDefaultLocale(rep.getDefaultLocale());
        }

        /**
         * Tasks schedule
         */
        if (rep.isTasksEnabled() != null) {
            organization.setTaskEnabled(rep.isTasksEnabled());
        }
        if (rep.getTaskFirstTime() != null) {
            organization.setTaskFirstTime(rep.getTaskFirstTime());
        }
        if (rep.getTaskDelay() != null) {
            organization.setTaskDelay(rep.getTaskDelay());
        }

        /**
         * Currencies
         */
        if (rep.getDefaultCurrency() != null) {
            organization.setDefaultCurrency(rep.getDefaultCurrency());
        }
        if (rep.getSupportedCurrencies() != null) {
            organization
                    .setSupportedCurrencies(new HashSet<String>(new HashSet<>(rep.getSupportedCurrencies())));
        }

        /**
         * Events
         */
        if (rep.getEventsEnabled() != null) {
            organization.setEventsEnabled(rep.getEventsEnabled());
        }
        if (rep.getEventsExpiration() != null) {
            organization.setEventsExpiration(rep.getEventsExpiration());
        }
        if (rep.getEventsListeners() != null) {
            organization.setEventsListeners(new HashSet<>(rep.getEventsListeners()));
        }
        if (rep.getEnabledEventTypes() != null) {
            organization.setEnabledEventTypes(new HashSet<>(rep.getEnabledEventTypes()));
        }

        if (rep.getAdminEventsEnabled() != null) {
            organization.setAdminEventsEnabled(rep.getAdminEventsEnabled());
        }
        if (rep.getAdminEventsDetailsEnabled() != null) {
            organization.setAdminEventsDetailsEnabled(rep.getAdminEventsDetailsEnabled());
        }

        /**
         * Smtp Server
         **/
        if (rep.getSmtpServer() != null) {
            organization.setSmtpConfig(new HashMap(rep.getSmtpServer()));
        }
    }

    public static void renameOrganization(OrganizationModel organization, String name) {
        if (name.equals(organization.getName())) {
            return;
        }

        String oldName = organization.getName();
        organization.setName(name);
    }

    public static ComponentModel toModel(OpenfactSession session, ComponentRepresentation rep) {
        ComponentModel model = new ComponentModel();
        model.setParentId(rep.getParentId());
        model.setProviderType(rep.getProviderType());
        model.setProviderId(rep.getProviderId());
        model.setConfig(new MultivaluedHashMap<>());
        model.setName(rep.getName());
        model.setSubType(rep.getSubType());

        if (rep.getConfig() != null) {
            Set<String> keys = new HashSet<>(rep.getConfig().keySet());
            for (String k : keys) {
                List<String> values = rep.getConfig().get(k);
                if (values != null) {
                    ListIterator<String> itr = values.listIterator();
                    while (itr.hasNext()) {
                        String v = itr.next();
                        if (v == null || v.trim().isEmpty()) {
                            itr.remove();
                        }
                    }

                    if (!values.isEmpty()) {
                        model.getConfig().put(k, values);
                    }
                }
            }
        }

        return model;
    }

    public static void updateComponent(OpenfactSession session, ComponentRepresentation rep, ComponentModel component, boolean internal) {
        if (rep.getParentId() != null) {
            component.setParentId(rep.getParentId());
        }

        if (rep.getProviderType() != null) {
            component.setProviderType(rep.getProviderType());
        }

        if (rep.getProviderId() != null) {
            component.setProviderId(rep.getProviderId());
        }

        if (rep.getSubType() != null) {
            component.setSubType(rep.getSubType());
        }

        Map<String, ProviderConfigProperty> providerConfiguration = null;
        if (!internal) {
            providerConfiguration = ComponentUtil.getComponentConfigProperties(session, component);
        }

        if (rep.getConfig() != null) {
            Set<String> keys = new HashSet<>(rep.getConfig().keySet());
            for (String k : keys) {
                if (!internal && !providerConfiguration.containsKey(k)) {
                    break;
                }

                List<String> values = rep.getConfig().get(k);
                if (values == null || values.isEmpty() || values.get(0) == null || values.get(0).trim().isEmpty()) {
                    component.getConfig().remove(k);
                } else {
                    ListIterator<String> itr = values.listIterator();
                    while (itr.hasNext()) {
                        String v = itr.next();
                        if (v == null || v.trim().isEmpty() || v.equals(ComponentRepresentation.SECRET_VALUE)) {
                            itr.remove();
                        }
                    }

                    if (!values.isEmpty()) {
                        component.getConfig().put(k, values);
                    }
                }
            }
        }
    }

    protected static void importComponents(OrganizationModel newOrganization, MultivaluedHashMap<String, ComponentExportRepresentation> components, String parentId) {
        for (Map.Entry<String, List<ComponentExportRepresentation>> entry : components.entrySet()) {
            String providerType = entry.getKey();
            for (ComponentExportRepresentation compRep : entry.getValue()) {
                ComponentModel component = new ComponentModel();
                component.setId(compRep.getId());
                component.setName(compRep.getName());
                component.setConfig(compRep.getConfig());
                component.setProviderType(providerType);
                component.setProviderId(compRep.getProviderId());
                component.setSubType(compRep.getSubType());
                component.setParentId(parentId);
                component = newOrganization.addComponentModel(component);
                if (compRep.getSubComponents() != null) {
                    importComponents(newOrganization, compRep.getSubComponents(), component.getId());
                }
            }
        }
    }

}