package info.htoomaungthait.ems_backend.repository;

import info.htoomaungthait.ems_backend.dto.DepartmentEmployeeCountDto;
import info.htoomaungthait.ems_backend.dto.DepartmentWithEmployeeTaxedSalaryDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepositoryCustomImpl  {
    @PersistenceContext
    private EntityManager entityManager;

    public List<DepartmentEmployeeCountDto> getDepartmentWithCounts() {
        String sql = "SELECT d.id, d.name, COUNT(e.id) AS employee_count " +
                "FROM tbl_departments d LEFT JOIN tbl_employees e ON d.id = e.department_id " +
                "GROUP BY d.id, d.name";

        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();

        return results.stream()
                .map(row -> new DepartmentEmployeeCountDto(
                        ((Number) row[0]).longValue(),
                        (String) row[1],
                        ((Number) row[2]).longValue()))
                .toList();
    }

    public List<DepartmentWithEmployeeTaxedSalaryDto> getDepartmentWithEmployeeCountAndSalariesTotal(){
        String sql = "SELECT d.id, d.name, COUNT(e.id) AS employee_count, COALESCE(SUM(e.salary),0) AS total_salary " +
                "FROM tbl_departments d LEFT JOIN tbl_employees e ON d.id = e.department_id "+
                "GROUP BY d.id, d.name;";
        List<Object[]> results = entityManager.createNativeQuery(sql).getResultList();

        return results.stream()
                .map( row -> new DepartmentWithEmployeeTaxedSalaryDto(
                        ((Number) row[0]).longValue(),
                        (String) row[1],
                        ((Number) row[2]).longValue(),
                        ((Number) row[3]).doubleValue(),
                        0.0,
                        0.0
                ))
                .toList();

    }
}
