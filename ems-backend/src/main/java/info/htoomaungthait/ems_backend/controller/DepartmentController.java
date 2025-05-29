package info.htoomaungthait.ems_backend.controller;

import info.htoomaungthait.ems_backend.dto.ApiResponse;
import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.request.DepartmentRequest;
import info.htoomaungthait.ems_backend.service.DepartmentService;
import info.htoomaungthait.ems_backend.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentDto>> createDepartment(@Valid @RequestBody DepartmentRequest departmentRequest){
        DepartmentDto departmentDto = this.departmentService.createDepartment(departmentRequest);

        return ResponseUtil.success(departmentDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseV2<DepartmentDto>> getDepartmentById(@PathVariable("id") Long id){
        DepartmentDto departmentDto = this.departmentService.getDepartmentById(id);

        return ResponseUtil.<DepartmentDto>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message("Department has been queried successfully")
                .data(departmentDto)
                .build();
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<Page<DepartmentDto>>> getAllDepartment(Pageable pageable){
        Page<DepartmentDto> departments = this.departmentService.getAllDepartment(pageable);

        return ResponseUtil.success(departments);
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<DepartmentDto>> updateDepartmentById(
            @PathVariable("id") Long id,
            @RequestBody DepartmentRequest departmentDataToUpdate
    ){
        DepartmentDto dbUpdatedEmployeeDto = this.departmentService.updateDepartmentById(id, departmentDataToUpdate);

        return ResponseUtil.success(dbUpdatedEmployeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<String>> deleteDepartmentById(@PathVariable Long id){

        Boolean status = this.departmentService.deleteDepartmentById(id);

        return ResponseUtil.success("Department with Id " + id + " has been deleted successfully");
    }


}
