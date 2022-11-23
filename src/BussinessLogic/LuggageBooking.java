package BussinessLogic;

public class LuggageBooking extends Booking {

	private String luggageWeight ;
	private String luggageType ;
	

	public LuggageBooking() {}	

	
	
	public LuggageBooking(String bookingID, double fareAmount, String driverID, String vehicleType, String passengerID,
			Route route, String luggageWeight, String luggageType) {
		super(bookingID, fareAmount, driverID, vehicleType, passengerID, route);
		this.luggageWeight = luggageWeight;
		this.luggageType = luggageType;
	}


	public String getLuggageWeight() {
		return luggageWeight;
	}


	public void setLuggageWeight(String luggageWeight) {
		this.luggageWeight = luggageWeight;
	}


	public String getLuggageType() {
		return luggageType;
	}


	public void setLuggageType(String luggageType) {
		this.luggageType = luggageType;
	}
	
	
	
	
}
