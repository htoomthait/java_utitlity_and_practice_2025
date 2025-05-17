package info.htoomaungthait.ems_backend.service;

import info.htoomaungthait.ems_backend.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    Page<EmployeeDto> getAllEmployees(Pageable pageable);

    EmployeeDto updateEmployeeById(Long  employeeId, EmployeeDto updatedEmployee);

    void deleteEmployeeById(Long employeeId);
}
