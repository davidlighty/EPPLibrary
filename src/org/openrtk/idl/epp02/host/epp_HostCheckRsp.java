package org.openrtk.idl.epp02.host;


/**
* org/openrtk/idl/epp/host/epp_HostCheckRsp.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from epp_host.idl
* Thursday, July 26, 2001 6:26:10 PM EDT
*/

public class epp_HostCheckRsp implements org.omg.CORBA.portable.IDLEntity
{
  public org.openrtk.idl.epp02.epp_Response m_rsp = null;
  public org.openrtk.idl.epp02.epp_CheckResult m_results[] = null;

  public epp_HostCheckRsp ()
  {
  } // ctor

  public epp_HostCheckRsp (org.openrtk.idl.epp02.epp_Response _m_rsp, org.openrtk.idl.epp02.epp_CheckResult[] _m_results)
  {
    m_rsp = _m_rsp;
    m_results = _m_results;
  } // ctor

  public void setRsp(org.openrtk.idl.epp02.epp_Response value) { m_rsp = value; }
  public org.openrtk.idl.epp02.epp_Response getRsp() { return m_rsp; }

  public void setResults(org.openrtk.idl.epp02.epp_CheckResult[] value) { m_results = value; }
  public org.openrtk.idl.epp02.epp_CheckResult[] getResults() { return m_results; }

  public String toString() { return this.getClass().getName() + ": { m_rsp ["+m_rsp+"] m_results ["+(m_results != null ? java.util.Arrays.asList(m_results) : null)+"] }"; }

} // class epp_HostCheckRsp
