package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.EmployeeDto;
import info.htoomaungthait.ems_backend.entity.Employee;
import info.htoomaungthait.ems_backend.exception.ResourceNotFoundException;
import info.htoomaungthait.ems_backend.mapper.EmployeeMapper;
import info.htoomaungthait.ems_backend.repository.EmployeeRepository;
import info.htoomaungthait.ems_backend.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee savedEmployee = null;
        try{
            Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
            savedEmployee = employeeRepository.save(employee);
        } catch (Exception e) {
            logger.error("Could not save employee properly! Detail => " + e.getMessage());
            throw new RuntimeException(e);
        }



        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with given id " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public Page<EmployeeDto> getAllEmployees(Pageable pageable) {

        Page<Employee> employees = employeeRepository.findAll(pageable);
        //        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
//                .collect(Collectors.toList());



        return employees.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given Id : "+ employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj =  employeeRepository.save(employee);



        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with given id " + employeeId));

        employeeRepository.delete(employee);
    }
}
