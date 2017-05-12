package com.rivetlogic.ecommerce.portlet.order.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.notification.constants.ShoppingCartPortletConstants;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;



@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=E-Commerce",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Shopping Orders",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OrdersPortlet extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(OrdersPortlet.class);

    public void updateOrderStatus(ActionRequest request, ActionResponse response) throws IOException, PortletException {
        long orderId = ParamUtil.getLong(request, ShoppingCartPortletConstants.ORDER_ID);
        String newStatus = ParamUtil.getString(request, ShoppingCartPortletConstants.STATUS_UPDATE);
        String redirect = ParamUtil.getString(request, "redirect");
        LOG.debug(String.format("Updating order %s with status %s", orderId, newStatus));
        
        try {
            ShoppingOrder order = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(orderId);
            order.setOrderStatus(newStatus);
            ShoppingOrderLocalServiceUtil.updateOrder(order);
            SessionMessages.add(request, "success");
            
        } catch(SystemException e) {
            LOG.error(e);
        }
        response.sendRedirect(redirect);
    }
    
    public void updateOrderNotes(ActionRequest request, ActionResponse response) throws IOException, PortletException {
        long orderId = ParamUtil.getLong(request, ShoppingCartPortletConstants.ORDER_ID);
        String notes = ParamUtil.getString(request, ShoppingCartPortletConstants.NOTES_UPDATE);
        String redirect = ParamUtil.getString(request, "redirect");
        LOG.debug(String.format("Updating notes for order %s", orderId));
        try {
            ShoppingOrder order = ShoppingOrderLocalServiceUtil.fetchShoppingOrder(orderId);
            order.setNotes(notes);
            ShoppingOrderLocalServiceUtil.updateOrder(order);
            SessionMessages.add(request, "success");
        } catch(SystemException e) {
            LOG.error(e);
        }
        response.sendRedirect(redirect);
    }
    

    
    

}