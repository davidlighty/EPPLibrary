package org.openrtk.idl.epp02.domain;


/**
* org/openrtk/idl/epp/domain/epp_DomainDeleteReq.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from epp_domain.idl
* Thursday, July 26, 2001 6:26:07 PM EDT
*/


////////////////////
public class epp_DomainDeleteReq implements org.omg.CORBA.portable.IDLEntity
{
  public org.openrtk.idl.epp02.epp_Command m_cmd = null;
  public String m_name = null;

  public epp_DomainDeleteReq ()
  {
  } // ctor

  public epp_DomainDeleteReq (org.openrtk.idl.epp02.epp_Command _m_cmd, String _m_name)
  {
    m_cmd = _m_cmd;
    m_name = _m_name;
  } // ctor

  public void setCmd(org.openrtk.idl.epp02.epp_Command value) { m_cmd = value; }
  public org.openrtk.idl.epp02.epp_Command getCmd() { return m_cmd; }

  public void setName(String value) { m_name = value; }
  public String getName() { return m_name; }

  public String toString() { return this.getClass().getName() + ": { m_cmd ["+m_cmd+"] m_name ["+m_name+"] }"; }

} // class epp_DomainDeleteReq
