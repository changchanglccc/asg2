package CORBA;

public abstract class _DSMS_InterfaceImplBase extends org.omg.CORBA.portable.ObjectImpl
implements DSMS_CORBA.DSMS_Interface, org.omg.CORBA.portable.InvokeHandler {
	
	// Constructors
	public _DSMS_InterfaceImplBase() {
	}
	
	private static java.util.Hashtable _methods = new java.util.Hashtable();

	static {
	_methods.put("createTRecord", new java.lang.Integer(0));
	_methods.put("createSRecord", new java.lang.Integer(1));
	_methods.put("getRecordCounts", new java.lang.Integer(2));
	_methods.put("editRecord", new java.lang.Integer(3));
	_methods.put("transferRecord", new java.lang.Integer(4));
	}
	
	public org.omg.CORBA.portable.OutputStream _invoke(String $method,
		    org.omg.CORBA.portable.InputStream in,
		    org.omg.CORBA.portable.ResponseHandler $rh) {
		org.omg.CORBA.portable.OutputStream out = null;
		java.lang.Integer __method = (java.lang.Integer) _methods.get($method);
		if (__method == null) {
		    throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
		}

		switch (__method.intValue()) {
		    case 0: 
		    {
		    	String managerID = in.read_string();
		        String firstName = in.read_string();
		        String lastName = in.read_string();
		        String address = in.read_string();
		        String phone = in.read_string();
		        String specialization = in.read_string();
		        String location = in.read_string();
		        String $result = null;
		        $result = this.createTRecord(managerID, firstName, lastName, address, phone, specialization, location);
		        out = $rh.createReply();
		        out.write_string($result);
		        break;
		    }

		    case 1: //createSRecord
		    {
		    	String managerID = in.read_string();
		        String firstName = in.read_string();
		        String lastName = in.read_string();
		        String courseRegistered = in.read_string();
		        String status = in.read_string();
		        String statusDate = in.read_string();
		        String $result = null;
		        $result = this.createSRecord(managerID, firstName, lastName, courseRegistered, status, statusDate);
		        out = $rh.createReply();
		        out.write_string($result);
		        break;
		    }

		    case 2: //getRecordCounts
		    {
		    	String managerID = in.read_string();
		        String $result = null;
		        $result = this.getRecordCounts(managerID);
		        out = $rh.createReply();
		        out.write_string($result);
		        break;
		    }

		    case 3: //editCRecord
		    {
		    	String managerID = in.read_string();
		        String recordID = in.read_string();
		        String fieldName = in.read_string();
		        String newValue = in.read_string();
		        String $result = null;
		        $result = this.editRecord(managerID, recordID, fieldName, newValue);
		        out = $rh.createReply();
		        out.write_string($result);
		        break;
		    }

		    case 4: //transferRecord
		    {
		        String managerID = in.read_string();
		        String recordID = in.read_string();
		        String remoteStationServerName = in.read_string();
		        String $result = null;
		        $result = this.transferRecord(managerID, recordID, remoteStationServerName);
		        out = $rh.createReply();
		        out.write_string($result);
		        break;
		    }

		    default:
		        throw new org.omg.CORBA.BAD_OPERATION(0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
		}

		return out;
		} // _invoke
		// Type-specific CORBA::Object operations
		private static String[] __ids = {
		"IDL:DSMS_CORBA/DSMS_Interface:1.0"};

		public String[] _ids() {
		return (String[]) __ids.clone();
		}

}
