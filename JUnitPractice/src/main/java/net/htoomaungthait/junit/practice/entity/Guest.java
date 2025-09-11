package net.htoomaungthait.junit.practice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "email", nullable = true)
    private String email;


    @Column(name = "visited_at", nullable = false)
    private LocalDateTime visitedAt;


    public static Guest of(String name, String email) {
        return Guest.builder()
                .name(name)
                .email(email)
                .build();
    }


    @PrePersist
    public void prePersist() {
        if (visitedAt == null) {
            visitedAt = LocalDateTime.now();
        }
    }


}
