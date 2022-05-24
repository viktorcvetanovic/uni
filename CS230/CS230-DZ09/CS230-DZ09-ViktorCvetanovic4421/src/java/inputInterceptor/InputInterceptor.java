/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputInterceptor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import interceptorStereotype.InterceptorStereotype;

/**
 *
 * @author BiG
 */
@Interceptor
@InterceptorStereotype
public class InputInterceptor {
    
    private static final Logger logger = Logger.getLogger(InputInterceptor.class.getName());
    
    @AroundInvoke
    public Object logMethodCall(InvocationContext invocationContext) throws Exception{
        logger.log(Level.INFO, new StringBuilder("Input ").append(invocationContext.getMethod().getName()).append(" method").toString());
        Object retVal = invocationContext.proceed();
        logger.log(Level.INFO, new StringBuilder("Output ").append(invocationContext.getMethod().getName()).append(" method").toString());
        return retVal;
    }
}
