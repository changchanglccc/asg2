package DSMS_CORBA;


/**
* DSMS_CORBA/DSMS_InterfacePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /Users/chongli/Github/asg2/src/DSMS_CORBA.idl
* Sunday, July 9, 2017 11:20:32 o'clock PM EDT
*/

public abstract class DSMS_InterfacePOA extends org.omg.PortableServer.Servant
 implements DSMS_CORBA.DSMS_InterfaceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("createTRecord", new java.lang.Integer (0));
    _methods.put ("createSRecord", new java.lang.Integer (1));
    _methods.put ("getRecordCounts", new java.lang.Integer (2));
    _methods.put ("editRecord", new java.lang.Integer (3));
    _methods.put ("transferRecord", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  /**
       	* Operation createTRecord
       	*/
       case 0:  // DSMS_CORBA/DSMS_Interface/createTRecord
       {
         String managerID = in.read_string ();
         String firstName = in.read_string ();
         String lastName = in.read_string ();
         String address = in.read_string ();
         String phone = in.read_string ();
         String specialization = in.read_string ();
         String location = in.read_string ();
         String $result = null;
         $result = this.createTRecord (managerID, firstName, lastName, address, phone, specialization, location);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }


  /**
       	* Operation createSRecord
       	*/
       case 1:  // DSMS_CORBA/DSMS_Interface/createSRecord
       {
         String managerID = in.read_string ();
         String firstName = in.read_string ();
         String lastName = in.read_string ();
         String courseRegistered = in.read_string ();
         String status = in.read_string ();
         String statusDate = in.read_string ();
         String $result = null;
         $result = this.createSRecord (managerID, firstName, lastName, courseRegistered, status, statusDate);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }


  /**
       	* Operation getRecordCounts
       	*/
       case 2:  // DSMS_CORBA/DSMS_Interface/getRecordCounts
       {
         String managerID = in.read_string ();
         String $result = null;
         $result = this.getRecordCounts (managerID);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }


  /**
       	* Operation editRecord
      	*/
       case 3:  // DSMS_CORBA/DSMS_Interface/editRecord
       {
         String managerID = in.read_string ();
         String recordID = in.read_string ();
         String fieldName = in.read_string ();
         String newValue = in.read_string ();
         String $result = null;
         $result = this.editRecord (managerID, recordID, fieldName, newValue);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }


  /**
       	* Operation transferRecord
       	*/
       case 4:  // DSMS_CORBA/DSMS_Interface/transferRecord
       {
         String managerID = in.read_string ();
         String recordID = in.read_string ();
         String remoteClinicServerName = in.read_string ();
         String $result = null;
         $result = this.transferRecord (managerID, recordID, remoteClinicServerName);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:DSMS_CORBA/DSMS_Interface:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public DSMS_Interface _this() 
  {
    return DSMS_InterfaceHelper.narrow(
    super._this_object());
  }

  public DSMS_Interface _this(org.omg.CORBA.ORB orb) 
  {
    return DSMS_InterfaceHelper.narrow(
    super._this_object(orb));
  }


} // class DSMS_InterfacePOA
