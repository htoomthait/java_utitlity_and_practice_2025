package info.htoomaungthait.ems_backend.service;

import info.htoomaungthait.ems_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployeeById(Long  employeeId, EmployeeDto updatedEmployee);

    void deleteEmployeeById(Long employeeId);
}
