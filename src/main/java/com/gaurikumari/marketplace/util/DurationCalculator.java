package com.gaurikumari.marketplace.util;

import org.springframework.stereotype.Component;

@Component
public class DurationCalculator {

    /**
     * Calculates a score based on estimated project duration (in days).
     * Shorter durations are weighted higher (urgency / tighter delivery),
     * longer durations are weighted lower per-day but still contribute.
     *
     * 1-7 days    -> 30
     * 8-14 days   -> 20
     * 15-30 days  -> 10
     * 30+ days    -> 5
     */
    public double calculateScore(Integer estimatedDays) {
        if (estimatedDays == null || estimatedDays <= 0) {
            return 0;
        }

        if (estimatedDays <= 7) {
            return 30;
        } else if (estimatedDays <= 14) {
            return 20;
        } else if (estimatedDays <= 30) {
            return 10;
        } else {
            return 5;
        }
    }

}