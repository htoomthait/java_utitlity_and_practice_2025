package info.htoomaungthait.ems_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tbl_projects")
public class Project {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank
   @Column(name= "name", length = 512)
   private String name;

   @Column(name = "description", nullable = true, length = 4096)
   private String description;


   @Column(name = "start_date", nullable = true)
   private LocalDate startDate;

   @Column(name = "end_date", nullable = true)
   private LocalDate endDate;

   @Column(name = "duration", nullable = true)
   @Comment("duration in month")
   private double duration;

   @Column(name = "category", nullable = true)
   @Enumerated(EnumType.STRING)
   private ProjectCategory category;

   @NotNull
   @Column(name = "status", nullable = false)
   @Enumerated(EnumType.STRING)
   private ProjectStatus status = ProjectStatus.INITIAL;

   @ManyToOne
   @JoinColumn(name = "project_manager", nullable = true)
   private Employee projectManager;

   @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
   private Set<ProjectAssignment> assignments = new HashSet<>();

   @CreationTimestamp
   @Column(updatable = false)
   private LocalDateTime createdAt;

   @UpdateTimestamp
   private LocalDateTime updatedAt;

   public Project(Long id, String name, String description, LocalDate startDate, LocalDate endDate, double duration, ProjectCategory category, ProjectStatus status, Employee projectManager) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.startDate = startDate;
      this.endDate = endDate;
      this.duration = duration;
      this.category = category;
      this.status = status;
      this.projectManager = projectManager;
   }

   public Project(String name, String description, LocalDate startDate, LocalDate endDate, double duration, ProjectCategory category, ProjectStatus status) {
      this.name = name;
      this.description = description;
      this.startDate = startDate;
      this.endDate = endDate;
      this.duration = duration;
      this.category = category;
      this.status = status;

   }

   public Project(String name, String description, LocalDate startDate, LocalDate endDate, double duration, ProjectCategory category, ProjectStatus status, Employee projectManager) {
      this.name = name;
      this.description = description;
      this.startDate = startDate;
      this.endDate = endDate;
      this.duration = duration;
      this.category = category;
      this.status = status;
      this.projectManager = projectManager;
   }

   public Long getId() {
      return id;
   }

   public @NotBlank String getName() {
      return name;
   }

   public String getDescription() {
      return description;
   }

   public LocalDate getStartDate() {
      return startDate;
   }

   public LocalDate getEndDate() {
      return endDate;
   }

   public double getDuration() {
      return duration;
   }

   public ProjectCategory getCategory() {
      return category;
   }

   public @NotNull ProjectStatus getStatus() {
      return status;
   }

   public Employee getProjectManager() {
      return projectManager;
   }

   public Set<ProjectAssignment> getAssignments() {
      return assignments;
   }

   public LocalDateTime getCreatedAt() {
      return createdAt;
   }

   public LocalDateTime getUpdatedAt() {
      return updatedAt;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setName(@NotBlank String name) {
      this.name = name;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public void setStartDate(LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setDuration(double duration) {
      this.duration = duration;
   }

   public void setCategory(ProjectCategory category) {
      this.category = category;
   }

   public void setStatus(@NotNull ProjectStatus status) {
      this.status = status;
   }

   public void setProjectManager(Employee projectManager) {
      this.projectManager = projectManager;
   }

   public void setAssignments(Set<ProjectAssignment> assignments) {
      this.assignments = assignments;
   }

   public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
   }

   public void setUpdatedAt(LocalDateTime updatedAt) {
      this.updatedAt = updatedAt;
   }
}
