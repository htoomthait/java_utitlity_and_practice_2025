package info.htoomaungthait.ems_backend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "info.htoomaungthait.ems_backend")
public class EmsBackendApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		String appName = dotenv.get("APP_NAME", "APP_NAME");
		String dbHost = dotenv.get("DB_HOST");
		String dbPort = dotenv.get("DB_PORT");
		String dbName = dotenv.get("DB_NAME");
		String dbUsername = dotenv.get("DB_USERNAME");
		String dbPassword = dotenv.get("DB_PASSWORD");

		System.out.println("App name: " + appName);
		System.out.println("Database Host: " + dbHost);
		System.out.println("Database Port: " + dbPort);
		System.out.println("Database Name: " + dbName);
		System.out.println("Database Username: " + dbUsername);
		System.out.println("Database Password: " + dbPassword);

		SpringApplication.run(EmsBackendApplication.class, args);

		System.out.print("This is main app!");


	}

}
