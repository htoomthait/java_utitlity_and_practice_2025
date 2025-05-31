package info.htoomaungthait.ems_backend.mapper;

import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.dto.EmployeeDto;
import info.htoomaungthait.ems_backend.model.Department;
import info.htoomaungthait.ems_backend.model.Employee;
import info.htoomaungthait.ems_backend.request.EmployeeRequest;
import info.htoomaungthait.ems_backend.service.impl.EmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeMapper {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeMapper.class);
    public static  EmployeeDto mapToEmployeeDto(Employee employee){

        Long departmentId = (employee.getDepartment() != null) ? employee.getDepartment().getId() : null;

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getSalary(),
                departmentId
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto, Department department){
        Employee employee = new Employee(
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getSalary()
        );
        employee.setDepartment(department); // associate department
        return employee;
    }

    public static Employee mapRequestToEmployee(EmployeeRequest employeeRequest, Department department){
        Employee employee = new Employee(
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmail(),
                employeeRequest.getSalary()
        );
        employee.setDepartment(department); // associate department
        return employee;
    }
}
