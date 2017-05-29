//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ProcessPlan;

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
class IOProductsData implements FieldProvider {
static Logger log4j = Logger.getLogger(IOProductsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String line;
  public String mProductId;
  public String mProductIdr;
  public String productiontype;
  public String productiontyper;
  public String quantity;
  public String cUomId;
  public String cUomIdr;
  public String uniqueattconsum;
  public String componentcost;
  public String decrease;
  public String rejected;
  public String quantityorder;
  public String mProductUomId;
  public String mProductUomIdr;
  public String cost;
  public String isactive;
  public String divisiongroupqty;
  public String copyproduct;
  public String mWarehouseRuleId;
  public String mWarehouseRuleIdr;
  public String maSequenceId;
  public String maSequenceproductId;
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
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("productiontype"))
      return productiontype;
    else if (fieldName.equalsIgnoreCase("productiontyper"))
      return productiontyper;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("uniqueattconsum"))
      return uniqueattconsum;
    else if (fieldName.equalsIgnoreCase("componentcost"))
      return componentcost;
    else if (fieldName.equalsIgnoreCase("decrease"))
      return decrease;
    else if (fieldName.equalsIgnoreCase("rejected"))
      return rejected;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("m_product_uom_idr") || fieldName.equals("mProductUomIdr"))
      return mProductUomIdr;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("divisiongroupqty"))
      return divisiongroupqty;
    else if (fieldName.equalsIgnoreCase("copyproduct"))
      return copyproduct;
    else if (fieldName.equalsIgnoreCase("m_warehouse_rule_id") || fieldName.equals("mWarehouseRuleId"))
      return mWarehouseRuleId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_rule_idr") || fieldName.equals("mWarehouseRuleIdr"))
      return mWarehouseRuleIdr;
    else if (fieldName.equalsIgnoreCase("ma_sequence_id") || fieldName.equals("maSequenceId"))
      return maSequenceId;
    else if (fieldName.equalsIgnoreCase("ma_sequenceproduct_id") || fieldName.equals("maSequenceproductId"))
      return maSequenceproductId;
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
  public static IOProductsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maSequenceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, maSequenceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static IOProductsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String maSequenceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(MA_SequenceProduct.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_SequenceProduct.CreatedBy) as CreatedByR, " +
      "        to_char(MA_SequenceProduct.Updated, ?) as updated, " +
      "        to_char(MA_SequenceProduct.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        MA_SequenceProduct.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = MA_SequenceProduct.UpdatedBy) as UpdatedByR," +
      "        MA_SequenceProduct.Line, " +
      "MA_SequenceProduct.M_Product_ID, " +
      "(CASE WHEN MA_SequenceProduct.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "MA_SequenceProduct.Productiontype, " +
      "(CASE WHEN MA_SequenceProduct.Productiontype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ProductiontypeR, " +
      "MA_SequenceProduct.Quantity, " +
      "MA_SequenceProduct.C_UOM_ID, " +
      "(CASE WHEN MA_SequenceProduct.C_UOM_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_UOM_IDR, " +
      "COALESCE(MA_SequenceProduct.Uniqueattconsum, 'N') AS Uniqueattconsum, " +
      "MA_SequenceProduct.Componentcost, " +
      "MA_SequenceProduct.Decrease, " +
      "MA_SequenceProduct.Rejected, " +
      "MA_SequenceProduct.QuantityOrder, " +
      "MA_SequenceProduct.M_Product_Uom_Id, " +
      "(CASE WHEN MA_SequenceProduct.M_Product_Uom_Id IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR('xxxx'),'') ) END) AS M_Product_Uom_IdR, " +
      "MA_SequenceProduct.Cost, " +
      "COALESCE(MA_SequenceProduct.IsActive, 'N') AS IsActive, " +
      "MA_SequenceProduct.Divisiongroupqty, " +
      "MA_SequenceProduct.Copyproduct, " +
      "MA_SequenceProduct.M_Warehouse_Rule_ID, " +
      "(CASE WHEN MA_SequenceProduct.M_Warehouse_Rule_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS M_Warehouse_Rule_IDR, " +
      "MA_SequenceProduct.MA_Sequence_ID, " +
      "MA_SequenceProduct.MA_Sequenceproduct_ID, " +
      "MA_SequenceProduct.AD_Org_ID, " +
      "MA_SequenceProduct.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM MA_SequenceProduct left join (select M_Product_ID, Name from M_Product) table1 on (MA_SequenceProduct.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (MA_SequenceProduct.Productiontype = list1.value and list1.ad_reference_id = '800034' and list1.ad_language = ?)  left join (select C_UOM_ID, Name from C_UOM) table3 on (MA_SequenceProduct.C_UOM_ID = table3.C_UOM_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL3 on (table3.C_UOM_ID = tableTRL3.C_UOM_ID and tableTRL3.AD_Language = ?)  left join (select M_Product_Uom_Id, C_UOM_ID from M_Product_UOM) table5 on (MA_SequenceProduct.M_Product_Uom_Id =  table5.M_Product_Uom_Id) left join (select M_Warehouse_Rule_ID, Name from M_Warehouse_Rule) table6 on (MA_SequenceProduct.M_Warehouse_Rule_ID = table6.M_Warehouse_Rule_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((maSequenceId==null || maSequenceId.equals(""))?"":"  AND MA_SequenceProduct.MA_Sequence_ID = ?  ");
    strSql = strSql + 
      "        AND MA_SequenceProduct.MA_Sequenceproduct_ID = ? " +
      "        AND MA_SequenceProduct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND MA_SequenceProduct.AD_Org_ID IN (";
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
      if (maSequenceId != null && !(maSequenceId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);
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
        IOProductsData objectIOProductsData = new IOProductsData();
        objectIOProductsData.created = UtilSql.getValue(result, "created");
        objectIOProductsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectIOProductsData.updated = UtilSql.getValue(result, "updated");
        objectIOProductsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectIOProductsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectIOProductsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectIOProductsData.line = UtilSql.getValue(result, "line");
        objectIOProductsData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectIOProductsData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectIOProductsData.productiontype = UtilSql.getValue(result, "productiontype");
        objectIOProductsData.productiontyper = UtilSql.getValue(result, "productiontyper");
        objectIOProductsData.quantity = UtilSql.getValue(result, "quantity");
        objectIOProductsData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectIOProductsData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectIOProductsData.uniqueattconsum = UtilSql.getValue(result, "uniqueattconsum");
        objectIOProductsData.componentcost = UtilSql.getValue(result, "componentcost");
        objectIOProductsData.decrease = UtilSql.getValue(result, "decrease");
        objectIOProductsData.rejected = UtilSql.getValue(result, "rejected");
        objectIOProductsData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectIOProductsData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectIOProductsData.mProductUomIdr = UtilSql.getValue(result, "m_product_uom_idr");
        objectIOProductsData.cost = UtilSql.getValue(result, "cost");
        objectIOProductsData.isactive = UtilSql.getValue(result, "isactive");
        objectIOProductsData.divisiongroupqty = UtilSql.getValue(result, "divisiongroupqty");
        objectIOProductsData.copyproduct = UtilSql.getValue(result, "copyproduct");
        objectIOProductsData.mWarehouseRuleId = UtilSql.getValue(result, "m_warehouse_rule_id");
        objectIOProductsData.mWarehouseRuleIdr = UtilSql.getValue(result, "m_warehouse_rule_idr");
        objectIOProductsData.maSequenceId = UtilSql.getValue(result, "ma_sequence_id");
        objectIOProductsData.maSequenceproductId = UtilSql.getValue(result, "ma_sequenceproduct_id");
        objectIOProductsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectIOProductsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectIOProductsData.language = UtilSql.getValue(result, "language");
        objectIOProductsData.adUserClient = "";
        objectIOProductsData.adOrgClient = "";
        objectIOProductsData.createdby = "";
        objectIOProductsData.trBgcolor = "";
        objectIOProductsData.totalCount = "";
        objectIOProductsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectIOProductsData);
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
    IOProductsData objectIOProductsData[] = new IOProductsData[vector.size()];
    vector.copyInto(objectIOProductsData);
    return(objectIOProductsData);
  }

/**
Create a registry
 */
  public static IOProductsData[] set(String maSequenceId, String uniqueattconsum, String maSequenceproductId, String adClientId, String adOrgId, String isactive, String createdby, String createdbyr, String updatedby, String updatedbyr, String mProductId, String mProductIdr, String quantity, String productiontype, String cUomId, String quantityorder, String mProductUomId, String componentcost, String decrease, String rejected, String cost, String divisiongroupqty, String copyproduct, String mWarehouseRuleId, String line)    throws ServletException {
    IOProductsData objectIOProductsData[] = new IOProductsData[1];
    objectIOProductsData[0] = new IOProductsData();
    objectIOProductsData[0].created = "";
    objectIOProductsData[0].createdbyr = createdbyr;
    objectIOProductsData[0].updated = "";
    objectIOProductsData[0].updatedTimeStamp = "";
    objectIOProductsData[0].updatedby = updatedby;
    objectIOProductsData[0].updatedbyr = updatedbyr;
    objectIOProductsData[0].line = line;
    objectIOProductsData[0].mProductId = mProductId;
    objectIOProductsData[0].mProductIdr = mProductIdr;
    objectIOProductsData[0].productiontype = productiontype;
    objectIOProductsData[0].productiontyper = "";
    objectIOProductsData[0].quantity = quantity;
    objectIOProductsData[0].cUomId = cUomId;
    objectIOProductsData[0].cUomIdr = "";
    objectIOProductsData[0].uniqueattconsum = uniqueattconsum;
    objectIOProductsData[0].componentcost = componentcost;
    objectIOProductsData[0].decrease = decrease;
    objectIOProductsData[0].rejected = rejected;
    objectIOProductsData[0].quantityorder = quantityorder;
    objectIOProductsData[0].mProductUomId = mProductUomId;
    objectIOProductsData[0].mProductUomIdr = "";
    objectIOProductsData[0].cost = cost;
    objectIOProductsData[0].isactive = isactive;
    objectIOProductsData[0].divisiongroupqty = divisiongroupqty;
    objectIOProductsData[0].copyproduct = copyproduct;
    objectIOProductsData[0].mWarehouseRuleId = mWarehouseRuleId;
    objectIOProductsData[0].mWarehouseRuleIdr = "";
    objectIOProductsData[0].maSequenceId = maSequenceId;
    objectIOProductsData[0].maSequenceproductId = maSequenceproductId;
    objectIOProductsData[0].adOrgId = adOrgId;
    objectIOProductsData[0].adClientId = adClientId;
    objectIOProductsData[0].language = "";
    return objectIOProductsData;
  }

/**
Select for auxiliar field
 */
  public static String selectAux800038(ConnectionProvider connectionProvider, String M_Product_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (CASE COUNT(*) WHEN 0 THEN 0 ELSE 1 END) AS TOTAL FROM M_PRODUCT_UOM WHERE M_PRODUCT_ID=? AND ISACTIVE='Y' ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "total");
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
  public static String selectActPFF8081813219E68E013219ECFE930004_Value(ConnectionProvider connectionProvider, String MA_SEQUENCEPRODUCT_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRODUCT.VALUE||' - '||MA_SEQUENCE.VALUE||' - '||MA_SEQUENCE.SEQNO AS value FROM MA_SEQUENCEPRODUCT JOIN MA_SEQUENCE ON MA_SEQUENCE.MA_SEQUENCE_ID = MA_SEQUENCEPRODUCT.MA_SEQUENCE_ID LEFT JOIN M_PRODUCT ON MA_SEQUENCEPRODUCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID WHERE MA_SEQUENCEPRODUCT_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_SEQUENCEPRODUCT_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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
  public static String selectActPFF8081813219E68E013219ECFE930004_Name(ConnectionProvider connectionProvider, String MA_SEQUENCEPRODUCT_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRODUCT.NAME||' - '||MA_SEQUENCE.NAME||' - '||MA_SEQUENCE.SEQNO AS name FROM MA_SEQUENCEPRODUCT JOIN MA_SEQUENCE ON MA_SEQUENCE.MA_SEQUENCE_ID = MA_SEQUENCEPRODUCT.MA_SEQUENCE_ID LEFT JOIN M_PRODUCT ON MA_SEQUENCEPRODUCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID WHERE MA_SEQUENCEPRODUCT_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_SEQUENCEPRODUCT_ID);

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
Select for auxiliar field
 */
  public static String selectDef801541_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef801543_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef801546_2(ConnectionProvider connectionProvider, String paramLanguage, String M_Product_IDR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDefECD90C86634B4A51B2FFCE7248293BED(ConnectionProvider connectionProvider, String Ma_Sequence_Id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(LINE),0)+10 AS DefaultValue FROM MA_SEQUENCEPRODUCT WHERE MA_SEQUENCE_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Ma_Sequence_Id);

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
      "        SELECT MA_SequenceProduct.MA_Sequence_ID AS NAME" +
      "        FROM MA_SequenceProduct" +
      "        WHERE MA_SequenceProduct.MA_Sequenceproduct_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String maSequenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Sequence left join (select MA_Sequence_ID, Name from MA_Sequence) table1 on (MA_Sequence.MA_Sequence_ID = table1.MA_Sequence_ID) WHERE MA_Sequence.MA_Sequence_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String maSequenceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM MA_Sequence left join (select MA_Sequence_ID, Name from MA_Sequence) table1 on (MA_Sequence.MA_Sequence_ID = table1.MA_Sequence_ID) WHERE MA_Sequence.MA_Sequence_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);

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
      "        UPDATE MA_SequenceProduct" +
      "        SET Line = TO_NUMBER(?) , M_Product_ID = (?) , Productiontype = (?) , Quantity = TO_NUMBER(?) , C_UOM_ID = (?) , Uniqueattconsum = (?) , Componentcost = TO_NUMBER(?) , Decrease = TO_NUMBER(?) , Rejected = TO_NUMBER(?) , QuantityOrder = TO_NUMBER(?) , M_Product_Uom_Id = (?) , Cost = TO_NUMBER(?) , IsActive = (?) , Divisiongroupqty = TO_NUMBER(?) , Copyproduct = (?) , M_Warehouse_Rule_ID = (?) , MA_Sequence_ID = (?) , MA_Sequenceproduct_ID = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE MA_SequenceProduct.MA_Sequenceproduct_ID = ? " +
      "                 AND MA_SequenceProduct.MA_Sequence_ID = ? " +
      "        AND MA_SequenceProduct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_SequenceProduct.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productiontype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uniqueattconsum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, componentcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, decrease);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rejected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, divisiongroupqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceproductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceproductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);
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
      "        INSERT INTO MA_SequenceProduct " +
      "        (Line, M_Product_ID, Productiontype, Quantity, C_UOM_ID, Uniqueattconsum, Componentcost, Decrease, Rejected, QuantityOrder, M_Product_Uom_Id, Cost, IsActive, Divisiongroupqty, Copyproduct, M_Warehouse_Rule_ID, MA_Sequence_ID, MA_Sequenceproduct_ID, AD_Org_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES (TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productiontype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uniqueattconsum);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, componentcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, decrease);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, rejected);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityorder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, divisiongroupqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseRuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceproductId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String maSequenceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM MA_SequenceProduct" +
      "        WHERE MA_SequenceProduct.MA_Sequenceproduct_ID = ? " +
      "                 AND MA_SequenceProduct.MA_Sequence_ID = ? " +
      "        AND MA_SequenceProduct.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND MA_SequenceProduct.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maSequenceId);
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
      "          FROM MA_SequenceProduct" +
      "         WHERE MA_SequenceProduct.MA_Sequenceproduct_ID = ? ";

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
      "          FROM MA_SequenceProduct" +
      "         WHERE MA_SequenceProduct.MA_Sequenceproduct_ID = ? ";

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
