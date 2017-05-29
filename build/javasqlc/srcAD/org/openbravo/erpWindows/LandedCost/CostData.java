//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.LandedCost;

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
class CostData implements FieldProvider {
static Logger log4j = Logger.getLogger(CostData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String line;
  public String adOrgId;
  public String mLandedcostId;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String mLcTypeId;
  public String mLcTypeIdr;
  public String dateacct;
  public String cInvoicelineId;
  public String amount;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String mLcDistributionAlgId;
  public String mLcDistributionAlgIdr;
  public String description;
  public String mInoutId;
  public String mInoutIdr;
  public String matchingAmt;
  public String ismatched;
  public String matchingCostadjustmentId;
  public String matchingCostadjustmentIdr;
  public String ismatchingadjusted;
  public String isactive;
  public String processing;
  public String posted;
  public String postedBtn;
  public String processMatching;
  public String cancelMatching;
  public String processed;
  public String adClientId;
  public String mLcCostId;
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
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("m_landedcost_id") || fieldName.equals("mLandedcostId"))
      return mLandedcostId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("m_lc_type_id") || fieldName.equals("mLcTypeId"))
      return mLcTypeId;
    else if (fieldName.equalsIgnoreCase("m_lc_type_idr") || fieldName.equals("mLcTypeIdr"))
      return mLcTypeIdr;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_invoiceline_id") || fieldName.equals("cInvoicelineId"))
      return cInvoicelineId;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("m_lc_distribution_alg_id") || fieldName.equals("mLcDistributionAlgId"))
      return mLcDistributionAlgId;
    else if (fieldName.equalsIgnoreCase("m_lc_distribution_alg_idr") || fieldName.equals("mLcDistributionAlgIdr"))
      return mLcDistributionAlgIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("m_inout_id") || fieldName.equals("mInoutId"))
      return mInoutId;
    else if (fieldName.equalsIgnoreCase("m_inout_idr") || fieldName.equals("mInoutIdr"))
      return mInoutIdr;
    else if (fieldName.equalsIgnoreCase("matching_amt") || fieldName.equals("matchingAmt"))
      return matchingAmt;
    else if (fieldName.equalsIgnoreCase("ismatched"))
      return ismatched;
    else if (fieldName.equalsIgnoreCase("matching_costadjustment_id") || fieldName.equals("matchingCostadjustmentId"))
      return matchingCostadjustmentId;
    else if (fieldName.equalsIgnoreCase("matching_costadjustment_idr") || fieldName.equals("matchingCostadjustmentIdr"))
      return matchingCostadjustmentIdr;
    else if (fieldName.equalsIgnoreCase("ismatchingadjusted"))
      return ismatchingadjusted;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("posted_btn") || fieldName.equals("postedBtn"))
      return postedBtn;
    else if (fieldName.equalsIgnoreCase("process_matching") || fieldName.equals("processMatching"))
      return processMatching;
    else if (fieldName.equalsIgnoreCase("cancel_matching") || fieldName.equals("cancelMatching"))
      return cancelMatching;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("m_lc_cost_id") || fieldName.equals("mLcCostId"))
      return mLcCostId;
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
  public static CostData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mLandedcostId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mLandedcostId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CostData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mLandedcostId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_LC_Cost.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_LC_Cost.CreatedBy) as CreatedByR, " +
      "        to_char(M_LC_Cost.Updated, ?) as updated, " +
      "        to_char(M_LC_Cost.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_LC_Cost.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_LC_Cost.UpdatedBy) as UpdatedByR," +
      "        M_LC_Cost.Line, " +
      "M_LC_Cost.AD_Org_ID, " +
      "M_LC_Cost.M_Landedcost_ID, " +
      "M_LC_Cost.C_Doctype_ID, " +
      "(CASE WHEN M_LC_Cost.C_Doctype_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS C_Doctype_IDR, " +
      "M_LC_Cost.M_Lc_Type_ID, " +
      "(CASE WHEN M_LC_Cost.M_Lc_Type_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS M_Lc_Type_IDR, " +
      "M_LC_Cost.Dateacct, " +
      "M_LC_Cost.C_Invoiceline_ID, " +
      "M_LC_Cost.Amount, " +
      "M_LC_Cost.C_Currency_ID, " +
      "(CASE WHEN M_LC_Cost.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "M_LC_Cost.M_Lc_Distribution_Alg_ID, " +
      "(CASE WHEN M_LC_Cost.M_Lc_Distribution_Alg_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS M_Lc_Distribution_Alg_IDR, " +
      "M_LC_Cost.Description, " +
      "M_LC_Cost.M_Inout_ID, " +
      "(CASE WHEN M_LC_Cost.M_Inout_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table6.MovementDate, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS M_Inout_IDR, " +
      "M_LC_Cost.Matching_Amt, " +
      "COALESCE(M_LC_Cost.IsMatched, 'N') AS IsMatched, " +
      "M_LC_Cost.Matching_Costadjustment_ID, " +
      "(CASE WHEN M_LC_Cost.Matching_Costadjustment_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Documentno), ''))),'') ) END) AS Matching_Costadjustment_IDR, " +
      "COALESCE(M_LC_Cost.IsMatchingAdjusted, 'N') AS IsMatchingAdjusted, " +
      "COALESCE(M_LC_Cost.Isactive, 'N') AS Isactive, " +
      "M_LC_Cost.Processing, " +
      "M_LC_Cost.Posted, " +
      "list1.name as Posted_BTN, " +
      "M_LC_Cost.Process_Matching, " +
      "M_LC_Cost.Cancel_Matching, " +
      "COALESCE(M_LC_Cost.Processed, 'N') AS Processed, " +
      "M_LC_Cost.AD_Client_ID, " +
      "M_LC_Cost.M_LC_Cost_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM M_LC_Cost left join (select C_Doctype_ID, Name from C_Doctype) table1 on (M_LC_Cost.C_Doctype_ID = table1.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL1 on (table1.C_DocType_ID = tableTRL1.C_DocType_ID and tableTRL1.AD_Language = ?)  left join (select M_Lc_Type_ID, Name from M_Lc_Type) table3 on (M_LC_Cost.M_Lc_Type_ID = table3.M_Lc_Type_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table4 on (M_LC_Cost.C_Currency_ID = table4.C_Currency_ID) left join (select M_Lc_Distribution_Alg_ID, Name from M_Lc_Distribution_Alg) table5 on (M_LC_Cost.M_Lc_Distribution_Alg_ID = table5.M_Lc_Distribution_Alg_ID) left join (select M_Inout_ID, DocumentNo, MovementDate, C_BPartner_ID from M_Inout) table6 on (M_LC_Cost.M_Inout_ID = table6.M_Inout_ID) left join (select C_BPartner_ID, Name from C_BPartner) table7 on (table6.C_BPartner_ID = table7.C_BPartner_ID) left join (select M_CostAdjustment_ID, Documentno from M_CostAdjustment) table8 on (M_LC_Cost.Matching_Costadjustment_ID =  table8.M_CostAdjustment_ID) left join ad_ref_list_v list1 on (list1.ad_reference_id = '234' and list1.ad_language = ?  AND M_LC_Cost.Posted = TO_CHAR(list1.value))" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mLandedcostId==null || mLandedcostId.equals(""))?"":"  AND M_LC_Cost.M_Landedcost_ID = ?  ");
    strSql = strSql + 
      "        AND M_LC_Cost.M_LC_Cost_ID = ? " +
      "        AND M_LC_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_LC_Cost.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (mLandedcostId != null && !(mLandedcostId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLandedcostId);
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
        CostData objectCostData = new CostData();
        objectCostData.created = UtilSql.getValue(result, "created");
        objectCostData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCostData.updated = UtilSql.getValue(result, "updated");
        objectCostData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCostData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCostData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCostData.line = UtilSql.getValue(result, "line");
        objectCostData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCostData.mLandedcostId = UtilSql.getValue(result, "m_landedcost_id");
        objectCostData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectCostData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectCostData.mLcTypeId = UtilSql.getValue(result, "m_lc_type_id");
        objectCostData.mLcTypeIdr = UtilSql.getValue(result, "m_lc_type_idr");
        objectCostData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectCostData.cInvoicelineId = UtilSql.getValue(result, "c_invoiceline_id");
        objectCostData.amount = UtilSql.getValue(result, "amount");
        objectCostData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCostData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectCostData.mLcDistributionAlgId = UtilSql.getValue(result, "m_lc_distribution_alg_id");
        objectCostData.mLcDistributionAlgIdr = UtilSql.getValue(result, "m_lc_distribution_alg_idr");
        objectCostData.description = UtilSql.getValue(result, "description");
        objectCostData.mInoutId = UtilSql.getValue(result, "m_inout_id");
        objectCostData.mInoutIdr = UtilSql.getValue(result, "m_inout_idr");
        objectCostData.matchingAmt = UtilSql.getValue(result, "matching_amt");
        objectCostData.ismatched = UtilSql.getValue(result, "ismatched");
        objectCostData.matchingCostadjustmentId = UtilSql.getValue(result, "matching_costadjustment_id");
        objectCostData.matchingCostadjustmentIdr = UtilSql.getValue(result, "matching_costadjustment_idr");
        objectCostData.ismatchingadjusted = UtilSql.getValue(result, "ismatchingadjusted");
        objectCostData.isactive = UtilSql.getValue(result, "isactive");
        objectCostData.processing = UtilSql.getValue(result, "processing");
        objectCostData.posted = UtilSql.getValue(result, "posted");
        objectCostData.postedBtn = UtilSql.getValue(result, "posted_btn");
        objectCostData.processMatching = UtilSql.getValue(result, "process_matching");
        objectCostData.cancelMatching = UtilSql.getValue(result, "cancel_matching");
        objectCostData.processed = UtilSql.getValue(result, "processed");
        objectCostData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCostData.mLcCostId = UtilSql.getValue(result, "m_lc_cost_id");
        objectCostData.language = UtilSql.getValue(result, "language");
        objectCostData.adUserClient = "";
        objectCostData.adOrgClient = "";
        objectCostData.createdby = "";
        objectCostData.trBgcolor = "";
        objectCostData.totalCount = "";
        objectCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCostData);
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
    CostData objectCostData[] = new CostData[vector.size()];
    vector.copyInto(objectCostData);
    return(objectCostData);
  }

/**
Create a registry
 */
  public static CostData[] set(String mLandedcostId, String mLcCostId, String adClientId, String adOrgId, String isactive, String createdby, String createdbyr, String updatedby, String updatedbyr, String mInoutId, String mLcTypeId, String amount, String mLcDistributionAlgId, String description, String cCurrencyId, String cInvoicelineId, String ismatched, String ismatchingadjusted, String line, String processMatching, String matchingAmt, String cancelMatching, String matchingCostadjustmentId, String cDoctypeId, String dateacct, String posted, String postedBtn, String processing, String processed)    throws ServletException {
    CostData objectCostData[] = new CostData[1];
    objectCostData[0] = new CostData();
    objectCostData[0].created = "";
    objectCostData[0].createdbyr = createdbyr;
    objectCostData[0].updated = "";
    objectCostData[0].updatedTimeStamp = "";
    objectCostData[0].updatedby = updatedby;
    objectCostData[0].updatedbyr = updatedbyr;
    objectCostData[0].line = line;
    objectCostData[0].adOrgId = adOrgId;
    objectCostData[0].mLandedcostId = mLandedcostId;
    objectCostData[0].cDoctypeId = cDoctypeId;
    objectCostData[0].cDoctypeIdr = "";
    objectCostData[0].mLcTypeId = mLcTypeId;
    objectCostData[0].mLcTypeIdr = "";
    objectCostData[0].dateacct = dateacct;
    objectCostData[0].cInvoicelineId = cInvoicelineId;
    objectCostData[0].amount = amount;
    objectCostData[0].cCurrencyId = cCurrencyId;
    objectCostData[0].cCurrencyIdr = "";
    objectCostData[0].mLcDistributionAlgId = mLcDistributionAlgId;
    objectCostData[0].mLcDistributionAlgIdr = "";
    objectCostData[0].description = description;
    objectCostData[0].mInoutId = mInoutId;
    objectCostData[0].mInoutIdr = "";
    objectCostData[0].matchingAmt = matchingAmt;
    objectCostData[0].ismatched = ismatched;
    objectCostData[0].matchingCostadjustmentId = matchingCostadjustmentId;
    objectCostData[0].matchingCostadjustmentIdr = "";
    objectCostData[0].ismatchingadjusted = ismatchingadjusted;
    objectCostData[0].isactive = isactive;
    objectCostData[0].processing = processing;
    objectCostData[0].posted = posted;
    objectCostData[0].postedBtn = postedBtn;
    objectCostData[0].processMatching = processMatching;
    objectCostData[0].cancelMatching = cancelMatching;
    objectCostData[0].processed = processed;
    objectCostData[0].adClientId = adClientId;
    objectCostData[0].mLcCostId = mLcCostId;
    objectCostData[0].language = "";
    return objectCostData;
  }

/**
Select for auxiliar field
 */
  public static String selectAux27408C217279424DAFD659F7605D09CA(ConnectionProvider connectionProvider, String M_LANDEDCOST_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PROCESSED FROM M_LANDEDCOST WHERE M_LANDEDCOST_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_LANDEDCOST_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "processed");
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
  public static String selectDef00568254CB648733E050007F01000513_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef00568254CB668733E050007F01000513_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef0227873A968BE6FBE050007F01005124(ConnectionProvider connectionProvider, String m_landedcost_id, String m_inout_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM M_LC_COST WHERE (m_landedcost_id is not null and m_landedcost_id =?)    or (m_landedcost_id is null and m_inout_id = ?) ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_landedcost_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_inout_id);

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
      "        SELECT M_LC_Cost.M_Landedcost_ID AS NAME" +
      "        FROM M_LC_Cost" +
      "        WHERE M_LC_Cost.M_LC_Cost_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String mLandedcostId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(table1.Referencedate, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Documentno), ''))) AS NAME FROM M_LandedCost left join (select M_Landedcost_ID, Referencedate, Documentno from M_Landedcost) table1 on (M_LandedCost.M_Landedcost_ID = table1.M_Landedcost_ID) WHERE M_LandedCost.M_Landedcost_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLandedcostId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String mLandedcostId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(table1.Referencedate, 'DD-MM-YYYY') || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Documentno), ''))) AS NAME FROM M_LandedCost left join (select M_Landedcost_ID, Referencedate, Documentno from M_Landedcost) table1 on (M_LandedCost.M_Landedcost_ID = table1.M_Landedcost_ID) WHERE M_LandedCost.M_Landedcost_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLandedcostId);

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
      "        UPDATE M_LC_Cost" +
      "        SET Line = TO_NUMBER(?) , AD_Org_ID = (?) , M_Landedcost_ID = (?) , C_Doctype_ID = (?) , M_Lc_Type_ID = (?) , Dateacct = TO_DATE(?) , C_Invoiceline_ID = (?) , Amount = TO_NUMBER(?) , C_Currency_ID = (?) , M_Lc_Distribution_Alg_ID = (?) , Description = (?) , M_Inout_ID = (?) , Matching_Amt = TO_NUMBER(?) , IsMatched = (?) , Matching_Costadjustment_ID = (?) , IsMatchingAdjusted = (?) , Isactive = (?) , Processing = (?) , Posted = (?) , Process_Matching = (?) , Cancel_Matching = (?) , Processed = (?) , AD_Client_ID = (?) , M_LC_Cost_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_LC_Cost.M_LC_Cost_ID = ? " +
      "                 AND M_LC_Cost.M_Landedcost_ID = ? " +
      "        AND M_LC_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_LC_Cost.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLandedcostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLcTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLcDistributionAlgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, matchingAmt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismatched);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, matchingCostadjustmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismatchingadjusted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processMatching);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelMatching);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLcCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLcCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLandedcostId);
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
      "        INSERT INTO M_LC_Cost " +
      "        (Line, AD_Org_ID, M_Landedcost_ID, C_Doctype_ID, M_Lc_Type_ID, Dateacct, C_Invoiceline_ID, Amount, C_Currency_ID, M_Lc_Distribution_Alg_ID, Description, M_Inout_ID, Matching_Amt, IsMatched, Matching_Costadjustment_ID, IsMatchingAdjusted, Isactive, Processing, Posted, Process_Matching, Cancel_Matching, Processed, AD_Client_ID, M_LC_Cost_ID, created, createdby, updated, updatedBy)" +
      "        VALUES (TO_NUMBER(?), (?), (?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLandedcostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLcTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLcDistributionAlgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInoutId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, matchingAmt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismatched);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, matchingCostadjustmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismatchingadjusted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processMatching);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelMatching);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLcCostId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mLandedcostId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM M_LC_Cost" +
      "        WHERE M_LC_Cost.M_LC_Cost_ID = ? " +
      "                 AND M_LC_Cost.M_Landedcost_ID = ? " +
      "        AND M_LC_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_LC_Cost.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLandedcostId);
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
      "          FROM M_LC_Cost" +
      "         WHERE M_LC_Cost.M_LC_Cost_ID = ? ";

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
      "          FROM M_LC_Cost" +
      "         WHERE M_LC_Cost.M_LC_Cost_ID = ? ";

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
