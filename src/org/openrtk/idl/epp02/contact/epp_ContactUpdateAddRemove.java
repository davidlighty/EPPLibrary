package org.openrtk.idl.epp02.contact;


/**
* org/openrtk/idl/epp/contact/epp_ContactUpdateAddRemove.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from epp_contact.idl
* Thursday, July 26, 2001 6:26:13 PM EDT
*/


//////////////////////
public class epp_ContactUpdateAddRemove implements org.omg.CORBA.portable.IDLEntity
{
  public org.openrtk.idl.epp02.contact.epp_ContactStatus m_status[] = null;

  public epp_ContactUpdateAddRemove ()
  {
  } // ctor

  public epp_ContactUpdateAddRemove (org.openrtk.idl.epp02.contact.epp_ContactStatus[] _m_status)
  {
    m_status = _m_status;
  } // ctor

  public void setStatus(org.openrtk.idl.epp02.contact.epp_ContactStatus[] value) { m_status = value; }
  public org.openrtk.idl.epp02.contact.epp_ContactStatus[] getStatus() { return m_status; }

  public String toString() { return this.getClass().getName() + ": { m_status ["+(m_status != null ? java.util.Arrays.asList(m_status) : null)+"] }"; }

} // class epp_ContactUpdateAddRemove
