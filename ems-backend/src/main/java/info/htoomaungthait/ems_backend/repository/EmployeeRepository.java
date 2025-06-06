package info.htoomaungthait.ems_backend.repository;

import info.htoomaungthait.ems_backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);


}
