package com.gaurikumari.marketplace.service.pricing;

import com.gaurikumari.marketplace.dto.Request.PricingRequest;
import com.gaurikumari.marketplace.dto.Response.PricingResponse;

public interface PricingService {

    PricingResponse calculatePricing(PricingRequest request);

}