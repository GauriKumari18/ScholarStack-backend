package com.gaurikumari.marketplace.dto.Response;

import com.gaurikumari.marketplace.enums.BidStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BidResponse {

    private Long id;

    private Long projectId;

    private String projectTitle;

    private Long freelancerId;

    private String freelancerName;

    private Double proposedAmount;

    private String proposal;

    private Integer estimatedDays;

    private BidStatus status;

    private LocalDateTime createdAt;

}