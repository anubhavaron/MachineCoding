package dao;

import lombok.Getter;
import lombok.Setter;
import model.Ticket;
import model.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotDao {
    @Getter
    @Setter
    private Map<Integer, FloorDao> floorDaoMap = new HashMap<>();
    @Getter
    @Setter
    private Map<VehicleType, Integer> maxSlotMap = new HashMap<>();
    @Getter
    @Setter
    private Map<VehicleType, Integer> usedSlotMap = new HashMap<>();

}
