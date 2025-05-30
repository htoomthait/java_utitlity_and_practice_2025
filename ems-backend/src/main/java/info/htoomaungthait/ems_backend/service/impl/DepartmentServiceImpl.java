package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.exception.ResourceNotFoundException;
import info.htoomaungthait.ems_backend.mapper.DepartmentMapper;
import info.htoomaungthait.ems_backend.model.Department;
import info.htoomaungthait.ems_backend.repository.DepartmentRepository;
import info.htoomaungthait.ems_backend.request.DepartmentRequest;
import info.htoomaungthait.ems_backend.service.DepartmentService;
import info.htoomaungthait.ems_backend.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ResponseService<DepartmentDto> responseService;
    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ResponseService<DepartmentDto> responseService) {
        this.departmentRepository = departmentRepository;
        this.responseService = responseService;
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


}
