package com.example.sql_injection;

import com.example.sql_injection.model.User;
import com.example.sql_injection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.retry.annotation.EnableRetry;

import java.util.List;

import static com.example.sql_injection.model.Role.*;

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


	@Autowired
	PasswordEncoder bcrypt;

	@Bean
	public CommandLineRunner initDb(UserRepository UserRepository) {
		return (args) -> {

			var newUsers = List.of(
					new User("admin", bcrypt.encode("1234"), ADMIN),
					new User("Hasse", bcrypt.encode("ABC456"), USER),
					new User("Stina", bcrypt.encode("DET768"), USER),
					new User("Olof", bcrypt.encode("LOK789"), USER),
					new User("Beata", bcrypt.encode("SERTH45678"), USER),
					new User("Ludde", bcrypt.encode("3457"), USER),
					new User("Sigge", bcrypt.encode("PLI987TFE"), USER),
					new User("Bella", bcrypt.encode("ASDERT5"), USER),
					new User("Kajsa", bcrypt.encode("VGHTFD5"), MANAGER),
					new User("Gunvor", bcrypt.encode("9876543"), MANAGER));

			UserRepository.saveAll(newUsers);
		};
	}

}
