package model;

import lombok.Getter;
import lombok.Setter;

public class Ticket {
    @Getter
    @Setter
    private TicketStatus ticketStatus;
    @Getter
    private Integer floorNumber;
    @Getter
    private Integer slotNumber;
    @Getter
    private Vehicle vehicle;

    public Ticket( Integer floorNumber, Integer slotNumber, Vehicle vehicle) {
        this.vehicle = vehicle;
        this.ticketStatus = TicketStatus.ACTIVE;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
    }
}
