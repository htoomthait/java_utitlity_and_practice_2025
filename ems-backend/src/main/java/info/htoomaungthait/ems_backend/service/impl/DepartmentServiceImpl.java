package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.mapper.DepartmentMapper;
import info.htoomaungthait.ems_backend.model.Department;
import info.htoomaungthait.ems_backend.repository.DepartmentRepository;
import info.htoomaungthait.ems_backend.request.DepartmentRequest;
import info.htoomaungthait.ems_backend.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
            logger.error("Could not create department properly! Detail! => {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return DepartmentMapper.mapToDepartmentDto(createdDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        return null;
    }

    @Override
    public Page<DepartmentDto> getAllDepartment(Pageable pageable) {
        return null;
    }

    @Override
    public DepartmentDto updateDepartmentById(Long id, DepartmentRequest updatedDepartment) {
        return null;
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        return false;
    }
}
