package com.example.parkinglot.ParkingLotSystemDesign.Service;

public interface ParkingLotService {
	
	public void showBoardDetails();
	
	public void calculateAmount();
	
	public void getFirstFreeParkingBasedOnVehicle(String type);
	
	public void setParkingFullNotice();
	
	public void getEntry();
	
	public void getExit();
	
	public void removeParking(Long parkingNumber, Long floor);
	
	public void addFreeParking();

}
