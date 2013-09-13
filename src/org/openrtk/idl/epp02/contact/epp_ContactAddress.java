package org.openrtk.idl.epp02.contact;


/**
* org/openrtk/idl/epp/contact/epp_ContactAddress.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from epp_contact.idl
* Thursday, July 26, 2001 6:26:12 PM EDT
*/


//////////////////////////////////////
public class epp_ContactAddress implements org.omg.CORBA.portable.IDLEntity
{
  public String m_street1 = null;
  public String m_street2 = null;
  public String m_street3 = null;
  public String m_city = null;
  public String m_state_province = null;
  public String m_postal_code = null;
  public String m_country_code = null;

  public epp_ContactAddress ()
  {
  } // ctor

  public epp_ContactAddress (String _m_street1, String _m_street2, String _m_street3, String _m_city, String _m_state_province, String _m_postal_code, String _m_country_code)
  {
    m_street1 = _m_street1;
    m_street2 = _m_street2;
    m_street3 = _m_street3;
    m_city = _m_city;
    m_state_province = _m_state_province;
    m_postal_code = _m_postal_code;
    m_country_code = _m_country_code;
  } // ctor

  public void setStreet1(String value) { m_street1 = value; }
  public String getStreet1() { return m_street1; }

  public void setStreet2(String value) { m_street2 = value; }
  public String getStreet2() { return m_street2; }

  public void setStreet3(String value) { m_street3 = value; }
  public String getStreet3() { return m_street3; }

  public void setCity(String value) { m_city = value; }
  public String getCity() { return m_city; }

  public void setStateProvince(String value) { m_state_province = value; }
  public String getStateProvince() { return m_state_province; }

  public void setPostalCode(String value) { m_postal_code = value; }
  public String getPostalCode() { return m_postal_code; }

  public void setCountryCode(String value) { m_country_code = value; }
  public String getCountryCode() { return m_country_code; }

  public String toString() { return this.getClass().getName() + ": { m_street1 ["+m_street1+"] m_street2 ["+m_street2+"] m_street3 ["+m_street3+"] m_city ["+m_city+"] m_state_province ["+m_state_province+"] m_postal_code ["+m_postal_code+"] m_country_code ["+m_country_code+"] }"; }

} // class epp_ContactAddress
