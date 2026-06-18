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
public class PricingRequest {

    private ProjectComplexity complexity;

    private String techStack;

    private Integer estimatedDays;

}