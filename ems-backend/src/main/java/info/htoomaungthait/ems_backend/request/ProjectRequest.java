package info.htoomaungthait.ems_backend.request;

import info.htoomaungthait.ems_backend.model.ProjectCategory;
import info.htoomaungthait.ems_backend.model.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ProjectRequest {

    @NotBlank(message = "Project name is required")
    private String name;

    @Size(max= 4096, message = "Description cannot be exceed 500 characters!")
    private String description;


    private LocalDate startDate;

    private LocalDate endDate;

    private double duration;

    private ProjectCategory category;

    @NotBlank(message = "Project category cannot be blank!")
    private ProjectStatus status;

    private Long projectManager;


    public @NotBlank(message = "Project name is required") String getName() {
        return name;
    }

    public @Size(max = 4096, message = "Description cannot be exceed 500 characters!") String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getDuration() {
        return duration;
    }

    public ProjectCategory getCategory() {
        return category;
    }

    public @NotBlank(message = "Project category cannot be blank!") ProjectStatus getStatus() {
        return status;
    }

    public Long getProjectManager() {
        return projectManager;
    }

    public void setName(@NotBlank(message = "Project name is required") String name) {
        this.name = name;
    }

    public void setDescription(@Size(max = 4096, message = "Description cannot be exceed 500 characters!") String description) {
        this.description = description;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setCategory(ProjectCategory category) {
        this.category = category;
    }

    public void setStatus(@NotBlank(message = "Project category cannot be blank!") ProjectStatus status) {
        this.status = status;
    }

    public void setProjectManager(Long projectManager) {
        this.projectManager = projectManager;
    }
}
