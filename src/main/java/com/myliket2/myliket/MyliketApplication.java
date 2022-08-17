package com.myliket2.myliket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.myliket2.myliket")
public class MyliketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyliketApplication.class, args);
	}

}

