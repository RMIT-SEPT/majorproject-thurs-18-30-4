package com.rmit.sept.turtorial.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table( name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull(message = "business id cannot be blank")
    public Long businessId;
    @NotNull(message = "customer id cannot be blank")
    public Long customerId;
    @NotNull(message = "worker id cannot be blank")
    public Long workerId;

    // boolean variable representing the state of the booking
    public boolean isActive;

    @JsonFormat(pattern ="yyyy-MM-dd")
    public Date created_At;

    @NotNull(message = "booking start time required")
    @JsonFormat(pattern ="yyyy-MM-ddTHH-mm")
    public Date booked_At;

    @NotNull(message = "booking end time required")
    @JsonFormat(pattern ="yyyy-MM-ddTHH-mm")
    public Date booked_Till;

    public Booking() {

    }

    public Booking(Long id, Long businessId, Long customerId, Long workerId, Date booked_At, Date booked_Till) {
        this.id = id;
        this.businessId = businessId;
        this.customerId = customerId;
        this.workerId = workerId;
        this.booked_At = booked_At;
        this.booked_Till = booked_Till;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        this.isActive = active;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
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
