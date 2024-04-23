package edu.sejong.ex.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import edu.sejong.ex.vo.UserVO;

@Mapper
public interface UserMapper {
	public UserVO getUser(String username);	
	
	@Insert("insert into users(username,password) VALUES (#{username},#{password})")
	public int insertUser(UserVO userVO);
	
	@Insert("insert into authorities(username,authority) values(#{username},'ROLE_USER')")
	public void insertAuthoruties(UserVO userVO);

}
