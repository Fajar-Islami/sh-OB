/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2013-2016 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 *************************************************************************
 */

package org.openbravo.materialmgmt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.exception.OBSecurityException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.security.OrganizationStructureProvider;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBDao;
import org.openbravo.model.ad.access.Role;
import org.openbravo.model.ad.access.RoleOrganization;
import org.openbravo.service.datasource.DataSourceService;
import org.openbravo.service.datasource.DataSourceServiceProvider;
import org.openbravo.service.datasource.DefaultDataSourceService;
import org.openbravo.service.json.AdvancedQueryBuilder;
import org.openbravo.service.json.DataEntityQueryService;
import org.openbravo.service.json.JsonConstants;
import org.openbravo.service.json.JsonUtils;
import org.openbravo.userinterface.selector.CustomQuerySelectorDatasource;
import org.openbravo.userinterface.selector.Selector;
import org.openbravo.userinterface.selector.SelectorConstants;
import org.openbravo.userinterface.selector.SelectorField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manual datasource that creates a tree of characteristics with their values. Intended to be used
 * from characteristics filter.
 * 
 * The tree is generated in a single request without pagination or extra requests for child nodes as
 * volumes in it are expected to be small.
 * 
 * 
 * @author alostale
 * 
 */
public class ProductCharacteristicsDS extends DefaultDataSourceService {
  final static Logger log = LoggerFactory.getLogger(ProductCharacteristicsDS.class);

  final static int CHAR_ID = 0;
  final static int CHAR_NAME = 1;
  final static int VAL_ID = 2;
  final static int VAL_NAME = 3;
  final static int VAL_PARENT = 4;

  private static final String PRODUCT_CHARACTERISTICS_TABLE_ID = "8E4A6598CA2747B6B0E7257C6F3DEB19";

  @Inject
  private DataSourceServiceProvider dataSourceServiceProvider;

  @Override
  public String fetch(Map<String, String> parameters) {
    OBContext.setAdminMode(true);
    try {
      String dsIdentifier = parameters.get("_parentDSIdentifier");

      String productPath = parameters.get("_propertyPath");
      List<String> allNodes = new ArrayList<String>();
      Set<String> missingNodes = new HashSet<String>();

      JSONArray responseData = getAllNodes(parameters, dsIdentifier, productPath, allNodes,
          missingNodes, false);

      final JSONObject jsonResult = new JSONObject();
      final JSONObject jsonResponse = new JSONObject();

      jsonResponse.put(JsonConstants.RESPONSE_DATA, responseData);
      jsonResponse.put(JsonConstants.RESPONSE_STATUS, JsonConstants.RPCREQUEST_STATUS_SUCCESS);
      jsonResponse.put(JsonConstants.RESPONSE_TOTALROWS, responseData.length());
      jsonResponse.put(JsonConstants.RESPONSE_STARTROW, 0);
      jsonResponse.put(JsonConstants.RESPONSE_ENDROW, responseData.length() - 1);
      jsonResult.put(JsonConstants.RESPONSE_RESPONSE, jsonResponse);

      return jsonResult.toString();
    } catch (Throwable t) {
      log.error("Error building characteristics tree", t);
      return JsonUtils.convertExceptionToJson(t);
    } finally {
      OBContext.restorePreviousMode();
    }
  }

  @Override
  public void checkFetchDatasourceAccess(Map<String, String> parameter) {
    final OBContext obContext = OBContext.getOBContext();
    try {
      Entity entityToCheck = ModelProvider.getInstance().getEntityByTableId(
          PRODUCT_CHARACTERISTICS_TABLE_ID);
      obContext.getEntityAccessChecker().checkReadableAccess(entityToCheck);
    } catch (OBSecurityException e) {
      handleExceptionUnsecuredDSAccess(e);
    }
  }

  private JSONArray getAllNodes(Map<String, String> parameters, String dsIdentifier,
      String productPath, List<String> allNodes, Set<String> missingNodes, boolean addMissingNodes)
      throws JSONException {

    String gridWhereClause = null;
    String customSelectorWhereClause = null;
    AdvancedQueryBuilder qb = null;
    int initialNumOfMissingNodes = 0;
    Entity parentGridEntity = null;
    final List<Object> selectorParameters = new ArrayList<Object>();
    if (!addMissingNodes && dsIdentifier != null) {
      parentGridEntity = ModelProvider.getInstance().getEntity(dsIdentifier, false);
      if (parentGridEntity != null) {
        final DataEntityQueryService queryService = OBProvider.getInstance().get(
            DataEntityQueryService.class);

        queryService.setEntityName(parentGridEntity.getName());
        queryService.setFilterOnReadableOrganizations(true);
        if (parameters.containsKey(JsonConstants.USE_ALIAS)) {
          queryService.setUseAlias();
        }

        final JSONObject criteria = JsonUtils.buildCriteria(parameters);
        queryService.setCriteria(criteria);

        qb = queryService.getQueryBuilder();
        qb.setMainAlias("e");
        if (StringUtils.isNotBlank(qb.getWhereClause())) {
          gridWhereClause = queryService.getWhereClause();
        }
      } else {
        // check if this is a custom HQL selector
        DataSourceService ds = dataSourceServiceProvider.getDataSource(dsIdentifier);
        if (ds != null && ds instanceof CustomQuerySelectorDatasource) {
          CustomQuerySelectorDatasource selDS = (CustomQuerySelectorDatasource) ds;
          String selectorId = parameters.get("_selectorDefinition");
          Selector sel = OBDal.getInstance().get(Selector.class, selectorId);
          List<SelectorField> fields = OBDao.getActiveOBObjectList(sel,
              Selector.PROPERTY_OBUISELSELECTORFIELDLIST);

          // Forcing object initialization to prevent LazyInitializationException in case session is
          // cleared when number of records is big enough
          Hibernate.initialize(fields);

          // forces to use AND instead of OR in case of multiple fields with filter
          parameters.put(SelectorConstants.DS_REQUEST_TYPE_PARAMETER, "Window");

          customSelectorWhereClause = selDS.parseOptionalFilters(parameters, sel,
              JsonUtils.createDateFormat(), selectorParameters);

          if (StringUtils.isNotBlank(customSelectorWhereClause)
              && customSelectorWhereClause.indexOf("from ") != -1) {
            customSelectorWhereClause = customSelectorWhereClause
                .substring(customSelectorWhereClause.indexOf("from ") + 5);
          }
        }
      }
    } else {
      initialNumOfMissingNodes = missingNodes.size();
    }

    StringBuilder hqlBuilder = new StringBuilder();
    hqlBuilder.append(" select c.id, c.name, v.id, v.name, tn.reportSet ");
    hqlBuilder.append(" from ADTreeNode tn, ");
    hqlBuilder.append("      CharacteristicValue v, ");
    hqlBuilder.append("      Characteristic c ");
    hqlBuilder.append(" where tn.tree.typeArea ='CH'");
    hqlBuilder.append(" and tn.node = v.id");
    if (addMissingNodes) {
      hqlBuilder.append(" and v.id in (:missingNodes)");
    }
    hqlBuilder.append(" and v.characteristic = c");
    hqlBuilder.append(this.getClientOrgFilter());

    if (StringUtils.isNotBlank(gridWhereClause)) {
      hqlBuilder.append("  and exists (from ProductCharacteristicValue pcv, " + parentGridEntity
          + gridWhereClause + "  and pcv.characteristicValue = v and pcv.product = " + productPath
          + ")");

    } else if (StringUtils.isNotBlank(customSelectorWhereClause)) {
      hqlBuilder.append("  and exists (from ProductCharacteristicValue pcv, "
          + customSelectorWhereClause + "  and pcv.characteristicValue = v and pcv.product = "
          + productPath + ")");
    }

    hqlBuilder.append(" order by c.name, ");
    hqlBuilder.append("          coalesce(tn.reportSet, '-1'), ");
    hqlBuilder.append("          tn.sequenceNumber ");

    String hql = hqlBuilder.toString();
    log.debug("HQL:\n " + hql);

    Query qTree;
    try {
      qTree = OBDal.getInstance().getSession().createQuery(hql);
    } catch (Exception e) {
      if (StringUtils.isNotBlank(customSelectorWhereClause)
          || StringUtils.isNotBlank(gridWhereClause)) {
        log.error(
            "Error in product characteristics tree generated query, trying to generate it without parent grid limit {}",
            hql, e);
        // fallback: if it is not possible to restrict nodes to the filters applied in parent grid,
        // try to at least show all nodes
        return getAllNodes(parameters, null, productPath, allNodes, missingNodes, false);
      } else {
        throw new OBException(e);
      }
    }
    if (StringUtils.isNotBlank(gridWhereClause)) {
      for (Entry<String, Object> param : qb.getNamedParameters().entrySet()) {
        qTree.setParameter(param.getKey(), param.getValue());
        log.debug("Param {}:{}", param.getKey(), param.getValue());
      }
    } else if (StringUtils.isNotBlank(customSelectorWhereClause)) {
      for (int i = 0; i < selectorParameters.size(); i++) {
        qTree.setParameter(CustomQuerySelectorDatasource.ALIAS_PREFIX + Integer.toString(i),
            selectorParameters.get(i));
        log.debug("Param {}:{}", CustomQuerySelectorDatasource.ALIAS_PREFIX + Integer.toString(i)
            + " ", selectorParameters.get(i));
      }
    } else if (addMissingNodes) {
      qTree.setParameterList("missingNodes", missingNodes);
    }

    String currentCharId = null;
    JSONArray responseData = new JSONArray();
    for (Object rawNode : qTree.list()) {
      Object[] node = (Object[]) rawNode;
      String charId = (String) node[CHAR_ID];
      String nodeId = (String) node[VAL_ID];

      if (!charId.equals(currentCharId) && !allNodes.contains(charId)) {
        currentCharId = charId;
        // new characteristic
        JSONObject characteristic = new JSONObject();
        characteristic.put("id", charId);
        characteristic.put("_identifier", node[CHAR_NAME]);
        characteristic.put("showOpenIcon", true);
        characteristic.put("isCharacteristic", true);
        characteristic
            .put(
                "icon",
                "../web/org.openbravo.userinterface.smartclient/openbravo/skins/Default/org.openbravo.client.application/images/form/sectionItem-ico.png");
        // TODO: skinnable icon
        responseData.put(characteristic);
        allNodes.add(charId);
      }

      if (allNodes.contains(nodeId)) {
        continue;
      }

      JSONObject value = new JSONObject();
      String parentId = (String) node[VAL_PARENT];
      parentId = "0".equals(parentId) ? charId : parentId;

      value.put("id", nodeId);
      value.put("_identifier", node[VAL_NAME]);
      value.put("parentId", parentId);
      value.put("characteristic", charId);
      value.put("characteristic$_identifier", node[CHAR_NAME]);

      allNodes.add(nodeId);
      missingNodes.remove(nodeId);
      if (!allNodes.contains(parentId)) {
        missingNodes.add(parentId);
      }

      responseData.put(value);
    }

    if (missingNodes.size() > 0) {
      // we can have missing nodes in case grid criteria has been applied, in this case query for
      // them recursively
      if (addMissingNodes && initialNumOfMissingNodes == missingNodes.size()) {
        log.warn("Could not find all missing nodes in product characteristics {}", missingNodes);
      } else {
        JSONArray foundNodes = getAllNodes(parameters, dsIdentifier, productPath, allNodes,
            missingNodes, true);
        for (int i = 0; i < foundNodes.length(); i++) {
          responseData.put(foundNodes.get(i));
        }
      }
    }

    return responseData;
  }

  private String getClientOrgFilter() {
    String clientId = OBContext.getOBContext().getCurrentClient().getId();
    final Set<String> orgs = new HashSet<String>();
    OrganizationStructureProvider orgStructure = OBContext.getOBContext()
        .getOrganizationStructureProvider();

    // Role in OBContext has not organization list initialized, force reload to attach to current
    // DAL's session
    Role currentRole = OBDal.getInstance().get(Role.class,
        OBContext.getOBContext().getRole().getId());

    // Adding organizations in the trees of all granted ones
    for (RoleOrganization org : currentRole.getADRoleOrganizationList()) {
      orgs.addAll(orgStructure.getNaturalTree(org.getOrganization().getId()));
    }

    StringBuilder hqlBuilder = new StringBuilder();
    hqlBuilder.append(" and c.client.id = '" + clientId + "' ");
    hqlBuilder.append(" and c.organization.id in (");
    boolean addComma = false;
    for (String org : orgs) {
      if (addComma) {
        hqlBuilder.append(",");
      }
      hqlBuilder.append("'" + org + "'");
      addComma = true;
    }
    hqlBuilder.append(") ");
    return hqlBuilder.toString();
  }
}
