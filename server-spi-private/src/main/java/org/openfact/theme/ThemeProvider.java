package org.openfact.theme;

import java.io.IOException;
import java.util.Set;

public interface ThemeProvider {

    public int getProviderPriority();

    public Theme getTheme(String name, Theme.Type type) throws IOException;

    public Set<String> nameSet(Theme.Type type);

    public boolean hasTheme(String name, Theme.Type type);

}
