package model;

import lombok.Getter;
import lombok.Setter;

public class ParkingSlot {
    @Getter
    private int number;
    @Getter
    private VehicleType allowedVehicleType;
    @Getter
    @Setter
    private SlotStatus slotStatus;

    public ParkingSlot(int number, VehicleType allowedVehicleType) {
        this.number = number;
        this.allowedVehicleType = allowedVehicleType;
        this.slotStatus = SlotStatus.Free;
    }
}
