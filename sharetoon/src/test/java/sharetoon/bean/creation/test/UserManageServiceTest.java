package sharetoon.bean.creation.test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import sharetoon.users.dto.UserDTO;
import sharetoon.users.service.UserManageService;

public class UserManageServiceTest
{
	private final String CONFIG_LOCATION= "config/spring/applicationContext.xml";
	
	@Autowired
	private PlatformTransactionManager txMgr;
	
	@Test
	public void controllerIncTest()
	{
		
	}
	
//	@Test
//	public void transactionTest() throws Exception
//	{
//		ApplicationContext appCtxt= new ClassPathXmlApplicationContext(CONFIG_LOCATION);
//		UserManageService userMngSvc= appCtxt.getBean("userManageService", UserManageService.class);
//		
//		List<UserDTO> users= new ArrayList<UserDTO>();
//		
//		for(int i=0; i<10; i++)
//		{
//			UserDTO user= getSimpleUser();
//			user.setId(user.getId() + "-" + String.valueOf(i+1));
//			
//			if(i==7) {
//				user.setPoint(-100);
//			}
//			
//			users.add(user);
//		}
//		
//		userMngSvc.addUsers(users);
//	}
	
	@Test
	public void createUser() throws Exception
	{
		ApplicationContext appCtxt= new ClassPathXmlApplicationContext(CONFIG_LOCATION);
		txMgr= appCtxt.getBean("txMgr", DataSourceTransactionManager.class);
		DefaultTransactionDefinition txDef= new DefaultTransactionDefinition();
		TransactionStatus txStat= txMgr.getTransaction(txDef);
		UserManageService userMngSvc= appCtxt.getBean("userManageService", UserManageService.class);
		
		if(userMngSvc == null) {
			fail("bean creation fail");
		}
		
		try {
			userMngSvc.createUser(getSimpleUser());
		} catch(Exception e) {
			fail("create user get exception");
		} finally {
			txMgr.rollback(txStat);
		}
	}
	
	@Test(expected = Exception.class)
	public void createUserFail() throws Exception
	{
		ApplicationContext appCtxt= new ClassPathXmlApplicationContext(CONFIG_LOCATION);
		txMgr= appCtxt.getBean("txMgr", DataSourceTransactionManager.class);
		DefaultTransactionDefinition txDef= new DefaultTransactionDefinition();
		TransactionStatus txStat= txMgr.getTransaction(txDef);
		UserManageService userMngSvc= appCtxt.getBean("userManageService", UserManageService.class);
		
		if(userMngSvc == null) {
			fail("bean creation fail");
		}
		
		try {
			UserDTO user= new UserDTO();
			userMngSvc.createUser(user);
		} finally {
			txMgr.rollback(txStat);
		}
		
		fail("No Exception");
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