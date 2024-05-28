package com.example.parkinglot.ParkingLotSystemDesign.Entity;

import java.util.List;
import java.util.Map;

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
public class BoardingDisplay {
	
	private Long parkingLeftInTotal;
	private Map<Long, List<Long> > parkingPresentDetails;

}
