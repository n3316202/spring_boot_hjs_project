package edu.sejong.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sejong.ex.mapper.UserMapper;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	@Override
	public void addUser(UserVO userVO) {
		
		log.info("addUser");
		
		userVO.setEnabled("1");
		
		userMapper.insertUser(userVO);
		userMapper.insertAuthorities(userVO);
	}

}
