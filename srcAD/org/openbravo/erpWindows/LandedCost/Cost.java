
package org.openbravo.erpWindows.LandedCost;


import org.openbravo.erpCommon.reference.*;


import org.openbravo.erpCommon.ad_actionButton.*;


import org.codehaus.jettison.json.JSONObject;
import org.openbravo.erpCommon.utility.*;
import org.openbravo.data.FieldProvider;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.utils.Replace;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.exception.OBException;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.xmlEngine.XmlDocument;
import java.util.Vector;
import java.util.StringTokenizer;
import org.openbravo.database.SessionInfo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.Connection;

// Generated old code, not worth to make i.e. java imports perfect
@SuppressWarnings("unused")
public class Cost extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "D1B11CBC0FEF4CA0B44D3BECEBA219BC";
  private static final String tabId = "1C05058D61AC4B69A7E550F32F9F2873";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 1;
  private static final String moduleId = "0";
  
  @Override
  public void init(ServletConfig config) {
    setClassInfo("W", tabId, moduleId);
    super.init(config);
  }
  
  

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    TableSQLData tableSQL = null;
    VariablesSecureApp vars = new VariablesSecureApp(request);
    Boolean saveRequest = (Boolean) request.getAttribute("autosave");
    
    if(saveRequest != null && saveRequest){
      String currentOrg = vars.getStringParameter("inpadOrgId");
      String currentClient = vars.getStringParameter("inpadClientId");
      boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)
                            && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars,"#User_Org", windowId, accesslevel), currentOrg)) 
                            && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),currentClient)));
    
        OBError myError = new OBError();
        String commandType = request.getParameter("inpCommandType");
        String strmLcCostId = request.getParameter("inpmLcCostId");
         String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strmLcCostId.equals(""))
              total = saveRecord(vars, myError, 'U', strPM_Landedcost_ID);
          else
              total = saveRecord(vars, myError, 'I', strPM_Landedcost_ID);
          
          if (!myError.isEmpty() && total == 0)     
            throw new OBException(myError.getMessage());
        }
        vars.setSessionValue(request.getParameter("mappingName") +"|hash", vars.getPostDataHash());
        vars.setSessionValue(tabId + "|Header.view", "EDIT");
        
        return;
    }
    
    try {
      tableSQL = new TableSQLData(vars, this, tabId, Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    String strOrderBy = vars.getSessionValue(tabId + "|orderby");
    if (!strOrderBy.equals("")) {
      vars.setSessionValue(tabId + "|newOrder", "1");
    }

    if (vars.commandIn("DEFAULT")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID", "");

      String strM_LC_Cost_ID = vars.getGlobalVariable("inpmLcCostId", windowId + "|M_LC_Cost_ID", "");
            if (strPM_Landedcost_ID.equals("")) {
        strPM_Landedcost_ID = getParentID(vars, strM_LC_Cost_ID);
        if (strPM_Landedcost_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|M_Landedcost_ID");
        vars.setSessionValue(windowId + "|M_Landedcost_ID", strPM_Landedcost_ID);

        refreshParentSession(vars, strPM_Landedcost_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Cost.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strM_LC_Cost_ID.equals("")) strM_LC_Cost_ID = firstElement(vars, tableSQL);
          if (strM_LC_Cost_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_LC_Cost_ID, strPM_Landedcost_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Landedcost_ID, strM_LC_Cost_ID, tableSQL);
    } else if (vars.commandIn("DIRECT")) {
      String strM_LC_Cost_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strM_LC_Cost_ID.equals("")) strM_LC_Cost_ID = vars.getRequiredGlobalVariable("inpmLcCostId", windowId + "|M_LC_Cost_ID");
      else vars.setSessionValue(windowId + "|M_LC_Cost_ID", strM_LC_Cost_ID);
      
      
      String strPM_Landedcost_ID = getParentID(vars, strM_LC_Cost_ID);
      
      vars.setSessionValue(windowId + "|M_Landedcost_ID", strPM_Landedcost_ID);
      vars.setSessionValue("F25CBC61CDD64F5E8A6FDC41C6E23C96|Header.view", "EDIT");

      refreshParentSession(vars, strPM_Landedcost_ID);

      vars.setSessionValue(tabId + "|Cost.view", "EDIT");

      printPageEdit(response, request, vars, false, strM_LC_Cost_ID, strPM_Landedcost_ID, tableSQL);

    } else if (vars.commandIn("TAB")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|M_LC_Cost_ID");
      refreshParentSession(vars, strPM_Landedcost_ID);


      String strView = vars.getSessionValue(tabId + "|Cost.view");
      String strM_LC_Cost_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strM_LC_Cost_ID = firstElement(vars, tableSQL);
          if (strM_LC_Cost_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strM_LC_Cost_ID.equals("")) strM_LC_Cost_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strM_LC_Cost_ID, strPM_Landedcost_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPM_Landedcost_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {
vars.getRequestGlobalVariable("inpParamM_Landedcost_ID", tabId + "|paramM_Landedcost_ID");
vars.getRequestGlobalVariable("inpParamM_Inout_ID", tabId + "|paramM_Inout_ID");
vars.getRequestGlobalVariable("inpParamAmount", tabId + "|paramAmount");
vars.getRequestGlobalVariable("inpParamAmount_f", tabId + "|paramAmount_f");

        vars.getRequestGlobalVariable("inpParamUpdated", tabId + "|paramUpdated");
        vars.getRequestGlobalVariable("inpParamUpdatedBy", tabId + "|paramUpdatedBy");
        vars.getRequestGlobalVariable("inpParamCreated", tabId + "|paramCreated");
        vars.getRequestGlobalVariable("inpparamCreatedBy", tabId + "|paramCreatedBy");
            String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");

      
      vars.removeSessionValue(windowId + "|M_LC_Cost_ID");
      String strM_LC_Cost_ID="";

      String strView = vars.getSessionValue(tabId + "|Cost.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strM_LC_Cost_ID = firstElement(vars, tableSQL);
        if (strM_LC_Cost_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Cost.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_LC_Cost_ID, strPM_Landedcost_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Landedcost_ID, strM_LC_Cost_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");
      

      String strM_LC_Cost_ID = vars.getGlobalVariable("inpmLcCostId", windowId + "|M_LC_Cost_ID", "");
      vars.setSessionValue(tabId + "|Cost.view", "RELATION");
      printPageDataSheet(response, vars, strPM_Landedcost_ID, strM_LC_Cost_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");


      printPageEdit(response, request, vars, true, "", strPM_Landedcost_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");

      String strM_LC_Cost_ID = vars.getGlobalVariable("inpmLcCostId", windowId + "|M_LC_Cost_ID", "");
      vars.setSessionValue(tabId + "|Cost.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strM_LC_Cost_ID, strPM_Landedcost_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");
      String strM_LC_Cost_ID = vars.getRequiredStringParameter("inpmLcCostId");
      
      String strNext = nextElement(vars, strM_LC_Cost_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPM_Landedcost_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");
      String strM_LC_Cost_ID = vars.getRequiredStringParameter("inpmLcCostId");
      
      String strPrevious = previousElement(vars, strM_LC_Cost_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPM_Landedcost_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");

      vars.setSessionValue(tabId + "|Cost.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Cost.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Cost.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Cost.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|M_LC_Cost_ID");
      vars.setSessionValue(windowId + "|M_Landedcost_ID", strPM_Landedcost_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Cost.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Cost.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|M_LC_Cost_ID");
      vars.setSessionValue(windowId + "|M_Landedcost_ID", strPM_Landedcost_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPM_Landedcost_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPM_Landedcost_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPM_Landedcost_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPM_Landedcost_ID);      
      if (!myError.isEmpty()) {        
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
      } 
      else {
		if (myError.isEmpty()) {
		  myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsInserted");
		  myError.setMessage(total + " " + myError.getMessage());
		  vars.setMessage(tabId, myError);
		}        
        if (vars.commandIn("SAVE_NEW_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_NEW_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
    } else if (vars.commandIn("SAVE_EDIT_RELATION", "SAVE_EDIT_NEW", "SAVE_EDIT_EDIT", "SAVE_EDIT_NEXT")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");
      String strM_LC_Cost_ID = vars.getRequiredGlobalVariable("inpmLcCostId", windowId + "|M_LC_Cost_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPM_Landedcost_ID);      
      if (!myError.isEmpty()) {
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
      } 
      else {
        if (myError.isEmpty()) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsUpdated");
          myError.setMessage(total + " " + myError.getMessage());
          vars.setMessage(tabId, myError);
        }
        if (vars.commandIn("SAVE_EDIT_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_EDIT_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else if (vars.commandIn("SAVE_EDIT_NEXT")) {
          String strNext = nextElement(vars, strM_LC_Cost_ID, tableSQL);
          vars.setSessionValue(windowId + "|M_LC_Cost_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
    } else if (vars.commandIn("DELETE")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");

      String strM_LC_Cost_ID = vars.getRequiredStringParameter("inpmLcCostId");
      //CostData data = getEditVariables(vars, strPM_Landedcost_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasNotDeleteAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = CostData.delete(this, strM_LC_Cost_ID, strPM_Landedcost_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
        } catch(ServletException ex) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myError.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myError);
        }
        if (myError==null && total==0) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
        }
        vars.removeSessionValue(windowId + "|mLcCostId");
        vars.setSessionValue(tabId + "|Cost.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());





    } else if (vars.commandIn("BUTTONPosted")) {
        String strM_LC_Cost_ID = vars.getGlobalVariable("inpmLcCostId", windowId + "|M_LC_Cost_ID", "");
        String strTableId = "55A984C314FD4C4FB5E7C32DE36BB07B";
        String strPosted = vars.getStringParameter("inpposted");
        String strProcessId = "";
        log4j.debug("Loading Posted button in table: " + strTableId);
        String strOrg = vars.getStringParameter("inpadOrgId");
        String strClient = vars.getStringParameter("inpadClientId");
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{
          vars.setSessionValue("Posted|key", strM_LC_Cost_ID);
          vars.setSessionValue("Posted|tableId", strTableId);
          vars.setSessionValue("Posted|tabId", tabId);
          vars.setSessionValue("Posted|posted", strPosted);
          vars.setSessionValue("Posted|processId", strProcessId);
          vars.setSessionValue("Posted|path", strDireccion + request.getServletPath());
          vars.setSessionValue("Posted|windowId", windowId);
          vars.setSessionValue("Posted|tabName", "Cost");
          response.sendRedirect(strDireccion + "/ad_actionButton/Posted.html");
        }



    } else if (vars.commandIn("SAVE_XHR")) {
      String strPM_Landedcost_ID = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");
      OBError myError = new OBError();
      JSONObject result = new JSONObject();
      String commandType = vars.getStringParameter("inpCommandType");
      char saveType = "NEW".equals(commandType) ? 'I' : 'U';
      try {
        int total = saveRecord(vars, myError, saveType, strPM_Landedcost_ID);
        if (myError.isEmpty()) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsUpdated");
          myError.setMessage(total + " " + myError.getMessage());
          myError.setType("Success");
        }
        result.put("oberror", myError.toMap());
        result.put("tabid", vars.getStringParameter("tabID"));
        result.put("redirect", strDireccion + request.getServletPath() + "?Command=" + commandType);
      } catch (Exception e) {
        log4j.error("Error saving record (XHR request): " + e.getMessage(), e);
        myError.setType("Error");
        myError.setMessage(e.getMessage());
      }

      response.setContentType("application/json");
      PrintWriter out = response.getWriter();
      out.print(result.toString());
      out.flush();
      out.close();
    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }
  private CostData getEditVariables(Connection con, VariablesSecureApp vars, String strPM_Landedcost_ID) throws IOException,ServletException {
    CostData data = new CostData();
    ServletException ex = null;
    try {
   try {   data.line = vars.getRequiredNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }     data.adOrgId = vars.getRequiredGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.mLandedcostId = vars.getStringParameter("inpmLandedcostId");     data.cDoctypeId = vars.getRequiredStringParameter("inpcDoctypeId");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.mLcTypeId = vars.getRequiredStringParameter("inpmLcTypeId");     data.mLcTypeIdr = vars.getStringParameter("inpmLcTypeId_R");     data.dateacct = vars.getRequiredStringParameter("inpdateacct");     data.cInvoicelineId = vars.getStringParameter("inpcInvoicelineId");    try {   data.amount = vars.getRequiredNumericParameter("inpamount");  } catch (ServletException paramEx) { ex = paramEx; }     data.cCurrencyId = vars.getRequiredStringParameter("inpcCurrencyId");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.mLcDistributionAlgId = vars.getRequiredStringParameter("inpmLcDistributionAlgId");     data.mLcDistributionAlgIdr = vars.getStringParameter("inpmLcDistributionAlgId_R");     data.description = vars.getStringParameter("inpdescription");     data.mInoutId = vars.getStringParameter("inpmInoutId");     data.mInoutIdr = vars.getStringParameter("inpmInoutId_R");    try {   data.matchingAmt = vars.getNumericParameter("inpmatchingAmt");  } catch (ServletException paramEx) { ex = paramEx; }     data.ismatched = vars.getStringParameter("inpismatched", "N");     data.matchingCostadjustmentId = vars.getStringParameter("inpmatchingCostadjustmentId");     data.matchingCostadjustmentIdr = vars.getStringParameter("inpmatchingCostadjustmentId_R");     data.ismatchingadjusted = vars.getStringParameter("inpismatchingadjusted", "N");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.processing = vars.getStringParameter("inpprocessing");     data.posted = vars.getStringParameter("inpposted");     data.processMatching = vars.getStringParameter("inpprocessMatching");     data.cancelMatching = vars.getStringParameter("inpcancelMatching");     data.processed = vars.getStringParameter("inpprocessed", "N");     data.adClientId = vars.getRequiredGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.mLcCostId = vars.getRequestGlobalVariable("inpmLcCostId", windowId + "|M_LC_Cost_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.mLandedcostId = vars.getGlobalVariable("inpmLandedcostId", windowId + "|M_Landedcost_ID");


          vars.getGlobalVariable("inpprocessedheader", windowId + "|ProcessedHeader", "");
    
    

    
    }
    catch(ServletException e) {
    	vars.setEditionData(tabId, data);
    	throw e;
    }
    // Behavior with exception for numeric fields is to catch last one if we have multiple ones
    if(ex != null) {
      vars.setEditionData(tabId, data);
      throw ex;
    }
    return data;
  }


  private void refreshParentSession(VariablesSecureApp vars, String strPM_Landedcost_ID) throws IOException,ServletException {
      
      HeaderData[] data = HeaderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Landedcost_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|ReferenceDate", data[0].referencedate);    vars.setSessionValue(windowId + "|M_CostAdjustment_ID", data[0].mCostadjustmentId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|M_Landedcost_ID", data[0].mLandedcostId);
      vars.setSessionValue(windowId + "|M_Landedcost_ID", strPM_Landedcost_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
      vars.setSessionValue(windowId + "|LCProcessed", HeaderData.selectAuxA8CBEB3ABE9140D5A33334C1AC273517(this, strPM_Landedcost_ID));
      
  }
  
  
  private String getParentID(VariablesSecureApp vars, String strM_LC_Cost_ID) throws ServletException {
    String strPM_Landedcost_ID = CostData.selectParentID(this, strM_LC_Cost_ID);
    if (strPM_Landedcost_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strM_LC_Cost_ID);
      throw new ServletException("Parent record not found");
    }
    return strPM_Landedcost_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|M_LC_Cost_ID", data[0].getField("mLcCostId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPM_Landedcost_ID) throws IOException,ServletException {
      CostData[] data = CostData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Landedcost_ID, vars.getStringParameter("inpmLcCostId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
      refreshSessionEdit(vars, data);
    }

  private String nextElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(), 0, 0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.NEXT, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting next element", e);
      }
      if (data!=null) {
        if (data!=null) return data;
      }
    }
    return strSelected;
  }

  private int getKeyPosition(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("getKeyPosition: " + strSelected);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.GETPOSITION, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting key position", e);
      }
      if (data!=null) {
        // split offset -> (page,relativeOffset)
        int absoluteOffset = Integer.valueOf(data);
        int page = absoluteOffset / TableSQLData.maxRowsPerGridPage;
        int relativeOffset = absoluteOffset % TableSQLData.maxRowsPerGridPage;
        log4j.debug("getKeyPosition: absOffset: " + absoluteOffset + "=> page: " + page + " relOffset: " + relativeOffset);
        String currPageKey = tabId + "|" + "currentPage";
        vars.setSessionValue(currPageKey, String.valueOf(page));
        return relativeOffset;
      }
    }
    return 0;
  }

  private String previousElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.PREVIOUS, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting previous element", e);
      }
      if (data!=null) {
        return data;
      }
    }
    return strSelected;
  }

  private String firstElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,1);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.FIRST, "", tableSQL.getKeyColumn());

      } catch (Exception e) { 
        log4j.debug("Error getting first element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private String lastElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() + " AS ID"), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.LAST, "", tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting last element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPM_Landedcost_ID, String strM_LC_Cost_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");

    String strParamM_Landedcost_ID = vars.getSessionValue(tabId + "|paramM_Landedcost_ID");
String strParamM_Inout_ID = vars.getSessionValue(tabId + "|paramM_Inout_ID");
String strParamAmount = vars.getSessionValue(tabId + "|paramAmount");
String strParamAmount_f = vars.getSessionValue(tabId + "|paramAmount_f");

    boolean hasSearchCondition=false;
    vars.removeEditionData(tabId);
    hasSearchCondition = (tableSQL.hasInternalFilter() && ("").equals(strParamM_Landedcost_ID) && ("").equals(strParamM_Inout_ID) && ("").equals(strParamAmount) && ("").equals(strParamAmount_f)) || !(("").equals(strParamM_Landedcost_ID) || ("%").equals(strParamM_Landedcost_ID))  || !(("").equals(strParamM_Inout_ID) || ("%").equals(strParamM_Inout_ID))  || !(("").equals(strParamAmount) || ("%").equals(strParamAmount))  || !(("").equals(strParamAmount_f) || ("%").equals(strParamAmount_f)) ;
    String strOffset = vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strM_LC_Cost_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strM_LC_Cost_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/LandedCost/Cost_Relation", discard).createXmlDocument();

    boolean hasReadOnlyAccess = org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId);
    ToolBar toolbar = new ToolBar(this, true, vars.getLanguage(), "Cost", false, "document.frmMain.inpmLcCostId", "grid", "..", "".equals("Y"), "LandedCost", strReplaceWith, false, false, false, false, !hasReadOnlyAccess);
    toolbar.setTabId(tabId);
    
    toolbar.setDeleteable(true && !hasReadOnlyAccess);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    xmlDocument.setParameter("keyParent", strPM_Landedcost_ID);
    xmlDocument.setParameter("parentFieldName", Utility.getFieldName("0056819E5168679FE050007F01000569", vars.getLanguage()));


    StringBuffer orderByArray = new StringBuffer();
      vars.setSessionValue(tabId + "|newOrder", "1");
      String positions = vars.getSessionValue(tabId + "|orderbyPositions");
      orderByArray.append("var orderByPositions = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(positions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
      String directions = vars.getSessionValue(tabId + "|orderbyDirections");
      orderByArray.append("var orderByDirections = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(directions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
//    }

    xmlDocument.setParameter("selectedColumn", "\nvar selectedRow = " + selectedRow + ";\n" + orderByArray.toString());
    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("windowId", windowId);
    xmlDocument.setParameter("KeyName", "mLcCostId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      String hideBackButton = vars.getGlobalVariable("hideMenu", "#Hide_BackButton", "");
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Cost_Relation.html", "LandedCost", "W", strReplaceWith, tabs.breadcrumb(), hideBackButton.equals("true"));
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Cost_Relation.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.relationTemplate());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    {
      OBError myMessage = vars.getMessage(tabId);
      vars.removeMessage(tabId);
      if (myMessage!=null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", CostData.selectParent(this, strPM_Landedcost_ID));
    else xmlDocument.setParameter("parent", CostData.selectParentTrl(this, strPM_Landedcost_ID));

    xmlDocument.setParameter("grid", Utility.getContext(this, vars, "#RecordRange", windowId));
xmlDocument.setParameter("grid_Offset", strOffset);
xmlDocument.setParameter("grid_SortCols", positions);
xmlDocument.setParameter("grid_SortDirs", directions);
xmlDocument.setParameter("grid_Default", selectedRow);


    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean _boolNew, String _M_LC_Cost_ID, String strPM_Landedcost_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");

    // copy params to variables as they will be modified later
    boolean boolNew = _boolNew;
    String strM_LC_Cost_ID = _M_LC_Cost_ID;

    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " 1";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    CostData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamM_Landedcost_ID = vars.getSessionValue(tabId + "|paramM_Landedcost_ID");
String strParamM_Inout_ID = vars.getSessionValue(tabId + "|paramM_Inout_ID");
String strParamAmount = vars.getSessionValue(tabId + "|paramAmount");
String strParamAmount_f = vars.getSessionValue(tabId + "|paramAmount_f");

    boolean hasSearchCondition=false;
    hasSearchCondition = (tableSQL.hasInternalFilter() && ("").equals(strParamM_Landedcost_ID) && ("").equals(strParamM_Inout_ID) && ("").equals(strParamAmount) && ("").equals(strParamAmount_f)) || !(("").equals(strParamM_Landedcost_ID) || ("%").equals(strParamM_Landedcost_ID))  || !(("").equals(strParamM_Inout_ID) || ("%").equals(strParamM_Inout_ID))  || !(("").equals(strParamAmount) || ("%").equals(strParamAmount))  || !(("").equals(strParamAmount_f) || ("%").equals(strParamAmount_f)) ;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = CostData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Landedcost_ID, strM_LC_Cost_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strM_LC_Cost_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        data = new CostData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("mLcCostId") == null || dataField.getField("mLcCostId").equals("")) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
      } else {
        discard[0] = new String ("newDiscard");
        strCommand = "EDIT";
      }
    }
    
        String strProcessedHeader = CostData.selectAux27408C217279424DAFD659F7605D09CA(this, strPM_Landedcost_ID);
    vars.setSessionValue(windowId + "|ProcessedHeader", strProcessedHeader);
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars, strPM_Landedcost_ID);
        data = CostData.set(strPM_Landedcost_ID, "", Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), "Y", Utility.getDefault(this, vars, "Createdby", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), CostData.selectDef00568254CB648733E050007F01000513_0(this, Utility.getDefault(this, vars, "Createdby", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField)), Utility.getDefault(this, vars, "Updatedby", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), CostData.selectDef00568254CB668733E050007F01000513_1(this, Utility.getDefault(this, vars, "Updatedby", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField)), Utility.getDefault(this, vars, "M_Inout_ID", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), Utility.getDefault(this, vars, "M_Lc_Type_ID", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), Utility.getDefault(this, vars, "Amount", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "0", dataField), Utility.getDefault(this, vars, "M_Lc_Distribution_Alg_ID", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), Utility.getDefault(this, vars, "Description", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), Utility.getDefault(this, vars, "C_Invoiceline_ID", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), Utility.getDefault(this, vars, "IsMatched", "N", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "N", dataField), Utility.getDefault(this, vars, "IsMatchingAdjusted", "N", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "N", dataField), CostData.selectDef0227873A968BE6FBE050007F01005124(this, strPM_Landedcost_ID, Utility.getContext(this, vars, "m_inout_id", "D1B11CBC0FEF4CA0B44D3BECEBA219BC")), Utility.getDefault(this, vars, "Process_Matching", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "N", dataField), Utility.getDefault(this, vars, "Matching_Amt", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), Utility.getDefault(this, vars, "Cancel_Matching", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "N", dataField), Utility.getDefault(this, vars, "Matching_Costadjustment_ID", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), Utility.getDefault(this, vars, "C_Doctype_ID", "", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), Utility.getDefault(this, vars, "Dateacct", "@Referencedate@", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "", dataField), Utility.getDefault(this, vars, "Posted", "N", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "N", dataField), (vars.getLanguage().equals("en_US")?ListData.selectName(this, "234", Utility.getDefault(this, vars, "Posted", "N", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "N", dataField)):ListData.selectNameTrl(this, vars.getLanguage(), "234", Utility.getDefault(this, vars, "Posted", "N", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "N", dataField))), Utility.getDefault(this, vars, "Processing", "N", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "N", dataField), Utility.getDefault(this, vars, "Processed", "N", "D1B11CBC0FEF4CA0B44D3BECEBA219BC", "N", dataField));
        
      }
     }
      
    String currentPOrg=HeaderData.selectOrg(this, strPM_Landedcost_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean hasReadOnlyAccess = org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId);
    boolean editableTab = (!hasReadOnlyAccess && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (editableTab)
      xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/LandedCost/Cost_Edition",discard).createXmlDocument();
    else
      xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/LandedCost/Cost_NonEditable",discard).createXmlDocument();

    xmlDocument.setParameter("tabId", tabId);
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Cost", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpmLcCostId", "", "..", "".equals("Y"), "LandedCost", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strM_LC_Cost_ID), !hasReadOnlyAccess);
    toolbar.setTabId(tabId);
    toolbar.setDeleteable(true);
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "STD", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());

    // set updated timestamp to manage locking mechanism
    if (!boolNew) {
      xmlDocument.setParameter("updatedTimestamp", (dataField != null ? dataField
          .getField("updatedTimeStamp") : data[0].getField("updatedTimeStamp")));
    }
    
    boolean concurrentSave = vars.getSessionValue(tabId + "|concurrentSave").equals("true");
    if (concurrentSave) {
      //after concurrent save error, force autosave
      xmlDocument.setParameter("autosave", "Y");
    } else {
      xmlDocument.setParameter("autosave", "N");
    }
    vars.removeSessionValue(tabId + "|concurrentSave");

    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, true, (strCommand.equalsIgnoreCase("NEW")));
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      // if (!strM_LC_Cost_ID.equals("")) xmlDocument.setParameter("childTabContainer", tabs.childTabs(false));
	  // else xmlDocument.setParameter("childTabContainer", tabs.childTabs(true));
	  xmlDocument.setParameter("childTabContainer", tabs.childTabs(false));
	  String hideBackButton = vars.getGlobalVariable("hideMenu", "#Hide_BackButton", "");
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Cost_Relation.html", "LandedCost", "W", strReplaceWith, tabs.breadcrumb(), hideBackButton.equals("true"), !concurrentSave);
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Cost_Relation.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.editionTemplate(strCommand.equals("NEW")));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
		
        xmlDocument.setParameter("ProcessedHeader", strProcessedHeader);
    
    xmlDocument.setParameter("parentOrg", currentPOrg);
    xmlDocument.setParameter("commandType", strCommand);
    xmlDocument.setParameter("buscador",buscador);
    xmlDocument.setParameter("windowId", windowId);
    xmlDocument.setParameter("changed", "");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    final String strMappingName = Utility.getTabURL(tabId, "E", false);
    xmlDocument.setParameter("mappingName", strMappingName);
    xmlDocument.setParameter("confirmOnChanges", Utility.getJSConfirmOnChanges(vars, windowId));
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));

    xmlDocument.setParameter("paramSessionDate", strParamSessionDate);

    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    OBError myMessage = vars.getMessage(tabId);
    vars.removeMessage(tabId);
    if (myMessage!=null) {
      xmlDocument.setParameter("messageType", myMessage.getType());
      xmlDocument.setParameter("messageTitle", myMessage.getTitle());
      xmlDocument.setParameter("messageMessage", myMessage.getMessage());
    }
    xmlDocument.setParameter("displayLogic", getDisplayLogicContext(vars, boolNew));
    
    
     if (dataField==null) {
      xmlDocument.setData("structure1",data);
      
    } else {
      
        FieldProvider[] dataAux = new FieldProvider[1];
        dataAux[0] = dataField;
        
        xmlDocument.setData("structure1",dataAux);
      
    }
    
      
   
    try {
      ComboTableData comboTableData = null;
comboTableData = new ComboTableData(vars, this, "19", "C_Doctype_ID", "", "012167BBF1BF42ED964D9C18CFC55A27", Utility.getReferenceableOrg(vars, (dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId").equals("")?vars.getOrg():data[0].getField("adOrgId"))), Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("cDoctypeId"):dataField.getField("cDoctypeId")));
xmlDocument.setData("reportC_Doctype_ID","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
comboTableData = new ComboTableData(vars, this, "19", "M_Lc_Type_ID", "", "", Utility.getReferenceableOrg(vars, (dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId").equals("")?vars.getOrg():data[0].getField("adOrgId"))), Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("mLcTypeId"):dataField.getField("mLcTypeId")));
xmlDocument.setData("reportM_Lc_Type_ID","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
xmlDocument.setParameter("Dateacct_Format", vars.getSessionValue("#AD_SqlDateFormat"));
xmlDocument.setParameter("buttonAmount", Utility.messageBD(this, "Calc", vars.getLanguage()));
comboTableData = new ComboTableData(vars, this, "19", "C_Currency_ID", "", "", Utility.getReferenceableOrg(vars, (dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId").equals("")?vars.getOrg():data[0].getField("adOrgId"))), Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("cCurrencyId"):dataField.getField("cCurrencyId")));
xmlDocument.setData("reportC_Currency_ID","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
comboTableData = new ComboTableData(vars, this, "19", "M_Lc_Distribution_Alg_ID", "", "", Utility.getReferenceableOrg(vars, (dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId").equals("")?vars.getOrg():data[0].getField("adOrgId"))), Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("mLcDistributionAlgId"):dataField.getField("mLcDistributionAlgId")));
xmlDocument.setData("reportM_Lc_Distribution_Alg_ID","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
comboTableData = new ComboTableData(vars, this, "19", "M_Inout_ID", "", "", Utility.getReferenceableOrg(vars, (dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId").equals("")?vars.getOrg():data[0].getField("adOrgId"))), Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("mInoutId"):dataField.getField("mInoutId")));
xmlDocument.setData("reportM_Inout_ID","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
xmlDocument.setParameter("buttonMatching_Amt", Utility.messageBD(this, "Calc", vars.getLanguage()));
comboTableData = new ComboTableData(vars, this, "18", "Matching_Costadjustment_ID", "DA2E8CEC6A584B7A8052AE1F19551138", "", Utility.getReferenceableOrg(vars, (dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId").equals("")?vars.getOrg():data[0].getField("adOrgId"))), Utility.getContext(this, vars, "#User_Client", windowId), 0);
Utility.fillSQLParameters(this, vars, (dataField==null?data[0]:dataField), comboTableData, windowId, (dataField==null?data[0].getField("matchingCostadjustmentId"):dataField.getField("matchingCostadjustmentId")));
xmlDocument.setData("reportMatching_Costadjustment_ID","liststructure", comboTableData.select(!strCommand.equals("NEW")));
comboTableData = null;
xmlDocument.setParameter("Posted_BTNname", Utility.getButtonName(this, vars, "234", (dataField==null?data[0].getField("posted"):dataField.getField("posted")), "Posted_linkBTN", usedButtonShortCuts, reservedButtonShortCuts));boolean modalPosted = org.openbravo.erpCommon.utility.Utility.isModalProcess(""); 
xmlDocument.setParameter("Posted_Modal", modalPosted?"true":"false");
xmlDocument.setParameter("Process_Matching_BTNname", Utility.getButtonName(this, vars, "022DB9FBFB7E3B3FE050007F01000850", "Process_Matching_linkBTN", usedButtonShortCuts, reservedButtonShortCuts));boolean modalProcess_Matching = org.openbravo.erpCommon.utility.Utility.isModalProcess(""); 
xmlDocument.setParameter("Process_Matching_Modal", modalProcess_Matching?"true":"false");
xmlDocument.setParameter("Cancel_Matching_BTNname", Utility.getButtonName(this, vars, "023A9D09DFBE4316E050007F01005DAC", "Cancel_Matching_linkBTN", usedButtonShortCuts, reservedButtonShortCuts));boolean modalCancel_Matching = org.openbravo.erpCommon.utility.Utility.isModalProcess(""); 
xmlDocument.setParameter("Cancel_Matching_Modal", modalCancel_Matching?"true":"false");
xmlDocument.setParameter("Created_Format", vars.getSessionValue("#AD_SqlDateTimeFormat"));xmlDocument.setParameter("Created_Maxlength", Integer.toString(vars.getSessionValue("#AD_SqlDateTimeFormat").length()));
xmlDocument.setParameter("Updated_Format", vars.getSessionValue("#AD_SqlDateTimeFormat"));xmlDocument.setParameter("Updated_Maxlength", Integer.toString(vars.getSessionValue("#AD_SqlDateTimeFormat").length()));
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new ServletException(ex);
    }

    xmlDocument.setParameter("scriptOnLoad", getShortcutScript(usedButtonShortCuts, reservedButtonShortCuts));
    
    final String refererURL = vars.getSessionValue(tabId + "|requestURL");
    vars.removeSessionValue(tabId + "|requestURL");
    if(!refererURL.equals("")) {
    	final Boolean failedAutosave = (Boolean) vars.getSessionObject(tabId + "|failedAutosave");
		vars.removeSessionValue(tabId + "|failedAutosave");
    	if(failedAutosave != null && failedAutosave) {
    		final String jsFunction = "continueUserAction('"+refererURL+"');";
    		xmlDocument.setParameter("failedAutosave", jsFunction);
    	}
    }

    if (strCommand.equalsIgnoreCase("NEW")) {
      vars.removeSessionValue(tabId + "|failedAutosave");
      vars.removeSessionValue(strMappingName + "|hash");
    }

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageButtonFS(HttpServletResponse response, VariablesSecureApp vars, String strProcessId, String path) throws IOException, ServletException {
    log4j.debug("Output: Frames action button");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    xmlDocument.setParameter("type", strDireccion + path);
    out.println(xmlDocument.print());
    out.close();
  }





    private String getDisplayLogicContext(VariablesSecureApp vars, boolean isNew) throws IOException, ServletException {
      log4j.debug("Output: Display logic context fields");
      String result = "var strLCProcessed=\"" +Utility.getContext(this, vars, "LCProcessed", windowId) + "\";\nvar strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
      return result;
    }


    private String getReadOnlyLogicContext(VariablesSecureApp vars) throws IOException, ServletException {
      log4j.debug("Output: Read Only logic context fields");
      String result = "var strHeaderStatus=\"" + Utility.getContext(this, vars, "HeaderStatus", windowId) + "\";\n";
      return result;
    }




 
  private String getShortcutScript( HashMap<String, String> usedButtonShortCuts, HashMap<String, String> reservedButtonShortCuts){
    StringBuffer shortcuts = new StringBuffer();
    shortcuts.append(" function buttonListShorcuts() {\n");
    Iterator<String> ik = usedButtonShortCuts.keySet().iterator();
    Iterator<String> iv = usedButtonShortCuts.values().iterator();
    while(ik.hasNext() && iv.hasNext()){
      shortcuts.append("  keyArray[keyArray.length] = new keyArrayItem(\"").append(ik.next()).append("\", \"").append(iv.next()).append("\", null, \"altKey\", false, \"onkeydown\");\n");
    }
    shortcuts.append(" return true;\n}");
    return shortcuts.toString();
  }
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPM_Landedcost_ID) throws IOException, ServletException {
    CostData data = null;
    int total = 0;
    if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        myError.setError(newError);
        vars.setMessage(tabId, myError);
    }
    else {
        Connection con = null;
        try {
            con = this.getTransactionConnection();
            data = getEditVariables(con, vars, strPM_Landedcost_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = SequenceIdData.getUUID();
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.mLcCostId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (CostData.getCurrentDBTimestamp(this, data.mLcCostId).equals(
                vars.getStringParameter("updatedTimestamp"))) {
                total = data.update(con, this);
               } else {
                 myError.setMessage(Replace.replace(Replace.replace(Utility.messageBD(this,
                    "SavingModifiedRecord", vars.getLanguage()), "\\n", "<br/>"), "&quot;", "\""));
                 myError.setType("Error");
                 vars.setSessionValue(tabId + "|concurrentSave", "true");
               } 
		     }		            
          
            }
                else {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
            myError.setError(newError);            
          }
          releaseCommitConnection(con);
        } catch(Exception ex) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
            myError.setError(newError);   
            try {
              releaseRollbackConnection(con);
            } catch (final Exception e) { //do nothing 
            }           
        }
            
        if (myError.isEmpty() && total == 0) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=DBExecuteError");
            myError.setError(newError);
        }
        vars.setMessage(tabId, myError);
            
        if(!myError.isEmpty()){
            if(data != null ) {
                if(type == 'I') {            			
                    data.mLcCostId = "";
                }
                else {                    
                    
                        //BUTTON TEXT FILLING
                    data.postedBtn = ActionButtonDefaultData.getText(this, vars.getLanguage(), "234", data.getField("Posted"));
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|M_LC_Cost_ID", data.mLcCostId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Cost. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
