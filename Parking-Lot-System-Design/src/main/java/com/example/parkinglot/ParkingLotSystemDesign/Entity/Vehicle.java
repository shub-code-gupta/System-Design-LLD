package com.example.parkinglot.ParkingLotSystemDesign.Entity;


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
public class Vehicle {
	
	private String vehicleNumber;
	private VehicleType vehicleType;
}
