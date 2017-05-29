//Sqlc generated V1.O00-1
package org.openbravo.client.kernel;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class KernelUtilsData implements FieldProvider {
static Logger log4j = Logger.getLogger(KernelUtilsData.class);
  private String InitRecordNumber="0";
  public String adTabId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static String getParentTab(ConnectionProvider connectionProvider, String windowId, String tabLevel, String sequenceNumber)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select t.ad_tab_id" +
      "        from ad_tab t" +
      "        where t.ad_window_id = ?" +
      "        and t.seqno =" +
      "        (" +
      "        select max(seqno)" +
      "        from ad_tab" +
      "        where ad_window_id = t.ad_window_id" +
      "        and tabLevel = (TO_NUMBER(?)-1)" +
      "        and seqno < TO_NUMBER(?)" +
      "        )";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabLevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sequenceNumber);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tab_id");
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

  public static KernelUtilsData[] getAllSubtabs(ConnectionProvider connectionProvider, String windowId, String sequenceNumber, String tabLevel)    throws ServletException {
    return getAllSubtabs(connectionProvider, windowId, sequenceNumber, tabLevel, 0, 0);
  }

  public static KernelUtilsData[] getAllSubtabs(ConnectionProvider connectionProvider, String windowId, String sequenceNumber, String tabLevel, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select t.ad_tab_id" +
      "        from ad_tab t" +
      "        where ad_window_id = ?" +
      "        and seqno > TO_NUMBER(?)" +
      "        and seqno < (select coalesce(min(seqno), 999999) from ad_tab" +
      "        where tablevel <= TO_NUMBER(?)" +
      "        and seqno > TO_NUMBER(?)" +
      "        and ad_window_id = ?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sequenceNumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabLevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sequenceNumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

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
        KernelUtilsData objectKernelUtilsData = new KernelUtilsData();
        objectKernelUtilsData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectKernelUtilsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectKernelUtilsData);
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
    KernelUtilsData objectKernelUtilsData[] = new KernelUtilsData[vector.size()];
    vector.copyInto(objectKernelUtilsData);
    return(objectKernelUtilsData);
  }

  public static KernelUtilsData[] getFirstLevelSubtabs(ConnectionProvider connectionProvider, String windowId, String sequenceNumber, String tabLevel)    throws ServletException {
    return getFirstLevelSubtabs(connectionProvider, windowId, sequenceNumber, tabLevel, 0, 0);
  }

  public static KernelUtilsData[] getFirstLevelSubtabs(ConnectionProvider connectionProvider, String windowId, String sequenceNumber, String tabLevel, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select t.ad_tab_id" +
      "        from ad_tab t" +
      "        where ad_window_id = ?" +
      "        and seqno > TO_NUMBER(?)" +
      "        and tablevel = (TO_NUMBER(?)+1)" +
      "        and seqno < (select coalesce(min(seqno), 999999) from ad_tab" +
      "        where tablevel <= TO_NUMBER(?)" +
      "        and seqno > TO_NUMBER(?)" +
      "        and ad_window_id = ?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sequenceNumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabLevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tabLevel);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sequenceNumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, windowId);

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
        KernelUtilsData objectKernelUtilsData = new KernelUtilsData();
        objectKernelUtilsData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectKernelUtilsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectKernelUtilsData);
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
    KernelUtilsData objectKernelUtilsData[] = new KernelUtilsData[vector.size()];
    vector.copyInto(objectKernelUtilsData);
    return(objectKernelUtilsData);
  }
}
