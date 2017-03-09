package org.openfact.theme;

import java.io.IOException;
import java.util.Set;

public interface ThemeProvider {

    int getProviderPriority();

    Theme getTheme(String name, Theme.Type type) throws IOException;

    Set<String> nameSet(Theme.Type type);

    boolean hasTheme(String name, Theme.Type type);

}
