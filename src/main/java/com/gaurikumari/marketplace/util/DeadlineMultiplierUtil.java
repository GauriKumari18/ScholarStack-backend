package com.gaurikumari.marketplace.util;

import com.gaurikumari.marketplace.enums.DeadlineType;
import org.springframework.stereotype.Component;

@Component
public class DeadlineMultiplierUtil {

    /**
     * Returns the cost multiplier for a given deadline urgency type.
     */
    public double getMultiplier(DeadlineType deadlineType) {
        if (deadlineType == null) {
            return 1.0;
        }

        switch (deadlineType) {
            case RELAXED:
                return 1.0;
            case MODERATE:
                return 1.2;
            case URGENT:
                return 1.5;
            default:
                return 1.0;
        }
    }

}