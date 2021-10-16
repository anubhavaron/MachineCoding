import exception.NotParkingSpaceException;
import model.Ticket;
import model.Vehicle;
import model.VehicleType;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService("PR1234");
        parkingLotService.createParkingLot(5, Arrays.asList(1,2,3,4,5));
        Ticket ticket1 = null, ticket2 = null, ticket3 = null, ticket4 = null , ticket5 = null;
        try {
             ticket1 = parkingLotService.addVehicle(new Vehicle(VehicleType.TRUCK, "1"));
        } catch (NotParkingSpaceException e) {
            e.printStackTrace();
        }
        try {
            ticket2 = parkingLotService.addVehicle(new Vehicle(VehicleType.Bike, "2"));
        } catch (NotParkingSpaceException e) {
            e.printStackTrace();
        }
        try {
            ticket3 = parkingLotService.addVehicle(new Vehicle(VehicleType.Car, "3"));
        } catch (NotParkingSpaceException e) {
            e.printStackTrace();
        }
        try {
            ticket4 = parkingLotService.addVehicle(new Vehicle(VehicleType.Bike, "4"));
        } catch (NotParkingSpaceException e) {
            e.printStackTrace();
        }
        try {
            ticket5 = parkingLotService.addVehicle(new Vehicle(VehicleType.Car, "5"));
        } catch (NotParkingSpaceException e) {
            e.printStackTrace();
        }
        parkingLotService.unMarkVehicle(ticket1);
        parkingLotService.unMarkVehicle(ticket2);
        try {
            ticket2 = parkingLotService.addVehicle(new Vehicle(VehicleType.Bike, "2"));
        } catch (NotParkingSpaceException e) {
            e.printStackTrace();
        }



    }
}
