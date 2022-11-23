package BussinessLogic;

import java.util.ArrayList;

public class Passenger {

    private String passengerName;
	private String passengerID;
	private String passengerPassword;
	private String passengerEmail; 
	private String contactNumber;
	private String DOB; 
	private String passengerAddress; 
	private int vehicleRentalCount;
	
	
	public ArrayList <RentDetails> rentingRecords = new ArrayList <RentDetails>();
	public ArrayList <RentDetails> rentingOutRecords = new ArrayList <RentDetails>();
	public ArrayList <Booking> bookingRecords = new ArrayList <Booking>();
	public ArrayList <LuggageBooking> LBookingRecords = new ArrayList <LuggageBooking>();
	public ArrayList <HireDetails>   hireRecords  = new ArrayList <HireDetails>();
	
	
	public Passenger(String passengerName, String passengerID, String passengerPassword, String passengerEmail,
			String contactNumber, String dOB, String passengerAddress) {
		super();
		this.passengerName = passengerName;
		this.passengerID = passengerID;
		this.passengerPassword = passengerPassword;
		this.passengerEmail = passengerEmail;
		this.contactNumber = contactNumber;
		DOB = dOB;
		this.passengerAddress = passengerAddress;
		this.vehicleRentalCount = 0;
	}

 	
	public Passenger(String passengerName, String passengerID, String passengerPassword, String passengerEmail,
			String contactNumber, String dOB, String passengerAddress, int vehicleRentalCount) {
		super();
		this.passengerName = passengerName;
		this.passengerID = passengerID;
		this.passengerPassword = passengerPassword;
		this.passengerEmail = passengerEmail;
		this.contactNumber = contactNumber;
		DOB = dOB;
		this.passengerAddress = passengerAddress;
		this.vehicleRentalCount = vehicleRentalCount;
	}




	
	
	
	
	

	public ArrayList<RentDetails> getRentingOutRecords() {
		return rentingOutRecords;
	}


	public void setRentingOutRecords(ArrayList<RentDetails> rentingOutRecords) {
		this.rentingOutRecords = rentingOutRecords;
	}


	public ArrayList<HireDetails> getHireRecords() {
		return hireRecords;
	}


	public void setHireRecords(ArrayList<HireDetails> hireRecords) {
		this.hireRecords = hireRecords;
	}


	public String getPassengerName() {
		return passengerName;
	}


	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}


	public String getPassengerID() {
		return passengerID;
	}


	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}


	public String getPassengerPassword() {
		return passengerPassword;
	}


	public void setPassengerPassword(String passengerPassword) {
		this.passengerPassword = passengerPassword;
	}


	public String getPassengerEmail() {
		return passengerEmail;
	}


	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public String getPassengerAddress() {
		return passengerAddress;
	}


	public void setPassengerAddress(String passengerAddress) {
		this.passengerAddress = passengerAddress;
	}


	public int getVehicleRentalCount() {
		return vehicleRentalCount;
	}


	public void setVehicleRentalCount(int vehicleRentalCount) {
		this.vehicleRentalCount = vehicleRentalCount;
	}


	public ArrayList<RentDetails> getRentingRecords() {
		return rentingRecords;
	}


	public void setRentingRecords(ArrayList<RentDetails> rentingRecords) {
		this.rentingRecords = rentingRecords;
	}


	public ArrayList<Booking> getBookingRecords() {
		return bookingRecords;
	}


	public void setBookingRecords(ArrayList<Booking> bookingRecords) {
		this.bookingRecords = bookingRecords;
	}
	
	
		
	public ArrayList<LuggageBooking> getLBookingRecords() {
		return LBookingRecords;
	}




	public void setLBookingRecords(ArrayList<LuggageBooking> lBookingRecords) {
		LBookingRecords = lBookingRecords;
	}




	@Override
	public String toString() {
		return "Passenger [passengerName=" + passengerName + ", passengerID=" + passengerID + ", passengerPassword="
				+ passengerPassword + ", passengerEmail=" + passengerEmail + ", contactNumber=" + contactNumber
				+ ", DOB=" + DOB + ", passengerAddress=" + passengerAddress + ", vehicleRentalCount="
				+ vehicleRentalCount + ", rentingRecords=" + rentingRecords + ", bookingRecords=" + bookingRecords
				+ ", LBookingRecords=" + LBookingRecords + "]";
	}




	//Renting a vehicle
	public void rentVehicle(String rentID, double rentAmount,  String rentingDate, String duration, String returnDate, Vehicle vehicle) {
				
		rentingRecords.add(new RentDetails(rentID, rentAmount, rentingDate, duration, returnDate, vehicle, passengerID));
		
	}
 	
	 
	//Renting out a vehicle
	public void rentOutVehicle(RentDetails rentOutDetails) {
					
	rentingOutRecords.add(rentOutDetails);
			
	}
	
	
    public void bookRide(Booking booking) {		
		
	 bookingRecords.add(booking);	
		
    }
 	
 	
		
    public void cancelBooking(String bookingID) {		
		
    	for(int iterator = 0 ; iterator < bookingRecords.size(); iterator++) {
			
			if(bookingID.equals(bookingRecords.get(iterator).getBookingID())) {	
		
		        bookingRecords.remove(iterator);
                return;
				
			}
			
		}	
   		
    }

    
    
    public void LuggageBooking(LuggageBooking LBooking) {		
		
	 LBookingRecords.add(LBooking);	
			
    }
 	
    
    
    public void cancelLuggageBooking(String bookingID) {		
		
    	for(int iterator = 0 ; iterator < LBookingRecords.size(); iterator++) {
			
			if(bookingID.equals(LBookingRecords.get(iterator).getBookingID())) {	
		
		        LBookingRecords.remove(iterator);
                return;
				
			}
			
		}	
   		
    }


    
    public void hireDriver(HireDetails HD) {
        
    	hireRecords.add(HD);

    }



    




}
