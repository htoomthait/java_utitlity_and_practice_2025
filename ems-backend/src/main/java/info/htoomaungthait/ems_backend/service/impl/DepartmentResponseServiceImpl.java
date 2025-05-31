package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.dto.DepartmentEmployeeCountDto;
import info.htoomaungthait.ems_backend.service.ResponseService;
import info.htoomaungthait.ems_backend.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentResponseServiceImpl implements ResponseService<DepartmentDto> {

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> createdSuccess(String message, DepartmentDto data) {
        return ResponseUtil.<DepartmentDto>getInstance()
                .httpStatus(201)
                .statusCode(201)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> queriedSuccess(String message, DepartmentDto data) {
        return ResponseUtil.<DepartmentDto>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<Page<DepartmentDto>>> queriedPageSuccess(String message, Page<DepartmentDto> pageData) {
        return ResponseUtil.<Page<DepartmentDto>>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(pageData)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> updatedSuccess(String message, DepartmentDto data) {
        return ResponseUtil.<DepartmentDto>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> deletedSuccess(String message, DepartmentDto data) {
        return ResponseUtil.<DepartmentDto>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> resourceEmpty(String message) {
        return ResponseUtil.<DepartmentDto>getInstance()
                .httpStatus(200)
                .statusCode(204)
                .status("success")
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> resourceNotFound(String message) {
        return ResponseUtil.<DepartmentDto>getInstance()
                .httpStatus(404)
                .statusCode(404)
                .status("not found")
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> resourceConflict(String message) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> requestInvalid(String message) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseV2<DepartmentDto>> promptError(String message) {
        return ResponseUtil.<DepartmentDto>getInstance()
                .httpStatus(500)
                .statusCode(500)
                .status("error")
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<Page<DepartmentDto>>> promptErrorPage(String message) {
        return ResponseUtil.<Page<DepartmentDto>>getInstance()
                .httpStatus(500)
                .statusCode(500)
                .status("error")
                .message(message)
                .data(null)
                .build();
    }

    public ResponseEntity<ApiResponseV2<List<DepartmentEmployeeCountDto>>>  successQueryWithEmpCount(String message, List<DepartmentEmployeeCountDto> data){
        return ResponseUtil.<List<DepartmentEmployeeCountDto>>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }
}
