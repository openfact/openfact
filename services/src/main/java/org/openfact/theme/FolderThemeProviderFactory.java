package org.openfact.theme;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.RepeidSessionFactory;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.ThemeProviderFactory;

import java.io.File;

public class FolderThemeProviderFactory implements ThemeProviderFactory {

	private FolderThemeProvider themeProvider;

	@Override
	public ThemeProvider create(OpenfactSession sessions) {
		return themeProvider;
	}

	@Override
	public void init(Config.Scope config) {
		String d = config.get("dir");
		File rootDir = null;
		if (d != null) {
			rootDir = new File(d);
		}
		themeProvider = new FolderThemeProvider(rootDir);
	}

	@Override
	public void postInit(RepeidSessionFactory factory) {

	}

	@Override
	public void close() {

	}

	@Override
	public String getId() {
		return "folder";
	}
}
