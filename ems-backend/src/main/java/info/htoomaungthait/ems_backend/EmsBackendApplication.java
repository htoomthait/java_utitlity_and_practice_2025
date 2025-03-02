package info.htoomaungthait.ems_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsBackendApplication {

	public static void main(String[] args) {
//		Dotenv dotenv = Dotenv.load();
//
//		String dbHost = dotenv.get("DB_HOST");
//		String dbPort = dotenv.get("DB_PORT");
//
//		System.out.println("Database Host: " + dbHost);
//		System.out.println("Database Port: " + dbPort);

		SpringApplication.run(EmsBackendApplication.class, args);


	}

}
