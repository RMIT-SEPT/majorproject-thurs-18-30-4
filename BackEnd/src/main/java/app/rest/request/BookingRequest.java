package com.rmit.sept.turtorial.demo.rest.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class BookingRequest {
    @NotBlank
    private Long businessId;
    @NotBlank
    private Long customerId;
    @NotBlank
    private Long workerId;

    @NotBlank(message = "booking start time required")
    @JsonFormat(pattern ="yyyy-MM-ddTHH-mm")
    public Date booked_At;

    @NotBlank(message = "booking end time required")
    @JsonFormat(pattern ="yyyy-MM-ddTHH-mm")
    public Date booked_Till;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Date getBooked_At() {
        return booked_At;
    }

    public void setBooked_At(Date booked_At) {
        this.booked_At = booked_At;
    }

    public Date getBooked_Till() {
        return booked_Till;
    }

    public void setBooked_Till(Date booked_Till) {
        this.booked_Till = booked_Till;
    }
}
