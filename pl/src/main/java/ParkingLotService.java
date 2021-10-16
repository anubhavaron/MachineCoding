import dao.FloorDao;
import dao.ParkingLotDao;
import exception.NotParkingSpaceException;
import lombok.Getter;
import model.Ticket;
import model.TicketStatus;
import model.Vehicle;
import model.VehicleType;

import java.util.*;

public class ParkingLotService {
    @Getter
    private String id;
    private ParkingLotDao parkingLotDao = new ParkingLotDao();

    public ParkingLotService(String id) {
        this.id = id;
    }

    public void createParkingLot(int totalFloor, List<Integer> asList) {
        for(Integer floorNumber = 1; floorNumber <= totalFloor ; floorNumber++) {
            FloorDao floorDao = new FloorDao(asList.get(floorNumber-1), floorNumber);
            this.addFloor(floorDao);
        }
    }

    public Ticket addVehicle(Vehicle vehicle) throws NotParkingSpaceException {
        VehicleType vehicleType = vehicle.getVehicleType();
        if(parkingFull(vehicleType)) {
            throw new NotParkingSpaceException();
        }
        Map<Integer, FloorDao> floorDaoMap = parkingLotDao.getFloorDaoMap();
        int floorNumber  = 0, slotNumber = 0;
        for(Map.Entry<Integer, FloorDao> entry : floorDaoMap.entrySet()) {
            FloorDao floorDao = entry.getValue();
            if(floorDao.getAvailableSlots().get(vehicleType).size() > 0) {
                floorNumber = entry.getKey();
                slotNumber = floorDao.getAvailableSlots().get(vehicleType).iterator().next();
            }
        }
        return assignVehicleToSlotAndGenerateTicket(floorNumber, slotNumber, vehicle, parkingLotDao);
    }

    public void unMarkVehicle(Ticket ticket) {
        ticket.setTicketStatus(TicketStatus.DONE);
        updateUnParkingDataWithTicket(ticket);
    }

    private void updateUnParkingDataWithTicket(Ticket ticket) {
        int floorNumber = ticket.getFloorNumber();
        int slotNumber = ticket.getSlotNumber();
        Vehicle vehicle = ticket.getVehicle();
        parkingLotDao.getUsedSlotMap().put(vehicle.getVehicleType(), parkingLotDao.getUsedSlotMap().get(vehicle.getVehicleType())-1);
        FloorDao floorDao = parkingLotDao.getFloorDaoMap().get(floorNumber);
        Set<Integer> availableSLots = floorDao.getAvailableSlots().get(vehicle.getVehicleType());
        availableSLots.add(slotNumber);
        floorDao.getAvailableSlots().put(vehicle.getVehicleType(), availableSLots);
    }

    private void addFloor(FloorDao floorDao) {
        parkingLotDao.getFloorDaoMap().put(floorDao.getFloorNumber(), floorDao);
        for(Map.Entry<VehicleType, Set<Integer>> entry :floorDao.getAvailableSlots().entrySet()) {
            if(Objects.nonNull(parkingLotDao.getMaxSlotMap().get(entry.getKey()))) {
                parkingLotDao.getMaxSlotMap().put(entry.getKey(),
                        parkingLotDao.getMaxSlotMap().get(entry.getKey()) + entry.getValue().size());
            } else {
                parkingLotDao.getMaxSlotMap().put(entry.getKey(),
                        parkingLotDao.getMaxSlotMap().get(entry.getKey()) + entry.getValue().size());
            }
        }
    }



    private Ticket assignVehicleToSlotAndGenerateTicket(int floorNumber, int slotNumber, Vehicle vehicle, ParkingLotDao parkingLotDao) {
        Ticket ticket = new Ticket(floorNumber, slotNumber, vehicle);
        updateParkingDataWithTicket(parkingLotDao, ticket);
        return ticket;
    }

    private void updateParkingDataWithTicket(ParkingLotDao parkingLotDao, Ticket ticket) {
        Integer integer = parkingLotDao.getUsedSlotMap().get(ticket.getVehicle().getVehicleType());
        parkingLotDao.getUsedSlotMap().put(ticket.getVehicle().getVehicleType(), integer);
        FloorDao floorDao = parkingLotDao.getFloorDaoMap().get(ticket.getFloorNumber());
        floorDao.getAvailableSlots().get(ticket.getVehicle().getVehicleType()).remove(ticket.getSlotNumber());
    }

    private boolean parkingFull(VehicleType vehicleType) {
        return (parkingLotDao.getMaxSlotMap().get(vehicleType) == parkingLotDao.getUsedSlotMap().get(vehicleType));
    }
}
