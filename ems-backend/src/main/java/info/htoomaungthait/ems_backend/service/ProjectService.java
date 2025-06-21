package info.htoomaungthait.ems_backend.service;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.ProjectDto;
import info.htoomaungthait.ems_backend.request.ProjectRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ProjectService {

    ResponseEntity<ApiResponseV2<Page<ProjectDto>>> getAllPageableProject(Pageable pageable);

    ResponseEntity<ApiResponseV2<ProjectDto>> getProjectById(Long id);

    ResponseEntity<ApiResponseV2<ProjectDto>> createProject(ProjectRequest projectRequest);

    ResponseEntity<ApiResponseV2<ProjectDto>> updateProjectById(Long id, ProjectRequest projectRequest);

    ResponseEntity<ApiResponseV2<ProjectDto>> deleteProjectById(Long id);


}
