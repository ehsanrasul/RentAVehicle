package Database;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;
import Controller.*;
import BussinessLogic.*;
import BussinessLogic.Driver;
public class DBHandler implements PersistanceHandler {
	
	
	Connection con = null;
   
	/*Connecting DB*/
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/VMS", "root", "");
			if (con == null) {
				System.out.println("DB connection failed");
			} else
				System.out.println("DB connection successful");
		} catch (Exception e) {
			System.out.println("exception: " + e);
		}

	}
	
	
	
    /*Reading the entire Data from tables and Storing it 	
	into different ArrayList*/
	@Override
	public void readPassenger(ArrayList <Passenger> passenger) {
		// TODO Auto-generated method stub

		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from Passenger";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
			
			Passenger p = new Passenger(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)); 
			
			ArrayList <Booking> booking = new ArrayList <Booking>() ;
			ArrayList <RentDetails> rentDetails = new ArrayList <RentDetails>() ;
			ArrayList <LuggageBooking> LBooking = new ArrayList <LuggageBooking>() ;
			ArrayList <RentDetails> rentOutDetails = new ArrayList <RentDetails>() ;
			ArrayList <HireDetails> hireDetails = new ArrayList <HireDetails>() ;
			
			
			readBookings(booking);
			readRentDetails(rentDetails);
			readLuggageBookings(LBooking);	
			readRentOutDetails(rentOutDetails);
			//readHireDetails(hireDetails);
					
			for(int i = 0 ; i < booking.size(); i++) {
				if(p.getPassengerID().equals(booking.get(i).getPassengerID()) ) {				
					p.bookingRecords.add(booking.get(i));
				}
			} 
			
			
			for(int i = 0 ; i < rentDetails.size(); i++) {
				if(p.getPassengerID().equals(rentDetails.get(i).getPassengerID())) {				
					p.rentingRecords.add(rentDetails.get(i));
				}
			}
			
			for(int i = 0 ; i < LBooking.size(); i++) {
				if(p.getPassengerID().equals(LBooking.get(i).getPassengerID())){				
					p.LBookingRecords.add(LBooking.get(i));
				}
			} 
			
			for(int i = 0 ; i < rentOutDetails.size(); i++) {
				if(p.getPassengerID().equals(rentOutDetails.get(i).getPassengerID())) {				
					p.rentingOutRecords.add(rentOutDetails.get(i));
				}
			}
			
			
			for(int i = 0 ; i < hireDetails.size(); i++) {
				if(p.getPassengerID().equals(hireDetails.get(i).getPassengerID())) {				
					p.hireRecords.add(hireDetails.get(i));
				}
			}
			
			passenger.add(p);
					
 	}
			//con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}

	}

	public void readDriver(ArrayList <Driver> driver) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from Driver";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				ArrayList <HireDetails> hireDetails = new ArrayList <HireDetails>() ;
			    /*readHireRequests(hireDetails);
				HireDetails hd = new HireDetails(); 	
				
				for(int i = 0 ; i < hireDetails.size(); i++) {
					if(rs.getString(2).equals(hireDetails.get(i).getDriverID())) {				
						hd = hireDetails.get(i);
					}
				}*/
				
				
				Driver d = new Driver(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)); 
				driver.add(d);
			    
			}
			//con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}

	}

	
	
	public void readAvailableVehicles(ArrayList <RentDetails> availableVehicles) {
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from availableVehicles";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
					VehicleDescription vd = new VehicleDescription(rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8));
					Vehicle v = new Vehicle(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), vd); 
					RentDetails RD = new RentDetails(rs.getString(9), rs.getDouble(10), rs.getString(11), rs.getString(12), rs.getString(13), v ,rs.getString(14));
					availableVehicles.add(RD);
			
			}
			//con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}

		
   }
	
	
	
	
	
	public void readVehicle(ArrayList <Vehicle> vehicle) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from Vehicle V JOIN VehicleDescription VD ON V.vehicleID = VD.vehicleID";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
					VehicleDescription vd = new VehicleDescription(rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9));
					Vehicle v = new Vehicle(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), vd); 
					vehicle.add(v);
			
			}
			//con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}


	}


	

	@Override
	public void readBookings(ArrayList<Booking> booking) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from bookings";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				Route r = new Route(rs.getString(6), rs.getString(7));
				Booking b = new Booking(rs.getString(1), Double.parseDouble(rs.getString(2)), rs.getString(3), rs.getString(4), rs.getString(5), r); 
				booking.add(b);
				
			
			}
			//con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}


	
	}

	@Override
	public void readAvailableLuggageBookings(ArrayList<LuggageBooking> LBooking) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from availableLuggageBookings";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				Route r = new Route(rs.getString(6), rs.getString(7));
				LuggageBooking LB = new LuggageBooking(rs.getString(1), Double.parseDouble(rs.getString(2)), rs.getString(3), rs.getString(4), rs.getString(5), r, rs.getString(8), rs.getString(9)); 
				LBooking.add(LB);
				
			
			}
			//con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}
	}


	

	@Override
	public void readAvailableDrivers(ArrayList<Driver> driver) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from availableDriver";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				Driver d = new Driver(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)); 
				driver.add(d);
			
			}
			//con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}
		
	}
	

	@Override
	public void readAvailableBookings(ArrayList<Booking> booking) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from availableRides";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				Route r = new Route(rs.getString(6), rs.getString(7));
				Booking b = new Booking(rs.getString(1), Double.parseDouble(rs.getString(2)), rs.getString(3), rs.getString(4), rs.getString(5), r); 
				booking.add(b);
				
			
			}
			//con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}

		
	}

	@Override
	public void readLuggageBookings(ArrayList<LuggageBooking> LBooking) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from LuggageBookings";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				Route r = new Route(rs.getString(6), rs.getString(7));
				LuggageBooking LB = new LuggageBooking(rs.getString(1), Double.parseDouble(rs.getString(2)), rs.getString(3), rs.getString(4), rs.getString(5), r, rs.getString(8), rs.getString(9)); 
				LBooking.add(LB);
			
			}
			//con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}
		
	}

	@Override
	public void readRentDetails(ArrayList<RentDetails> rentDetails) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from rentDetails";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ArrayList <Vehicle> vehicle = new ArrayList <Vehicle>(); 
				readVehicle(vehicle);
				
				Vehicle v = new Vehicle();
				
				for(int i = 0 ; i < vehicle.size(); i++) {
					if(Integer.parseInt(rs.getString(6)) == vehicle.get(i).getVehicleID()) {				
				
						v = vehicle.get(i);
						
					}
				} 
					
				
				RentDetails RD = new RentDetails(rs.getString(1), Double.parseDouble(rs.getString(2)), rs.getString(3), rs.getString(4), rs.getString(5), v, rs.getString(7)); 
				rentDetails.add(RD);
			
			}
			//con.close();
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}
		
		
	}
	
	
	
	
	
	public void readRentOutDetails(ArrayList<RentDetails> rentDetails) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from rentOutDetails";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ArrayList <Vehicle> vehicle = new ArrayList <Vehicle>(); 
				readVehicle(vehicle);
				
				Vehicle v = new Vehicle();
				
				for(int i = 0 ; i < vehicle.size(); i++) {
					if(Integer.parseInt(rs.getString(6)) == vehicle.get(i).getVehicleID()) {				
				
						v = vehicle.get(i);
						
					}
				} 
				
				RentDetails RD = new RentDetails(rs.getString(1), Double.parseDouble(rs.getString(2)), rs.getString(3), rs.getString(4), rs.getString(5), v, rs.getString(7)); 
				rentDetails.add(RD);
			
			}
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}
		
		
	}
	
	
	
	public void readHireDetails(ArrayList<HireDetails> hireDetails) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from hireDetails";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				HireDetails HD  = new HireDetails(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getString(6)); 
				hireDetails.add(HD);
			
			}
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}
		
		
	}
	

	public void readHireRequests(ArrayList<HireDetails> hireRequests) {
		Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "Select * from hireRequest";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				HireDetails HD  = new HireDetails(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getString(6)); 
				hireRequests.add(HD);
			
			}
		}

		catch (SQLException e) {

			System.out.println("exception: " + e);
		}
		
		
	}

	

	
    /*Adding new Records in the Tables 	
	and Adding new Records*/ 

	public void writeVehicles(ArrayList <Vehicle> vehicles) {
	
		deleteVehicle();
		deleteVehicleDescription();
		String sql = "INSERT INTO Vehicle (vehicleName, vehicleType, vehicleID, vehicleModel) VALUES(?, ?, ?, ?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			
			for(int i = 0 ; i < vehicles.size(); i++) {
				statement.setString(1, vehicles.get(i).getVehicleName());
				statement.setString(2, vehicles.get(i).getVehicleType());
				statement.setString(3, Integer.toString(vehicles.get(i).getVehicleID()));
				statement.setString(4, vehicles.get(i).getVehicleModel());
				writeVehicleDescription(vehicles.get(i).getVd(), vehicles.get(i).getVehicleID());
				
				statement.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}	
	
	public void writeVehicleDescription(VehicleDescription VD, int vehicleID) {
	   	
		String sql = "INSERT INTO VehicleDescription (vehicleID, vehicleColor, vehicleBody, vehicleEngine, rentAmount) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement statement;
		try {
	
				statement = con.prepareStatement(sql);
				statement.setString(1, Integer.toString(vehicleID));
				statement.setString(2, VD.getVehicleColor());
				statement.setString(3, VD.getVehicleBody());
				statement.setString(4, VD.getVehicleEngine());
				statement.setString(5, Double.toString(VD.getRentAmount()));
				
				statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}	
	
	
	public void writeAvailableVehicles(ArrayList <RentDetails> availableVehicles) {
		
		deleteAvailableVehicles();
		//deleteVehicleDescription();
		String sql = "INSERT INTO availableVehicles (vehicleName, vehicleType, vehicleID, vehicleModel, vehicleColor, vehicleBody, vehicleEngine, fareAmount, rentID, rentOutPrice, rentingDate, duration, returnDate, passengerID) VALUES(?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			
			for(int i = 0 ; i < availableVehicles.size(); i++) {
				statement.setString(1, availableVehicles.get(i).getVehicle().getVehicleName());
				statement.setString(2, availableVehicles.get(i).getVehicle().getVehicleType());
				statement.setString(3, Integer.toString(availableVehicles.get(i).getVehicle().getVehicleID()));
				statement.setString(4, availableVehicles.get(i).getVehicle().getVehicleModel());
				statement.setString(5, availableVehicles.get(i).getVehicle().getVd().getVehicleColor());
				statement.setString(6, availableVehicles.get(i).getVehicle().getVd().getVehicleBody());
				statement.setString(7, availableVehicles.get(i).getVehicle().getVd().getVehicleEngine());
				statement.setString(8, Double.toString(availableVehicles.get(i).getVehicle().getVd().getRentAmount()));
				statement.setString(9, availableVehicles.get(i).getRentID());
				statement.setString(10, Double.toString(availableVehicles.get(i).getRentAmount()));
				statement.setString(11, availableVehicles.get(i).getRentingDate());
				statement.setString(12, availableVehicles.get(i).getDuration());
				statement.setString(13, availableVehicles.get(i).getReturnDate());
				//statement.setString(14, Integer.toString(availableVehicles.get(i).getVehicle().getVehicleID()));
				statement.setString(14, availableVehicles.get(i).getPassengerID());
		
				
				statement.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}	
	

	
	
	
	
	
	
	
	
	public void writePassenger(ArrayList <Passenger> p) {
		
		deletePassenger();
		deleteBookings();
		deleteLuggageBookings();
		deleteRentalDetails();
		deleteHireDetails(); 
		deleteRentOutRecords(); 
		 
		 
		String sql = "INSERT INTO Passenger (passengerName, passengerID, passengerPassword, passengerEmail, passengerContactNumber, DOB, passengerAddress, vehicleRentalCount) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		try {
			
			statement = con.prepareStatement(sql);
			
			for(int i = 0 ; i < p.size(); i++) {
				
				writeRentingRecords(p.get(i).rentingRecords);
				writeBookings(p.get(i).getBookingRecords());
				writeLuggageBookings(p.get(i).LBookingRecords);
				//writeHireRecords(p.get(i).hireRecords);
				writeRentOutRecords(p.get(i).rentingOutRecords);
				
				
				statement.setString(1, p.get(i).getPassengerName());
				statement.setString(2, p.get(i).getPassengerID());
				statement.setString(3, p.get(i).getPassengerPassword());
				statement.setString(4, p.get(i).getPassengerEmail());
				statement.setString(5, p.get(i).getContactNumber());
				statement.setString(6, p.get(i).getDOB());
				statement.setString(7, p.get(i).getPassengerAddress());
				statement.setString(8, Integer.toString( p.get(i).getVehicleRentalCount()));
				
				
				statement.executeUpdate();
//				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}	
	public void writeBookings(ArrayList <Booking> b) {
		
		String sql = "INSERT INTO bookings (bookingID, fareAmount, driverID, vehicleType, passengerID, pickupLocation, dropoffLocation) VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		try {
			
			statement = con.prepareStatement(sql);
			  
			for(int i = 0 ; i < b.size(); i++) {
				statement.setString(1, b.get(i).getBookingID());
				statement.setString(2, Double.toString(b.get(i).getFareAmount()));
				statement.setString(3, b.get(i).getDriverID());
				statement.setString(4, b.get(i).getVehicleType());
				statement.setString(5, b.get(i).getPassengerID());
				statement.setString(6, b.get(i).getRoute().getPickupLocation());
				statement.setString(7, b.get(i).getRoute().getDropoffLocation());
				
				statement.executeUpdate();

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}	
	
	
	
	public void writeAvailableBookings(ArrayList <Booking> b) {
		
		deleteAvailableBookings();
		
		String sql = "INSERT INTO availableRides (bookingID, fareAmount, driverID, vehicleType, passengerID, pickupLocation, dropoffLocation) VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		try {
			
			statement = con.prepareStatement(sql);
			
			for(int i = 0 ; i < b.size(); i++) {
				statement.setString(1, b.get(i).getBookingID());
				statement.setString(2, Double.toString(b.get(i).getFareAmount()));
				statement.setString(3, b.get(i).getDriverID());
				statement.setString(4, b.get(i).getVehicleType());
				statement.setString(5, b.get(i).getPassengerID());
				statement.setString(6, b.get(i).getRoute().getPickupLocation());
				statement.setString(7, b.get(i).getRoute().getDropoffLocation());
				
				statement.executeUpdate();

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}	
	

	
	
	
	public void writeRentingRecords(ArrayList <RentDetails> RD) {
		
		String sql = "INSERT INTO RentDetails (rentID, rentAmount, rentingDate, duration, returnDate, vehicleID, passengerID) VALUES(?, ?, ?, ? , ? , ? , ?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			
			for(int i = 0 ; i < RD.size(); i++) {
				statement.setString(1, RD.get(i).getRentID());
				statement.setString(2, Double.toString(RD.get(i).getRentAmount()));
				statement.setString(3, RD.get(i).getRentingDate());
				statement.setString(4, RD.get(i).getDuration());
				statement.setString(5, RD.get(i).getReturnDate());
				statement.setString(6, Integer.toString(RD.get(i).getVehicle().getVehicleID()));
				statement.setString(7, RD.get(i).getPassengerID());
		
				statement.executeUpdate();

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}	
	
	
	
	
	public void writeRentOutRecords(ArrayList <RentDetails> ROR) {
		
		String sql = "INSERT INTO RentOutDetails (rentID, rentAmount, rentingDate, duration, returnDate, vehicleID, passengerID) VALUES(?, ?, ?, ? , ? , ? , ?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			
			for(int i = 0 ; i < ROR.size(); i++) {
				statement.setString(1, ROR.get(i).getRentID());
				statement.setString(2, Double.toString(ROR.get(i).getRentAmount()));
				statement.setString(3, ROR.get(i).getRentingDate());
				statement.setString(4, ROR.get(i).getDuration());
				statement.setString(5, ROR.get(i).getReturnDate());
				statement.setString(6, Integer.toString(ROR.get(i).getVehicle().getVehicleID()));
				statement.setString(7, ROR.get(i).getPassengerID());
		
				statement.executeUpdate();

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}	
	

	
	public void writeHireRecords(ArrayList <HireDetails> hireDetails) {
		
		String sql = "INSERT INTO HireDetails (HireID, DriverID, HireAmount, hiringDate, HireEndDate, passengerID) VALUES(?, ?, ? , ? , ? , ?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			
			for(int i = 0 ; i < hireDetails.size(); i++) {
				statement.setString(1, hireDetails.get(i).getHireID());
				statement.setString(2, hireDetails.get(i).getDriverID());
				statement.setString(3, Double.toString(hireDetails.get(i).getHireAmount()));
				statement.setString(4, hireDetails.get(i).getHiringDate());
				statement.setString(5, hireDetails.get(i).getHireEndDate());
				statement.setString(6, hireDetails.get(i).getPassengerID());
		
				statement.executeUpdate();

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}	
	

	
	
	
	public void writeHireRequest(HireDetails hireRequests) {
		
		String sql = "INSERT INTO HireDetails (HireID, DriverID, HireAmount, hiringDate, HireEndDate, passengerID) VALUES(?, ?, ? , ? , ? , ?)";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			
				statement.setString(1, hireRequests.getHireID());
				statement.setString(2, hireRequests.getDriverID());
				statement.setString(3, Double.toString(hireRequests.getHireAmount()));
				statement.setString(4, hireRequests.getHiringDate());
				statement.setString(5, hireRequests.getHireEndDate());
				statement.setString(6, hireRequests.getPassengerID());
		
				statement.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}	
	

	
	
	public void writeLuggageBookings(ArrayList <LuggageBooking> LB) {
		
		String sql = "INSERT INTO luggageBookings (bookingID, fareAmount, driverID, vehicleType, passengerID, pickupLocation, dropoffLocation, luggageWeight, luggageType) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		try {
	
			for(int i = 0 ; i < LB.size(); i++) {
				statement = con.prepareStatement(sql);
				statement.setString(1, LB.get(i).getBookingID());
				statement.setString(2, Double.toString(LB.get(i).getFareAmount()));
				statement.setString(3, LB.get(i).getDriverID());
				statement.setString(4, LB.get(i).getVehicleType());
				statement.setString(5, LB.get(i).getPassengerID());
				statement.setString(6, LB.get(i).getRoute().getPickupLocation());
				statement.setString(7, LB.get(i).getRoute().getDropoffLocation());
				statement.setString(8, LB.get(i).getLuggageWeight());
				statement.setString(9, LB.get(i).getLuggageType());
		
				statement.executeUpdate();
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}	
	
	
	public void writeAvailableLuggageBookings(ArrayList <LuggageBooking> LB) {
		
		deleteAvailableLuggageBookings();
		String sql = "INSERT INTO availableluggageBookings (bookingID, fareAmount, driverID, vehicleType, passengerID, pickupLocation, dropoffLocation, luggageWeight, luggageType) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		try {
	
			for(int i = 0 ; i < LB.size(); i++) {
				statement = con.prepareStatement(sql);
				statement.setString(1, LB.get(i).getBookingID());
				statement.setString(2, Double.toString(LB.get(i).getFareAmount()));
				statement.setString(3, LB.get(i).getDriverID());
				statement.setString(4, LB.get(i).getVehicleType());
				statement.setString(5, LB.get(i).getPassengerID());
				statement.setString(6, LB.get(i).getRoute().getPickupLocation());
				statement.setString(7, LB.get(i).getRoute().getDropoffLocation());
				statement.setString(8, LB.get(i).getLuggageWeight());
				statement.setString(9, LB.get(i).getLuggageType());
		
				statement.executeUpdate();
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}	
	

	public void writeDriver(ArrayList <Driver> d) {
		
		deleteDriver();
		deleteHireRequest();	
		String sql = "INSERT INTO Driver (driverName, driverID, driverPassword, driverEmail, driverContactNumber, DOB, driverAddress) VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		try {
	
			for(int i = 0 ; i < d.size(); i++) {
				statement = con.prepareStatement(sql);
				statement.setString(1, d.get(i).getDriverName());
				statement.setString(2, d.get(i).getDriverID());
				statement.setString(3, d.get(i).getDriverPassword());
				statement.setString(4, d.get(i).getDriverEmail());
				statement.setString(5, d.get(i).getDriverContactNumber());
				statement.setString(6, d.get(i).getDOB());
				statement.setString(7, d.get(i).getDriverAddress());
				
				//writeHireRequest(d.get(i).getHireDetails());
				statement.executeUpdate();

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}	
	
	public void writeAvailableDriver(ArrayList <Driver> d) {
		
		deleteAvailableDriver();
		
		String sql = "INSERT INTO availableDriver (driverName, driverID, driverPassword, driverEmail, driverContactNumber, DOB, driverAddress) VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement;
		try {
	
			for(int i = 0 ; i < d.size(); i++) {
				statement = con.prepareStatement(sql);
				statement.setString(1, d.get(i).getDriverName());
				statement.setString(2, d.get(i).getDriverID());
				statement.setString(3, d.get(i).getDriverPassword());
				statement.setString(4, d.get(i).getDriverEmail());
				statement.setString(5, d.get(i).getDriverContactNumber());
				statement.setString(6, d.get(i).getDOB());
				statement.setString(7, d.get(i).getDriverAddress());
				
				statement.executeUpdate();

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}	

	
	
	
    /*Droping the Existing records in the tables 	
	and Adding new Records*/ 

	public void deleteVehicle() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Vehicle";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

   	
	public void deletePassenger() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Passenger";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteBookings() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM bookings";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteAvailableBookings() {
		// TODO Auto-generated method stub
		
		String sql = "DELETE FROM availablerides";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteAvailableLuggageBookings() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM availableluggagebookings";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
	}

	}
	
	public void deleteLuggageBookings() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM luggagebookings";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
     		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteDriver() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Driver";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteRentalDetails() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM rentdetails";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteVehicleDescription() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM vehicledescription";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void deleteAvailableDriver() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM availabledriver";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	public void deleteHireDetails() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM hireDetails";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public void deleteHireRequest() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM hireRequest";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	
	public void deleteRentOutRecords() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM rentOutDetails";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	
	public void deleteAvailableVehicles() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM availableVehicles";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			int rowsDeleted = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}