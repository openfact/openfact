package org.openfact;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@UserContext
public class UserContextInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        try {
            return ctx.proceed();
        } finally {
            CompaniesResource.clearUser();
        }
    }

}
