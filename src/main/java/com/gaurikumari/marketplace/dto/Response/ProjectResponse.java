package com.gaurikumari.marketplace.dto.Response;

import com.gaurikumari.marketplace.enums.ProjectComplexity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {

    private Long id;

    private String title;

    private String description;

    private Double budget;

    private String techStack;

    private Integer expectedDuration;

    private ProjectComplexity complexity;

    private String status;

    private String clientName;

    private LocalDateTime createdAt;

    public void setClientId(Long id) {
    }
}