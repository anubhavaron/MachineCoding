package dao;

import lombok.Getter;
import lombok.Setter;
import model.ParkingSlot;
import model.VehicleType;
import util.FloorMakerUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FloorDao {
    @Getter
    @Setter
    private Integer floorNumber;
    @Getter
    private Map<Integer, ParkingSlot> parkingSlotMap = new HashMap<>();
    @Getter
    private Map<VehicleType, Set<Integer>> availableSlots = new HashMap<>();

    public FloorDao(int totalSlots, int floorNumber) {
        this.floorNumber = floorNumber;
        FloorMakerUtil.makeFloor(totalSlots, this);
    }
}
