package com.gaurikumari.marketplace.service;

import com.gaurikumari.marketplace.dto.Request.BidRequest;
import com.gaurikumari.marketplace.dto.Response.BidResponse;

import java.util.List;

public interface BidService {

    BidResponse createBid(BidRequest request);

    List<BidResponse> getProjectBids(Long projectId);

    List<BidResponse> getFreelancerBids(Long freelancerId);

}