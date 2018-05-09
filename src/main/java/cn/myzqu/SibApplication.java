package cn.myzqu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.myzqu.dao")
public class SibApplication {

	public static void main(String[] args) {
		SpringApplication.run(SibApplication.class, args);
	}
}
