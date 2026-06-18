package com.gaurikumari.marketplace.controller;

import com.gaurikumari.marketplace.dto.Request.BidRequest;
import com.gaurikumari.marketplace.dto.Response.BidResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gaurikumari.marketplace.service.BidService;

import java.util.List;

@RestController
@RequestMapping("/api/bids")
@RequiredArgsConstructor
public class BidController {

    private final BidService bidService;

    // POST /api/bids
    @PostMapping
    public ResponseEntity<BidResponse> createBid(@RequestBody BidRequest request) {
        BidResponse response = bidService.createBid(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /api/bids/project/{projectId}
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<BidResponse>> getProjectBids(@PathVariable Long projectId) {
        List<BidResponse> bids = bidService.getProjectBids(projectId);
        return ResponseEntity.ok(bids);
    }

    // GET /api/bids/freelancer/{freelancerId}
    @GetMapping("/freelancer/{freelancerId}")
    public ResponseEntity<List<BidResponse>> getFreelancerBids(@PathVariable Long freelancerId) {
        List<BidResponse> bids = bidService.getFreelancerBids(freelancerId);
        return ResponseEntity.ok(bids);
    }

}