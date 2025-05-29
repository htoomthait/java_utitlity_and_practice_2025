package info.htoomaungthait.ems_backend.controller;

import info.htoomaungthait.ems_backend.dto.ApiResponse;
import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.request.DepartmentRequest;
import info.htoomaungthait.ems_backend.service.DepartmentService;
import info.htoomaungthait.ems_backend.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
