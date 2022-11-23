package BussinessLogic;

public class VehicleDescription {

	private String vehicleColor ;
	private String vehicleBody  ;
	private String vehicleEngine ;
	private double rentAmount ;
	
	public VehicleDescription() {}
	
	public VehicleDescription(String vehicleColor, String vehicleBody, String vehicleEngine, double rentAmount ) {
		super();
		this.vehicleColor = vehicleColor;
		this.vehicleBody = vehicleBody;
		this.vehicleEngine = vehicleEngine;
		this.rentAmount = rentAmount ;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getVehicleBody() {
		return vehicleBody;
	}

	public void setVehicleBody(String vehicleBody) {
		this.vehicleBody = vehicleBody;
	}

	
	public String getVehicleEngine() {
		return vehicleEngine;
	}

	public void setVehicleEngine(String vehicleEngine) {
		this.vehicleEngine = vehicleEngine;
	}
	
	
	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	@Override
	public String toString() {
		return "VehicleDescription [vehicleColor=" + vehicleColor + ", vehicleBody=" + vehicleBody + ", vehicleEngine=" + vehicleEngine + "]";
	}
	
	
	
	
}
