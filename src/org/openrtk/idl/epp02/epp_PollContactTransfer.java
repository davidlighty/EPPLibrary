package org.openrtk.idl.epp02;


/**
* org/openrtk/idl/epp/epp_PollContactTransfer.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from epp.idl
* Thursday, July 26, 2001 6:26:04 PM EDT
*/

public class epp_PollContactTransfer implements org.omg.CORBA.portable.IDLEntity
{
  public String m_contact_roid = null;
  public org.openrtk.idl.epp02.epp_AuthInfo m_auth_info = null;

  public epp_PollContactTransfer ()
  {
  } // ctor

  public epp_PollContactTransfer (String _m_contact_roid, org.openrtk.idl.epp02.epp_AuthInfo _m_auth_info)
  {
    m_contact_roid = _m_contact_roid;
    m_auth_info = _m_auth_info;
  } // ctor

  public void setContactRoid(String value) { m_contact_roid = value; }
  public String getContactRoid() { return m_contact_roid; }

  public void setAuthInfo(org.openrtk.idl.epp02.epp_AuthInfo value) { m_auth_info = value; }
  public org.openrtk.idl.epp02.epp_AuthInfo getAuthInfo() { return m_auth_info; }

  public String toString() { return this.getClass().getName() + ": { m_contact_roid ["+m_contact_roid+"] m_auth_info ["+m_auth_info+"] }"; }

} // class epp_PollContactTransfer
