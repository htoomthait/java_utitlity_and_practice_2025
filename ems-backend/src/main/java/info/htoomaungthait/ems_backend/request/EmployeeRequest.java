package info.htoomaungthait.ems_backend.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmployeeRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    private double salary;


    private Long department;


    public void setFirstName(@NotBlank(message = "First name is required") String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NotBlank(message = "Last name is required") String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Invalid email format") String email) {
        this.email = email;
    }

    public @NotBlank(message = "First name is required") String getFirstName() {
        return firstName;
    }

    public @NotBlank(message = "Last name is required") String getLastName() {
        return lastName;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Invalid email format") String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Long getDepartment() {
        return department;
    }
}
