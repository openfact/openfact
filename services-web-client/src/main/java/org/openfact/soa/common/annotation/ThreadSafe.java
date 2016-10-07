package org.openfact.soa.common.annotation;

import java.lang.annotation.*;


@Documented
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.CLASS)
public @interface ThreadSafe {
}
