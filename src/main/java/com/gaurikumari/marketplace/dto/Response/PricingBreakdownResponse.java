package com.gaurikumari.marketplace.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingBreakdownResponse {

    private String featureName;

    private Double baseCost;

    private Double complexityMultiplier;

    private Double finalFeatureCost;

}