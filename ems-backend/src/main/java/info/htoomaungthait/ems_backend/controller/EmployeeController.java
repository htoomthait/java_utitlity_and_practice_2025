package info.htoomaungthait.ems_backend.controller;

import info.htoomaungthait.ems_backend.dto.ApiResponse;
import info.htoomaungthait.ems_backend.dto.EmployeeDto;
import info.htoomaungthait.ems_backend.entity.Employee;
import info.htoomaungthait.ems_backend.request.EmployeeRequest;
import info.htoomaungthait.ems_backend.service.EmployeeService;
import info.htoomaungthait.ems_backend.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public  EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // Build add employee REST API

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeDto>> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){

        EmployeeDto savedEmployee =  this.employeeService.createEmployee(employeeRequest);

        return ResponseUtil.success(savedEmployee);
    }

    // Build get employee REST API
    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<EmployeeDto>> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDtoById = this.employeeService.getEmployeeById(employeeId);

        return ResponseUtil.success(employeeDtoById);
    }


    // Build get all employees REST API
    @GetMapping
    public ResponseEntity<ApiResponse<Page<EmployeeDto>>> getAllEmployee(Pageable pageable){
        Page<EmployeeDto> employees = this.employeeService.getAllEmployees(pageable);

        return ResponseUtil.success(employees);
    }

    // Build update employee REST API
    @PutMapping("{id}")
    public  ResponseEntity<ApiResponse<EmployeeDto>> updateEmployeeById(
            @PathVariable("id") Long employeeId,
            @RequestBody EmployeeDto updatedEmployee){

        EmployeeDto dbUpdatedEmployee = employeeService.updateEmployeeById(employeeId, updatedEmployee);

        return ResponseUtil.success(dbUpdatedEmployee);
    }


    // Build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<String>> deleteEmployeeById(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);


        return ResponseUtil.success("Employee with Id " + employeeId + " has been deleted successfully!");
    }


}
