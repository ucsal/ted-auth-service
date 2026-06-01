package ucsal.ted_auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TedAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TedAuthServiceApplication.class, args);
	}

}
