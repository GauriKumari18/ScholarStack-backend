package com.gaurikumari.marketplace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project_feedback")
public class ProjectFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // A feedback entry belongs to one project
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "client_difficulty_rating")
    private Integer clientDifficultyRating;

    @Column(name = "actual_days_taken")
    private Integer actualDaysTaken;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}