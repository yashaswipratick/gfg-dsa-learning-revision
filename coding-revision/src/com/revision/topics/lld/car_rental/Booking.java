package com.revision.topics.lld.car_rental;

import java.time.LocalDate;

public class Booking {

    String Id;
    String customerId;
    Car id;
    LocalDate startDate;
    LocalDate endDate;

    public String getId() {
        return Id;
    }

    public void setId(Car id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
