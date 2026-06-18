package com.gaurikumari.marketplace.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BidRequest {

    private Long projectId;

    private Long freelancerId;

    private Double proposedAmount;

    private String proposal;

    private Integer estimatedDays;

}