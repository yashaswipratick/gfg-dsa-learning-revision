package com.revision.topics.lld.car_rental;

// Use Build Pattern
public class Car {

    String id;
    String name;
    Integer seats;
    Integer availability;
    Integer mileage;
    Long kilometers;
    Integer launchYear;
    Integer fuelCapacity;
    String mode; // automatic or manual
    Long basePrice;
    String location;
    String model;
    Long usage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Long getKilometers() {
        return kilometers;
    }

    public void setKilometers(Long kilometers) {
        this.kilometers = kilometers;
    }

    public Integer getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(Integer launchYear) {
        this.launchYear = launchYear;
    }

    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Long basePrice) {
        this.basePrice = basePrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getUsage() {
        return usage;
    }

    public void setUsage(Long usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", seats=" + seats +
                ", availability=" + availability +
                ", mileage=" + mileage +
                ", kilometers=" + kilometers +
                ", launchYear=" + launchYear +
                ", fuelCapacity=" + fuelCapacity +
                ", mode='" + mode + '\'' +
                ", basePrice=" + basePrice +
                ", location='" + location + '\'' +
                ", model='" + model + '\'' +
                ", usage=" + usage +
                '}';
    }
}
