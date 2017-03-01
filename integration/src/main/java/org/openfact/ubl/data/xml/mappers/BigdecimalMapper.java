package org.openfact.ubl.data.xml.mappers;

import java.math.BigDecimal;
import java.util.function.Function;

public class BigdecimalMapper implements Function<Object, BigDecimal> {

    @Override
    public BigDecimal apply(Object o) {
        if (o != null) {
            return new BigDecimal(String.valueOf(o));
        }
        return null;
    }

}
