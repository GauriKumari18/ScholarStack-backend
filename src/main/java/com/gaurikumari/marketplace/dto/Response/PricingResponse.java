package com.gaurikumari.marketplace.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingResponse {

    private Double minimumPrice;

    private Double recommendedPrice;

    private Double maximumPrice;

    private Double difficultyScore;

    private Double subtotal;
    private Double developerMultiplier;
    private Double urgencyMultiplier;
    private Double totalCost;

    private List<PricingBreakdownResponse> breakdown;
    private MilestoneResponse milestones;

}