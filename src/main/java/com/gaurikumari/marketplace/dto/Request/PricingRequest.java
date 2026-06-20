package com.gaurikumari.marketplace.dto.Request;

import com.gaurikumari.marketplace.enums.DeadlineType;
import com.gaurikumari.marketplace.enums.DeveloperLevel;
import com.gaurikumari.marketplace.enums.ProjectComplexity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingRequest {

    private ProjectComplexity complexity;
    private String techStack;
    private Integer estimatedDays;
    private List<FeatureRequest> features;
    private DeveloperLevel developerLevel;
    private DeadlineType deadlineType;

}