/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */
package org.openfact.services.util;

import org.openfact.OAuth2Constants;
import org.openfact.models.OpenfactContext;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.UserModel;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
import java.util.Locale;
import java.util.Set;

/**
 * @author <a href="mailto:gerbermichi@me.com">Michael Gerber</a>
 */
public class LocaleHelper {

    private static final String LOCALE_COOKIE = "OPENFACT_LOCALE";
    private static final String KC_LOCALE_PARAM = "kc_locale";

    public static Locale getLocale(OpenfactSession session, OrganizationModel organization, UserModel user) {
        if (!organization.isInternationalizationEnabled()) {
            return Locale.ENGLISH;
        } else {
            Locale locale = getUserLocale(session, organization, user);
            return locale != null ? locale : Locale.forLanguageTag(organization.getDefaultLocale());
        }
    }

    public static Locale getLocaleFromCookie(OpenfactSession session) {
        OpenfactContext ctx = session.getContext();

        if (ctx.getRequestHeaders() != null && ctx.getRequestHeaders().getCookies().containsKey(LOCALE_COOKIE)) {
            String localeString = ctx.getRequestHeaders().getCookies().get(LOCALE_COOKIE).getValue();
            Locale locale = findLocale(ctx.getOrganization().getSupportedLocales(), localeString);
            if (locale != null) {
                return locale;
            }
        }

        String locale = ctx.getOrganization().getDefaultLocale();
        if (locale != null) {
            return Locale.forLanguageTag(locale);
        } else {
            return Locale.ENGLISH;
        }
    }

    private static Locale getUserLocale(OpenfactSession session, OrganizationModel organization, UserModel user) {
        UriInfo uriInfo = session.getContext().getUri();
        HttpHeaders httpHeaders = session.getContext().getRequestHeaders();        

        // ui_locales query parameter
        if (uriInfo != null && uriInfo.getQueryParameters().containsKey(OAuth2Constants.UI_LOCALES_PARAM)) {
            String localeString = uriInfo.getQueryParameters().getFirst(OAuth2Constants.UI_LOCALES_PARAM);
            Locale locale = findLocale(organization.getSupportedLocales(), localeString.split(" "));
            if (locale != null) {
                return locale;
            }
        }

        // Accept-Language http header
        if (httpHeaders != null && httpHeaders.getAcceptableLanguages() != null && !httpHeaders.getAcceptableLanguages().isEmpty()) {
            for (Locale l : httpHeaders.getAcceptableLanguages()) {
                String localeString = l.toLanguageTag();
                Locale locale = findLocale(organization.getSupportedLocales(), localeString);
                if (locale != null) {
                    return locale;
                }
            }
        }

        return null;
    }

    private static Locale findLocale(Set<String> supportedLocales, String... localeStrings) {
        for (String localeString : localeStrings) {
            if (localeString != null) {
                Locale result = null;
                Locale search = Locale.forLanguageTag(localeString);
                for (String languageTag : supportedLocales) {
                    Locale locale = Locale.forLanguageTag(languageTag);
                    if (locale.getLanguage().equals(search.getLanguage())) {
                        if (locale.getCountry().equals("") && result == null) {
                            result = locale;
                        }
                        if (locale.getCountry().equals(search.getCountry())) {
                            return locale;
                        }
                    }
                }
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

}
