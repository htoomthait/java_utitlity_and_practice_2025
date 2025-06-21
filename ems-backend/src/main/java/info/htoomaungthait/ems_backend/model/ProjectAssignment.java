package info.htoomaungthait.ems_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_project_assignments")
public class ProjectAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Many assignments link to one employee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Many assignments link to one project
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "status", nullable = true)
    @Enumerated(EnumType.STRING)
    private ProjectAssignStatus status;

    public ProjectAssignment(Long id, Employee employee, Project project, ProjectAssignStatus status) {
        this.id = id;
        this.employee = employee;
        this.project = project;
        this.status = status;
    }

    public ProjectAssignment(Employee employee, Project project, ProjectAssignStatus status) {
        this.employee = employee;
        this.project = project;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public ProjectAssignStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setStatus(ProjectAssignStatus status) {
        this.status = status;
    }
}


