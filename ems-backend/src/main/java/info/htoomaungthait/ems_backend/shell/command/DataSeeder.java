package info.htoomaungthait.ems_backend.shell.command;


import info.htoomaungthait.ems_backend.data.seeder.DepartmentSeeder;
import info.htoomaungthait.ems_backend.data.seeder.EmployeeSeeder;
import info.htoomaungthait.ems_backend.repository.DepartmentRepository;
import info.htoomaungthait.ems_backend.repository.EmployeeRepository;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@ShellCommandGroup("Database Seeder Commands")
public class DataSeeder {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public DataSeeder(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository){
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @ShellMethod(value = "Make data seed", key="seed")
    public void makeDbSeeding(){
            System.out.println("Data seeding initiated");

            EmployeeSeeder employeeSeeder = new EmployeeSeeder(this.employeeRepository);
            DepartmentSeeder departmentSeeder = new DepartmentSeeder(this.departmentRepository);

//            employeeSeeder.makeSeed(30);
            departmentSeeder.makeSeed();

            System.out.println("Data seeding done.");
    }


}
