package info.htoomaungthait.ems_backend.repository;

import info.htoomaungthait.ems_backend.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
