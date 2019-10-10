package com.platform.rentalhome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * describe:
 *
 * @author Administrator
 * @date 2019/09/05
 * @Time 21:30
 */
@SpringBootApplication
@MapperScan(basePackages = "com.platform.rentalhome.mapper")
public class RentalhomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalhomeApplication.class, args);
	}

}
