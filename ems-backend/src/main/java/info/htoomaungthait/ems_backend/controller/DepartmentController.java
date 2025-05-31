package info.htoomaungthait.ems_backend.controller;

import info.htoomaungthait.ems_backend.dto.ApiResponse;
import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.dto.DepartmentEmployeeCountDto;
import info.htoomaungthait.ems_backend.request.DepartmentRequest;
import info.htoomaungthait.ems_backend.service.DepartmentService;
import info.htoomaungthait.ems_backend.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseV2<DepartmentDto>> createDepartment(@Valid @RequestBody DepartmentRequest departmentRequest) {

        return this.departmentService.createDepartment(departmentRequest);

    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseV2<DepartmentDto>> getDepartmentById(@PathVariable("id") Long id) {

        return this.departmentService.getDepartmentById(id);

    }

    @GetMapping()
    public ResponseEntity<ApiResponseV2<Page<DepartmentDto>>> getAllDepartment(Pageable pageable) {

        return this.departmentService.getAllDepartment(pageable);


    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponseV2<DepartmentDto>> updateDepartmentById(
            @PathVariable("id") Long id,
            @RequestBody DepartmentRequest departmentDataToUpdate
    ) {
        return this.departmentService.updateDepartmentById(id, departmentDataToUpdate);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponseV2<DepartmentDto>> deleteDepartmentById(@PathVariable Long id) {

        return this.departmentService.deleteDepartmentById(id);


    }

    @GetMapping("get-with-employee-count")
    public ResponseEntity<ApiResponseV2<List<DepartmentEmployeeCountDto>>> getDepartmentWithEmployeeCount(){
        return this.departmentService.getDepartmentEmployeeCountDto();
    }


}
