package server;

public class Student extends Record {
	
	public Student(long recordID, String firstName, String lastName, String courseRegistered, String status, String statusDate) {
		super(recordID, firstName, lastName, courseRegistered, status, statusDate);
	}

	@Override
	public String getRecordType() {
		return "SR";
	}
	
	public String toString() {
		String studentRecord = "First Name: "+ getFirstName() + "\n" 
				+ "Last Name: " + getLastName() + "\n"
				+ "courseRegistered: " + getCourseRegistered() + "\n"
				+ "Status: " + getStatus() + "\n"
				+ "StatusDate: " + getStatusDate() + "\n";
		return studentRecord;
	}

}
