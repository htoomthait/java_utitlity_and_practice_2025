package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.ProjectDto;
import info.htoomaungthait.ems_backend.service.ResponseService;
import info.htoomaungthait.ems_backend.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectResponseServiceImpl implements ResponseService<ProjectDto> {
    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> createdSuccess(String message, ProjectDto data) {
        return ResponseUtil.<ProjectDto>getInstance()
                .httpStatus(201)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> queriedSuccess(String message, ProjectDto data) {
        return ResponseUtil.<ProjectDto>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<Page<ProjectDto>>> queriedPageSuccess(String message, Page<ProjectDto> pageData) {
        return ResponseUtil.<Page<ProjectDto>>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(pageData)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> updatedSuccess(String message, ProjectDto data) {
        return ResponseUtil.<ProjectDto>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> deletedSuccess(String message, ProjectDto data) {
        return ResponseUtil.<ProjectDto>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(data)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> resourceEmpty(String message) {
        return ResponseUtil.<ProjectDto>getInstance()
                .httpStatus(200)
                .statusCode(204)
                .status("empty")
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> resourceNotFound(String message) {
        return ResponseUtil.<ProjectDto>getInstance()
                .httpStatus(404)
                .statusCode(404)
                .status("not found")
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> resourceConflict(String message) {
        return ResponseUtil.<ProjectDto>getInstance()
                .httpStatus(200)
                .statusCode(200)
                .status("success")
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> requestInvalid(String message) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> promptError(String message) {
        return ResponseUtil.<ProjectDto>getInstance()
                .httpStatus(500)
                .statusCode(500)
                .status("error")
                .message(message)
                .data(null)
                .build();
    }

    @Override
    public ResponseEntity<ApiResponseV2<Page<ProjectDto>>> promptErrorPage(String message) {
        return ResponseUtil.<Page<ProjectDto>>getInstance()
                .httpStatus(500)
                .statusCode(500)
                .status("error")
                .message(message)
                .data(null)
                .build();
    }
}
