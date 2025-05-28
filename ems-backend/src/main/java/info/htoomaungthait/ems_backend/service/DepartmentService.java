package info.htoomaungthait.ems_backend.service;

import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.request.DepartmentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentRequest departmentRequest);

    DepartmentDto getDepartmentById(Long id);

    Page<DepartmentDto> getAllDepartment(Pageable pageable);

    DepartmentDto updateDepartmentById(Long id, DepartmentRequest updatedDepartment);

    boolean deleteDepartmentById(Long id);
}
