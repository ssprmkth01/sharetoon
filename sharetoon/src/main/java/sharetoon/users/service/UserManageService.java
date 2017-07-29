package sharetoon.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import sharetoon.users.dao.UserDao;
import sharetoon.users.dto.UserDTO;

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
	
//	/**
//	 * 잠시 트랜잭션 테스트용 서비스 오퍼레이션. TODO : 삭제
//	 * @param users
//	 * @throws Exception
//	 */
//	@Transactional(rollbackFor={Exception.class})
//	public void addUsers(List<UserDTO> users) throws Exception
//	{
//		for(UserDTO user : users)
//		{
//			if(user.getPoint() < 0)
//			{
//				throw new Exception("Exception !!");
//			}
//			userDao.addUser(user);
//		}
//	}
}