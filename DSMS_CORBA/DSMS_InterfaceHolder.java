package DSMS_CORBA;

/**
* DSMS_CORBA/DSMS_InterfaceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from DSMS_CORBA.idl
* Monday, July 10, 2017 2:08:06 PM EDT
*/

public final class DSMS_InterfaceHolder implements org.omg.CORBA.portable.Streamable
{
  public DSMS_CORBA.DSMS_Interface value = null;

  public DSMS_InterfaceHolder ()
  {
  }

  public DSMS_InterfaceHolder (DSMS_CORBA.DSMS_Interface initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DSMS_CORBA.DSMS_InterfaceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DSMS_CORBA.DSMS_InterfaceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DSMS_CORBA.DSMS_InterfaceHelper.type ();
  }

}
