package info.htoomaungthait.ems_backend.dto;

public class DepartmentEmployeeCountDto {

    private Long id;
    private String name;
    private long employeeCount;



    public DepartmentEmployeeCountDto(Long id, String name, long employeeCount) {
        this.id = id;
        this.name = name;
        this.employeeCount = employeeCount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }
}
