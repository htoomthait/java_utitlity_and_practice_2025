package info.htoomaungthait.ems_backend.dto;

import info.htoomaungthait.ems_backend.model.DepartmentStatus;

public class DepartmentDto {

    private Long id;
    private String name;
    private String description;
    private DepartmentStatus status;

    public DepartmentDto(Long id, String name, String description, DepartmentStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
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

    public DepartmentStatus getStatus() {
        return status;
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

    public void setStatus(DepartmentStatus status) {
        this.status = status;
    }
}
