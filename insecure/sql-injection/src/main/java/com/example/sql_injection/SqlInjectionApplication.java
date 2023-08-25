package com.example.sql_injection;

import com.example.sql_injection.model.User;
import com.example.sql_injection.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.retry.annotation.EnableRetry;

import java.util.List;

@SpringBootApplication
@EnableRetry
public class SqlInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlInjectionApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		//builder.setConnectTimeout(Duration.ofSeconds(3));
		return builder.build();
	}

	@Bean
	public CommandLineRunner initDb(UserRepository UserRepository) {
		return (args) -> {

			var newUsers = List.of(new User("admin", "1234", "ADMIN"),
												new User("Kalle","kallekanin82","USER"),
												new User("Lisa","lisaflisan1999","USER"),
												new User("Micke","mIcKe82!","USER"),
												new User("Beata","beatricesvenssoN?","USER"),
												new User("Ricky", "qwerty12345","USER"),
												new User("Sigismund", "password123456789!","USER"));


			UserRepository.saveAll(newUsers);
		};
	}

}
