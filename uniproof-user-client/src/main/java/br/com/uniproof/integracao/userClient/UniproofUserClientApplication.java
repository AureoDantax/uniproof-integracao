package br.com.uniproof.integracao.userClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UniproofUserClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniproofUserClientApplication.class, args);
	}

}
