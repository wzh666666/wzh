package com.juzheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.juzheng.mapper")
public class WzhApplication {




	public static void main(String[] args) {
		SpringApplication.run(WzhApplication.class, args);
	}

}

