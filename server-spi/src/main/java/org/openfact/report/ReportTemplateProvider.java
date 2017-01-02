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
package org.openfact.report;

import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;

import java.util.List;

public interface ReportTemplateProvider<T> extends Provider {

    ReportTemplateProvider setOrganization(OrganizationModel organization);

    ReportTemplateProvider setThemeName(String themeName);

    ReportTemplateProvider setAttribute(String name, Object value);

    byte[] getReportAsPdf(T t) throws ReportException;

    byte[] getReportAsPdf(List<T> t) throws ReportException;

    byte[] getReport(T t, ExportFormat exportFormat) throws ReportException;

    byte[] getReport(List<T> t, ExportFormat exportFormat) throws ReportException;

}
