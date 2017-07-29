package sharetoon.common.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ValidateParameterAdvice implements MethodInterceptor
{
	@Override
	public Object invoke(MethodInvocation mthdInvoc) throws Throwable 
	{
		Object[] parameters= mthdInvoc.getArguments();

		for(Object param : parameters)
		{
			/**
			 * TODO : parameter check
			 */
			System.out.println(param);
		}
		
		mthdInvoc.proceed();
		return null;
	}
}