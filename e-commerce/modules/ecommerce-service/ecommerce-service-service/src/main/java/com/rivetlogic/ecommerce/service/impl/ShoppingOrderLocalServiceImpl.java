/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.ecommerce.service.impl;

import java.util.List;
import java.util.Map;

import aQute.bnd.annotation.ProviderType;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.notification.util.EmailNotificationUtil;
import com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil;
import com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil;
import com.rivetlogic.ecommerce.service.base.ShoppingOrderLocalServiceBaseImpl;
import com.rivetlogic.ecommerce.service.persistence.ShoppingOrderUtil;
import com.rivetlogic.ecommerce.service.util.OrderStatusEnum;


/**
 * The implementation of the Shopping Order local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.ecommerce.service.ShoppingOrderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author isaiulate
 * @see ShoppingOrderLocalServiceBaseImpl
 * @see com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil
 */
@ProviderType
public class ShoppingOrderLocalServiceImpl
	extends ShoppingOrderLocalServiceBaseImpl {
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.ecommerce.service.ShoppingOrderLocalServiceUtil} to access the Shopping Order local service.
	 */
	
	public List<ShoppingOrder> findByOrderStatusAndUserId(String orderStatus, long userId) throws SystemException {
		return ShoppingOrderUtil.findByOrderStatusAndUserId(orderStatus, userId);
	}
	
	public ShoppingOrder getUserActiveOrder(long userId, long groupId, long companyId, boolean createIfNotFound) throws SystemException{
		List<ShoppingOrder> activeOrders = findByOrderStatusAndUserId(OrderStatusEnum.IN_PROGRESS.toString(), userId);
		ShoppingOrder activeShoppingOrder = null;
		if(null != activeOrders && !activeOrders.isEmpty()){
			activeShoppingOrder = activeOrders.get(0);
		}else
			if(createIfNotFound){
				activeShoppingOrder = ShoppingOrderLocalServiceUtil.createShoppingOrder(CounterLocalServiceUtil.increment(ShoppingOrder.class.getName()));
				activeShoppingOrder.setOrderStatus(OrderStatusEnum.IN_PROGRESS.toString());
				activeShoppingOrder.setUserId(userId);
				activeShoppingOrder.setGroupId(groupId);
				activeShoppingOrder.setCompanyId(companyId);
				activeShoppingOrder.setCreateDate(DateUtil.newDate());
				activeShoppingOrder.setModifiedDate(DateUtil.newDate());
				ShoppingOrderLocalServiceUtil.addShoppingOrder(activeShoppingOrder);
			}

		return activeShoppingOrder;
	}
	
	public ShoppingOrder updateOrder(ShoppingOrder shoppingOrder) throws SystemException{
		shoppingOrder.setModifiedDate(DateUtil.newDate());
		return updateShoppingOrder(shoppingOrder);
	}
	
	public void placeOrder(ShoppingOrder shoppingOrder, Message notifMessages[], List<String>orderItemsProductIdsList, Map<String, Float> prices, boolean paypalEnabled) throws SystemException{
		shoppingOrder.setOrderStatus(paypalEnabled? OrderStatusEnum.WAITING_FOR_PAYPAL.toString() : OrderStatusEnum.WAITING_FOR_PAYMENT.toString());
		updateOrder(shoppingOrder);
		ShoppingOrderItemLocalServiceUtil.saveOrderItemsByProductId(orderItemsProductIdsList, shoppingOrder, prices);
		if(!paypalEnabled && null != notifMessages)
			for(Message message : notifMessages){
				EmailNotificationUtil.sendEmailNotification(message);
			}
	}
	
	public ShoppingOrder createOrder(long orderId){
		ShoppingOrder shoppingOrder = createShoppingOrder(orderId); 
		shoppingOrder.setCreateDate(DateUtil.newDate());
		return shoppingOrder;
	}
	
	public List<ShoppingOrder> findByGroupIdAndOrderStatus(long groupId, String orderStatus, int start, int end) throws SystemException {
	    return shoppingOrderPersistence.findByGroupIdAndOrderStatus(groupId, orderStatus, start, end);
	}
	
	public List<ShoppingOrder> findByGroupIdAndOrderStatus(long groupId, String orderStatus, int start, int end, OrderByComparator comparator) throws SystemException {
        return shoppingOrderPersistence.findByGroupIdAndOrderStatus(groupId, orderStatus, start, end, comparator);
    }
	
	public List<ShoppingOrder> findByGroupId(long groupId, int start, int end) throws SystemException {
        return shoppingOrderPersistence.findByGroupId(groupId, start, end);
    }
	
	public List<ShoppingOrder> findByGroupId(long groupId, int start, int end, OrderByComparator comparator) throws SystemException {
		List<ShoppingOrder> shoppingOrderList = shoppingOrderPersistence.findByGroupId(groupId, start, end, comparator);
		return shoppingOrderList;
		
    }
	
	public int countByGroupId(long groupId) throws SystemException {
	    return shoppingOrderPersistence.countByGroupId(groupId);
	}


	
}