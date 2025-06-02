package info.htoomaungthait.ems_backend.request;

import info.htoomaungthait.ems_backend.model.DepartmentStatus;
import jakarta.validation.constraints.NotBlank;

public class DepartmentRequest {

    @NotBlank
    private String name;


    private String description;


    private DepartmentStatus status;

    public DepartmentRequest(String name, String description, DepartmentStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }


    public @NotBlank(message = "Department name is required") String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DepartmentStatus getStatus() {
        return status;
    }

    public void setName(@NotBlank(message = "Department name is required") String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(DepartmentStatus status) {
        this.status = status;
    }
}
