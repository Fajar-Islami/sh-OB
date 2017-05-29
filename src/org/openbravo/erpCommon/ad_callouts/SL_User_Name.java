/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html 
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License. 
 * The Original Code is Openbravo ERP. 
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2001-2014 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.erpCommon.ad_callouts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.xmlEngine.XmlDocument;

public class SL_User_Name extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    if (vars.commandIn("DEFAULT")) {
      String strChanged = vars.getStringParameter("inpLastFieldChanged");
      if (log4j.isDebugEnabled())
        log4j.debug("CHANGED: " + strChanged);
      String strFirstname = vars.getStringParameter("inpfirstname");
      String strLastname = vars.getStringParameter("inplastname");
      String strName = vars.getStringParameter("inpname");
      String strUserName = vars.getStringParameter("inpusername");
      String strTabId = vars.getStringParameter("inpTabId");
      try {
        printPage(response, vars, strChanged, strFirstname, strLastname, strName, strUserName,
            strTabId);
      } catch (ServletException ex) {
        pageErrorCallOut(response);
      }
    } else
      pageError(response);
  }

  private void printPage(HttpServletResponse response, VariablesSecureApp vars, String strChanged,
      String strFirstname, String strLastname, String strName, String strUserName, String strTabId)
      throws IOException, ServletException {
    String localStrName = strName;
    String localStrLastname = strLastname;
    if (log4j.isDebugEnabled())
      log4j.debug("Output: dataSheet");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();

    if (!localStrLastname.equals(""))
      localStrLastname = " " + localStrLastname;

    StringBuffer resultado = new StringBuffer();
    resultado.append("var calloutName='SL_User_Name';\n\n");
    resultado.append("var respuesta = new Array(");
    // limits name and username to a maximum number of characters
    int maxChar = 60;
    // do not change the name field, if the user just left it
    if (!strChanged.equals("inpname")) {
      if (FormatUtilities.replaceJS(strFirstname + localStrLastname).length() > maxChar) {
        localStrName = FormatUtilities.replaceJS(strFirstname + localStrLastname).substring(0,
            maxChar);
      } else {
        localStrName = FormatUtilities.replaceJS(strFirstname + localStrLastname);
      }
      resultado.append("new Array(\"inpname\", \"" + localStrName + "\"),");
    }
    // if we have a name filled in use that for the username
    if (strUserName.equals("")) {
      if (!localStrName.equals("")) {
        if (FormatUtilities.replaceJS(localStrName).length() > maxChar) {
          resultado.append("new Array(\"inpusername\", \""
              + FormatUtilities.replaceJS(localStrName).substring(0, maxChar) + "\")");
        } else {
          resultado.append("new Array(\"inpusername\", \""
              + FormatUtilities.replaceJS(localStrName) + "\")");
        }
      } else {
        // else concatenate first- and lastname
        if (FormatUtilities.replaceJS(strFirstname + localStrLastname).length() > maxChar) {
          resultado.append("new Array(\"inpusername\", \""
              + FormatUtilities.replaceJS(strFirstname + localStrLastname).substring(0, maxChar)
              + "\")");
        } else {
          resultado.append("new Array(\"inpusername\", \""
              + FormatUtilities.replaceJS(strFirstname + localStrLastname) + "\")");
        }
      }
    } else {
      if (FormatUtilities.replaceJS(strUserName).length() > maxChar) {
        resultado.append("new Array(\"inpusername\", \""
            + FormatUtilities.replaceJS(strUserName).substring(0, maxChar) + "\")");
      } else {
        resultado.append("new Array(\"inpusername\", \"" + FormatUtilities.replaceJS(strUserName)
            + "\")");
      }
    }
    // informs about characters cut
    if (FormatUtilities.replaceJS(strFirstname + localStrLastname).length() > maxChar) {
      resultado.append(", new Array('MESSAGE', \""
          + FormatUtilities.replaceJS(Utility.messageBD(this, "NameUsernameLengthCut",
              vars.getLanguage())) + "\")");
    } else {
      resultado.append(", new Array('MESSAGE', \"\")");
    }
    resultado.append(");");
    xmlDocument.setParameter("array", resultado.toString());
    xmlDocument.setParameter("frameName", "appFrame");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }
}