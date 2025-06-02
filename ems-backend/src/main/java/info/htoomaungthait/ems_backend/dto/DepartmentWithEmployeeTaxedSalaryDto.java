package info.htoomaungthait.ems_backend.dto;

public class DepartmentWithEmployeeTaxedSalaryDto {
    private Long id;
    private String name;
    private long employeeCount;
    private double salaryTotal;
    private double taxPercentage;
    private double taxedSalaryTotal;

    public DepartmentWithEmployeeTaxedSalaryDto(Long id, String name, long employeeCount, double salaryTotal, double taxPercentage, double taxedSalaryTotal) {
        this.id = id;
        this.name = name;
        this.employeeCount = employeeCount;
        this.salaryTotal = salaryTotal;
        this.taxPercentage = taxPercentage;
        this.taxedSalaryTotal = taxedSalaryTotal;
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

    public double getSalaryTotal() {
        return salaryTotal;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public double getTaxedSalaryTotal() {
        return taxedSalaryTotal;
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

    public void setSalaryTotal(double salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public void setTaxedSalaryTotal(double taxedSalaryTotal) {
        this.taxedSalaryTotal = taxedSalaryTotal;
    }
}
