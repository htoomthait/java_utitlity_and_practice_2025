package info.htoomaungthait.ems_backend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsBackendApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();

		String dbHost = dotenv.get("DB_HOST");
		String dbPort = dotenv.get("DB_PORT");
		String dbName = dotenv.get("DB_NAME");
		String dbUsername = dotenv.get("DB_USERNAME");
		String dbPassword = dotenv.get("DB_PASSWORD");

		System.out.println("Database Host: " + dbHost);
		System.out.println("Database Port: " + dbPort);
		System.out.println("Database Name: " + dbName);
		System.out.println("Database Username: " + dbUsername);
		System.out.println("Database Password: " + dbPassword);

		SpringApplication.run(EmsBackendApplication.class, args);

		System.out.print("This is main app!");


	}

}
