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
<%@ page import="com.rivetlogic.ecommerce.shoppingcart.configuration.ShoppingCartConfiguration" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.rivetlogic.ecommerce.service.util.PortletPropsUtil" %>
<%@page import="com.rivetlogic.ecommerce.beans.ShoppingCartPrefsBean"%>



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

<%

ShoppingCartConfiguration shoppingCartConfiguration =
        (ShoppingCartConfiguration) renderRequest.getAttribute(ShoppingCartConfiguration.class.getName());


String enablePaypal = StringPool.BLANK;
String  paypalEmail= StringPool.BLANK;
String  storeEmail= StringPool.BLANK;
String  storeName= StringPool.BLANK;
String storeEmailSubject = StringPool.BLANK;
String  customerEmailSubject= StringPool.BLANK;
String  checkoutSuccessMessage= StringPool.BLANK;
String  checkoutErrorMessage= StringPool.BLANK;
String  storeEmailTemplate= StringPool.BLANK;
String  customerEmailTemplate= StringPool.BLANK;
String cartEmptyMessage = StringPool.BLANK;



enablePaypal = portletPreferences.getValue(PreferencesKeys.ENABLE_PAYPAL,"false");
paypalEmail = portletPreferences.getValue(PreferencesKeys.PAYPAL_EMAIL, "");
storeEmail = portletPreferences.getValue(PreferencesKeys.STORE_EMAIL, "");
storeName = portletPreferences.getValue(PreferencesKeys.STORE_NAME, "");
storeEmailSubject = portletPreferences.getValue(PreferencesKeys.STORE_NOTIF_SUBJECT_TEMPLATE, PortletPropsUtil.get(PreferencesKeys.DEFAULT_STORE_EMAIL_SUBJECT));
customerEmailSubject = portletPreferences.getValue(PreferencesKeys.CUSTOMER_NOTIF_SUBJECT_TEMPLATE, PortletPropsUtil.get(PreferencesKeys.DEFAULT_CUSTOMER_EMAIL_SUBJECT));
checkoutSuccessMessage = portletPreferences.getValue(PreferencesKeys.CHECKOUT_SUCCESS_MESSAGE, PortletPropsUtil.get(PreferencesKeys.DEFAULT_MESSAGE_CHECKOUT_SUCCESS));
checkoutErrorMessage = portletPreferences.getValue(PreferencesKeys.CHECKOUT_ERROR_MESSAGE, PortletPropsUtil.get(PreferencesKeys.DEFAULT_MESSAGE_CHECKOUT_ERROR));
cartEmptyMessage = portletPreferences.getValue(PreferencesKeys.CART_EMPTY_MESSAGE, PortletPropsUtil.get(PreferencesKeys.DEFAULT_MESSAGE_CART_EMPTY));

String defaultStoreEmailTemplate = UnicodeFormatter.toString(PortletPropsUtil.get(PreferencesKeys.DEFAULT_STORE_EMAIL_BODY));
String defaultCustomerEmailTemplate = UnicodeFormatter.toString(PortletPropsUtil.get(PreferencesKeys.DEFAULT_CUSTOMER_EMAIL_BODY));
storeEmailTemplate = portletPreferences.getValue(PreferencesKeys.STORE_NOTIF_BODY_TEMPLATE, defaultStoreEmailTemplate);
customerEmailTemplate = portletPreferences.getValue(PreferencesKeys.CUSTOMER_NOTIF_BODY_TEMPLATE, defaultCustomerEmailTemplate);

boolean isPayPalEnabled = Boolean.valueOf(enablePaypal);

	

%>