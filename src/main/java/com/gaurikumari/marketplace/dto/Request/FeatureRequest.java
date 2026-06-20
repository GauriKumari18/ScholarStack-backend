package com.gaurikumari.marketplace.dto.Request;

import com.gaurikumari.marketplace.enums.ComplexityLevel;
import com.gaurikumari.marketplace.enums.FeatureType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeatureRequest {

    private FeatureType featureType;

    private ComplexityLevel complexityLevel;

}