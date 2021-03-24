package com.lic.sharding;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import com.lic.sharding.dao.UserMapper;
import com.lic.sharding.domain.User;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.lic.sharding.dao.*")
public class ShardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingApplication.class, args);
	}

}
