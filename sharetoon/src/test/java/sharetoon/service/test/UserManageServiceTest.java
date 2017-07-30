package sharetoon.service.test;

import static org.junit.Assert.fail;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.servlet.ModelAndView;

import junit.framework.Assert;
import sharetoon.test.helper.ConfigurableDispatcherServlet;
import sharetoon.users.dto.UserDTO;
import sharetoon.users.service.UserManageService;

public class UserManageServiceTest
{
	private final String CONFIG_LOCATION= "config/spring/applicationContext.xml";
//	private String[] locations=
//		{
//			"C:\\git\\sharetoon\\sharetoon\\src\\main\\resources\\config\\spring\\applicationContext.xml",
//			"C:\\git\\sharetoon\\sharetoon\\src\\main\\resources\\config\\spring\\servletContext.xml"
//		};
	private String[] locations=
		{
			"config/spring/applicationContext.xml",
			"config/spring/servletContext.xml"
		};
	
	@Autowired
	private PlatformTransactionManager txMgr;
	
//	/**
//	 * 동작 안함;;;;;;;
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	@Test
//	public void controllerIncTest() throws ServletException, IOException
//	{
//		ConfigurableDispatcherServlet servlet= new ConfigurableDispatcherServlet(locations);
//		servlet.init(new MockServletConfig(new MockServletContext("spring")));
//		
//		MockHttpServletRequest req= new MockHttpServletRequest("POST", "/JoinMember.do");
//		req.addParameter("id", "ssprmkth01");
//		req.addParameter("password", "ssprmkth01");
//		req.addParameter("email", "ssprmkth01@gmail.com");
//		req.addParameter("point", "100");
//		
//		MockHttpServletResponse res= new MockHttpServletResponse();
//		
//		servlet.service(req, res);
//		
//		ModelAndView mav= servlet.getModelAndView();
//		Assert.assertEquals(mav.getViewName(), "LoginForm");
//	}
	
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