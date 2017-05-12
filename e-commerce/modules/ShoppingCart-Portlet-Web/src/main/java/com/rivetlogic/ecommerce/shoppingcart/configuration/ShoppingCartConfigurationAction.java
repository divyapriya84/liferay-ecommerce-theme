package com.rivetlogic.ecommerce.shoppingcart.configuration;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.UnicodeFormatter;
import com.rivetlogic.ecommerce.beans.ShoppingCartPrefsBean;
import com.rivetlogic.ecommerce.service.util.PreferencesKeys;

@Component(
    configurationPid = "com.rivetlogic.ecommerce.shoppingcart.configuration.ShoppingCartConfiguration",
    configurationPolicy = ConfigurationPolicy.OPTIONAL,
    immediate = true,
    property = {
        "javax.portlet.name=com_rivetlogic_ecommerce_shoppingcart_portlet_ShoppingCartPortlet"
    },
    service = ConfigurationAction.class
)
public class ShoppingCartConfigurationAction extends DefaultConfigurationAction {

    @Override
    public void processAction(
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {

        
        String storeEmail = ParamUtil.getString(actionRequest, PreferencesKeys.STORE_EMAIL);
        String storeName = ParamUtil.getString(actionRequest, PreferencesKeys.STORE_NAME);
        String enablePaypal = ParamUtil.getString(actionRequest,  PreferencesKeys.ENABLE_PAYPAL);
        String paypalEmail = ParamUtil.getString(actionRequest, PreferencesKeys.PAYPAL_EMAIL);
        String storeEmailSubject = ParamUtil.getString(actionRequest, PreferencesKeys.STORE_NOTIF_SUBJECT_TEMPLATE);
        String storeEmailContent = ParamUtil.getString(actionRequest, PreferencesKeys.STORE_NOTIF_BODY_TEMPLATE);
        String customerEmailSubject = ParamUtil.getString(actionRequest, PreferencesKeys.CUSTOMER_NOTIF_SUBJECT_TEMPLATE);
        String customerEmailContent = ParamUtil.getString(actionRequest, PreferencesKeys.CUSTOMER_NOTIF_BODY_TEMPLATE);
        String checkoutSuccessMessage = ParamUtil.getString(actionRequest, PreferencesKeys.CHECKOUT_SUCCESS_MESSAGE);
        String checkoutErrorMessage = ParamUtil.getString(actionRequest, PreferencesKeys.CHECKOUT_ERROR_MESSAGE);
        String cartIsEmptyMessage = ParamUtil.getString(actionRequest, PreferencesKeys.CART_EMPTY_MESSAGE);
        
        
        setPreference(actionRequest, PreferencesKeys.STORE_EMAIL, storeEmail);
        setPreference(actionRequest, PreferencesKeys.STORE_NAME, storeName);
        setPreference(actionRequest, PreferencesKeys.ENABLE_PAYPAL, enablePaypal);
        setPreference(actionRequest, PreferencesKeys.PAYPAL_EMAIL, paypalEmail);
        setPreference(actionRequest, PreferencesKeys.STORE_NOTIF_SUBJECT_TEMPLATE, storeEmailSubject);
        setPreference(actionRequest, PreferencesKeys.STORE_NOTIF_BODY_TEMPLATE, storeEmailContent);
        setPreference(actionRequest, PreferencesKeys.CUSTOMER_NOTIF_SUBJECT_TEMPLATE, customerEmailSubject);
        setPreference(actionRequest, PreferencesKeys.CUSTOMER_NOTIF_BODY_TEMPLATE, customerEmailContent);
        setPreference(actionRequest, PreferencesKeys.CHECKOUT_SUCCESS_MESSAGE, checkoutSuccessMessage);
        setPreference(actionRequest, PreferencesKeys.CHECKOUT_ERROR_MESSAGE, checkoutErrorMessage);
        setPreference(actionRequest, PreferencesKeys.CART_EMPTY_MESSAGE, cartIsEmptyMessage);
        
        super.processAction(portletConfig, actionRequest, actionResponse);
    }

    @Override
    public void include(
        PortletConfig portletConfig, HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse) throws Exception {
    	
    	
        httpServletRequest.setAttribute(
            ShoppingCartConfiguration.class.getName(),
            _shoppingCartConfiguration);

        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

   

	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _shoppingCartConfiguration = Configurable.createConfigurable(
            ShoppingCartConfiguration.class, properties);
    }

    private volatile ShoppingCartConfiguration _shoppingCartConfiguration;

}