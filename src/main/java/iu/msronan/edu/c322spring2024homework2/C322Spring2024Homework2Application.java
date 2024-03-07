package iu.msronan.edu.c322spring2024homework2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class C322Spring2024Homework2Application {

	public static void main(String[] args) {
		SpringApplication.run(C322Spring2024Homework2Application.class, args);
	}

}
