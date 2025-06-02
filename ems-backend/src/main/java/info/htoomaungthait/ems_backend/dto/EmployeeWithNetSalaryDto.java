package info.htoomaungthait.ems_backend.dto;

public class EmployeeWithNetSalaryDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
    private Long department;
    private double deduction;
    private double netSalary;

    public EmployeeWithNetSalaryDto(Long id, String firstName, String lastName, String email, double salary, Long department, double deduction, double netSalary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.deduction = deduction;
        this.netSalary = netSalary;
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public Long getDepartment() {
        return department;
    }

    public double getDeduction() {
        return deduction;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
}
