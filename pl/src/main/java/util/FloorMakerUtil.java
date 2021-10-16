package util;

import dao.FloorDao;
import model.ParkingSlot;
import model.VehicleType;

import java.util.*;

public class FloorMakerUtil {

    public static void makeFloor(int totalSlots, FloorDao floorDao) {
        Map<Integer, ParkingSlot> parkingSlotMap = floorDao.getParkingSlotMap();
        Map<VehicleType, Set<Integer>> availableSlots = floorDao.getAvailableSlots();
        for(Integer slotNumber = 1; slotNumber <= totalSlots; slotNumber++) {
            VehicleType vehicleType = FloorMakerUtil.getVehicleType(slotNumber);
            ParkingSlot parkingSlot = new ParkingSlot(slotNumber, vehicleType);
            parkingSlotMap.put(slotNumber, parkingSlot);
            updateParkingSlotInAvailableSlotMap(vehicleType, parkingSlot, availableSlots);
        }
    }

    private static void updateParkingSlotInAvailableSlotMap(VehicleType vehicleType, ParkingSlot parkingSlot, Map<VehicleType, Set<Integer>> availableSlots) {
        if(Objects.nonNull(availableSlots.get(vehicleType))) {
            availableSlots.get(vehicleType).add(parkingSlot.getNumber());
        } else {
            availableSlots.put(vehicleType, new HashSet<>(parkingSlot.getNumber()));
        }
    }

    private static VehicleType getVehicleType(int slotNo) {
        switch (slotNo) {
            case 1 : return VehicleType.TRUCK;
            case 2 :
            case 3 : return VehicleType.Bike;
        }
        return VehicleType.Car;
    }
}
