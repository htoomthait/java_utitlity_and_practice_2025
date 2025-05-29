package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.exception.ResourceNotFoundException;
import info.htoomaungthait.ems_backend.mapper.DepartmentMapper;
import info.htoomaungthait.ems_backend.mapper.EmployeeMapper;
import info.htoomaungthait.ems_backend.model.Department;
import info.htoomaungthait.ems_backend.repository.DepartmentRepository;
import info.htoomaungthait.ems_backend.request.DepartmentRequest;
import info.htoomaungthait.ems_backend.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentRequest departmentRequest) {
        Department departmentToCreate = DepartmentMapper.mapRequestToDepartment(departmentRequest);
        Department createdDepartment = null;

        try{
            createdDepartment = this.departmentRepository.save(departmentToCreate);
        } catch (Exception e) {
            logger.error("Could not create department properly! Check detail => {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return DepartmentMapper.mapToDepartmentDto(createdDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = null;
        try{
            department = this.departmentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Department does not exist with given id " + id));
        } catch (Exception e) {
            logger.error("Could find department by Id! Check detail => {}",e.getMessage());
            throw new RuntimeException(e);
        }
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public Page<DepartmentDto> getAllDepartment(Pageable pageable) {
        Page<Department> departments = null;

        try{
            departments = this.departmentRepository.findAll(pageable);

        }catch(Exception e){
            logger.error("Department list could not be queried! Check detail => {}", e.getMessage());
            throw new RuntimeException(e);
        }

        if (departments == null) {
            throw new AssertionError("Department list is empty");
        }
        return departments.map(DepartmentMapper::mapToDepartmentDto);
    }

    @Override
    public DepartmentDto updateDepartmentById(Long id, DepartmentRequest updatedDepartment) {
        Department department;
        Department updatedDataToReturn;

        try{
            department = this.departmentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found for given department id: " + id));

            department.setName(updatedDepartment.getName());
            department.setDescription(updatedDepartment.getDescription());
            department.setStatus((updatedDepartment.getStatus()));

            updatedDataToReturn = this.departmentRepository.save(department);
        } catch (Exception e) {
            logger.error("Could not update for given department with Id: " + id);
            throw new RuntimeException(e);
        }


        return DepartmentMapper.mapToDepartmentDto(updatedDataToReturn);
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        try{
            this.departmentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found for given department id: " + id));
            this.departmentRepository.deleteById(id);
        }catch (Exception e){
            logger.error("Could not delete the department with Id : " + id + "!");
            throw new RuntimeException(e);
        }

        return true;
    }
}
