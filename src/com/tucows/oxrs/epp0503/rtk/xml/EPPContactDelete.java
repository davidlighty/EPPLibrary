/*
**
** EPP RTK Java
** Copyright (C) 2001, Tucows, Inc.
**
**
** This library is free software; you can redistribute it and/or
** modify it under the terms of the GNU Lesser General Public
** License as published by the Free Software Foundation; either
** version 2.1 of the License, or (at your option) any later version.
** 
** This library is distributed in the hope that it will be useful,
** but WITHOUT ANY WARRANTY; without even the implied warranty of
** MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
** Lesser General Public License for more details.
** 
** You should have received a copy of the GNU Lesser General Public
** License along with this library; if not, write to the Free Software
** Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
** 
*/

/*
 * $Header: /cvsroot/epp-rtk/epp-rtk/java/src/com/tucows/oxrs/epp0503/rtk/xml/EPPContactDelete.java,v 1.1 2003/03/21 16:18:22 tubadanm Exp $
 * $Revision: 1.1 $
 * $Date: 2003/03/21 16:18:22 $
 */

package com.tucows.oxrs.epp0503.rtk.xml;

import java.io.*;
import java.util.*;
import java.text.*;

import com.tucows.oxrs.epp0503.rtk.*;
import org.openrtk.idl.epp0503.*;
import org.openrtk.idl.epp0503.contact.*;

import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import org.apache.xerces.parsers.*;
import org.xml.sax.*;
import org.apache.xerces.dom.*;
import org.apache.xml.serialize.*;

/**
 * Class for the EPP Contact Delete command and response.
 * Extends the epp_ContactDelete interface from the EPP IDLs to provide
 * the XML translation for the EPP Contact Delete command.</P>
 * The Delete command allows a client to destroy an instance of an EPP object in the server.
 * The deletion of an EPP object is subject to constraints as stated in the EPP Spec.</P>
 * the XML translation for the EPP Contact Delete command.
 * Usage is demonstrated in the com.tucows.oxrs.epp0503.rtk.example.ContactExample
 * class.
 * @see com.tucows.oxrs.epp0503.rtk.example.ContactExample
 * @see org.openrtk.idl.epp0503.epp_Action
 * @see org.openrtk.idl.epp0503.contact.epp_ContactDelete
 * @see org.openrtk.idl.epp0503.contact.epp_ContactDeleteReq
 * @see org.openrtk.idl.epp0503.contact.epp_ContactDeleteRsp
 * @see EPP Contact Spec for more information
 */
public class EPPContactDelete extends EPPContactBase implements epp_ContactDelete
{

    private epp_ContactDeleteReq action_request_;
    private epp_ContactDeleteRsp action_response_;

    /**
     * Default constructor
     */
    public EPPContactDelete () {}

    /**
     * Constructor with response XML string to automatically parse.
     * @param xml The EPP Contact Delete response XML String
     * @throws org.openrtk.idl.epp0503.epp_XMLException if the response XML is not parsable or does not contain the expected data
     * @throws org.openrtk.idl.epp0503.epp_Exception if the server has responded with an error code 
     * @see #fromXML(String)
     */
    public EPPContactDelete (String xml) throws epp_XMLException, epp_Exception
    {
        String method_name = "EPPContactDelete(String)";
        debug(DEBUG_LEVEL_TWO,method_name,"xml is ["+xml+"]");
        fromXML(xml);
    }

    /**
     * Accessor method for the contact delete request data.
     * Must be set to for this command.
     * @param value org.openrtk.idl.epp0503.epp_ContactDeleteReq
     */
    public void setRequestData(epp_ContactDeleteReq value) { action_request_ = value; }
    /**
     * Accessor method for the contact check response data.
     * @return value org.openrtk.idl.epp0503.epp_ContactDeleteRsp
     */
    public epp_ContactDeleteRsp getResponseData() { return action_response_; }

    /**
     * Builds request XML from the request data.
     * Implemented method from org.openrtk.idl.epp0503.epp_Action interface.
     * @throws epp_XMLException if required data is missing
     * @see #setRequestData(epp_ContactDeleteReq)
     * @see org.openrtk.idl.epp0503.epp_Action
     */
    public String toXML() throws epp_XMLException
    {
        String method_name = "buildRequestXML()";
        debug(DEBUG_LEVEL_THREE,method_name,"Entered");

        if ( action_request_ == null || 
             action_request_.m_cmd == null ||
             action_request_.m_id == null )
        {
            throw new epp_XMLException("missing request data or contact id");
        }

        Document doc = new DocumentImpl();
        Element root = createDocRoot(doc);

        Element command = doc.createElement("command");
        Element delete = doc.createElement("delete");

        epp_Command command_data = action_request_.m_cmd;

        if ( command_data.m_creds != null )
        {
            command.appendChild( prepareCreds( doc, command_data.m_creds ) );
        }
        
        Element contact_delete = doc.createElement("contact:delete");
        setCommonAttributes(contact_delete);

        addXMLElement(doc, contact_delete, "contact:id", action_request_.m_id);

        delete.appendChild( contact_delete );

        command.appendChild( delete );

        prepareExtensionElement( doc, command, command_data.m_extension );

        if ( command_data.m_client_trid != null )
        {
            addXMLElement(doc, command, "clTRID", command_data.m_client_trid);
        }

        root.appendChild( command );
        doc.appendChild( root );
        
        String request_xml;
        
        try
        {
            request_xml = createXMLFromDoc(doc);
        }
        catch (IOException xcp)
        {
            throw new epp_XMLException("IOException in building XML ["+xcp.getMessage()+"]");
        }

        debug(DEBUG_LEVEL_THREE,method_name,"Leaving");

        return request_xml;
    }

    /**
     * Parses a new XML String and populates the response data member.
     * Implemented method from org.openrtk.idl.epp0503.epp_Action interface.
     * @param A new XML String to parse
     * @throws epp_XMLException if the response XML is not parsable or does not contain the expected data
     * @throws org.openrtk.idl.epp0503.epp_Exception if the server has responded with an error code 
     * @see org.openrtk.idl.epp0503.epp_Action
     */
    public void fromXML(String xml) throws epp_XMLException, epp_Exception
    {
        String method_name = "fromXML()";
        debug(DEBUG_LEVEL_THREE,method_name,"Entered");

        xml_ = xml;

        try
        {
            Element epp_node = getDocumentElement();
            Node response_node = epp_node.getElementsByTagName("response").item(0);

            if ( response_node == null )
            {
                throw new epp_XMLException("unparsable or missing response");
            }

            action_response_ = new epp_ContactDeleteRsp();
            
            action_response_.m_rsp = parseGenericResult(response_node);

            if ( action_response_.m_rsp.m_results[0].m_code >= epp_Session.EPP_UNKNOWN_COMMAND )
            {
                throw new epp_Exception(action_response_.m_rsp.m_results);
            }
        }
        catch (SAXException xcp)
        {
            debug(DEBUG_LEVEL_ONE,method_name,xcp);
            throw new epp_XMLException("unable to parse xml ["+xcp.getClass().getName()+"] ["+xcp.getMessage()+"]");
        }
        catch (IOException xcp)
        {
            debug(DEBUG_LEVEL_ONE,method_name,xcp);
            throw new epp_XMLException("unable to parse xml ["+xcp.getClass().getName()+"] ["+xcp.getMessage()+"]");
        }

    }
    
}
