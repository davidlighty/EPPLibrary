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
 * $Header: /cvsroot/epp-rtk/epp-rtk/java/src/com/tucows/oxrs/epp02/rtk/RTKBase.java,v 1.5 2003/12/24 17:42:04 tubadanm Exp $
 * $Revision: 1.5 $
 * $Date: 2003/12/24 17:42:04 $
 */

package com.tucows.oxrs.epp02.rtk;

import java.text.*;
import java.util.*;
import java.io.*;
import org.apache.log4j.*;

/**
 * RTK Base -- Base of the registrar tool kit.  All RTK classes inherit from this one.
 * Defines: debug method and constants; date formats.
 * Note that despite this class extending a CORBA Object class, it does not make
 * any promises of CORBA functionality.  Extension of the CORBA ObjectImpl was required
 * because of the methods required by the RTK IDL interfaces.
 *
 * @author Daniel Manley
 * @version $Revision: 1.5 $ $Date: 2003/12/24 17:42:04 $
**/

public abstract class RTKBase extends org.omg.CORBA.portable.ObjectImpl
{
    /**
     * RTK Version number.
     */
    public static final String RTK_VERSION = "0.7.5-02";

    /**
     * Defined as "\r\n".  Used to complete a request to the EPP Server.
     */
    protected static final String CRLF = "\r\n";

    /**
     * Debug level for no debug output.
     */
    public static final int DEBUG_NONE = 0;
    /**
     * Debug level for sending exceptions to System.err.
     */
    public static final int DEBUG_LEVEL_ONE = 1;
    /**
     * Debug level for debugging points on interest throughout the RTK code,
     * including display of XML messages to and from the EPP Server
     */
    public static final int DEBUG_LEVEL_TWO = 2;
    /**
     * Debug level for showing all debugging output, which
     * include entry and exit of methods.
     */
    public static final int DEBUG_LEVEL_THREE = 3;

    private static int debug_level_ = DEBUG_NONE;
    
    private static Properties rtk_properties_ = null;

    private static Logger logger_ = null;

    /**
     * DateFormat for "yyyy-MM-dd'T'HH:mm:ss.0'Z'".
     * This is the format returned by the EPP Server in timestamps
     * (eg. expiration date, last modified date, etc...). It can be used
     * to convert String dates into Date objects. eg:</P>
     * <PRE>java.util.Date date_object = UTC_FMT.parse(date_string); </PRE>
     */
    public static final DateFormat UTC_FMT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.0'Z'");

    /**
     * DateFormat for "yyyy-MM-dd".
     * It can be used to convert String dates into Date objects
     * and vice versa. eg:</P>
     * <PRE>String date_string = DATE_FMT.format(date_object); </PRE>
     */
    public static final DateFormat DATE_FMT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Accessor method for the debug level.  Use DEBUG_LEVEL_NONE,
     * DEBUG_LEVEL_ONE, DEBUG_LEVEL_TWO, or DEBUG_LEVEL_THREE.
     * @param value The debug level
     */
    public static void setDebugLevel(int value) { debug_level_ = value; }
    /**
     * Accessor method for the version
     * @return int the current debug level
     */
    public static int getDebugLevel() { return debug_level_; }

    /**
     * Prints a debug message to System.err.  If the set debug level
     * is greater than or equal to the given level, then the message
     * is printed.  The print out includes the class name, the given
     * method name, the current date and time, the given debug level
     * of this message, and the message itself.
     * @param level the debug level of this message
     * @param method_name the method name String
     * @param message the message String
     */
    public void debug(int level, String method_name, String message)
    {
        if ( debug_level_ >= level )
        {
            String advancedLogging;
            try
            {
                advancedLogging = RTKBase.getRTKProperties().getProperty("rtk.debug.advancedLogging");
            }
            catch ( Exception prop_xcp )
            {
                advancedLogging = "false";
            }
            
            if ( advancedLogging.equalsIgnoreCase("false") ||
                 getLogger() == null )
            {
                System.err.println(getClass().getName()+"."+method_name+" {"+new Date()+"}["+level+"] : "+message);
            }
            else
            {
                getLogger().debug(getClass().getName()+"."+method_name+" {"+new Date()+"}["+level+"] : "+message);
            }
        }
    }

    /**
     * Prints an exception to System.err, including its stack trace.
     * If the set debug level is greater than or equal to the given level,
     * then the exception is reported is reported.
     * The print out includes the class name, the given
     * method name, the current date and time, the given debug level
     * of this exception, the exception class name and the exception's message.
     * This is followed by the stack trace.
     * @param level the debug level of this message
     * @param method_name the method name String
     * @param xcp the exception to be reported
     */
    public void debug(int level, String method_name, Exception xcp)
    {
        if ( debug_level_ >= level )
        {
            String advancedLogging;
            try
            {
                advancedLogging = RTKBase.getRTKProperties().getProperty("rtk.debug.advancedLogging");
            }
            catch ( Exception prop_xcp )
            {
                advancedLogging = "false";
            }
            
            if ( advancedLogging.equalsIgnoreCase("false") ||
                 getLogger() == null )
            {
                System.err.println(getClass().getName()+"."+method_name+" {"+new Date()+"}["+level+"] : ["+xcp.getClass().getName()+"] ["+xcp.getMessage()+"]");
                xcp.printStackTrace(System.err);
            }
            else 
            {
                getLogger().error(getClass().getName()+"."+method_name+" {"+new Date()+"}["+level+"] : ["+xcp.getClass().getName()+"] ["+xcp.getMessage()+"]");
                getLogger().error(xcp);
            }
        }
    }

    /**
     * Method required by ObjectImpl and the CORBA Object interface.
     * Always returns null.  It's only here to satisfy the CORBA requirements
     * of the IDL usage.
     */
    public String[] _ids() { return null; }

    /**
     * Returns the global properties for the RTK.
     * By default the properties are empty.  If the RTK user specifies
     * the system property "rtk.props.file", then that file will be loaded.
     * If there is a problem loading that file, then an exception will
     * be thrown.
     */
    public static Properties getRTKProperties() throws FileNotFoundException, IOException
    {
        
        if ( rtk_properties_ == null )
        {
            Properties system_props = System.getProperties();

            String rtk_props_file = (String) system_props.getProperty("rtk.props.file");

            rtk_properties_ = new Properties();

            if ( rtk_props_file != null &&
                 rtk_props_file.length() != 0 )
            {
                // so only try to load the properties from a file
                // if one was specified.  If the file is not found,
                // well, then, a real exception will be thrown.
                rtk_properties_.load(new FileInputStream(rtk_props_file));
            }
        }
        
        return rtk_properties_;
    }
    
    private synchronized static Logger getLogger()
    {
        if (logger_ == null)
        {
            synchronized(RTK_VERSION)
            {
                try
                {
                    PropertyConfigurator.configure(getRTKProperties());

                    logger_ = Logger.getLogger("epprtk");
                }
                catch(Exception xcp)
                {
                    System.err.println("LOGGER: disabled using stderr");
                    //xcp.printStackTrace();
                }
            }                
        }
        
        return logger_;
    }

}
