package org.openfact.services.resources.admin.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@OrganizationAuth
@Interceptor
public class OrganizationAuthInterceptor {

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {
        try {
            return ic.proceed();
        } finally {
        }
    }

}