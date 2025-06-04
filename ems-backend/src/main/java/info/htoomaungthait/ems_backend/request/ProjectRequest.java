package info.htoomaungthait.ems_backend.request;

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

    private String category;

    @NotBlank(message = "Project category cannot be blank!")
    private String status;


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

    public String getCategory() {
        return category;
    }

    public @NotBlank(message = "Project category cannot be blank!") String getStatus() {
        return status;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStatus(@NotBlank(message = "Project category cannot be blank!") String status) {
        this.status = status;
    }
}
