package sharetoon.users.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import sharetoon.users.dto.UserDTO;

public class UserDao 
{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public void addUser(UserDTO user)
	{
		sqlMapClientTemplate.insert("User.addUser", user);
	}
}
