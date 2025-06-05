package info.htoomaungthait.ems_backend.mapper;

import info.htoomaungthait.ems_backend.dto.ProjectDto;
import info.htoomaungthait.ems_backend.model.Project;
import info.htoomaungthait.ems_backend.model.ProjectCategory;
import info.htoomaungthait.ems_backend.request.ProjectRequest;

public class ProjectMapper {

    public static ProjectDto mapToProjectDto(Project project){
        return new ProjectDto(
                    project.getId(),
                    project.getName(),
                    project.getDescription(),
                    project.getStartDate(),
                    project.getEndDate(),
                    project.getDuration(),
                    project.getCategory(),
                    project.getStatus(),
                    project.getProjectManager(),
                    project.getAssignments()
                );

    }

    public static Project mapToProject(ProjectDto projectDto){

        return new Project(
                projectDto.getName(),
                projectDto.getDescription(),
                projectDto.getStartDate(),
                projectDto.getEndDate(),
                projectDto.getDuration(),
                projectDto.getCategory(),
                projectDto.getStatus(),
                projectDto.getProjectManager()
        );
    }

    public  static Project mapRequestToProject(ProjectRequest projectRequest){

        return new Project(
                projectRequest.getName(),
                projectRequest.getDescription(),
                projectRequest.getStartDate(),
                projectRequest.getEndDate(),
                projectRequest.getDuration(),
                projectRequest.getCategory(),
                projectRequest.getStatus()

        );
    }
}
