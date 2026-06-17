package com.gaurikumari.marketplace.dto.Request;

import com.gaurikumari.marketplace.enums.ProjectComplexity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequest {

    private String title;

    private String description;

    private Double budget;

    private String techStack;

    private Integer expectedDuration;

    private ProjectComplexity complexity;

    private Long clientId;

}