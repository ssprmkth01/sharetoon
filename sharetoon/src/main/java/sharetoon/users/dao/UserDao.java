package sharetoon.users.dao;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import sharetoon.users.dto.UserDTO;

public class UserDao 
{
	private SqlMapClientTemplate sqlMapClientTemplate;

	public void addUser(UserDTO user)
	{
		sqlMapClientTemplate.insert("User.addUser", user);
	}

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
}
