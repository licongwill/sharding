package com.lic.sharding;

import com.lic.sharding.dao.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.lic.sharding.dao.*")
public class ShardingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ShardingApplication.class, args);
		UserMapper userMapper = context.getBean("userMapper",UserMapper.class);
		userMapper.findById(1L);
	}

}
