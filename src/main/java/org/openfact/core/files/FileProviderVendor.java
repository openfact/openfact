package org.openfact.core.files;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Documented
public @interface FileProviderVendor {

    Type type();

    enum Type {
        FTP,
        FILESYSTEM,
        JPA,
        DROPBOX;
    }

}