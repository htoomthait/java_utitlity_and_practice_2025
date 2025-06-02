package info.htoomaungthait.ems_backend.repository;

import info.htoomaungthait.ems_backend.dto.DepartmentEmployeeCountDto;
import info.htoomaungthait.ems_backend.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(value = "SELECT d.id AS id, d.name AS name, COUNT(e.id) AS employeeCount " +
        "FROM tbl_departments d LEFT JOIN tbl_employees e ON d.id = e.department_id " +
        "GROUP BY d.id, d.name",
        nativeQuery = true)
    List<DepartmentEmployeeCountDto> getDepartmentsWithEmployeeCount();

}
