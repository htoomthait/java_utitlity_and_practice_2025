package info.htoomaungthait.ems_backend.controller;

import info.htoomaungthait.ems_backend.dto.EmployeeDto;
import info.htoomaungthait.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public  EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // Build add employee REST API

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee =  this.employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build get employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDtoById = this.employeeService.getEmployeeById(employeeId);

        return ResponseEntity.ok(employeeDtoById);
    }


    // Build get all employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employees = this.employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    // Build update employee REST API
    @PutMapping("{id}")
    public  ResponseEntity<EmployeeDto> updateEmployeeById(
            @PathVariable("id") Long employeeId,
            @RequestBody EmployeeDto updatedEmployee){

        EmployeeDto dbUpdatedEmployee = employeeService.updateEmployeeById(employeeId, updatedEmployee);

        return ResponseEntity.ok(dbUpdatedEmployee);
    }


    // Build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);

        return ResponseEntity.ok("Employee with Id " + employeeId + "has been deleted successfully!");
    }


}
