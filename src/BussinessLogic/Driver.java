package BussinessLogic;

public class Driver {
		
		private String driverName;
		private String driverID;
		private String driverPassword;
		private String driverEmail; 
		private String driverContactNumber;
		private String DOB; 
		private String driverAddress;
		
		private HireDetails hireDetails;



		
		public Driver(String driverName, String driverID, String driverPassword, String driverEmail,
				String driverContactNumber, String dOB, String driverAddress) {
			super();
			this.driverName = driverName;
			this.driverID = driverID;
			this.driverPassword = driverPassword;
			this.driverEmail = driverEmail;
			this.driverContactNumber = driverContactNumber;
			DOB = dOB;
			this.driverAddress = driverAddress;
		}

		
		

		public Driver(String driverName, String driverID, String driverPassword, String driverEmail,
				String driverContactNumber, String dOB, String driverAddress, HireDetails hireDetails) {
			super();
			this.driverName = driverName;
			this.driverID = driverID;
			this.driverPassword = driverPassword;
			this.driverEmail = driverEmail;
			this.driverContactNumber = driverContactNumber;
			DOB = dOB;
			this.driverAddress = driverAddress;
			this.hireDetails = hireDetails;
		}




		public HireDetails getHireDetails() {
			return hireDetails;
		}




		public void setHireDetails(HireDetails hireDetails) {
			this.hireDetails = hireDetails;
		}




		public String getDriverName() {
			return driverName;
		}


		public void setDriverName(String driverName) {
			this.driverName = driverName;
		}


		public String getDriverID() {
			return driverID;
		}


		public void setDriverID(String driverID) {
			this.driverID = driverID;
		}


		public String getDriverPassword() {
			return driverPassword;
		}


		public void setDriverPassword(String driverPassword) {
			this.driverPassword = driverPassword;
		}


		public String getDriverEmail() {
			return driverEmail;
		}


		public void setDriverEmail(String driverEmail) {
			this.driverEmail = driverEmail;
		}


		public String getDriverContactNumber() {
			return driverContactNumber;
		}


		public void setDriverContactNumber(String driverContactNumber) {
			this.driverContactNumber = driverContactNumber;
		}


		public String getDOB() {
			return DOB;
		}


		public void setDOB(String dOB) {
			DOB = dOB;
		}


		public String getDriverAddress() {
			return driverAddress;
		}


		public void setDriverAddress(String driverAddress) {
			this.driverAddress = driverAddress;
		}




		@Override
		public String toString() {
			return "Driver [driverName=" + driverName + ", driverID=" + driverID + ", driverPassword=" + driverPassword
					+ ", driverEmail=" + driverEmail + ", driverContactNumber=" + driverContactNumber + ", DOB=" + DOB
					+ ", driverAddress=" + driverAddress + "]";
		} 
		
		
		
}
