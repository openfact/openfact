package org.openfact.ubl.data.xml.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Function;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ArrayKey {

    String[] arrayKey();

    String[] fieldKey();

    Class<? extends Function> mapper();

}
