package com.gaurikumari.marketplace.controller;

import com.gaurikumari.marketplace.dto.Request.PricingRequest;
import com.gaurikumari.marketplace.dto.Response.PricingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gaurikumari.marketplace.service.pricing.PricingService;

@RestController
@RequestMapping("/api/pricing")
@RequiredArgsConstructor
public class PricingController {

    private final PricingService pricingService;

    // POST /api/pricing/calculate
    @PostMapping("/calculate")
    public ResponseEntity<PricingResponse> calculatePricing(@RequestBody PricingRequest request) {
        PricingResponse response = pricingService.calculatePricing(request);
        return ResponseEntity.ok(response);
    }

}