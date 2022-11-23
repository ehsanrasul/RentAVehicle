package BussinessLogic;

import java.util.ArrayList;

public class DriverCatalog {
	
	private ArrayList <Driver> driverRecords = new ArrayList<Driver>();
    private ArrayList <Booking> availableBooking = new ArrayList <Booking>();
    private ArrayList <LuggageBooking> availableLuggageBooking = new ArrayList <LuggageBooking>();
	
		
	public ArrayList<LuggageBooking> getAvailableLuggageBooking() {
		return availableLuggageBooking;
	}

	public void setAvailableLuggageBooking(ArrayList<LuggageBooking> availableLuggageBooking) {
		this.availableLuggageBooking = availableLuggageBooking;
	}

	public ArrayList<Driver> getDriverRecords() {
		return driverRecords;
	}

	public void setDriverRecords(ArrayList<Driver> driverRecords) {
		this.driverRecords = driverRecords;
	}

	public ArrayList<Booking> getAvailableBooking() {
		return availableBooking;
	}

	public void setAvailableBooking(ArrayList <Booking> availableBooking) {
		this.availableBooking = availableBooking;
	}

			
	//Methods		
	public void addAvailableBooking(String bookingID, String vehicleType, String passengerID, String pickupLocation, String dropoffLocation) {
		
		Route route = new Route(pickupLocation, dropoffLocation); 
		availableBooking.add(new Booking(bookingID, 0.00, "N/A", vehicleType, passengerID, route));		
	}
	
	
	public Booking acceptBooking(String bookingID, double fareAmount, String driverID) {
		
		for(int iterator = 0 ; iterator < availableBooking.size(); iterator++) {
			
			if(bookingID.equals(availableBooking.get(iterator).getBookingID())) {	
				
				availableBooking.get(iterator).setFareAmount(fareAmount);
				availableBooking.get(iterator).setDriverID(bookingID);            
				
				Booking booking = new Booking() ; 
                booking = availableBooking.get(iterator); 
				
                availableBooking.remove(iterator);
                
				return booking ;
			}
			
		}
		
		return null; 
    }
	
	
	public boolean rejectBooking(String bookingID) {
		
		
		for(int iterator = 0 ; iterator < availableBooking.size(); iterator++) {
			
			if(bookingID.equals(availableBooking.get(iterator).getBookingID())) {	
		
		        availableBooking.remove(iterator);
                return true;
				
			}
			
		}
		return false;
	}
	
	
	
	public void addDriver(Driver driver) {
		

		driverRecords.add(driver);

		
	}
	
	
	
	public void addAvailableLuggageBooking(String bookingID, String vehicleType, String passengerID, String pickupLocation, String dropoffLocation , String luggageType, String luggageWeight) {
		
		Route route = new Route(pickupLocation, dropoffLocation);
		LuggageBooking LBooking = new LuggageBooking(bookingID, 0.00, "N/A", vehicleType, passengerID, route, luggageWeight, luggageType); 
		availableLuggageBooking.add(LBooking);
	 }
	
	
	public LuggageBooking acceptLuggageBooking(String bookingID, double fareAmount, String driverID) {
		
		for(int iterator = 0 ; iterator < availableLuggageBooking.size(); iterator++) {
			
			if(bookingID.equals(availableLuggageBooking.get(iterator).getBookingID())) {	
				
				availableLuggageBooking.get(iterator).setFareAmount(fareAmount);
				availableLuggageBooking.get(iterator).setDriverID(bookingID);            
				
				LuggageBooking LBooking = new LuggageBooking() ; 
                LBooking = availableLuggageBooking.get(iterator); 
				
                availableLuggageBooking.remove(iterator);
                
				return LBooking ;
			}
			
		}
		
		return null; 
    }

	
	public boolean rejectLuggageBooking(String bookingID) {
		
		
		for(int iterator = 0 ; iterator < availableLuggageBooking.size(); iterator++) {
			
			if(bookingID.equals(availableLuggageBooking.get(iterator).getBookingID())) {	
		
		        availableLuggageBooking.remove(iterator);
                return true;
				
			}
			
		}
		return false;
	}
	
	
	
	
	public boolean addNewHiring(HireDetails HD) {	
		
		
		for(int iterator = 0 ; iterator < driverRecords.size(); iterator++) {
			
			if(HD.getPassengerID().equals(driverRecords.get(iterator).getDriverID())) {	
		
				driverRecords.get(iterator).setHireDetails(HD);;
                return true;
				
			}
			
		}
		
		return false;
    }
	
	
	
	public HireDetails acceptHiring(String hireID, double hireAmount, String driverID) {
		
		for(int iterator = 0 ; iterator < driverRecords.size(); iterator++) {
			
			if(driverID.equals(driverRecords.get(iterator).getDriverID())) {	
				
				driverRecords.get(iterator).getHireDetails().setHireAmount(hireAmount);
				
				HireDetails HD = new HireDetails() ; 
                HD = driverRecords.get(iterator).getHireDetails(); 
				
                driverRecords.get(iterator).setHireDetails(null);;
                
				return HD ;
			}
			
		}
		
		return null; 
    }

	
	
	
	
}
