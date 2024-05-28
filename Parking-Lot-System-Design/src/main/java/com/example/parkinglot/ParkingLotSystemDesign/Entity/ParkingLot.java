package com.example.parkinglot.ParkingLotSystemDesign.Entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParkingLot {
	
	private Long parkingLotNumber;
	private Long floorNumber;
	private boolean isParkingFree;
	private VehicleType vihicleType;
	private ParkingSpotType parkingSpotType;
	private List<String> entryGate;
	private List<String> exitGate;
	
	
}
