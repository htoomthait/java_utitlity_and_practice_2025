package info.htoomaungthait.ems_backend.data.seeder;

import com.github.javafaker.Faker;
import info.htoomaungthait.ems_backend.model.Employee;
import info.htoomaungthait.ems_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Component
public class EmployeeSeeder {

//    private final int numberOfEmployee;
    private final EmployeeRepository employeeRepository;

    private final Set<String> usedEmails = new HashSet<>();



    public EmployeeSeeder( EmployeeRepository employeeRepository){
//        this.numberOfEmployee = numberOfEmployee;
        this.employeeRepository = employeeRepository;


    }



    public void makeSeed(int numberOfEmployee){
        System.out.println("Employee seeding initiated!");
        final Faker faker = new Faker(new Locale("en"));

        for(int i = 1; i <= numberOfEmployee; i++){
            System.out.println("Employee " + i + " is added");
            Employee employee = new Employee();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(generateUniqueEmail(firstName, lastName));

            employeeRepository.save(employee);
        }

        System.out.println("Employee seeding done!");
    }

    private String generateUniqueEmail(String firstName, String lastName) {
        String email = (firstName + "." + lastName + "@example.com").toLowerCase();
        int suffix = 1;

        while (usedEmails.contains(email) || employeeRepository.existsByEmail(email)) {
            email = (firstName + "." + lastName + suffix + "@example.com").toLowerCase();
            suffix++;
        }

        usedEmails.add(email);
        return email;
    }
}
