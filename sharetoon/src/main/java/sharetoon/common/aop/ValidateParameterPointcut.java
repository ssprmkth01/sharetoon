package sharetoon.common.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.util.PatternMatchUtils;

@SuppressWarnings("serial")
public class ValidateParameterPointcut extends NameMatchMethodPointcut
{
	public void setMappedClassName(final String mappedClassName)
	{
		this.setClassFilter(new ClassFilter() 
		{
			@Override
			public boolean matches(Class<?> clazz) 
			{
				return PatternMatchUtils.simpleMatch(mappedClassName, clazz.getSimpleName());
			}
		});
	}
}
