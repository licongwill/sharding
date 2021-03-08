package com.lic.sharding;

import com.lic.sharding.dao.UserDao;
import com.lic.sharding.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShardingApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ShardingApplication.class, args);
		UserDao userDao = (UserDao) run.getBean("userDao");
		User byId = userDao.findById(1L);
	}

}
