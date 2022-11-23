package BussinessLogic;

import java.util.ArrayList;

public class PassengerCatalog {

	private ArrayList <Passenger> passengerRecords = new ArrayList<Passenger>();

	public ArrayList<Passenger> getPassengerRecords() {
		return passengerRecords;
	}

	public void setPassengerRecords(ArrayList<Passenger> passengerRecords) {
		this.passengerRecords = passengerRecords;
	}
	
	
	public void getRegularCustomers(ArrayList <Passenger> regularCustomers ) {
		
		for(int iterator = 0 ; iterator < passengerRecords.size(); iterator++)
		{
			   if(passengerRecords.get(iterator).getVehicleRentalCount() >= 5) {
				   
				    regularCustomers.add(passengerRecords.get(iterator)); 
			   }			
		}
		
	}		
	
	
     public void addBooking(Booking booking) {		
    	
    	 	for(int iterator = 0 ; iterator < passengerRecords.size(); iterator++)
 		{
 			   if(passengerRecords.get(iterator).getPassengerID().equals(booking.getPassengerID()) ) {
 				   
 				   passengerRecords.get(iterator).bookRide(booking);  
 				   
 			   }			
 		}
    	 
     } 	
	
	
	
     public boolean deleteBooking(String bookingID, String passengerID) {		
     	
 	 	for(int iterator = 0 ; iterator < passengerRecords.size(); iterator++)
		{
			   if(passengerRecords.get(iterator).getPassengerID().equals(passengerID)) {
				   
				   passengerRecords.get(iterator).cancelBooking(bookingID);   
				   return true;
			   }			
		}
 	 	return false;
    }
	
     
     
     public void addLuggageBooking(LuggageBooking LBooking) {		
     	
 	 	for(int iterator = 0 ; iterator < passengerRecords.size(); iterator++)
		{
			   if(passengerRecords.get(iterator).getPassengerID().equals(LBooking.getPassengerID()) ) {
				   
				   passengerRecords.get(iterator).LuggageBooking(LBooking);  
				   
			   }			
		}
 	 
  } 	
	
     public boolean deleteLuggageBooking(String bookingID, String passengerID) {		
      	
  	 	for(int iterator = 0 ; iterator < passengerRecords.size(); iterator++)
 		{
 			   if(passengerRecords.get(iterator).getPassengerID().equals(passengerID)) {
 				   
 				   passengerRecords.get(iterator).cancelLuggageBooking(bookingID);   
 				   return true;
 			   }			
 		}
  	 	return false;
     }
  	
  	
  	
  	
     public void rentVehicle(int vehicleID, String rentID, String rentingDate, String duration, String returnDate, vehicleCatalog VehicleCatalog, int accountIndex, double discountPercentage) { 	
    	 	
    	 	
    		Vehicle vehicle = new Vehicle (); 
    		vehicle = VehicleCatalog.getVehicle(vehicleID);
    		int passengerRentalCount =  getPassengerRecords().get(accountIndex).getVehicleRentalCount() + 1;
    		getPassengerRecords().get(accountIndex).setVehicleRentalCount(passengerRentalCount);
    	
    		if(passengerRentalCount >= 5) {
    			
    			double disountedAmount  = vehicle.getVd().getRentAmount() - (discountPercentage/vehicle.getVd().getRentAmount())*100 ;
    			getPassengerRecords().get(accountIndex).rentVehicle(rentID, disountedAmount, rentingDate, duration, returnDate, vehicle); 
    				
    		}else {
     			
    			getPassengerRecords().get(accountIndex).rentVehicle(rentID, vehicle.getVd().getRentAmount(), rentingDate, duration, returnDate, vehicle); 
    			
    		 }
    	
    	 	
     } 
  	
  	
  	
  	public void rentOutVehicle(RentDetails RD) {
  	  	
  			for(int iterator = 0 ; iterator < passengerRecords.size(); iterator++)
 		{
 			   if(passengerRecords.get(iterator).getPassengerID().equals(RD.getPassengerID()) ) {
 				   
 				   passengerRecords.get(iterator).rentOutVehicle(RD);  
 				   
 			   }			
 		}
  	  	
  	}

   	
   	public void HireDriver(HireDetails HD) {
   	   	
		for(int iterator = 0 ; iterator < passengerRecords.size(); iterator++)
 		{
 			   if(passengerRecords.get(iterator).getPassengerID().equals(HD.getPassengerID()) ) {
 				   
 				   passengerRecords.get(iterator).hireDriver(HD);  
 				   
 			   }			
 		}
   	   	
    } 

   	
   	

   	
   	

   	
   	
  	
 	
}
