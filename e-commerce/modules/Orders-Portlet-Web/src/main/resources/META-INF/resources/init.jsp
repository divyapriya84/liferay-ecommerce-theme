<%-- 
/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>


<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>

<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.logging.Logger"%>

<%@page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>

<%@ page import="com.liferay.portal.kernel.xml.Document" %>
<%@ page import="com.liferay.portal.kernel.xml.DocumentException" %>
<%@ page import="com.liferay.portal.kernel.xml.Node" %>
<%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>

<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException"%>

<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@ page import="com.rivetlogic.ecommerce.service.util.PreferencesKeys"%>
<%@ page import="com.rivetlogic.ecommerce.service.util.OrderStatusEnum" %>
<%@ page import="com.rivetlogic.ecommerce.cart.ShoppingCartItem" %>
<%@ page import="com.rivetlogic.ecommerce.model.ShoppingOrder" %>
<%@ page import="com.rivetlogic.ecommerce.model.ShoppingOrderItem" %>
<%@ page import="com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil" %>
<%@ page import="com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil" %>
<%@ page import="com.rivetlogic.ecommerce.notification.constants.ShoppingCartPortletConstants" %>
<%@ page import="com.rivetlogic.ecommerce.beans.ShoppingCartPrefsBean" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<c:set var="pns" scope="request">
	<portlet:namespace />
</c:set>
<c:set var="portletId" scope="request">
	<%= (String) request.getAttribute(WebKeys.PORTLET_ID) %>
</c:set>

<%
String redirect = ParamUtil.getString(request, "redirect");
String currentURL = PortalUtil.getCurrentURL(request);
%>