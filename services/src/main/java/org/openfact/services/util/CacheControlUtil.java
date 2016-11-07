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

package org.openfact.services.util;

import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.Config;

import javax.ws.rs.core.CacheControl;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class CacheControlUtil {

    public static void noBackButtonCacheControlHeader() {
        HttpResponse response = ResteasyProviderFactory.getContextData(HttpResponse.class);
        response.getOutputHeaders().putSingle("Cache-Control", "no-store, must-revalidate, max-age=0");
    }

    public static CacheControl getDefaultCacheControl() {
        CacheControl cacheControl = new CacheControl();
        cacheControl.setNoTransform(false);
        Integer maxAge = Config.scope("theme").getInt("staticMaxAge");
        if (maxAge != null && maxAge > 0) {
            cacheControl.setMaxAge(maxAge);
        } else {
            cacheControl.setNoCache(true);
        }
        return cacheControl;
    }

    public static CacheControl noCache() {

        CacheControl cacheControl = new CacheControl();
        cacheControl.setMustRevalidate(true);
        cacheControl.setNoCache(true);
        cacheControl.setNoStore(true);

        return cacheControl;
    }


}
