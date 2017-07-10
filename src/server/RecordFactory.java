package server;

import java.util.HashMap;
import java.util.Map;


public class RecordFactory {

	public static Record createRecordFromMap(Map<String, String> map) {

		String recordID = map.get("id");
        String firstName = map.get("fn");
        String lastName = map.get("ln");
        String type = map.get("ty");
        
        int idnum = (int) Long.parseLong(recordID.replace(type, ""), 10);
        
        if ("TR".equals(type)) {
        	 String address = map.get("ad");
             String phone = map.get("ph");
             String specialization = map.get("sp");
             String location = map.get("lo");
             return new Teacher(idnum, firstName, lastName, address, phone, specialization, location);

        }
        if ("SR".equals(type)) {
            
            String courseRegistered = map.get("cr");
            String status = map.get("st");
            String statusDate = map.get("sd");
            return new Student(idnum, firstName, lastName, courseRegistered, status, statusDate);
        }
      
		return null;
	}

	public static Map<String, String> createMapFromRecord(Record record) {
		Map<String, String> map = new HashMap<String, String>();
        map.put("id", record.getId());
        map.put("fn", record.getFirstName());
        map.put("ln", record.getLastName());
        map.put("ty", record.getRecordType());

        try {
            Teacher tr = (Teacher) record;
            map.put("ad", tr.getAddress());
            map.put("ph", tr.getPhone());
            map.put("sp", tr.getSpecialization());
            map.put("lo", tr.getLocation());
            		
        } catch (ClassCastException ex) {
        }

        try {
            Student sr = (Student) record;
            map.put("cr", sr.getCourseRegistered());
            map.put("st", sr.getStatus());
            map.put("sd", sr.getStatusDate());
        } catch (ClassCastException ex) {
        }

        return map;
	}

}

