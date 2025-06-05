package info.htoomaungthait.ems_backend.dto;

import info.htoomaungthait.ems_backend.model.Employee;
import info.htoomaungthait.ems_backend.model.ProjectAssignment;
import info.htoomaungthait.ems_backend.model.ProjectCategory;
import info.htoomaungthait.ems_backend.model.ProjectStatus;

import java.time.LocalDate;
import java.util.Set;

public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double duration;
    private ProjectCategory category;
    private ProjectStatus status;
    private Employee projectManager;
    private Set<ProjectAssignment> assignments;

    public ProjectDto(Long id, String name, String description, LocalDate startDate, LocalDate endDate, double duration, ProjectCategory category, ProjectStatus status, Employee projectManager, Set<ProjectAssignment> assignments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
        this.category = category;
        this.status = status;
        this.projectManager = projectManager;
        this.assignments = assignments;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
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

    public ProjectStatus getStatus() {
        return status;
    }

    public Employee getProjectManager() {
        return projectManager;
    }

    public Set<ProjectAssignment> getAssignments() {
        return assignments;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
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

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }

    public void setAssignments(Set<ProjectAssignment> assignments) {
        this.assignments = assignments;
    }
}
