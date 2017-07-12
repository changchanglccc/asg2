package server;

public class Teacher extends Record {
	
	public Teacher(long recordID, String firstName, String lastName, String address, String phone, String specialization, String location){
		super(recordID, firstName, lastName, address, phone, specialization, location);
	}

	@Override
	public String getRecordType() {
		return "TR";
	}
	
	public String toString() {
		String teacherRecord = "First Name: "+ getFirstName() + "\n" 
					+ "Last Name: " + getLastName() + "\n"
					+ "Address: " + getAddress() + "\n"
					+ "Phone: " + getPhone() + "\n"
					+ "specialization: " + getSpecialization() + "\n"
					+ "location: " + getLocation() + "\n";
		return teacherRecord;
	}

}
