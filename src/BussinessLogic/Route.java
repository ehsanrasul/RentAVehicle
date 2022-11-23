package BussinessLogic;

public class Route {

	
	private String pickupLocation ; 
	private String dropoffLocation ;
    private String distance ;

	
    public Route() {}
	


	public Route(String pickupLocation, String dropoffLocation) {
		super();
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;
	}


	public String getPickupLocation() {
		return pickupLocation;
	}


	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}


	public String getDropoffLocation() {
		return dropoffLocation;
	}


	public void setDropoffLocation(String dropoffLocation) {
		this.dropoffLocation = dropoffLocation;
	}


	public String getDistance() {
		return distance;
	}


	public void setDistance(String distance) {
		this.distance = distance;
	}



	@Override
	public String toString() {
		return "Route [pickupLocation=" + pickupLocation + ", dropoffLocation=" + dropoffLocation + ", distance="
				+ distance + "]";
	}
	  
    
	

	

	
	
}
