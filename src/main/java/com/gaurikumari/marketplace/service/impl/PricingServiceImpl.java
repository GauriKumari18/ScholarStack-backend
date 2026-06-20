package com.gaurikumari.marketplace.service.impl;

import com.gaurikumari.marketplace.dto.Request.PricingRequest;
import com.gaurikumari.marketplace.dto.Response.PricingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.gaurikumari.marketplace.service.pricing.PricingService;
import com.gaurikumari.marketplace.util.ComplexityCalculator;
import com.gaurikumari.marketplace.util.DurationCalculator;
import com.gaurikumari.marketplace.util.TechStackCalculator;

@Service
@RequiredArgsConstructor
public class PricingServiceImpl implements PricingService {

    private final ComplexityCalculator complexityCalculator;
    private final TechStackCalculator techStackCalculator;
    private final DurationCalculator durationCalculator;

    // Base price multiplier - each "point" of score translates to this much currency
    private static final double PRICE_PER_SCORE_POINT = 200;

    @Override
    public PricingResponse calculatePricing(PricingRequest request) {

        // 1. Get score from each calculator
        double complexityScore = complexityCalculator.calculateScore(request.getComplexity());
        double techScore = techStackCalculator.calculateScore(request.getTechStack());
        double durationScore = durationCalculator.calculateScore(request.getEstimatedDays());

        // 2. Total difficulty score
        double totalScore = complexityScore + techScore + durationScore;

        // 3. Map score to price range
        double recommendedPrice = totalScore * PRICE_PER_SCORE_POINT;
        double minimumPrice = recommendedPrice * 0.8;   // -20%
        double maximumPrice = recommendedPrice * 1.3;   // +30%

        // 4. Build response
        PricingResponse response = new PricingResponse();
        response.setMinimumPrice(round(minimumPrice));
        response.setRecommendedPrice(round(recommendedPrice));
        response.setMaximumPrice(round(maximumPrice));
        response.setDifficultyScore(round(totalScore));

        return response;
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}