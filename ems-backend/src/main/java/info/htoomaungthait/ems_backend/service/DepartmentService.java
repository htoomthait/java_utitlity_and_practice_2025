package info.htoomaungthait.ems_backend.service;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.dto.DepartmentEmployeeCountDto;
import info.htoomaungthait.ems_backend.request.DepartmentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {

    ResponseEntity<ApiResponseV2<DepartmentDto>> createDepartment(DepartmentRequest departmentRequest);

    ResponseEntity<ApiResponseV2<DepartmentDto>> getDepartmentById(Long id);

    ResponseEntity<ApiResponseV2<Page<DepartmentDto>>> getAllDepartment(Pageable pageable);

    ResponseEntity<ApiResponseV2<DepartmentDto>> updateDepartmentById(Long id, DepartmentRequest updatedDepartment);

    ResponseEntity<ApiResponseV2<DepartmentDto>> deleteDepartmentById(Long id);

    ResponseEntity<ApiResponseV2<List<DepartmentEmployeeCountDto>>> getDepartmentEmployeeCountDto();
}
