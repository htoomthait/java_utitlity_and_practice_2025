package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.dto.DepartmentEmployeeCountDto;
import info.htoomaungthait.ems_backend.dto.DepartmentWithEmployeeTaxedSalaryDto;
import info.htoomaungthait.ems_backend.exception.ResourceNotFoundException;
import info.htoomaungthait.ems_backend.mapper.DepartmentMapper;
import info.htoomaungthait.ems_backend.model.Department;
import info.htoomaungthait.ems_backend.repository.DepartmentRepository;
import info.htoomaungthait.ems_backend.repository.DepartmentRepositoryCustomImpl;
import info.htoomaungthait.ems_backend.request.DepartmentRequest;
import info.htoomaungthait.ems_backend.service.DepartmentService;
import info.htoomaungthait.ems_backend.service.ResponseService;
import info.htoomaungthait.ems_backend.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentRepositoryCustomImpl departmentRepositoryCustom;
    private final DepartmentResponseServiceImpl responseService;
    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    public DepartmentServiceImpl(
            DepartmentRepository departmentRepository,
            DepartmentResponseServiceImpl responseService,
            DepartmentRepositoryCustomImpl departmentRepositoryCustom) {
        this.departmentRepository = departmentRepository;
        this.responseService = responseService;
        this.departmentRepositoryCustom = departmentRepositoryCustom;
    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> createDepartment(DepartmentRequest departmentRequest) {
        Department departmentToCreate = DepartmentMapper.mapRequestToDepartment(departmentRequest);
        Department createdDepartment = new Department();

        try {
            createdDepartment = this.departmentRepository.save(departmentToCreate);
        } catch (Exception e) {
            String errorMessage = "Could not create department properly! ";
            logger.error(errorMessage + "Check detail => {}", e.getMessage());

            return this.responseService.promptError(errorMessage);
        }

        return this.responseService.createdSuccess(
                "Your department has been created successfully!",
                DepartmentMapper.mapToDepartmentDto(createdDepartment)
        );
    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> getDepartmentById(Long id) {
        try {
            Department department = this.departmentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with given id " + id));

            return this.responseService.queriedSuccess(
                    "Department with ID: " + id + " has been queried successfully!",
                    DepartmentMapper.mapToDepartmentDto(department)
            );

        } catch (ResourceNotFoundException ex) {
            logger.warn(ex.getMessage());
            return this.responseService.resourceNotFound(ex.getMessage());

        } catch (Exception e) {
            String errorMessage = "Could not fetch department by ID: " + id;
            logger.error("{}! Check detail => {}", errorMessage, e.getMessage());
            return this.responseService.promptError(errorMessage);
        }
    }

    @Override
    public ResponseEntity<ApiResponseV2<Page<DepartmentDto>>> getAllDepartment(Pageable pageable) {
        Page<Department> departments = null;

        try {
            departments = this.departmentRepository.findAll(pageable);

        } catch (Exception e) {
            String errorMessage = "Could not query department pagination list";
            logger.error("{}! Check detail => {}", errorMessage, e.getMessage());
            return this.responseService.promptErrorPage(errorMessage);
        }


        return this.responseService.queriedPageSuccess("",
                departments.map(DepartmentMapper::mapToDepartmentDto)
        );
    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> updateDepartmentById(Long id, DepartmentRequest updatedDepartment) {
        Department department;
        Department updatedDataToReturn;

        try {
            department = this.departmentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found for given department id: " + id));

            department.setName(updatedDepartment.getName());
            department.setDescription(updatedDepartment.getDescription());
            department.setStatus((updatedDepartment.getStatus()));

            updatedDataToReturn = this.departmentRepository.save(department);

            return this.responseService.queriedSuccess(
                    "Department with ID: " + id + " has been updated successfully!",
                    DepartmentMapper.mapToDepartmentDto(updatedDataToReturn)
            );
        } catch (ResourceNotFoundException ex) {
            logger.warn(ex.getMessage());
            return this.responseService.resourceNotFound(ex.getMessage());

        } catch (Exception e) {
            String errorMessage = "Could not fetch department by ID: " + id;
            logger.error("{}! Check detail => {}", errorMessage, e.getMessage());
            return this.responseService.promptError(errorMessage);
        }


    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> deleteDepartmentById(Long id) {
        try {
            Department department = this.departmentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found for given department id: " + id));
            this.departmentRepository.deleteById(id);

            return this.responseService.deletedSuccess("Department with ID: " + id + " has been deleted successfully!",
                    DepartmentMapper.mapToDepartmentDto(department)
            );
        } catch (ResourceNotFoundException ex) {
            logger.warn(ex.getMessage());
            return this.responseService.resourceNotFound(ex.getMessage());

        } catch (Exception e) {
            String errorMessage = "Department with ID: " + id + "cannot be deleted";
            logger.error("{}! Check detail => {}", errorMessage, e.getMessage());
            return this.responseService.promptError(errorMessage);
        }


    }

    @Override
    public ResponseEntity<ApiResponseV2<List<DepartmentEmployeeCountDto>>> getDepartmentEmployeeCountDto() {
        try{
//            List<DepartmentEmployeeCountDto> departmentData = this.departmentRepositoryCustom.getDepartmentWithCounts(); // this is working version too
            List<DepartmentEmployeeCountDto> departmentData =  this.departmentRepository.getDepartmentsWithEmployeeCount();

            return this.responseService
                    .successQueryWithEmpCount("Your departments with employee count list has been queried successfully",
                            departmentData
                    );
        } catch (Exception e) {
            String errorMessage = "Could not query the department list with employee count!";
            logger.error("{} Check detail => {}", errorMessage, e.getMessage());

            return ResponseUtil.<List<DepartmentEmployeeCountDto>>getInstance()
                    .httpStatus(503).statusCode(503).status("success").message(errorMessage).data(null)
                    .build();
        }


    }

    @Override
    public ResponseEntity<ApiResponseV2<List<DepartmentWithEmployeeTaxedSalaryDto>>> getDepartmentWithTaxedEmployeeSalaries() {
        try{

            List<DepartmentWithEmployeeTaxedSalaryDto> rawData = this.departmentRepositoryCustom.getDepartmentWithEmployeeCountAndSalariesTotal();



            List<DepartmentWithEmployeeTaxedSalaryDto> taxedData = rawData.stream().map(DepartmentServiceImpl::calculateTaxedAmountOfGivenSalary)
                    .toList();

            return ResponseUtil.<List<DepartmentWithEmployeeTaxedSalaryDto>>getInstance()
                    .httpStatus(200).statusCode(200).status("success").message("")
                    .data(taxedData)
                    .build();

        } catch (Exception e) {
            String errorMessage = "Could not query the department list with employee tax salaries!";
            logger.error("{} Check detail => {}", errorMessage, e.getMessage());

            return ResponseUtil.<List<DepartmentWithEmployeeTaxedSalaryDto>>getInstance()
                    .httpStatus(503).statusCode(503).status("success").message(errorMessage).data(null)
                    .build();
        }
    }

    private static DepartmentWithEmployeeTaxedSalaryDto calculateTaxedAmountOfGivenSalary(DepartmentWithEmployeeTaxedSalaryDto department){
        double taxPercentage = 5.0; // 5% taxed
        double taxPercentageToCal = taxPercentage / 100;
        double totalSalary = department.getSalaryTotal();
        double taxedAmount = totalSalary * taxPercentageToCal;
        double totalTaxedSalary = totalSalary - taxedAmount;

        return new DepartmentWithEmployeeTaxedSalaryDto(
                department.getId(),
                department.getName(),
                department.getEmployeeCount(),
                totalSalary,
                taxPercentage,
                totalTaxedSalary
        );

    }


}
