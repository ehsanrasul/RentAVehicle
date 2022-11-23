package BussinessLogic;

public class Vehicle {

	private String vehicleName ;
	private String vehicleType ;
	private int vehicleID ;
	private String vehicleModel ;
 	private VehicleDescription vd;
	
		
	public Vehicle() {}


	public Vehicle(String vehicleName, String vehicleType, int vehicleID, String vehicleModel, VehicleDescription vd) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vehicleID = vehicleID;
		this.vehicleModel = vehicleModel;
		this.vd = vd;
	}



	public String getVehicleName() {
		return vehicleName;
	}



	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}



	public String getVehicleType() {
		return vehicleType;
	}



	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}



	public int getVehicleID() {
		return vehicleID;
	}



	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}



	public String getVehicleModel() {
		return vehicleModel;
	}



	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}



	public VehicleDescription getVd() {
		return vd;
	}



	public void setVd(VehicleDescription vd) {
		this.vd = vd;
	}



	@Override
	public String toString() {
		return "Vehicle [vehicleName=" + vehicleName + ", vehicleType=" + vehicleType + ", vehicleID=" + vehicleID
				+ ", vehicleModel=" + vehicleModel + ", vehicleDescription = " + vd + "]";
	}
		

	
	
    
	
	
}
