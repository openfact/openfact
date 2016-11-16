package org.openfact.report;

import java.util.Collection;
import java.util.Map;

import org.openfact.provider.Provider;

public interface ReportProvider extends Provider {
	byte[] processReportTheme(Map<String, Object> parameters, String templateName, ReportTheme theme,
            Collection<?> data);
}
