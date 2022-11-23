package BussinessLogic;

public class Booking {

	private String bookingID ;
	private double fareAmount ;
	private String driverID ;
    private String vehicleType;
	private String passengerID;
	private Route route ;
	
	
	public Booking() {}


	public Booking(String bookingID, double fareAmount, String driverID, String vehicleType, String passengerID,
			Route route) {
		super();
		this.bookingID = bookingID;
		this.fareAmount = fareAmount;
		this.driverID = driverID;
		this.vehicleType = vehicleType;
		this.passengerID = passengerID;
		this.route = route;
	}


	public String getBookingID() {
		return bookingID;
	}


	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}


	public double getFareAmount() {
		return fareAmount;
	}


	public void setFareAmount(double fareAmount) {
		this.fareAmount = fareAmount;
	}


	public String getDriverID() {
		return driverID;
	}


	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public String getPassengerID() {
		return passengerID;
	}


	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}


	public Route getRoute() {
		return route;
	}


	public void setRoute(Route route) {
		this.route = route;
	}


	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", fareAmount=" + fareAmount + ", driverID=" + driverID
				+ ", vehicleType=" + vehicleType + ", passengerID=" + passengerID + ", route=" + route + "]";
	}

	
	
		
	
	
		
	
}
