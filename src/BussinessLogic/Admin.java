package BussinessLogic;

import java.util.ArrayList;

public class Admin {

	private String adminID = "AD9999" ;
	private String adminPassword = "CR7" ;
	private ArrayList <Driver> availableDrivers = new ArrayList<Driver>();
	private ArrayList <RentDetails> availableVehicles = new ArrayList<RentDetails>();
	
		
	public String getAdminID() {
		return this.adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public ArrayList<Driver> getAvailableDrivers() {
		return availableDrivers;
	}
	public void setAvailableDrivers(ArrayList<Driver> availableDrivers) {
		this.availableDrivers = availableDrivers;
	}
		
	public ArrayList<RentDetails> getAvailableVehicles() {
		return availableVehicles;
	}
	public void setAvailableVehicles(ArrayList<RentDetails> availableVehicles) {
		this.availableVehicles = availableVehicles;
	}
	
	
	
	public void addAvailableDriver(Driver driver) {	
		
	availableDrivers.add(driver);	
		
	}
						
	
	public void addAvailableRentOutRecords(RentDetails RD) {	
		
		availableVehicles.add(RD);	
			
	}
	
	
	
	public boolean removeAvailableDriver(String driverID) {	
		
		boolean flag = false ;
		for(int iterator = 0 ; iterator < availableDrivers.size(); iterator++) {
			
			if(driverID.equals(availableDrivers.get(iterator).getDriverID())) {	
		
		        availableDrivers.remove(iterator);
		        flag = true ;
                return flag;
				
			}
			
		}	
		
			return flag ;
	}
	
	
	
	public boolean acceptDriver(String driverID, DriverCatalog driverCatalog) {	
		
		boolean flag = false ;
		for(int iterator = 0 ; iterator < getAvailableDrivers().size(); iterator++) {
			if(driverID.equals(getAvailableDrivers().get(iterator).getDriverID())) {	
				addDriver(getAvailableDrivers().get(iterator), driverCatalog);
		        getAvailableDrivers().remove(iterator);
		        flag = true ; 
                return flag;
			}
		}
		return flag ;
	}
	
	
    public void addDriver(Driver driver, DriverCatalog driverCatalog) {
    	
    	driverCatalog.addDriver(driver);
        	
    }	


   
    public RentDetails acceptVehicle(int vehicleID, vehicleCatalog VehicleCatalog) {	
		
		boolean flag = false ;
		for(int iterator = 0 ; iterator < availableVehicles.size(); iterator++) {
			if(vehicleID == availableVehicles.get(iterator).getVehicle().getVehicleID()) {	
				addVehicle(availableVehicles.get(iterator).getVehicle(), VehicleCatalog);
				RentDetails obj =getAvailableVehicles().get(iterator);
		        getAvailableVehicles().remove(iterator);
                return obj;
			}
		}
		return null;
	}


    public void addVehicle(Vehicle vehicle, vehicleCatalog VehicleCatalog) {
    	
    	VehicleCatalog.addVehicle(vehicle);
    	
    }
    
  
    public boolean removeRentOutRequest(int vehicleID) {

    	boolean flag = false ;
		for(int iterator = 0 ; iterator < availableVehicles.size(); iterator++) {
			
			if(vehicleID == availableVehicles.get(iterator).getVehicle().getVehicleID()) {	
		
		        availableVehicles.remove(iterator);
		        flag = true ;
                return flag;
				
			}
			
		}	
		
	return flag ;
	
    }  
    
}
