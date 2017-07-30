package sharetoon.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sharetoon.users.dto.UserDTO;
import sharetoon.users.service.UserManageService;

@Controller
public class UserManageController 
{
	@Autowired
	private UserManageService userMngSvc;
	
	@RequestMapping("/JoinMember.do")
	public ModelAndView joinMember(
			@RequestParam("id")String userId, 
			String password,
			@RequestParam("mail1")String mailId,
			@RequestParam("mail2")String mailVendor) throws Exception
	{
		UserDTO user= new UserDTO();
		user.setId(userId);
		user.setPassword(password);
		user.setEmail(mailId + "@" + mailVendor);
		user.setPoint(100);
		
		/**
		 * TODO : 에러처리
		 */
		userMngSvc.createUser(user);
		ModelAndView mav= new ModelAndView("LoginForm");
		return mav;
	}
}
