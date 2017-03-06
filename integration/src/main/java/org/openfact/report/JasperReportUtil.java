package org.openfact.report;

import net.sf.jasperreports.engine.*;
import org.openfact.Config;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JasperReportUtil {

    private ConcurrentHashMap<String, JasperReport> cache;

    public JasperReportUtil() {
        if (Config.scope("theme").getBoolean("cacheTemplates", true)) {
            cache = new ConcurrentHashMap<>();
        }
    }

    public JasperPrint processReport(ReportTheme theme, String templateName, Map<String, Object> parameters, JRDataSource dataSource) throws JasperReportException {
        try {
            JasperReport jr;
            if (cache != null) {
                String key = theme.getName() + "/" + templateName;
                jr = cache.get(key);
                if (jr == null) {
                    jr = getReport(templateName, theme);
                    if (cache.putIfAbsent(key, jr) != null) {
                        jr = cache.get(key);
                    }
                }
            } else {
                jr = getReport(templateName, theme);
            }

            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, dataSource);
            return jp;
        } catch (Exception e) {
            throw new JasperReportException("Failed to process report template " + templateName, e);
        }
    }

    private JasperReport getReport(String templateName, ReportTheme theme) throws IOException, JRException {
        URL url = theme.getTemplate(templateName);
        JasperReport jr = JasperCompileManager.compileReport(url.openStream());
        return jr;
    }

}
