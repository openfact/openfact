package org.openfact.provider.wildfly;

import org.jboss.modules.Module;
import org.jboss.modules.ModuleClassLoader;
import org.jboss.modules.ModuleIdentifier;
import org.openfact.Config;
import org.openfact.report.JarReportThemeProviderFactory;

public class ModuleReportThemeProviderFactory extends JarReportThemeProviderFactory {

    @Override
    public void init(Config.Scope config) {
        String[] modules = config.getArray("modules");
        if (modules != null) {
            try {
                for (String moduleSpec : modules) {
                    Module module = Module.getContextModuleLoader().loadModule(ModuleIdentifier.fromString(moduleSpec));
                    ModuleClassLoader classLoader = module.getClassLoader();
                    loadThemes(classLoader, classLoader.getResourceAsStream(OPENFACT_REPORT_THEMES_JSON));
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to load report themes", e);
            }
        }
    }

    @Override
    public String getId() {
        return "module";
    }

}
