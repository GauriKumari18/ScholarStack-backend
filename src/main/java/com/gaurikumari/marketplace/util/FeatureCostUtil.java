package com.gaurikumari.marketplace.util;

import com.gaurikumari.marketplace.enums.FeatureType;
import org.springframework.stereotype.Component;

@Component
public class FeatureCostUtil {

    /**
     * Returns the base cost for a given feature type.
     */
    public double getBaseCost(FeatureType featureType) {
        if (featureType == null) {
            return 0;
        }

        switch (featureType) {
            case STATIC_PAGE:
                return 300;
            case LOGIN_SYSTEM:
                return 800;
            case DATABASE_SETUP:
                return 700;
            case API_INTEGRATION:
                return 1000;
            case REALTIME_FEATURE:
                return 1500;
            default:
                return 0;
        }
    }

}