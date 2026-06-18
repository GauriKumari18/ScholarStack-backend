package com.gaurikumari.marketplace.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingResponse {

    private Double minimumPrice;

    private Double recommendedPrice;

    private Double maximumPrice;

    private Double difficultyScore;

}