package BussinessLogic;

public class RentDetails {

	private String rentID ;
	private double rentAmount ;
	private String rentingDate ;
	private String duration ;
	private String returnDate ;
	private Vehicle vehicle ;
	private String passengerID ;
	
	
	public RentDetails(String rentID, double rentAmount, String rentingDate, String duration, String returnDate, Vehicle vehicle) {
		super();
		this.rentID = rentID;
		this.rentAmount = rentAmount;
		this.rentingDate = rentingDate;
		this.duration = duration;
		this.returnDate = returnDate;
		this.vehicle = vehicle ;
	}


	
	public RentDetails(String rentID, double rentAmount, String rentingDate, String duration, String returnDate,
			Vehicle vehicle, String passengerID) {
		super();
		this.rentID = rentID;
		this.rentAmount = rentAmount;
		this.rentingDate = rentingDate;
		this.duration = duration;
		this.returnDate = returnDate;
		this.vehicle = vehicle;
		this.passengerID = passengerID;
	}


	public String getRentID() {
		return rentID;
	}


	public void setRentID(String rentID) {
		this.rentID = rentID;
	}


	public double getRentAmount() {
		return rentAmount;
	}


	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}


	public String getRentingDate() {
		return rentingDate;
	}


	public void setRentingDate(String rentingDate) {
		this.rentingDate = rentingDate;
	}


	public String getDuration() {
		return duration;
	}


	public void setDuration(String duration) {
		this.duration = duration;
	}


	public String getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}



	public Vehicle getVehicle() {
		return vehicle;
	}



	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	

	public String getPassengerID() {
		return passengerID;
	}



	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}



	@Override
	public String toString() {
		return "RentDetails [rentID=" + rentID + ", rentAmount=" + rentAmount + ", rentingDate=" + rentingDate
				+ ", duration=" + duration + ", returnDate=" + returnDate + "]";
	}
	
	
	
	
	
	
	
}
