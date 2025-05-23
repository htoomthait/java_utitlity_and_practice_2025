package info.htoomaungthait.ems_backend.shell.command;


import info.htoomaungthait.ems_backend.data.seeder.EmployeeSeeder;
import info.htoomaungthait.ems_backend.repository.EmployeeRepository;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@ShellCommandGroup("Database Seeder Commands")
public class DataSeeder {
    private final EmployeeRepository employeeRepository;

    public DataSeeder(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @ShellMethod(value = "Make data seed", key="seed")
    public void makeDbSeeding(){
            System.out.println("Data seeding initiated");

            EmployeeSeeder employeeSeeder = new EmployeeSeeder(this.employeeRepository);

            employeeSeeder.makeSeed(30);

            System.out.println("Data seeding done.");
    }


}
