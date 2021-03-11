package com.lic.sharding;

import com.lic.sharding.dao.UserMapper;
import com.lic.sharding.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingApplicationTests {

	@Autowired
	private UserMapper userDao;

	@Test
	void contextLoads() {
	}

	@Test
	public void testUser(){
		User byId = userDao.findById(1L);
		System.out.println(byId.toString());
	}
}
