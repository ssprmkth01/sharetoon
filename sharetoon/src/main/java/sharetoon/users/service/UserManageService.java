package sharetoon.users.service;

import sharetoon.users.dao.UserDao;
import sharetoon.users.dto.UserDTO;

public class UserManageService 
{
	private UserDao userDao;
	
	/**
	 * 유저 생성 서비스
	 * @param user : 유저 정보
	 */
	public void createUser(UserDTO user)
	{
		/**
		 * TODO : validation
		 */
		userDao.addUser(user);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}