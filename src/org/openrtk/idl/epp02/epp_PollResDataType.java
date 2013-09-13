package org.openrtk.idl.epp02;


/**
* org/openrtk/idl/epp/epp_PollResDataType.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from epp.idl
* Thursday, July 26, 2001 6:26:04 PM EDT
*/

public class epp_PollResDataType implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static org.openrtk.idl.epp02.epp_PollResDataType[] __array = new org.openrtk.idl.epp02.epp_PollResDataType [__size];

  public static final int _DOMAIN_TRANSFER = 0;
  public static final org.openrtk.idl.epp02.epp_PollResDataType DOMAIN_TRANSFER = new org.openrtk.idl.epp02.epp_PollResDataType(_DOMAIN_TRANSFER);
  public static final int _CONTACT_TRANSFER = 1;
  public static final org.openrtk.idl.epp02.epp_PollResDataType CONTACT_TRANSFER = new org.openrtk.idl.epp02.epp_PollResDataType(_CONTACT_TRANSFER);

  public int value ()
  {
    return __value;
  }

  public static org.openrtk.idl.epp02.epp_PollResDataType from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected epp_PollResDataType (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class epp_PollResDataType
