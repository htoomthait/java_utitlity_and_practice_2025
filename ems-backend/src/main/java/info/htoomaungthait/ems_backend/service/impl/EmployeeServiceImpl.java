package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.EmployeeDto;
import info.htoomaungthait.ems_backend.model.Department;
import info.htoomaungthait.ems_backend.model.Employee;
import info.htoomaungthait.ems_backend.exception.ResourceNotFoundException;
import info.htoomaungthait.ems_backend.mapper.EmployeeMapper;
import info.htoomaungthait.ems_backend.repository.DepartmentRepository;
import info.htoomaungthait.ems_backend.repository.EmployeeRepository;
import info.htoomaungthait.ems_backend.request.EmployeeRequest;
import info.htoomaungthait.ems_backend.service.EmployeeService;
import info.htoomaungthait.ems_backend.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeResponseServiceImpl responseService;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository,
            EmployeeResponseServiceImpl responseService){
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.responseService = responseService;
    }


    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> createEmployee(EmployeeRequest employeeRequest) {
        Employee savedEmployee = null;
        try{
            Department department = departmentRepository.findById(employeeRequest.getDepartment())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found for given department Id"));

            Employee employee = EmployeeMapper.mapRequestToEmployee(employeeRequest, department);

            if(employeeRepository.existsByEmail(employee.getEmail())){
                return this.responseService.resourceConflict("Email already existed!");
            }

            savedEmployee = employeeRepository.save(employee);




        } catch (ResourceNotFoundException e) {
            logger.warn(e.getMessage());
            return this.responseService.resourceNotFound(e.getMessage());
        }
        catch (Exception e) {
            String errorMessage = "Could not save employee properly! ";
            logger.error("{} Detail => {}", errorMessage, e.getMessage());
            return this.responseService.promptError(errorMessage);
        }



//        logger.info("saved employee with department ID: {}", savedEmployee.getDepartment().getId());
        return this.responseService.createdSuccess(
                "Your employee has been created successfully!",
                EmployeeMapper.mapToEmployeeDto(savedEmployee));
    }

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> getEmployeeById(Long employeeId) {
        Employee employee = null;
        try {
            employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id " + employeeId));

        }catch(ResourceNotFoundException e){
            logger.warn(e.getMessage());
            return this.responseService.resourceNotFound(e.getMessage());
        }catch (Exception e) {
            String errorMessage = "Could not query employee properly for given ID: " + employeeId + "!";
            logger.error("{} Detail => {}", errorMessage, e.getMessage());
            return this.responseService.promptError(errorMessage);
        }


        return this.responseService.queriedSuccess("Your employee with ID: " + employeeId + " has been queried successfully!",
                EmployeeMapper.mapToEmployeeDto(employee)
        );

    }

    @Override
    public ResponseEntity<ApiResponseV2<Page<EmployeeDto>>> getAllEmployees(Pageable pageable) {
        Page<Employee> employees = null;
        try{
            employees = employeeRepository.findAll(pageable);
        } catch (Exception e) {
            String errorMessage = "Could not query employee(s) properly! ";
            logger.error("{} Detail => {}", errorMessage, e.getMessage());
            return this.responseService.promptErrorPage(errorMessage);
        }





        return this.responseService.queriedPageSuccess("Employee(s) have been queried successfully!",
                employees.map(EmployeeMapper::mapToEmployeeDto)
        );
    }

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> updateEmployeeById(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee;
        try{
            employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given Id : "+ employeeId));

            // Check for unique email violation
            if (employeeRepository.existsByEmail(updatedEmployee.getEmail()) &&
                    !employee.getEmail().equals(updatedEmployee.getEmail())) {
                return this.responseService.resourceConflict("Email already exists!");
            }

            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setSalary(updatedEmployee.getSalary());

            Employee updatedEmployeeObj =  employeeRepository.save(employee);


            return this.responseService.updatedSuccess("Your employee with ID " + employeeId + " has been updated successfully!",
                    EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj)
            );

        }catch(ResourceNotFoundException e){
            logger.warn(e.getMessage());
            return this.responseService.resourceNotFound(e.getMessage());
        }catch (Exception e) {
            String errorMessage = "Could not update employee properly for given ID: " + employeeId + "!";
            logger.error("{} Detail => {}", errorMessage, e.getMessage());
            return this.responseService.promptError(errorMessage);
        }



    }

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> deleteEmployeeById(Long employeeId) {
        Employee employee;
        try{
            employee = employeeRepository.findById(employeeId)
                    .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with given id " + employeeId));

            employeeRepository.delete(employee);

            return this.responseService
                    .deletedSuccess("Employee with ID: "+ employeeId + " has been deleted successfully!",
                            EmployeeMapper.mapToEmployeeDto(employee)
                    );

        } catch(ResourceNotFoundException e){
            logger.warn(e.getMessage());
            return this.responseService.resourceNotFound(e.getMessage());
        }catch (Exception e) {
            String errorMessage = "Could not update employee properly for given ID: " + employeeId + "!";
            logger.error("{} Detail => {}", errorMessage, e.getMessage());
            return this.responseService.promptError(errorMessage);
        }



    }
}
