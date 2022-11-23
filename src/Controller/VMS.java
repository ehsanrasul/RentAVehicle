package Controller;

import java.util.ArrayList;
import Controller.*;
import BussinessLogic.*;
import Database.*;
public class VMS {

	vehicleCatalog VehicleCatalog = new vehicleCatalog();  
	Admin admin = new Admin();
	PassengerCatalog passengerCatalog = new PassengerCatalog();  
	DriverCatalog driverCatalog = new DriverCatalog();  
	Discount discount = new Discount();
	DBHandler handler  = new DBHandler();
	static int accountIndex ;
	
	private static VMS vms = new VMS(); 
	
	public VMS(){
		
		readData();
		
	}
	
	
	//Getter for VMS Singelton  object 
	public static VMS getInstance() {
		
		return vms;
	}
	
	
	
	//This Method Logs the admin into the system  
	public boolean adminLogin(String ID, String password) {
		
		boolean flag = false ;
			
		if(admin.getAdminID().equals(ID) && admin.getAdminPassword().equals(password)) {
			
			flag = true ;
			return flag ;
		}
		
		return flag ;
	}
	
	
	//This Method Registers the Passenger
    public void registerPassenger(String passengerName, String passengerID, String passengerPassword, String passengerEmail, String passengerContactNumber, String DOB, String passengerAddress) {
    	
    	Passenger passenger = new Passenger(passengerName, passengerID, passengerPassword, passengerEmail, passengerContactNumber, DOB, passengerAddress);
        	
    }	
  
    
    //This Method Logs the Passenger into the system  
		public boolean passengerLogin(String ID, String password) {
		
		boolean flag = false ;
		for(int iterator1 = 0; iterator1 < passengerCatalog.getPassengerRecords().size(); iterator1++)
		{
			if(passengerCatalog.getPassengerRecords().get(iterator1).getPassengerID().equals(ID) && passengerCatalog.getPassengerRecords().get(iterator1).getPassengerPassword().equals(password)) {
   		   		
				accountIndex = iterator1;
				flag = true ;
				return flag ;	
			}
		}
		
		return flag ;
	}
	
		
	
	
    
    
	//This Method Logs the driver into the system 
	public boolean driverLogin(String ID, String password) {
		boolean flag = false ;
		
		for(int iterator1 = 0; iterator1 < driverCatalog.getDriverRecords().size(); iterator1++)
		{
			if(driverCatalog.getDriverRecords().get(iterator1).getDriverID().equals(ID) && driverCatalog.getDriverRecords().get(iterator1).getDriverPassword().equals(password)) {
		   		
				accountIndex = iterator1;
				flag = true ;
				return flag ;	
			}
				
		}
		
		return flag ;
	}
	
	
	
	
	/*This Functionality is Managed by Admin  
	  Manage Vehicle
	  Adding Discount  
	  Recruiting Drivers*/  
	
	/*Vehicle Management*/
	public void addVehicle(String vehicleName, String vehicleType, int vehicleID, String vehicleModel, String vehicleColor, String vehicleBody ,String vehicleEngine, double rentAmount )
	{
		VehicleDescription vd = new VehicleDescription (vehicleColor, vehicleBody, vehicleEngine, rentAmount);
		Vehicle vehicleObj = new Vehicle(vehicleName, vehicleType, vehicleID, vehicleModel, vd);
		VehicleCatalog.addVehicle(vehicleObj);	
	}
	
	
	public boolean checkVehicle(int vehicleID) {
		
		return VehicleCatalog.checkVehicle(vehicleID);
	
	}
	
	public Vehicle getVehicle(int vehicleID) {
		
	    return VehicleCatalog.getVehicle(vehicleID);
		
	}
	
	
	public void updateVehicle(String vehicleName, String vehicleType, int vehicleID, String vehicleModel, String vehicleColor, String vehicleBody ,String vehicleEngine, double rentAmount ) {
		
		VehicleCatalog.updateVehicle(vehicleName, vehicleType, vehicleID, vehicleModel, vehicleColor, vehicleBody, vehicleEngine, rentAmount);
		//System.out.println(VehicleCatalog.getVehicleRecords().get(0).toString());	

	}
	
	
	public boolean deleteVehicle(int vehicleID) {
		
		return VehicleCatalog.deleteVehicle(vehicleID);
		
	}
	
	/*Displaying Regular Customers on Screen*/ 
	public void getRegularCustomers() {
        		
		ArrayList <Passenger> regularCustomers = new ArrayList <Passenger>(); 
		passengerCatalog.getRegularCustomers(regularCustomers);

	}	
	
	
	public void giveDiscount(double discountPercentage) {
		
     	discount.setDiscountPercentage(discountPercentage);
	}
	
    /*Driver RecruitMent*/	
	public ArrayList <Driver> recruitDriver() {	
		
		
		return admin.getAvailableDrivers();
	}
	

    /* This Method Recruits the driver */
	public boolean acceptDriver(String driverID) {	
	
		return admin.acceptDriver(driverID, driverCatalog) ;
		
	}
	

	/*Rejecting Driver Request*/
	public boolean rejectDriver(String driverID) {
				
		return admin.removeAvailableDriver(driverID);
	}
	
	
	
	public boolean acceptVehicle(int vehicleID) {
		
	 RentDetails RD = admin.acceptVehicle(vehicleID, VehicleCatalog); 	
	 if(RD == null) return false;	
	 passengerCatalog.rentOutVehicle(RD);	
	 return true;
		 
	} 
	
	public boolean rejectVehicle(int vehicleID) {
		
		 return admin.removeRentOutRequest(vehicleID);
			 
	} 

	
	public ArrayList <RentDetails> getVehicles(){
	
		
		return admin.getAvailableVehicles();
	}
	
	


	/*This Functionality Is Managed By Customer
	  Renting Vehicle
	  Booking Ride
	  Canceling Ride
	  Booking Vehicle for Luggage Transport 
	  Canceling the Booking*/
	


	/* Rent Vehicle */
	public ArrayList <Vehicle> rentVehicle(){
		
		return VehicleCatalog.getVehicleRecords();
	} 
	
	
	public ArrayList<Vehicle> getSpecificTypeVehicle(String vehicleType) {
		
		ArrayList <Vehicle> vt = new ArrayList <Vehicle>(); 
		VehicleCatalog.getSpecificTypeVehicle(vt, vehicleType);
		
		return vt ;
	}
	
	
	
	/*User will enter the Vehicle ID 
	  Get Vehicle Method will be Called*/
	public void enterRentingDetails(int vehicleID, String rentID, String rentingDate, String duration, String returnDate) {
		
		double discountPercentage = discount.getDiscountPercentage();
		passengerCatalog.rentVehicle(vehicleID, rentID, rentingDate, duration, returnDate, VehicleCatalog, accountIndex, discountPercentage);		
	
	}  
	

	
	public void rentOutVehicle(String vehicleName, String vehicleType, int vehicleID, String vehicleModel, String vehicleColor, String vehicleBody ,String vehicleEngine, String rentID, double rentOutPrice, String rentingDate, String duration, String returnDate ) {
		
	 VehicleDescription VD = new VehicleDescription(vehicleColor, vehicleBody, vehicleEngine, 0.00);	
	 Vehicle vehicle = new Vehicle(vehicleName, vehicleType, vehicleID, vehicleModel, VD);
	 String passengerID  =  passengerCatalog.getPassengerRecords().get(accountIndex).getPassengerID();
	 RentDetails rentOutRecords = new RentDetails(rentID, rentOutPrice, rentingDate, duration, returnDate, vehicle, passengerID); 	
	 admin.addAvailableRentOutRecords(rentOutRecords);
		
	}
	
	
	
	
	
	/*Booking a Ride */
	public void bookRide(String bookingID, String vehicleType, String pickupLocation, String dropoffLocation) {
				
		String passengerID  =  passengerCatalog.getPassengerRecords().get(accountIndex).getPassengerID();
		driverCatalog.addAvailableBooking(bookingID, vehicleType, passengerID, pickupLocation, dropoffLocation);
		
	} 

	
	
	/*Cancel Booking
     This Method Cancels Confirmed and UnConfirmed Bookings*/	
	public boolean cancelBooking(String bookingID) {
		
		String passengerID  =  passengerCatalog.getPassengerRecords().get(accountIndex).getPassengerID();
	   	boolean flag1 = driverCatalog.rejectBooking(bookingID);
		boolean flag2 = passengerCatalog.deleteBooking(bookingID, passengerID);
		if(flag1 == true || flag2 == true) return true;
		else return false;
	
	
	}
	
	
	/* Booking a Ride for Luggage Transport */
	public void LuggageTrasport(String bookingID, String vehicleType, String pickupLocation, String dropoffLocation, String luggageType, String luggageWeight) {
		
		String passengerID  =  passengerCatalog.getPassengerRecords().get(accountIndex).getPassengerID();
		driverCatalog.addAvailableLuggageBooking(bookingID, vehicleType, passengerID, pickupLocation, dropoffLocation, luggageType, luggageWeight);
	} 
	
	
	/* Canceling the Luggage Transportation Booking  */
	public boolean cancelLuggageBooking(String bookingID) {
		
		String passengerID  =  passengerCatalog.getPassengerRecords().get(accountIndex).getPassengerID();
		boolean flag1 = driverCatalog.rejectLuggageBooking(bookingID);
		boolean flag2 = passengerCatalog.deleteLuggageBooking(bookingID, passengerID);
	    if(flag1 == true || flag2 == true) return true;
		else return false;
	
	}
 
	 
	 
	public ArrayList<Driver> getDrivers(){ 
		
    return driverCatalog.getDriverRecords();
    
	}


	
	
	 public boolean hireDriver(String driverID, String hireID, String hiringDate, String hireEndDate) { 
	   	 
		 String passengerID  =  passengerCatalog.getPassengerRecords().get(accountIndex).getPassengerID();
		 HireDetails HD = new HireDetails(hireID, driverID, 0.00, hiringDate, hireEndDate, passengerID); 
		 return driverCatalog.addNewHiring(HD);  
	 }	


	 /*This Module Manages the Functionality of Driver
	   Accepting a Ride
	   Accepting a Luggage Transportation Request*/


	/* Accepting a Booking */
	public ArrayList<Booking> getAvailableBookings(){
		
	  return driverCatalog.getAvailableBooking();	
	}
	
	
	public ArrayList<LuggageBooking> getAvailableLuggageBookings(){
		
		  return driverCatalog.getAvailableLuggageBooking();	
	}
	
	public boolean acceptBooking(String bookingID, double fareAmount) {
		
		String driverID  =  driverCatalog.getDriverRecords().get(accountIndex).getDriverID();
		Booking booking = new Booking() ; 	
		booking  = driverCatalog.acceptBooking(bookingID, fareAmount, driverID);
		if(booking != null) {
		  passengerCatalog.addBooking(booking);
		  return true;	
			
		}else return false;
		
	}
	
	public void rejectBooking(String bookingID) {
		
		driverCatalog.rejectBooking(bookingID);
		
	}
	
    /*Accepting a Luggage Transportation Request */ 
	public boolean acceptLuggageBooking(String bookingID, double fareAmount) {

		String driverID  =  driverCatalog.getDriverRecords().get(accountIndex).getDriverID();
		LuggageBooking LBooking = new LuggageBooking() ; 	
		LBooking = driverCatalog.acceptLuggageBooking(bookingID, fareAmount, driverID);
		if(LBooking != null) {
			passengerCatalog.addLuggageBooking(LBooking);
			return true;	
			
		}else return false;
	
	}

	
	public void rejectLuggageBooking(String bookingID) {
	
	   driverCatalog.rejectBooking(bookingID);
	
	}
	
	
	
	public boolean acceptHiring(String hireID, double hireAmount) {	
		
		String driverID  =  driverCatalog.getDriverRecords().get(accountIndex).getDriverID();
		HireDetails HD = new HireDetails() ; 	
		HD  = driverCatalog.acceptHiring(hireID, hireAmount, driverID);
		if(HD != null) {
		  passengerCatalog.HireDriver(HD);
		  return true;	
			
		}else return false;
		
    }
	
	
	
   public void display() {
	   
	   
		for(int i = 0 ; i < admin.getAvailableVehicles().size(); i++ )
		{
			
			//System.out.println("index");
			//System.out.println(admin.getAvailableVehicles().get(i).toString());
			
			
		}
		

	   
	   
   }	
	
	
	
	
   /*  These Methods are used as Helpers for DataBase Management  */	
	public void readData() {
		
		 handler.connectDB();
		 handler.readAvailableDrivers(admin.getAvailableDrivers());
		 handler.readPassenger(passengerCatalog.getPassengerRecords());
		 handler.readVehicle(VehicleCatalog.getVehicleRecords());
		 handler.readDriver(driverCatalog.getDriverRecords());
		 handler.readAvailableBookings(driverCatalog.getAvailableBooking()); 
		 handler.readAvailableLuggageBookings(driverCatalog.getAvailableLuggageBooking());
		 handler.readAvailableVehicles(admin.getAvailableVehicles());
		 
		 
	} 

	
	public void writeData() {
		
		 handler.connectDB();
	 	 handler.writeVehicles(VehicleCatalog.getVehicleRecords());
	     handler.writePassenger(passengerCatalog.getPassengerRecords());
	     handler.writeDriver(driverCatalog.getDriverRecords());
	     handler.writeAvailableBookings(driverCatalog.getAvailableBooking());
	 	 handler.writeAvailableDriver(admin.getAvailableDrivers());
	 	 handler.writeAvailableLuggageBookings(driverCatalog.getAvailableLuggageBooking());
	 	 handler.writeAvailableVehicles(admin.getAvailableVehicles());
	 	 display();
	 	 
	}

	
}
