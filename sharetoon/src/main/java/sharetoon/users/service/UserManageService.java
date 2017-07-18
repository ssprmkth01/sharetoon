package sharetoon.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import sharetoon.users.dao.UserDao;
import sharetoon.users.dto.UserDTO;

@Transactional
public class UserManageService 
{
	@Autowired
	private UserDao userDao;
	
	/**
	 * 유저 생성 서비스
	 * @param user : 유저 정보
	 */
	public void createUser(UserDTO user) throws Exception
	{
		String validMsg= validateUser(user);
		
		if( StringUtils.hasText(validMsg) )
		{
			throw new Exception(validMsg);
		}
		
		userDao.addUser(user);
	}
	
	private String validateUser(UserDTO user)
	{
		if( !StringUtils.hasText(user.getId()) ) {
			return "Empty ID";
		} else if( !StringUtils.hasText(user.getPassword()) ) {
			return "Empty Password";
		} else if( !StringUtils.hasText(user.getEmail()) ) {
			return "Empty Email Address";
		} else if( user.getPoint() < 0 ) {
			return "Invalid Point";
		}
		return "";
	}
	
	
}