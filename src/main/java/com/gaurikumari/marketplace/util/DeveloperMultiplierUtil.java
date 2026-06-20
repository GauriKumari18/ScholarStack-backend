package com.gaurikumari.marketplace.util;

import com.gaurikumari.marketplace.enums.DeveloperLevel;
import org.springframework.stereotype.Component;

@Component
public class DeveloperMultiplierUtil {

    /**
     * Returns the cost multiplier for a given developer level.
     */
    public double getMultiplier(DeveloperLevel developerLevel) {
        if (developerLevel == null) {
            return 1.0;
        }

        switch (developerLevel) {
            case BEGINNER:
                return 0.8;
            case INTERMEDIATE:
                return 1.0;
            case ADVANCED:
                return 1.5;
            default:
                return 1.0;
        }
    }

}