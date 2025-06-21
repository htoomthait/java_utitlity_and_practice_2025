package info.htoomaungthait.ems_backend.controller;

import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import info.htoomaungthait.ems_backend.dto.ProjectDto;
import info.htoomaungthait.ems_backend.request.ProjectRequest;
import info.htoomaungthait.ems_backend.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
         this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<ApiResponseV2<Page<ProjectDto>>> getAllProject(Pageable pageable){

        return this.projectService.getAllPageableProject(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseV2<ProjectDto>> getProjectById(@PathVariable("id") Long id){

        return this.projectService.getProjectById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponseV2<ProjectDto>> createProject(@Valid @RequestBody ProjectRequest projectRequest){

        return this.projectService.createProject(projectRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseV2<ProjectDto>> updateProjectById(
            @PathVariable("id") Long id,
            @Valid @RequestBody ProjectRequest projectRequest){
        return this.projectService.updateProjectById(id, projectRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseV2<ProjectDto>> deleteProjectById(@PathVariable("id") Long id){

        return this.projectService.deleteProjectById(id);
    }
}
