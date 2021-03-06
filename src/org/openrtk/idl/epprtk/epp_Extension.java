/*
**
** EPP RTK Java
** Copyright (C) 2002, Tucows, Inc.
** Copyright (C) 2003, Liberty RMS
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

package org.openrtk.idl.epprtk;

import org.w3c.dom.*;


/**
 * Master external interface for the implementor of the EPP Extension element.</p>
 * The Unspc(unspecified) element may be used for server-defined command extensions.</p>
 * The interface brings together epp_ExtensionOperations and standard IDL classes.
 * $Header: /cvsroot/epp-rtk/epp-rtk/java/src/org/openrtk/idl/epprtk/epp_Extension.java,v 1.1 2004/12/07 15:27:49 ewang2004 Exp $<br>
 * $Revision: 1.1 $<br>
 * $Date: 2004/12/07 15:27:49 $<br>
 */
public interface epp_Extension extends epp_ExtensionOperations, org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity 
{
	/**
	 * Method to submit a current XML Document and create a required XML structure
	 * within that document, thus preserving namespace attributes.
	 * Return the element for later serializing to XML String.
	 * @param doc
	 * @return
	 */
	public Element toXMLElement(Document doc) throws epp_XMLException;
} // interface epp_Extension
