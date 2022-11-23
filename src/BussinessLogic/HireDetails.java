package BussinessLogic;

public class HireDetails {
	
	private String hireID ;
	private String driverID;
	private double hireAmount ;
	private String hiringDate ;
	private String hireEndDate ;
	private String passengerID ;

	public HireDetails() {}

	public HireDetails(String hireID, String driverID, double hireAmount, String hiringDate, String hireEndDate,
			String passengerID) {
		super();
		this.hireID = hireID;
		this.driverID = driverID;
		this.hireAmount = hireAmount;
		this.hiringDate = hiringDate;
		this.hireEndDate = hireEndDate;
		this.passengerID = passengerID;
	}



	public String getHireID() {
		return hireID;
	}
	public void setHireID(String hireID) {
		this.hireID = hireID;
	}
	public double getHireAmount() {
		return hireAmount;
	}
	public void setHireAmount(double hireAmount) {
		this.hireAmount = hireAmount;
	}
	public String getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(String hiringDate) {
		this.hiringDate = hiringDate;
	}
	public String getHireEndDate() {
		return hireEndDate;
	}
	public void setHireEndDate(String hireEndDate) {
		this.hireEndDate = hireEndDate;
	}
	public String getPassengerID() {
		return passengerID;
	}
	public void setPassengerID(String passengerID) {
		this.passengerID = passengerID;
	}

	public String getDriverID() {
		return driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

    
	
	
	
	

}
