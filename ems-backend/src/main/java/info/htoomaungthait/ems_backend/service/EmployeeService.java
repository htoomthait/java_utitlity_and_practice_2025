package info.htoomaungthait.ems_backend.service;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.EmployeeDto;
import info.htoomaungthait.ems_backend.dto.EmployeeWithNetSalaryDto;
import info.htoomaungthait.ems_backend.request.EmployeeRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    ResponseEntity<ApiResponseV2<EmployeeDto>> createEmployee(EmployeeRequest employeeRequest);

    ResponseEntity<ApiResponseV2<EmployeeDto>> getEmployeeById(Long employeeId);

    ResponseEntity<ApiResponseV2<Page<EmployeeDto>>> getAllEmployees(Pageable pageable);

    ResponseEntity<ApiResponseV2<EmployeeDto>> updateEmployeeById(Long  employeeId, EmployeeDto updatedEmployee);

    ResponseEntity<ApiResponseV2<EmployeeDto>> deleteEmployeeById(Long employeeId);

    ResponseEntity<ApiResponseV2<EmployeeWithNetSalaryDto>> getEmployeeByIdWithNetSalary(Long employeeId);

    ResponseEntity<ApiResponseV2<List<EmployeeWithNetSalaryDto>>> getEmployeesWithNetSalary();

}
