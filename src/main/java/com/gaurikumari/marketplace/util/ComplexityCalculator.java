package com.gaurikumari.marketplace.util;

import com.gaurikumari.marketplace.enums.ProjectComplexity;
import org.springframework.stereotype.Component;

@Component
public class ComplexityCalculator {

    /**
     * Calculates a score based on project complexity.
     * EASY      -> 10
     * MEDIUM    -> 25
     * HARD      -> 40
     */
    public double calculateScore(ProjectComplexity complexity) {
        if (complexity == null) {
            return 0;
        }

        switch (complexity) {
            case BEGINNER:
                return 10;
            case INTERMEDIATE:
                return 25;
            case ADVANCED:
                return 40;
            default:
                return 0;
        }
    }

}