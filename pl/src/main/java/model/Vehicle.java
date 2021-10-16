package model;

import lombok.Getter;

public class Vehicle {
    @Getter
    private VehicleType vehicleType;
    @Getter
    private String licenceNumber;

    public Vehicle(VehicleType vehicleType, String licenceNumber) {
        this.vehicleType = vehicleType;
        this.licenceNumber = licenceNumber;
    }

    public Vehicle(VehicleType truck) {
    }
}
