package com.gaurikumari.marketplace.model;

import com.gaurikumari.marketplace.enums.ProjectComplexity;
import com.gaurikumari.marketplace.enums.ProjectStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description", length = 3000)
    private String description;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "tech_stack")
    private String techStack;

    @Column(name = "expected_duration")
    private Integer expectedDuration;

    @Enumerated(EnumType.STRING)
    @Column(name = "complexity", length = 50)
    private ProjectComplexity complexity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50)
    private ProjectStatus status;

    // Many projects can belong to one client (User)
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}