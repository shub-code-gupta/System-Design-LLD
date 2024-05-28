package com.example.parkinglot.ParkingLotSystemDesign.Entity;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
public class Ticket {
	
	private Long ticketId;
	private Date entryTime;
	private Date exitTime;
	private VehicleType vehicleType;
	private Vehicle vehicleDetails;
	private Float totalCost;

}
