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

package com.rivetlogic.ecommerce.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.rivetlogic.ecommerce.exception.NoSuchNotificationException;
import com.rivetlogic.ecommerce.model.Notification;
import com.rivetlogic.ecommerce.model.impl.NotificationImpl;
import com.rivetlogic.ecommerce.model.impl.NotificationModelImpl;
import com.rivetlogic.ecommerce.service.persistence.NotificationPK;
import com.rivetlogic.ecommerce.service.persistence.NotificationPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author isaiulate
 * @see NotificationPersistence
 * @see com.rivetlogic.ecommerce.service.persistence.NotificationUtil
 * @generated
 */
@ProviderType
public class NotificationPersistenceImpl extends BasePersistenceImpl<Notification>
	implements NotificationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NotificationUtil} to access the notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NotificationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NotificationModelImpl.ENTITY_CACHE_ENABLED,
			NotificationModelImpl.FINDER_CACHE_ENABLED, NotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NotificationModelImpl.ENTITY_CACHE_ENABLED,
			NotificationModelImpl.FINDER_CACHE_ENABLED, NotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NotificationModelImpl.ENTITY_CACHE_ENABLED,
			NotificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERID = new FinderPath(NotificationModelImpl.ENTITY_CACHE_ENABLED,
			NotificationModelImpl.FINDER_CACHE_ENABLED, NotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrderId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID =
		new FinderPath(NotificationModelImpl.ENTITY_CACHE_ENABLED,
			NotificationModelImpl.FINDER_CACHE_ENABLED, NotificationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrderId",
			new String[] { Long.class.getName() },
			NotificationModelImpl.ORDERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORDERID = new FinderPath(NotificationModelImpl.ENTITY_CACHE_ENABLED,
			NotificationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrderId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the notifications where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the matching notifications
	 */
	@Override
	public List<Notification> findByOrderId(long orderId) {
		return findByOrderId(orderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Notification> findByOrderId(long orderId, int start, int end) {
		return findByOrderId(orderId, start, end, null);
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
	@Override
	public List<Notification> findByOrderId(long orderId, int start, int end,
		OrderByComparator<Notification> orderByComparator) {
		return findByOrderId(orderId, start, end, orderByComparator, true);
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
	@Override
	public List<Notification> findByOrderId(long orderId, int start, int end,
		OrderByComparator<Notification> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID;
			finderArgs = new Object[] { orderId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORDERID;
			finderArgs = new Object[] { orderId, start, end, orderByComparator };
		}

		List<Notification> list = null;

		if (retrieveFromCache) {
			list = (List<Notification>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Notification notification : list) {
					if ((orderId != notification.getOrderId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_NOTIFICATION_WHERE);

			query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

				if (!pagination) {
					list = (List<Notification>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Notification>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first notification in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	@Override
	public Notification findByOrderId_First(long orderId,
		OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException {
		Notification notification = fetchByOrderId_First(orderId,
				orderByComparator);

		if (notification != null) {
			return notification;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderId=");
		msg.append(orderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificationException(msg.toString());
	}

	/**
	 * Returns the first notification in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	@Override
	public Notification fetchByOrderId_First(long orderId,
		OrderByComparator<Notification> orderByComparator) {
		List<Notification> list = findByOrderId(orderId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	@Override
	public Notification findByOrderId_Last(long orderId,
		OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException {
		Notification notification = fetchByOrderId_Last(orderId,
				orderByComparator);

		if (notification != null) {
			return notification;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orderId=");
		msg.append(orderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificationException(msg.toString());
	}

	/**
	 * Returns the last notification in the ordered set where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	@Override
	public Notification fetchByOrderId_Last(long orderId,
		OrderByComparator<Notification> orderByComparator) {
		int count = countByOrderId(orderId);

		if (count == 0) {
			return null;
		}

		List<Notification> list = findByOrderId(orderId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Notification[] findByOrderId_PrevAndNext(
		NotificationPK notificationPK, long orderId,
		OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException {
		Notification notification = findByPrimaryKey(notificationPK);

		Session session = null;

		try {
			session = openSession();

			Notification[] array = new NotificationImpl[3];

			array[0] = getByOrderId_PrevAndNext(session, notification, orderId,
					orderByComparator, true);

			array[1] = notification;

			array[2] = getByOrderId_PrevAndNext(session, notification, orderId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Notification getByOrderId_PrevAndNext(Session session,
		Notification notification, long orderId,
		OrderByComparator<Notification> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTIFICATION_WHERE);

		query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(NotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(orderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notification);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Notification> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notifications where orderId = &#63; from the database.
	 *
	 * @param orderId the order ID
	 */
	@Override
	public void removeByOrderId(long orderId) {
		for (Notification notification : findByOrderId(orderId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(notification);
		}
	}

	/**
	 * Returns the number of notifications where orderId = &#63;.
	 *
	 * @param orderId the order ID
	 * @return the number of matching notifications
	 */
	@Override
	public int countByOrderId(long orderId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORDERID;

		Object[] finderArgs = new Object[] { orderId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NOTIFICATION_WHERE);

			query.append(_FINDER_COLUMN_ORDERID_ORDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(orderId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORDERID_ORDERID_2 = "notification.id.orderId = ?";

	public NotificationPersistenceImpl() {
		setModelClass(Notification.class);
	}

	/**
	 * Caches the notification in the entity cache if it is enabled.
	 *
	 * @param notification the notification
	 */
	@Override
	public void cacheResult(Notification notification) {
		entityCache.putResult(NotificationModelImpl.ENTITY_CACHE_ENABLED,
			NotificationImpl.class, notification.getPrimaryKey(), notification);

		notification.resetOriginalValues();
	}

	/**
	 * Caches the notifications in the entity cache if it is enabled.
	 *
	 * @param notifications the notifications
	 */
	@Override
	public void cacheResult(List<Notification> notifications) {
		for (Notification notification : notifications) {
			if (entityCache.getResult(
						NotificationModelImpl.ENTITY_CACHE_ENABLED,
						NotificationImpl.class, notification.getPrimaryKey()) == null) {
				cacheResult(notification);
			}
			else {
				notification.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notifications.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NotificationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the notification.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Notification notification) {
		entityCache.removeResult(NotificationModelImpl.ENTITY_CACHE_ENABLED,
			NotificationImpl.class, notification.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Notification> notifications) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Notification notification : notifications) {
			entityCache.removeResult(NotificationModelImpl.ENTITY_CACHE_ENABLED,
				NotificationImpl.class, notification.getPrimaryKey());
		}
	}

	/**
	 * Creates a new notification with the primary key. Does not add the notification to the database.
	 *
	 * @param notificationPK the primary key for the new notification
	 * @return the new notification
	 */
	@Override
	public Notification create(NotificationPK notificationPK) {
		Notification notification = new NotificationImpl();

		notification.setNew(true);
		notification.setPrimaryKey(notificationPK);

		return notification;
	}

	/**
	 * Removes the notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationPK the primary key of the notification
	 * @return the notification that was removed
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	@Override
	public Notification remove(NotificationPK notificationPK)
		throws NoSuchNotificationException {
		return remove((Serializable)notificationPK);
	}

	/**
	 * Removes the notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notification
	 * @return the notification that was removed
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	@Override
	public Notification remove(Serializable primaryKey)
		throws NoSuchNotificationException {
		Session session = null;

		try {
			session = openSession();

			Notification notification = (Notification)session.get(NotificationImpl.class,
					primaryKey);

			if (notification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(notification);
		}
		catch (NoSuchNotificationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Notification removeImpl(Notification notification) {
		notification = toUnwrappedModel(notification);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notification)) {
				notification = (Notification)session.get(NotificationImpl.class,
						notification.getPrimaryKeyObj());
			}

			if (notification != null) {
				session.delete(notification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (notification != null) {
			clearCache(notification);
		}

		return notification;
	}

	@Override
	public Notification updateImpl(Notification notification) {
		notification = toUnwrappedModel(notification);

		boolean isNew = notification.isNew();

		NotificationModelImpl notificationModelImpl = (NotificationModelImpl)notification;

		Session session = null;

		try {
			session = openSession();

			if (notification.isNew()) {
				session.save(notification);

				notification.setNew(false);
			}
			else {
				notification = (Notification)session.merge(notification);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NotificationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((notificationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						notificationModelImpl.getOriginalOrderId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORDERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID,
					args);

				args = new Object[] { notificationModelImpl.getOrderId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ORDERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORDERID,
					args);
			}
		}

		entityCache.putResult(NotificationModelImpl.ENTITY_CACHE_ENABLED,
			NotificationImpl.class, notification.getPrimaryKey(), notification,
			false);

		notification.resetOriginalValues();

		return notification;
	}

	protected Notification toUnwrappedModel(Notification notification) {
		if (notification instanceof NotificationImpl) {
			return notification;
		}

		NotificationImpl notificationImpl = new NotificationImpl();

		notificationImpl.setNew(notification.isNew());
		notificationImpl.setPrimaryKey(notification.getPrimaryKey());

		notificationImpl.setOrderId(notification.getOrderId());
		notificationImpl.setSubject(notification.getSubject());
		notificationImpl.setBody(notification.getBody());
		notificationImpl.setSender(notification.getSender());
		notificationImpl.setRecipients(notification.getRecipients());

		return notificationImpl;
	}

	/**
	 * Returns the notification with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification
	 * @return the notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	@Override
	public Notification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotificationException {
		Notification notification = fetchByPrimaryKey(primaryKey);

		if (notification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotificationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return notification;
	}

	/**
	 * Returns the notification with the primary key or throws a {@link NoSuchNotificationException} if it could not be found.
	 *
	 * @param notificationPK the primary key of the notification
	 * @return the notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	@Override
	public Notification findByPrimaryKey(NotificationPK notificationPK)
		throws NoSuchNotificationException {
		return findByPrimaryKey((Serializable)notificationPK);
	}

	/**
	 * Returns the notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification
	 * @return the notification, or <code>null</code> if a notification with the primary key could not be found
	 */
	@Override
	public Notification fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(NotificationModelImpl.ENTITY_CACHE_ENABLED,
				NotificationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Notification notification = (Notification)serializable;

		if (notification == null) {
			Session session = null;

			try {
				session = openSession();

				notification = (Notification)session.get(NotificationImpl.class,
						primaryKey);

				if (notification != null) {
					cacheResult(notification);
				}
				else {
					entityCache.putResult(NotificationModelImpl.ENTITY_CACHE_ENABLED,
						NotificationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(NotificationModelImpl.ENTITY_CACHE_ENABLED,
					NotificationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return notification;
	}

	/**
	 * Returns the notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificationPK the primary key of the notification
	 * @return the notification, or <code>null</code> if a notification with the primary key could not be found
	 */
	@Override
	public Notification fetchByPrimaryKey(NotificationPK notificationPK) {
		return fetchByPrimaryKey((Serializable)notificationPK);
	}

	@Override
	public Map<Serializable, Notification> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Notification> map = new HashMap<Serializable, Notification>();

		for (Serializable primaryKey : primaryKeys) {
			Notification notification = fetchByPrimaryKey(primaryKey);

			if (notification != null) {
				map.put(primaryKey, notification);
			}
		}

		return map;
	}

	/**
	 * Returns all the notifications.
	 *
	 * @return the notifications
	 */
	@Override
	public List<Notification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Notification> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Notification> findAll(int start, int end,
		OrderByComparator<Notification> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Notification> findAll(int start, int end,
		OrderByComparator<Notification> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Notification> list = null;

		if (retrieveFromCache) {
			list = (List<Notification>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_NOTIFICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICATION;

				if (pagination) {
					sql = sql.concat(NotificationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Notification>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Notification>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the notifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Notification notification : findAll()) {
			remove(notification);
		}
	}

	/**
	 * Returns the number of notifications.
	 *
	 * @return the number of notifications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NOTIFICATION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NotificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the notification persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(NotificationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_NOTIFICATION = "SELECT notification FROM Notification notification";
	private static final String _SQL_SELECT_NOTIFICATION_WHERE = "SELECT notification FROM Notification notification WHERE ";
	private static final String _SQL_COUNT_NOTIFICATION = "SELECT COUNT(notification) FROM Notification notification";
	private static final String _SQL_COUNT_NOTIFICATION_WHERE = "SELECT COUNT(notification) FROM Notification notification WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "notification.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Notification exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Notification exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(NotificationPersistenceImpl.class);
}