package com.gaurikumari.marketplace.util;

import com.gaurikumari.marketplace.enums.ComplexityLevel;
import org.springframework.stereotype.Component;

@Component
public class ComplexityUtil {

    /**
     * Returns the cost multiplier for a given complexity level.
     */
    public double getMultiplier(ComplexityLevel complexityLevel) {
        if (complexityLevel == null) {
            return 1.0;
        }

        switch (complexityLevel) {
            case EASY:
                return 1.0;
            case MEDIUM:
                return 1.5;
            case HARD:
                return 2.5;
            default:
                return 1.0;
        }
    }

}