package org.openfact.report;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.openfact.Config;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class JasperReportUtil {

    private ConcurrentHashMap<String, JasperReport> cache;

    @PostConstruct
    private void init() {
        if (Config.scope("report").getBoolean("cacheTemplates", true)) {
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
        URL url = theme.getTemplate(templateName + ".jasper");
        if (url != null) {
            return (JasperReport) JRLoader.loadObject(url);
        }

        url = theme.getTemplate(templateName + ".jrxml");
        if (url != null) {
            return JasperCompileManager.compileReport(url.openStream());
        }

        return null;
    }

}
