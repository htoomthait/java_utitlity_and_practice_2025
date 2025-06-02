package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.DepartmentDto;
import info.htoomaungthait.ems_backend.dto.EmployeeDto;
import info.htoomaungthait.ems_backend.model.Employee;
import info.htoomaungthait.ems_backend.service.ResponseService;
import info.htoomaungthait.ems_backend.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeResponseServiceImpl implements ResponseService<EmployeeDto> {

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> createdSuccess(String message, EmployeeDto data) {
        return ResponseUtil.<EmployeeDto>getInstance()
                .httpStatus(201)
                .statusCode(201)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> queriedSuccess(String message, EmployeeDto data) {
        return ResponseUtil.<EmployeeDto>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<Page<EmployeeDto>>> queriedPageSuccess(String message, Page<EmployeeDto> pageData) {
        return ResponseUtil.<Page<EmployeeDto>>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(pageData)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> updatedSuccess(String message, EmployeeDto data) {
        return ResponseUtil.<EmployeeDto>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> deletedSuccess(String message, EmployeeDto data) {
        return ResponseUtil.<EmployeeDto>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> resourceEmpty(String message) {
        return ResponseUtil.<EmployeeDto>getInstance()
                .httpStatus(200)
                .statusCode(204)
                .status("success")
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> resourceNotFound(String message) {
        return ResponseUtil.<EmployeeDto>getInstance()
                .httpStatus(404)
                .statusCode(404)
                .status("not found")
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> resourceConflict(String message) {
        return ResponseUtil.<EmployeeDto>getInstance()
                .httpStatus(409)
                .statusCode(409)
                .status("duplicate")
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> requestInvalid(String message) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseV2<EmployeeDto>> promptError(String message) {
        return ResponseUtil.<EmployeeDto>getInstance()
                .httpStatus(500)
                .statusCode(500)
                .status("error")
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<Page<EmployeeDto>>> promptErrorPage(String message) {
        return ResponseUtil.<Page<EmployeeDto>>getInstance()
                .httpStatus(500)
                .statusCode(500)
                .status("error")
                .message(message)
                .data(null)
                .build();
    }

    public ResponseEntity<ApiResponseV2<String>> anyStringResp(String message){
        return ResponseUtil.<String>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("error")
                .message(message)
                .data(null)
                .build();
    }
}
