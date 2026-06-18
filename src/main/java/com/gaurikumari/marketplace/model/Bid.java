package com.gaurikumari.marketplace.model;

import com.gaurikumari.marketplace.enums.BidStatus;
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
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "proposed_amount", nullable = false)
    private Double proposedAmount;

    @Column(name = "proposal", nullable = false, columnDefinition = "TEXT")
    private String proposal;

    @Column(name = "estimated_days", nullable = false)
    private Integer estimatedDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 50)
    private BidStatus status;

    // Relationship 1: A bid belongs to one project
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // Relationship 2: A bid belongs to one freelancer
    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private User freelancer;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}