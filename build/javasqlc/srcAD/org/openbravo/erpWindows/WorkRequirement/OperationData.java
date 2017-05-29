//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.WorkRequirement;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

/**
WAD Generated class
 */
class OperationData implements FieldProvider {
static Logger log4j = Logger.getLogger(OperationData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String seqno;
  public String maSequenceId;
  public String maSequenceIdr;
  public String maProcessId;
  public String maProcessIdr;
  public String startdate;
  public String enddate;
  public String estimatedtime;
  public String runtime;
  public String quantity;
  public String donequantity;
  public String costcenteruse;
  public String description;
  public String noqty;
  public String groupuse;
  public String closed;
  public String outsourced;
  public String preptime;
  public String usedmaterial;
  public String maWorkrequirementId;
  public String isactive;
  public String maWrphaseId;
  public String name;
  public String adOrgId;
  public String adClientId;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("ma_sequence_id") || fieldName.equals("maSequenceId"))
      return maSequenceId;
    else if (fieldName.equalsIgnoreCase("ma_sequence_idr") || fieldName.equals("maSequenceIdr"))
      return maSequenceIdr;
    else if (fieldName.equalsIgnoreCase("ma_process_id") || fieldName.equals("maProcessId"))
      return maProcessId;
    else if (fieldName.equalsIgnoreCase("ma_process_idr") || fieldName.equals("maProcessIdr"))
      return maProcessIdr;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("estimatedtime"))
      return estimatedtime;
    else if (fieldName.equalsIgnoreCase("runtime"))
      return runtime;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("donequantity"))
      return donequantity;
    else if (fieldName.equalsIgnoreCase("costcenteruse"))
      return costcenteruse;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("noqty"))
      return noqty;
    else if (fieldName.equalsIgnoreCase("groupuse"))
      return groupuse;
    else if (fieldName.equalsIgnoreCase("closed"))
      return closed;
    else if (fieldName.equalsIgnoreCase("outsourced"))
      return outsourced;
    else if (fieldName.equalsIgnoreCase("preptime"))
      return preptime;
    else if (fieldName.equalsIgnoreCase("usedmaterial"))
      return usedmaterial;
    else if (fieldName.equalsIgnoreCase("ma_workrequirement_id") || fieldName.equals("maWorkrequirementId"))
      return maWorkrequirementId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ma_wrphase_id") || fieldName.equals("maWrphaseId"))
      return maWrphaseId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static OperationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maWorkrequirementId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maWorkrequirementId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static OperationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maWorkrequirementId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_WRPhase.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_WRPhase.CreatedBy) as CreatedByR, " +
      "        to_char(MA_WRPhase.Updated, ?) as updated, " +
      "        to_char(MA_WRPhase.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_WRPhase.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_WRPhase.UpdatedBy) as UpdatedByR," +
      "        MA_WRPhase.SeqNo, " +
      "MA_WRPhase.MA_Sequence_ID, " +
      "(CASE WHEN MA_WRPhase.MA_Sequence_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS MA_Sequence_IDR, " +
      "MA_WRPhase.MA_Process_ID, " +
      "(CASE WHEN MA_WRPhase.MA_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS MA_Process_IDR, " +
      "MA_WRPhase.Startdate, " +
      "MA_WRPhase.Enddate, " +
      "MA_WRPhase.Estimatedtime, " +
      "MA_WRPhase.Runtime, " +
      "MA_WRPhase.Quantity, " +
      "MA_WRPhase.Donequantity, " +
      "MA_WRPhase.CostCenterUse, " +
      "MA_WRPhase.Description, " +
      "COALESCE(MA_WRPhase.Noqty, 'N') AS Noqty, " +
      "COALESCE(MA_WRPhase.Groupuse, 'N') AS Groupuse, " +
      "MA_WRPhase.Closed, " +
      "COALESCE(MA_WRPhase.Outsourced, 'N') AS Outsourced, " +
      "MA_WRPhase.Preptime, " +
      "COALESCE(MA_WRPhase.Usedmaterial, 'N') AS Usedmaterial, " +
      "MA_WRPhase.MA_Workrequirement_ID, " +
      "COALESCE(MA_WRPhase.IsActive, 'N') AS IsActive, " +
      "MA_WRPhase.MA_Wrphase_ID, " +
      "MA_WRPhase.Name, " +
      "MA_WRPhase.AD_Org_ID, " +
      "MA_WRPhase.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_WRPhase left join (select MA_Sequence_ID, Name from MA_Sequence) table1 on (MA_WRPhase.MA_Sequence_ID = table1.MA_Sequence_ID) left join (select MA_Process_ID, Name from MA_Process) table2 on (MA_WRPhase.MA_Process_ID = table2.MA_Process_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maWorkrequirementId==null || maWorkrequirementId.equals(""))?"":"  AND MA_WRPhase.MA_Workrequirement_ID = ?  ");
    strSql = strSql + 
      "        AND MA_WRPhase.MA_Wrphase_ID = ? " +
      "        AND MA_WRPhase.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_WRPhase.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (maWorkrequirementId != null && !(maWorkrequirementId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        OperationData objectOperationData = new OperationData();
        objectOperationData.created = UtilSql.getValue(result, "created");
        objectOperationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectOperationData.updated = UtilSql.getValue(result, "updated");
        objectOperationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectOperationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectOperationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectOperationData.seqno = UtilSql.getValue(result, "seqno");
        objectOperationData.maSequenceId = UtilSql.getValue(result, "ma_sequence_id");
        objectOperationData.maSequenceIdr = UtilSql.getValue(result, "ma_sequence_idr");
        objectOperationData.maProcessId = UtilSql.getValue(result, "ma_process_id");
        objectOperationData.maProcessIdr = UtilSql.getValue(result, "ma_process_idr");
        objectOperationData.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectOperationData.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectOperationData.estimatedtime = UtilSql.getValue(result, "estimatedtime");
        objectOperationData.runtime = UtilSql.getValue(result, "runtime");
        objectOperationData.quantity = UtilSql.getValue(result, "quantity");
        objectOperationData.donequantity = UtilSql.getValue(result, "donequantity");
        objectOperationData.costcenteruse = UtilSql.getValue(result, "costcenteruse");
        objectOperationData.description = UtilSql.getValue(result, "description");
        objectOperationData.noqty = UtilSql.getValue(result, "noqty");
        objectOperationData.groupuse = UtilSql.getValue(result, "groupuse");
        objectOperationData.closed = UtilSql.getValue(result, "closed");
        objectOperationData.outsourced = UtilSql.getValue(result, "outsourced");
        objectOperationData.preptime = UtilSql.getValue(result, "preptime");
        objectOperationData.usedmaterial = UtilSql.getValue(result, "usedmaterial");
        objectOperationData.maWorkrequirementId = UtilSql.getValue(result, "ma_workrequirement_id");
        objectOperationData.isactive = UtilSql.getValue(result, "isactive");
        objectOperationData.maWrphaseId = UtilSql.getValue(result, "ma_wrphase_id");
        objectOperationData.name = UtilSql.getValue(result, "name");
        objectOperationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOperationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectOperationData.language = UtilSql.getValue(result, "language");
        objectOperationData.adUserClient = "";
        objectOperationData.adOrgClient = "";
        objectOperationData.createdby = "";
        objectOperationData.trBgcolor = "";
        objectOperationData.totalCount = "";
        objectOperationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOperationData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    OperationData objectOperationData[] = new OperationData[vector.size()];
    vector.copyInto(objectOperationData);
    return(objectOperationData);
  }

/**
Create a registry
 */
  public static OperationData[] set(String maWorkrequirementId, String estimatedtime, String usedmaterial, String startdate, String maWrphaseId, String adClientId, String adOrgId, String isactive, String createdby, String createdbyr, String updatedby, String updatedbyr, String maProcessId, String quantity, String donequantity, String costcenteruse, String preptime, String closed, String seqno, String noqty, String groupuse, String maSequenceId, String name, String description, String outsourced, String enddate, String runtime)    throws ServletException {
    OperationData objectOperationData[] = new OperationData[1];
    objectOperationData[0] = new OperationData();
    objectOperationData[0].created = "";
    objectOperationData[0].createdbyr = createdbyr;
    objectOperationData[0].updated = "";
    objectOperationData[0].updatedTimeStamp = "";
    objectOperationData[0].updatedby = updatedby;
    objectOperationData[0].updatedbyr = updatedbyr;
    objectOperationData[0].seqno = seqno;
    objectOperationData[0].maSequenceId = maSequenceId;
    objectOperationData[0].maSequenceIdr = "";
    objectOperationData[0].maProcessId = maProcessId;
    objectOperationData[0].maProcessIdr = "";
    objectOperationData[0].startdate = startdate;
    objectOperationData[0].enddate = enddate;
    objectOperationData[0].estimatedtime = estimatedtime;
    objectOperationData[0].runtime = runtime;
    objectOperationData[0].quantity = quantity;
    objectOperationData[0].donequantity = donequantity;
    objectOperationData[0].costcenteruse = costcenteruse;
    objectOperationData[0].description = description;
    objectOperationData[0].noqty = noqty;
    objectOperationData[0].groupuse = groupuse;
    objectOperationData[0].closed = closed;
    objectOperationData[0].outsourced = outsourced;
    objectOperationData[0].preptime = preptime;
    objectOperationData[0].usedmaterial = usedmaterial;
    objectOperationData[0].maWorkrequirementId = maWorkrequirementId;
    objectOperationData[0].isactive = isactive;
    objectOperationData[0].maWrphaseId = maWrphaseId;
    objectOperationData[0].name = name;
    objectOperationData[0].adOrgId = adOrgId;
    objectOperationData[0].adClientId = adClientId;
    objectOperationData[0].language = "";
    return objectOperationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef801569_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as Createdby FROM AD_User left join (select AD_User_ID, Name from AD_User) table2 on (AD_User.AD_User_ID = table2.AD_User_ID) WHERE AD_User.isActive='Y' AND AD_User.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef801571_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))), '') ) as Updatedby FROM AD_User left join (select AD_User_ID, Name from AD_User) table2 on (AD_User.AD_User_ID = table2.AD_User_ID) WHERE AD_User.isActive='Y' AND AD_User.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef801759(ConnectionProvider connectionProvider, String MA_WORKREQUIREMENT_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SEQNO),0)+10 AS DefaultValue FROM MA_WRPHASE WHERE MA_WORKREQUIREMENT_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_WORKREQUIREMENT_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MA_WRPhase.MA_Workrequirement_ID AS NAME" +
      "        FROM MA_WRPhase" +
      "        WHERE MA_WRPhase.MA_Wrphase_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String maWorkrequirementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.StartDate, 'DD-MM-YYYY')) AS NAME FROM MA_WorkRequirement left join (select MA_Workrequirement_ID, DocumentNo, StartDate from MA_Workrequirement) table1 on (MA_WorkRequirement.MA_Workrequirement_ID = table1.MA_Workrequirement_ID) WHERE MA_WorkRequirement.MA_Workrequirement_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maWorkrequirementId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.DocumentNo), '')) || ' - ' || TO_CHAR(table1.StartDate, 'DD-MM-YYYY')) AS NAME FROM MA_WorkRequirement left join (select MA_Workrequirement_ID, DocumentNo, StartDate from MA_Workrequirement) table1 on (MA_WorkRequirement.MA_Workrequirement_ID = table1.MA_Workrequirement_ID) WHERE MA_WorkRequirement.MA_Workrequirement_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE MA_WRPhase" +
      "        SET SeqNo = TO_NUMBER(?) , MA_Sequence_ID = (?) , MA_Process_ID = (?) , Startdate = TO_DATE(?) , Enddate = TO_DATE(?) , Estimatedtime = TO_NUMBER(?) , Runtime = TO_NUMBER(?) , Quantity = TO_NUMBER(?) , Donequantity = TO_NUMBER(?) , CostCenterUse = TO_NUMBER(?) , Description = (?) , Noqty = (?) , Groupuse = (?) , Closed = (?) , Outsourced = (?) , Preptime = TO_NUMBER(?) , Usedmaterial = (?) , MA_Workrequirement_ID = (?) , IsActive = (?) , MA_Wrphase_ID = (?) , Name = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_WRPhase.MA_Wrphase_ID = ? " +
      "                 AND MA_WRPhase.MA_Workrequirement_ID = ? " +
      "        AND MA_WRPhase.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_WRPhase.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, runtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, donequantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costcenteruse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, noqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupuse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preptime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usedmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWrphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWrphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO MA_WRPhase " +
      "        (SeqNo, MA_Sequence_ID, MA_Process_ID, Startdate, Enddate, Estimatedtime, Runtime, Quantity, Donequantity, CostCenterUse, Description, Noqty, Groupuse, Closed, Outsourced, Preptime, Usedmaterial, MA_Workrequirement_ID, IsActive, MA_Wrphase_ID, Name, AD_Org_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES (TO_NUMBER(?), (?), (?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, runtime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, donequantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costcenteruse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, noqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, groupuse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, closed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, outsourced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preptime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, usedmaterial);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWrphaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int delete(ConnectionProvider connectionProvider, String param1, String maWorkrequirementId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_WRPhase" +
      "        WHERE MA_WRPhase.MA_Wrphase_ID = ? " +
      "                 AND MA_WRPhase.MA_Workrequirement_ID = ? " +
      "        AND MA_WRPhase.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_WRPhase.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM MA_WRPhase" +
      "         WHERE MA_WRPhase.MA_Wrphase_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM MA_WRPhase" +
      "         WHERE MA_WRPhase.MA_Wrphase_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }
}
