package client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

import DSMS_CORBA.DSMS_Interface;
import DSMS_CORBA.DSMS_InterfaceHelper;

public class Client_Config{
	
	String managerID;
    String schoolServer;
    DSMS_Interface STUB;
    
    /** LOGing is done here **/
	public static void logFile(String fileName, String Operation)
			throws SecurityException {
		fileName = fileName + "_Log.txt";
		File log = new File(fileName);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		try {
			log.setWritable(true);
			FileWriter fileWriter = new FileWriter(log, true);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(Operation + " " + dateFormat.format(date));
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("COULD NOT LOG!!");
		}
	}

	public Client_Config(String managerID) {
		if (!managerID.matches("MTL[0-9]{4}")){
            throw new RuntimeException("Bad Manager ID");
        }
		this.managerID = managerID;
        this.schoolServer = managerID.substring(0, 3);
        logFile(managerID,"Manager - " + managerID + "Log In DSMS system.");
	}

	public void connect() {
		try {
            // ghetto hardcode the parameters
            ORB orb = ORB.init(new String[]{"-ORBInitialHost", "localhost", "-ORBInitialPort", "1050"}, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);

            NameComponent nc = new NameComponent(schoolServer, "");
            NameComponent path[] = {nc};
            STUB = DSMS_InterfaceHelper.narrow(ncRef.resolve(path));

            logFile(managerID, "Connected!");
        } catch (Exception ex) {
            logFile(managerID, ex.toString() + ex.getMessage());
        }
		
	}

	public String createDRecord(String managerID, String firstName, String lastName, String address, String phone,
			String specialization, String location) {
		
		logFile(managerID, "Manager choose to create Doctor Record !" + "\n" );
		String result;
		result = STUB.createTRecord(managerID, firstName, lastName, address, phone, specialization, location);
		logFile(managerID, "Manager Create Doctor Record Succeed!" + "\n" + result);
		return result;
	}

	public String createNRecord(String managerID, String firstName, String lastName, String designation, String status,
			String statusDate) {

		logFile(managerID, "Manager choose to create Nurse Record !" + "\n" );
		String result;
		result = STUB.createSRecord(managerID, firstName, lastName, designation, status, statusDate);
		logFile(managerID, "Manager Create Nurse Record Succeed!" + "\n" + result);
		return result;
	}

	public String getRecordCounts(String managerID) {

		logFile(managerID, "Manager choose to get Record counts !" + "\n" );
		String result;
		result = STUB.getRecordCounts(managerID);
		logFile(managerID, "The Record counts --" + "\n" +result );
		return result;
	}

	public String editRecord(String managerID, String recordID, String fieldName, String newValue) {

		logFile(managerID, "Manager choose to edit Record !" + "\n" );
		String result;
		result = STUB.editRecord(managerID, recordID, fieldName, newValue);
		return result;
	}

	public String transferRecord(String managerID, String recordID, String remoteClinicLocation) {

		logFile(managerID, "Manager choose to transfer Recrod !" + "\n" );
		String result;
		result = STUB.transferRecord(managerID, recordID, remoteClinicLocation);
		return result;
	}

}

