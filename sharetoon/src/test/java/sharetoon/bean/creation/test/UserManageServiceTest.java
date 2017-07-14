package sharetoon.bean.creation.test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sharetoon.users.dto.UserDTO;
import sharetoon.users.service.UserManageService;

public class UserManageServiceTest 
{
	@Test
	public void addUser() 
	{
		ApplicationContext appCtxt= new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
		UserManageService userMngSvc= appCtxt.getBean("userManageService", UserManageService.class);
		
		if(userMngSvc == null) {
			fail("bean creation fail");
		}
		
		userMngSvc.createUser(getSimpleUser());
	}
	
	private UserDTO getSimpleUser()
	{
		UserDTO user= new UserDTO();
		
		user.setId("ssprmkth01");
		user.setPassword("ssprmkth01");
		user.setEmail("ssprmkth01@gmail.com");
		user.setPoint(100);
		
		return user;
	}

}