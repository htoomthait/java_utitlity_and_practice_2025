package info.htoomaungthait.ems_backend.mapper;

import info.htoomaungthait.ems_backend.dto.EmployeeDto;
import info.htoomaungthait.ems_backend.entity.Employee;
import info.htoomaungthait.ems_backend.request.EmployeeRequest;

public class EmployeeMapper {
    public static  EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

    public static Employee mapRequestToEmployee(EmployeeRequest employeeRequest){
        return new Employee(
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmail()
        );
    }
}
