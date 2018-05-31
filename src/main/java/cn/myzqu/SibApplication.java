package cn.myzqu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("cn.myzqu.dao")
@EnableScheduling
public class SibApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SibApplication.class, args);
	}
}
