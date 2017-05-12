<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>"
    var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
    var="configurationRenderURL" />


<liferay-ui:tabs names="Store Email,Customer Email,Messages,Paypal" refresh="false" tabsValues="Store Email,Customer Email,Messages,Paypal" type="pills">
<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

    <aui:input name="redirect" type="hidden"
        value="<%= configurationRenderURL %>" />

    <liferay-ui:section>
		<aui:input name="storeEmail" label="email-label" type="text" value="<%= storeEmail %>" required="true"/>
		<aui:input name="storeName" label="name-label" type="text" value="<%= storeName %>" required="true"/>
		<aui:input name="storeEmailSubject" label="email-subject-label" type="text" value="<%=storeEmailSubject %>" required="true"/>
		<liferay-ui:input-editor name="storeEmailEditor" initMethod="initStoreEmailEditor" editorImpl="liferay"/>
		<aui:input name="storeEmailContent" id="store-email-content" type="hidden" value="<%= storeEmailTemplate%>" required="true"/>

    </liferay-ui:section>
    
    <liferay-ui:section>
		<aui:input name="customerEmailSubject" label="email-subject-label" type="text" value="<%= customerEmailSubject %>" required="true"/>
		<liferay-ui:input-editor name="customerEmailEditor" initMethod="initCustomerEmailEditor"/>
		<aui:input name="customerEmailContent" id="customer-email-content" type="hidden" value="<%= customerEmailTemplate %>" required="true"/>
	</liferay-ui:section>
	
    <liferay-ui:section>
		<aui:input name="checkoutSuccessMessage" label="checkout-success-label" type="text" value="<%= checkoutSuccessMessage %>" required="true"/>
		<aui:input name="checkoutErrorMessage" label="checkout-error-label" type="text" value="<%= checkoutErrorMessage  %>" required="true"/>
		<aui:input name="cartEmptyMessage" label="empty-cart-message-label" type="text" value="<%= cartEmptyMessage %>" required="true"/>
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:input name="enablePaypal" label="enable-paypal" type="checkbox" value="<%= enablePaypal%>"/>
		<aui:input name="paypalEmail" label="paypal-email" type="text" value="<%= paypalEmail %>"/>
	</liferay-ui:section>	
    <aui:button-row>
        <aui:button type="submit" onclick="getEmailsText()"></aui:button>
    </aui:button-row>
</aui:form>
</liferay-ui:tabs>

<script type="text/javascript">

function <portlet:namespace />initStoreEmailEditor() {
	return '<%=storeEmailTemplate%>';
}

function <portlet:namespace />initCustomerEmailEditor() {
	return '<%=customerEmailTemplate%>';
}

function getEmailsText() {
	var pns = '<portlet:namespace />';
	document.getElementById(pns + 'customer-email-content').value = window[pns+'customerEmailEditor'].getHTML();
	document.getElementById(pns + 'store-email-content').value = window[pns+'storeEmailEditor'].getHTML();
	console.log(document.getElementById(pns + 'store-email-content').value);
	var invalidFiels = document.getElementsByClassName('error-field'); 
	if(invalidFiels && invalidFiels.length > 0){
		document.getElementById('error-message').className = 'alert alert-danger'; 
	}
}

</script>