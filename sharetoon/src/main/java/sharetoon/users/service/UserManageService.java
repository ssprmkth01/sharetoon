package sharetoon.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
		userDao.addUser(user);
	}
}