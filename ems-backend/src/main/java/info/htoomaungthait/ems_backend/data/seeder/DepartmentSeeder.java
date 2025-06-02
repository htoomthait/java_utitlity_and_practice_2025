package info.htoomaungthait.ems_backend.data.seeder;

import info.htoomaungthait.ems_backend.model.Department;
import info.htoomaungthait.ems_backend.model.DepartmentStatus;
import info.htoomaungthait.ems_backend.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;

public class DepartmentSeeder {

    private final DepartmentRepository departmentRepository;

    public DepartmentSeeder(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public void makeSeed(){
        System.out.println("Department seeding initiated!");

        this.getDepartmentData().forEach(departmentRepository::save);


        System.out.println("Department seeding done!");
    }


    private List<Department> getDepartmentData(){
        List<Department> departments = new ArrayList<>();

        departments.add(new Department("Admin", "To provide administration to overall organization.", DepartmentStatus.ACTIVE));
        departments.add(new Department("HR", "To provide human resource service for organisation.", DepartmentStatus.ACTIVE));
        departments.add(new Department("Finance", "To manage cash flow, budget and allocation", DepartmentStatus.ACTIVE));
        departments.add(new Department("Production", "To produce good and product",DepartmentStatus.ACTIVE));
        departments.add(new Department("Marketing", "To do marketing", DepartmentStatus.ACTIVE));
        departments.add(new Department("Sale", "To make sale",DepartmentStatus.ACTIVE));
        departments.add(new Department("Service", "To provide service.",DepartmentStatus.ACTIVE));
        departments.add(new Department("Logistic", "To transportation of good, service and persons", DepartmentStatus.INACTIVE));
        departments.add(new Department("Research and Development", "To make research and development", DepartmentStatus.HIATUS));
        departments.add(new Department("Legal", "To provide legal advices and solve legal problems", DepartmentStatus.ACTIVE));



        return departments;
    }
}
