package info.htoomaungthait.ems_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tbl_departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;


    @Column(name = "description", nullable = true)
    private String description;


    @NotNull
    @Enumerated(EnumType.STRING)
    private DepartmentStatus status = DepartmentStatus.ACTIVE;

    public Department() {

    }

    public Department(String name, String description, DepartmentStatus status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Department(Long id, String name, String description, DepartmentStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public  String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DepartmentStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(DepartmentStatus status) {
        this.status = status;
    }
}

