package org.openfact.ubl.data.xml.mappers;

import java.util.function.Function;

public class StringMapper implements Function<Object, String> {

    @Override
    public String apply(Object o) {
        if (o != null) {
            return String.valueOf(o);
        }
        return null;
    }

}
