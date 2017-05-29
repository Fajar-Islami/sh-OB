//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ManufacturingPlan;

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
class LinesData implements FieldProvider {
static Logger log4j = Logger.getLogger(LinesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String planneddate;
  public String mProductId;
  public String mProductIdr;
  public String qty;
  public String neededqty;
  public String inouttrxtype;
  public String inouttrxtyper;
  public String parentId;
  public String cumqty;
  public String plannedorderdate;
  public String isfixed;
  public String mRequisitionlineId;
  public String mRequisitionlineIdr;
  public String maProcessplanId;
  public String maProcessplanIdr;
  public String cOrderlineId;
  public String cOrderlineIdr;
  public String maWorkrequirementId;
  public String maWorkrequirementIdr;
  public String mrpSalesforecastlineId;
  public String mrpSalesforecastlineIdr;
  public String recalculatestock;
  public String isexploded;
  public String isplanned;
  public String mrpRunProductionId;
  public String isactive;
  public String adOrgId;
  public String adClientId;
  public String mrpRunProductionlineId;
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
    else if (fieldName.equalsIgnoreCase("planneddate"))
      return planneddate;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("neededqty"))
      return neededqty;
    else if (fieldName.equalsIgnoreCase("inouttrxtype"))
      return inouttrxtype;
    else if (fieldName.equalsIgnoreCase("inouttrxtyper"))
      return inouttrxtyper;
    else if (fieldName.equalsIgnoreCase("parent_id") || fieldName.equals("parentId"))
      return parentId;
    else if (fieldName.equalsIgnoreCase("cumqty"))
      return cumqty;
    else if (fieldName.equalsIgnoreCase("plannedorderdate"))
      return plannedorderdate;
    else if (fieldName.equalsIgnoreCase("isfixed"))
      return isfixed;
    else if (fieldName.equalsIgnoreCase("m_requisitionline_id") || fieldName.equals("mRequisitionlineId"))
      return mRequisitionlineId;
    else if (fieldName.equalsIgnoreCase("m_requisitionline_idr") || fieldName.equals("mRequisitionlineIdr"))
      return mRequisitionlineIdr;
    else if (fieldName.equalsIgnoreCase("ma_processplan_id") || fieldName.equals("maProcessplanId"))
      return maProcessplanId;
    else if (fieldName.equalsIgnoreCase("ma_processplan_idr") || fieldName.equals("maProcessplanIdr"))
      return maProcessplanIdr;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_orderline_idr") || fieldName.equals("cOrderlineIdr"))
      return cOrderlineIdr;
    else if (fieldName.equalsIgnoreCase("ma_workrequirement_id") || fieldName.equals("maWorkrequirementId"))
      return maWorkrequirementId;
    else if (fieldName.equalsIgnoreCase("ma_workrequirement_idr") || fieldName.equals("maWorkrequirementIdr"))
      return maWorkrequirementIdr;
    else if (fieldName.equalsIgnoreCase("mrp_salesforecastline_id") || fieldName.equals("mrpSalesforecastlineId"))
      return mrpSalesforecastlineId;
    else if (fieldName.equalsIgnoreCase("mrp_salesforecastline_idr") || fieldName.equals("mrpSalesforecastlineIdr"))
      return mrpSalesforecastlineIdr;
    else if (fieldName.equalsIgnoreCase("recalculatestock"))
      return recalculatestock;
    else if (fieldName.equalsIgnoreCase("isexploded"))
      return isexploded;
    else if (fieldName.equalsIgnoreCase("isplanned"))
      return isplanned;
    else if (fieldName.equalsIgnoreCase("mrp_run_production_id") || fieldName.equals("mrpRunProductionId"))
      return mrpRunProductionId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("mrp_run_productionline_id") || fieldName.equals("mrpRunProductionlineId"))
      return mrpRunProductionlineId;
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
  public static LinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mrpRunProductionId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mrpRunProductionId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static LinesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mrpRunProductionId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MRP_Run_ProductionLine.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MRP_Run_ProductionLine.CreatedBy) as CreatedByR, " +
      "        to_char(MRP_Run_ProductionLine.Updated, ?) as updated, " +
      "        to_char(MRP_Run_ProductionLine.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MRP_Run_ProductionLine.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MRP_Run_ProductionLine.UpdatedBy) as UpdatedByR," +
      "        MRP_Run_ProductionLine.Planneddate, " +
      "MRP_Run_ProductionLine.M_Product_ID, " +
      "(CASE WHEN MRP_Run_ProductionLine.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "MRP_Run_ProductionLine.Qty, " +
      "MRP_Run_ProductionLine.Neededqty, " +
      "MRP_Run_ProductionLine.Inouttrxtype, " +
      "(CASE WHEN MRP_Run_ProductionLine.Inouttrxtype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS InouttrxtypeR, " +
      "MRP_Run_ProductionLine.Parent_ID, " +
      "MRP_Run_ProductionLine.Cumqty, " +
      "MRP_Run_ProductionLine.Plannedorderdate, " +
      "COALESCE(MRP_Run_ProductionLine.Isfixed, 'N') AS Isfixed, " +
      "MRP_Run_ProductionLine.M_Requisitionline_ID, " +
      "(CASE WHEN MRP_Run_ProductionLine.M_Requisitionline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Qty), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.Needbydate, 'DD-MM-YYYY')),'') ) END) AS M_Requisitionline_IDR, " +
      "MRP_Run_ProductionLine.MA_Processplan_ID, " +
      "(CASE WHEN MRP_Run_ProductionLine.MA_Processplan_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS MA_Processplan_IDR, " +
      "MRP_Run_ProductionLine.C_OrderLine_ID, " +
      "(CASE WHEN MRP_Run_ProductionLine.C_OrderLine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table9.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.LineNetAmt), ''))),'') ) END) AS C_OrderLine_IDR, " +
      "MRP_Run_ProductionLine.MA_Workrequirement_ID, " +
      "(CASE WHEN MRP_Run_ProductionLine.MA_Workrequirement_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table10.StartDate, 'DD-MM-YYYY')),'') ) END) AS MA_Workrequirement_IDR, " +
      "MRP_Run_ProductionLine.MRP_Salesforecastline_ID, " +
      "(CASE WHEN MRP_Run_ProductionLine.MRP_Salesforecastline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL12.Name IS NULL THEN TO_CHAR(table12.Name) ELSE TO_CHAR(tableTRL12.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table15.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table14.DateDoc, 'DD-MM-YYYY')),'') ) END) AS MRP_Salesforecastline_IDR, " +
      "MRP_Run_ProductionLine.Recalculatestock, " +
      "COALESCE(MRP_Run_ProductionLine.Isexploded, 'N') AS Isexploded, " +
      "COALESCE(MRP_Run_ProductionLine.Isplanned, 'N') AS Isplanned, " +
      "MRP_Run_ProductionLine.MRP_Run_Production_ID, " +
      "COALESCE(MRP_Run_ProductionLine.IsActive, 'N') AS IsActive, " +
      "MRP_Run_ProductionLine.AD_Org_ID, " +
      "MRP_Run_ProductionLine.AD_Client_ID, " +
      "MRP_Run_ProductionLine.MRP_Run_Productionline_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM MRP_Run_ProductionLine left join (select M_Product_ID, Name from M_Product) table1 on (MRP_Run_ProductionLine.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (MRP_Run_ProductionLine.Inouttrxtype = list1.value and list1.ad_reference_id = '800098' and list1.ad_language = ?)  left join (select M_Requisitionline_ID, M_Requisition_ID, M_Product_ID, Qty, Needbydate from M_Requisitionline) table3 on (MRP_Run_ProductionLine.M_Requisitionline_ID = table3.M_Requisitionline_ID) left join (select M_Requisition_ID, DocumentNo from M_Requisition) table4 on (table3.M_Requisition_ID = table4.M_Requisition_ID) left join (select M_Product_ID, Name from M_Product) table5 on (table3.M_Product_ID = table5.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL5 on (table5.M_Product_ID = tableTRL5.M_Product_ID and tableTRL5.AD_Language = ?)  left join (select MA_Processplan_ID, Name from MA_Processplan) table7 on (MRP_Run_ProductionLine.MA_Processplan_ID = table7.MA_Processplan_ID) left join (select C_OrderLine_ID, C_Order_ID, Line, LineNetAmt from C_OrderLine) table8 on (MRP_Run_ProductionLine.C_OrderLine_ID = table8.C_OrderLine_ID) left join (select C_Order_ID, DocumentNo, DateOrdered, GrandTotal from C_Order) table9 on (table8.C_Order_ID = table9.C_Order_ID) left join (select MA_Workrequirement_ID, DocumentNo, StartDate from MA_Workrequirement) table10 on (MRP_Run_ProductionLine.MA_Workrequirement_ID = table10.MA_Workrequirement_ID) left join (select MRP_Salesforecastline_ID, M_Product_ID, MRP_Salesforecast_ID from MRP_Salesforecastline) table11 on (MRP_Run_ProductionLine.MRP_Salesforecastline_ID = table11.MRP_Salesforecastline_ID) left join (select M_Product_ID, Name from M_Product) table12 on (table11.M_Product_ID = table12.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL12 on (table12.M_Product_ID = tableTRL12.M_Product_ID and tableTRL12.AD_Language = ?)  left join (select MRP_Salesforecast_ID, C_BPartner_ID, DateDoc from MRP_Salesforecast) table14 on (table11.MRP_Salesforecast_ID = table14.MRP_Salesforecast_ID) left join (select C_BPartner_ID, Name from C_BPartner) table15 on (table14.C_BPartner_ID = table15.C_BPartner_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mrpRunProductionId==null || mrpRunProductionId.equals(""))?"":"  AND MRP_Run_ProductionLine.MRP_Run_Production_ID = ?  ");
    strSql = strSql + 
      "        AND MRP_Run_ProductionLine.MRP_Run_Productionline_ID = ? " +
      "        AND MRP_Run_ProductionLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MRP_Run_ProductionLine.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (mrpRunProductionId != null && !(mrpRunProductionId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunProductionId);
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
        LinesData objectLinesData = new LinesData();
        objectLinesData.created = UtilSql.getValue(result, "created");
        objectLinesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectLinesData.updated = UtilSql.getValue(result, "updated");
        objectLinesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectLinesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectLinesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectLinesData.planneddate = UtilSql.getDateValue(result, "planneddate", "dd-MM-yyyy");
        objectLinesData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectLinesData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectLinesData.qty = UtilSql.getValue(result, "qty");
        objectLinesData.neededqty = UtilSql.getValue(result, "neededqty");
        objectLinesData.inouttrxtype = UtilSql.getValue(result, "inouttrxtype");
        objectLinesData.inouttrxtyper = UtilSql.getValue(result, "inouttrxtyper");
        objectLinesData.parentId = UtilSql.getValue(result, "parent_id");
        objectLinesData.cumqty = UtilSql.getValue(result, "cumqty");
        objectLinesData.plannedorderdate = UtilSql.getDateValue(result, "plannedorderdate", "dd-MM-yyyy");
        objectLinesData.isfixed = UtilSql.getValue(result, "isfixed");
        objectLinesData.mRequisitionlineId = UtilSql.getValue(result, "m_requisitionline_id");
        objectLinesData.mRequisitionlineIdr = UtilSql.getValue(result, "m_requisitionline_idr");
        objectLinesData.maProcessplanId = UtilSql.getValue(result, "ma_processplan_id");
        objectLinesData.maProcessplanIdr = UtilSql.getValue(result, "ma_processplan_idr");
        objectLinesData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectLinesData.cOrderlineIdr = UtilSql.getValue(result, "c_orderline_idr");
        objectLinesData.maWorkrequirementId = UtilSql.getValue(result, "ma_workrequirement_id");
        objectLinesData.maWorkrequirementIdr = UtilSql.getValue(result, "ma_workrequirement_idr");
        objectLinesData.mrpSalesforecastlineId = UtilSql.getValue(result, "mrp_salesforecastline_id");
        objectLinesData.mrpSalesforecastlineIdr = UtilSql.getValue(result, "mrp_salesforecastline_idr");
        objectLinesData.recalculatestock = UtilSql.getValue(result, "recalculatestock");
        objectLinesData.isexploded = UtilSql.getValue(result, "isexploded");
        objectLinesData.isplanned = UtilSql.getValue(result, "isplanned");
        objectLinesData.mrpRunProductionId = UtilSql.getValue(result, "mrp_run_production_id");
        objectLinesData.isactive = UtilSql.getValue(result, "isactive");
        objectLinesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectLinesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectLinesData.mrpRunProductionlineId = UtilSql.getValue(result, "mrp_run_productionline_id");
        objectLinesData.language = UtilSql.getValue(result, "language");
        objectLinesData.adUserClient = "";
        objectLinesData.adOrgClient = "";
        objectLinesData.createdby = "";
        objectLinesData.trBgcolor = "";
        objectLinesData.totalCount = "";
        objectLinesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectLinesData);
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
    LinesData objectLinesData[] = new LinesData[vector.size()];
    vector.copyInto(objectLinesData);
    return(objectLinesData);
  }

/**
Create a registry
 */
  public static LinesData[] set(String mrpRunProductionId, String mrpRunProductionlineId, String adClientId, String adOrgId, String isactive, String createdby, String createdbyr, String updatedby, String updatedbyr, String mProductId, String mProductIdr, String qty, String neededqty, String planneddate, String parentId, String inouttrxtype, String isfixed, String cOrderlineId, String mrpSalesforecastlineId, String mRequisitionlineId, String maProcessplanId, String maWorkrequirementId, String isexploded, String plannedorderdate, String isplanned, String cumqty, String recalculatestock)    throws ServletException {
    LinesData objectLinesData[] = new LinesData[1];
    objectLinesData[0] = new LinesData();
    objectLinesData[0].created = "";
    objectLinesData[0].createdbyr = createdbyr;
    objectLinesData[0].updated = "";
    objectLinesData[0].updatedTimeStamp = "";
    objectLinesData[0].updatedby = updatedby;
    objectLinesData[0].updatedbyr = updatedbyr;
    objectLinesData[0].planneddate = planneddate;
    objectLinesData[0].mProductId = mProductId;
    objectLinesData[0].mProductIdr = mProductIdr;
    objectLinesData[0].qty = qty;
    objectLinesData[0].neededqty = neededqty;
    objectLinesData[0].inouttrxtype = inouttrxtype;
    objectLinesData[0].inouttrxtyper = "";
    objectLinesData[0].parentId = parentId;
    objectLinesData[0].cumqty = cumqty;
    objectLinesData[0].plannedorderdate = plannedorderdate;
    objectLinesData[0].isfixed = isfixed;
    objectLinesData[0].mRequisitionlineId = mRequisitionlineId;
    objectLinesData[0].mRequisitionlineIdr = "";
    objectLinesData[0].maProcessplanId = maProcessplanId;
    objectLinesData[0].maProcessplanIdr = "";
    objectLinesData[0].cOrderlineId = cOrderlineId;
    objectLinesData[0].cOrderlineIdr = "";
    objectLinesData[0].maWorkrequirementId = maWorkrequirementId;
    objectLinesData[0].maWorkrequirementIdr = "";
    objectLinesData[0].mrpSalesforecastlineId = mrpSalesforecastlineId;
    objectLinesData[0].mrpSalesforecastlineIdr = "";
    objectLinesData[0].recalculatestock = recalculatestock;
    objectLinesData[0].isexploded = isexploded;
    objectLinesData[0].isplanned = isplanned;
    objectLinesData[0].mrpRunProductionId = mrpRunProductionId;
    objectLinesData[0].isactive = isactive;
    objectLinesData[0].adOrgId = adOrgId;
    objectLinesData[0].adClientId = adClientId;
    objectLinesData[0].mrpRunProductionlineId = mrpRunProductionlineId;
    objectLinesData[0].language = "";
    return objectLinesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803628_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef803630_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef803632_2(ConnectionProvider connectionProvider, String paramLanguage, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))), '') ) as M_Product_ID FROM M_Product left join (select M_Product_ID, Name from M_Product) table2 on (M_Product.M_Product_ID = table2.M_Product_ID)left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  WHERE M_Product.isActive='Y' AND M_Product.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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
      "        SELECT MRP_Run_ProductionLine.MRP_Run_Production_ID AS NAME" +
      "        FROM MRP_Run_ProductionLine" +
      "        WHERE MRP_Run_ProductionLine.MRP_Run_Productionline_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String mrpRunProductionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))) AS NAME FROM MRP_Run_Production left join (select MRP_Run_Production_ID, Name, MRP_Planner_ID, M_Product_ID from MRP_Run_Production) table1 on (MRP_Run_Production.MRP_Run_Production_ID = table1.MRP_Run_Production_ID) left join (select MRP_Planner_ID, Name from MRP_Planner) table2 on (table1.MRP_Planner_ID = table2.MRP_Planner_ID) left join (select M_Product_ID, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  WHERE MRP_Run_Production.MRP_Run_Production_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunProductionId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String mrpRunProductionId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))) AS NAME FROM MRP_Run_Production left join (select MRP_Run_Production_ID, Name, MRP_Planner_ID, M_Product_ID from MRP_Run_Production) table1 on (MRP_Run_Production.MRP_Run_Production_ID = table1.MRP_Run_Production_ID) left join (select MRP_Planner_ID, Name from MRP_Planner) table2 on (table1.MRP_Planner_ID = table2.MRP_Planner_ID) left join (select M_Product_ID, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  WHERE MRP_Run_Production.MRP_Run_Production_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunProductionId);

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
      "        UPDATE MRP_Run_ProductionLine" +
      "        SET Planneddate = TO_DATE(?) , M_Product_ID = (?) , Qty = TO_NUMBER(?) , Neededqty = TO_NUMBER(?) , Inouttrxtype = (?) , Parent_ID = (?) , Cumqty = TO_NUMBER(?) , Plannedorderdate = TO_DATE(?) , Isfixed = (?) , M_Requisitionline_ID = (?) , MA_Processplan_ID = (?) , C_OrderLine_ID = (?) , MA_Workrequirement_ID = (?) , MRP_Salesforecastline_ID = (?) , Recalculatestock = (?) , Isexploded = (?) , Isplanned = (?) , MRP_Run_Production_ID = (?) , IsActive = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , MRP_Run_Productionline_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE MRP_Run_ProductionLine.MRP_Run_Productionline_ID = ? " +
      "                 AND MRP_Run_ProductionLine.MRP_Run_Production_ID = ? " +
      "        AND MRP_Run_ProductionLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MRP_Run_ProductionLine.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, neededqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, inouttrxtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cumqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedorderdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpSalesforecastlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recalculatestock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isexploded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunProductionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunProductionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunProductionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunProductionId);
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
      "        INSERT INTO MRP_Run_ProductionLine " +
      "        (Planneddate, M_Product_ID, Qty, Neededqty, Inouttrxtype, Parent_ID, Cumqty, Plannedorderdate, Isfixed, M_Requisitionline_ID, MA_Processplan_ID, C_OrderLine_ID, MA_Workrequirement_ID, MRP_Salesforecastline_ID, Recalculatestock, Isexploded, Isplanned, MRP_Run_Production_ID, IsActive, AD_Org_ID, AD_Client_ID, MRP_Run_Productionline_ID, created, createdby, updated, updatedBy)" +
      "        VALUES (TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, neededqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, inouttrxtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, parentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cumqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedorderdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isfixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maProcessplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maWorkrequirementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpSalesforecastlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recalculatestock);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isexploded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isplanned);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunProductionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunProductionlineId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mrpRunProductionId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MRP_Run_ProductionLine" +
      "        WHERE MRP_Run_ProductionLine.MRP_Run_Productionline_ID = ? " +
      "                 AND MRP_Run_ProductionLine.MRP_Run_Production_ID = ? " +
      "        AND MRP_Run_ProductionLine.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MRP_Run_ProductionLine.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpRunProductionId);
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
      "          FROM MRP_Run_ProductionLine" +
      "         WHERE MRP_Run_ProductionLine.MRP_Run_Productionline_ID = ? ";

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
      "          FROM MRP_Run_ProductionLine" +
      "         WHERE MRP_Run_ProductionLine.MRP_Run_Productionline_ID = ? ";

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
