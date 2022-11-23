package Database;

import java.util.ArrayList;
import BussinessLogic.Passenger;
import BussinessLogic.*;

public interface  PersistanceHandler {
	abstract void connectDB();
	abstract void readPassenger(ArrayList <Passenger> passenger);
	abstract void readDriver(ArrayList <Driver> driver);
	abstract void readVehicle(ArrayList <Vehicle> vehicle);
	abstract void readBookings(ArrayList <Booking> booking); 
	abstract void readAvailableLuggageBookings(ArrayList <LuggageBooking> LBooking); 
	abstract void readAvailableDrivers(ArrayList <Driver> driver);
	abstract void readAvailableBookings(ArrayList <Booking> booking); 
	abstract void readLuggageBookings(ArrayList <LuggageBooking> LBooking); 
	abstract void readRentDetails(ArrayList <RentDetails> rentDetails);
}
