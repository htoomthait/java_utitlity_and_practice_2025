package info.htoomaungthait.ems_backend.controller;

import info.htoomaungthait.ems_backend.dto.ApiResponse;
import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.EmployeeDto;
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
    public ResponseEntity<ApiResponseV2<EmployeeDto>> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){

        return this.employeeService.createEmployee(employeeRequest);


    }

    // Build get employee REST API
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseV2<EmployeeDto>> getEmployeeById(@PathVariable("id") Long employeeId){

        return this.employeeService.getEmployeeById(employeeId);


    }


    // Build get all employees REST API
    @GetMapping
    public ResponseEntity<ApiResponseV2<Page<EmployeeDto>>> getAllEmployee(Pageable pageable){
        return this.employeeService.getAllEmployees(pageable);
    }

    // Build update employee REST API
    @PutMapping("{id}")
    public  ResponseEntity<ApiResponseV2<EmployeeDto>> updateEmployeeById(
            @PathVariable("id") Long employeeId,
            @RequestBody EmployeeDto updatedEmployee){

        return employeeService.updateEmployeeById(employeeId, updatedEmployee);


    }


    // Build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponseV2<EmployeeDto>> deleteEmployeeById(@PathVariable("id") Long employeeId){


        return employeeService.deleteEmployeeById(employeeId);



    }


}
