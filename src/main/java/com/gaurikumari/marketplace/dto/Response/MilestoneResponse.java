package com.gaurikumari.marketplace.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MilestoneResponse {

    private Double startPayment;

    private Double midPayment;

    private Double finalPayment;

}