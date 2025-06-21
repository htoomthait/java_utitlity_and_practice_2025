package info.htoomaungthait.ems_backend.service.impl;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.ProjectDto;
import info.htoomaungthait.ems_backend.mapper.ProjectMapper;
import info.htoomaungthait.ems_backend.model.Project;
import info.htoomaungthait.ems_backend.repository.ProjectRepository;
import info.htoomaungthait.ems_backend.request.ProjectRequest;
import info.htoomaungthait.ems_backend.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
    private final ProjectRepository projectRepository;
    private final ProjectResponseServiceImpl projectResponseService;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectResponseServiceImpl projectResponseService){
        this.projectRepository = projectRepository;
        this.projectResponseService = projectResponseService;
    }

    @Override
    public ResponseEntity<ApiResponseV2<Page<ProjectDto>>> getAllPageableProject(Pageable pageable) {
        Page<Project> projects = null;
        try{

            projects = this.projectRepository.findAll(pageable);

        } catch (Exception e) {
            String errorMessage = "Could not query employee(s) properly! ";
            logger.error("{} Detail => {}", errorMessage, e.getMessage());
            this.projectResponseService.promptError(errorMessage);
        }
        return this.projectResponseService.queriedPageSuccess(
                "Projects have been queried!",
                projects.map(ProjectMapper::mapToProjectDto)
        );
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> getProjectById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> createProject(ProjectRequest projectRequest) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> updateProjectById(Long id, ProjectRequest projectRequest) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseV2<ProjectDto>> deleteProjectById(Long id) {
        return null;
    }
}
