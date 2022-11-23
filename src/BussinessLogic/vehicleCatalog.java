package BussinessLogic;

import java.util.ArrayList;

public class vehicleCatalog {

	ArrayList <Vehicle> vehicleRecords = new ArrayList <Vehicle>();
	ArrayList <Vehicle> regularRecords = new ArrayList <Vehicle>();
	

				
	public ArrayList<Vehicle> getVehicleRecords() {
		return vehicleRecords;
	}

	public void setVehicleRecords(ArrayList<Vehicle> vehicleRecords) {
		this.vehicleRecords = vehicleRecords;
	}

	public ArrayList<Vehicle> getRegularRecords() {
		return regularRecords;
	}

	public void setRegularRecords(ArrayList<Vehicle> regularRecords) {
		this.regularRecords = regularRecords;
	}
	
	

	//Add Vehicle
	public void addVehicle(Vehicle vehicleObj ) {
		
			vehicleRecords.add(vehicleObj);
				
	}
	
	//Delete Vehicle
	public boolean deleteVehicle(int ID) {
		boolean flag = false ;
		for(int i = 0 ; i < vehicleRecords.size(); i++)
		{
			if(vehicleRecords.get(i).getVehicleID() == ID)
			{
			   vehicleRecords.remove(i);
				flag = true ;
				return flag ;
			}
		}
		return flag;
	}
	

	//Display Records
	public void displayRecords() {
		
		for(int i = 0 ; i < vehicleRecords.size(); i++)
		{
			   System.out.println(vehicleRecords.get(i).toString());
							
		}
		
	}
	
	
	public boolean checkVehicle(int vehicleID) {
		
		
		for(int iterator = 0 ; iterator < vehicleRecords.size(); iterator++)
		{
			   if(vehicleID == vehicleRecords.get(iterator).getVehicleID()) {
				   
				   return true ;
				   
			   }			
		}
		
		return false ;
		
	}
	
	
	public int getVehicleIndex(int vehicleID) {
		
		
		for(int iterator = 0 ; iterator < vehicleRecords.size(); iterator++)
		{
			   if(vehicleID == vehicleRecords.get(iterator).getVehicleID()) {
				   
				   return iterator ;
				   
			   }			
		}
		
		return -1 ;
		
	}
	
	
	
	public Vehicle getVehicle(int vehicleID) {
		
		Vehicle vehicle = new Vehicle();
		
		for(int iterator = 0 ; iterator < vehicleRecords.size(); iterator++)
		{
			   if(vehicleID == vehicleRecords.get(iterator).getVehicleID()) {
				   
				    vehicle = vehicleRecords.get(iterator);
				    return vehicle ; 
			   }			
		}
		
			return vehicle ;
	}
	
	 
	 public void updateVehicle(String vehicleName, String vehicleType, int vehicleID, String vehicleModel, String vehicleColor, String vehicleBody ,String vehicleEngine, double rentAmount ) {
		 
		 
        int index = getVehicleIndex(vehicleID);		 
		 
        VehicleDescription vd = new VehicleDescription (vehicleColor, vehicleBody, vehicleEngine, rentAmount);
		Vehicle vehicleObj = new Vehicle(vehicleName, vehicleType, vehicleID, vehicleModel, vd);
			
	    vehicleRecords.set(index, vehicleObj);
		 
	 }
	 
	 
	 // VT is vehicles of a specific Type
	 public void getSpecificTypeVehicle(ArrayList <Vehicle> vt, String vehicleType) {
		 
		 for(int iterator = 0 ; iterator < vehicleRecords.size(); iterator++)
			{
				   if(vehicleRecords.get(iterator).getVehicleType().equalsIgnoreCase(vehicleType)) {
					   
					    vt.add(vehicleRecords.get(iterator)); 
				   }			
			}
		 
		 
		} 

   }
