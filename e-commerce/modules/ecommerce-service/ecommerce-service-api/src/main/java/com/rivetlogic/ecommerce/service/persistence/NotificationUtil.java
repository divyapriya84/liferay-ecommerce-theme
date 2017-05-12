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

package com.rivetlogic.ecommerce.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.rivetlogic.ecommerce.model.Notification;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the notification service. This utility wraps {@link com.rivetlogic.ecommerce.service.persistence.impl.NotificationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author isaiulate
 * @see NotificationPersistence
 * @see com.rivetlogic.ecommerce.service.persistence.impl.NotificationPersistenceImpl
 * @generated
 */
@ProviderType
public class NotificationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Notification notification) {
		getPersistence().clearCache(notification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Notification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Notification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Notification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Notification> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Notification update(Notification notification) {
		return getPersistence().update(notification);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Notification update(Notification notification,
		ServiceContext serviceContext) {
		return getPersistence().update(notification, serviceContext);
	}

	/**
	* Returns all the notifications where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the matching notifications
	*/
	public static List<Notification> findByOrderId(long orderId) {
		return getPersistence().findByOrderId(orderId);
	}

	/**
	* Returns a range of all the notifications where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @return the range of matching notifications
	*/
	public static List<Notification> findByOrderId(long orderId, int start,
		int end) {
		return getPersistence().findByOrderId(orderId, start, end);
	}

	/**
	* Returns an ordered range of all the notifications where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notifications
	*/
	public static List<Notification> findByOrderId(long orderId, int start,
		int end, OrderByComparator<Notification> orderByComparator) {
		return getPersistence()
				   .findByOrderId(orderId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the notifications where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching notifications
	*/
	public static List<Notification> findByOrderId(long orderId, int start,
		int end, OrderByComparator<Notification> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByOrderId(orderId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification
	* @throws NoSuchNotificationException if a matching notification could not be found
	*/
	public static Notification findByOrderId_First(long orderId,
		OrderByComparator<Notification> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchNotificationException {
		return getPersistence().findByOrderId_First(orderId, orderByComparator);
	}

	/**
	* Returns the first notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification, or <code>null</code> if a matching notification could not be found
	*/
	public static Notification fetchByOrderId_First(long orderId,
		OrderByComparator<Notification> orderByComparator) {
		return getPersistence().fetchByOrderId_First(orderId, orderByComparator);
	}

	/**
	* Returns the last notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification
	* @throws NoSuchNotificationException if a matching notification could not be found
	*/
	public static Notification findByOrderId_Last(long orderId,
		OrderByComparator<Notification> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchNotificationException {
		return getPersistence().findByOrderId_Last(orderId, orderByComparator);
	}

	/**
	* Returns the last notification in the ordered set where orderId = &#63;.
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification, or <code>null</code> if a matching notification could not be found
	*/
	public static Notification fetchByOrderId_Last(long orderId,
		OrderByComparator<Notification> orderByComparator) {
		return getPersistence().fetchByOrderId_Last(orderId, orderByComparator);
	}

	/**
	* Returns the notifications before and after the current notification in the ordered set where orderId = &#63;.
	*
	* @param notificationPK the primary key of the current notification
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification
	* @throws NoSuchNotificationException if a notification with the primary key could not be found
	*/
	public static Notification[] findByOrderId_PrevAndNext(
		NotificationPK notificationPK, long orderId,
		OrderByComparator<Notification> orderByComparator)
		throws com.rivetlogic.ecommerce.exception.NoSuchNotificationException {
		return getPersistence()
				   .findByOrderId_PrevAndNext(notificationPK, orderId,
			orderByComparator);
	}

	/**
	* Removes all the notifications where orderId = &#63; from the database.
	*
	* @param orderId the order ID
	*/
	public static void removeByOrderId(long orderId) {
		getPersistence().removeByOrderId(orderId);
	}

	/**
	* Returns the number of notifications where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the number of matching notifications
	*/
	public static int countByOrderId(long orderId) {
		return getPersistence().countByOrderId(orderId);
	}

	/**
	* Caches the notification in the entity cache if it is enabled.
	*
	* @param notification the notification
	*/
	public static void cacheResult(Notification notification) {
		getPersistence().cacheResult(notification);
	}

	/**
	* Caches the notifications in the entity cache if it is enabled.
	*
	* @param notifications the notifications
	*/
	public static void cacheResult(List<Notification> notifications) {
		getPersistence().cacheResult(notifications);
	}

	/**
	* Creates a new notification with the primary key. Does not add the notification to the database.
	*
	* @param notificationPK the primary key for the new notification
	* @return the new notification
	*/
	public static Notification create(NotificationPK notificationPK) {
		return getPersistence().create(notificationPK);
	}

	/**
	* Removes the notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationPK the primary key of the notification
	* @return the notification that was removed
	* @throws NoSuchNotificationException if a notification with the primary key could not be found
	*/
	public static Notification remove(NotificationPK notificationPK)
		throws com.rivetlogic.ecommerce.exception.NoSuchNotificationException {
		return getPersistence().remove(notificationPK);
	}

	public static Notification updateImpl(Notification notification) {
		return getPersistence().updateImpl(notification);
	}

	/**
	* Returns the notification with the primary key or throws a {@link NoSuchNotificationException} if it could not be found.
	*
	* @param notificationPK the primary key of the notification
	* @return the notification
	* @throws NoSuchNotificationException if a notification with the primary key could not be found
	*/
	public static Notification findByPrimaryKey(NotificationPK notificationPK)
		throws com.rivetlogic.ecommerce.exception.NoSuchNotificationException {
		return getPersistence().findByPrimaryKey(notificationPK);
	}

	/**
	* Returns the notification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificationPK the primary key of the notification
	* @return the notification, or <code>null</code> if a notification with the primary key could not be found
	*/
	public static Notification fetchByPrimaryKey(NotificationPK notificationPK) {
		return getPersistence().fetchByPrimaryKey(notificationPK);
	}

	public static java.util.Map<java.io.Serializable, Notification> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the notifications.
	*
	* @return the notifications
	*/
	public static List<Notification> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @return the range of notifications
	*/
	public static List<Notification> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notifications
	*/
	public static List<Notification> findAll(int start, int end,
		OrderByComparator<Notification> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notifications
	* @param end the upper bound of the range of notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of notifications
	*/
	public static List<Notification> findAll(int start, int end,
		OrderByComparator<Notification> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the notifications from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of notifications.
	*
	* @return the number of notifications
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NotificationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NotificationPersistence, NotificationPersistence> _serviceTracker =
		ServiceTrackerFactory.open(NotificationPersistence.class);
}