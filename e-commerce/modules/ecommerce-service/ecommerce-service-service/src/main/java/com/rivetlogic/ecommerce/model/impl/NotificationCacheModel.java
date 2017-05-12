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

package com.rivetlogic.ecommerce.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.rivetlogic.ecommerce.model.Notification;
import com.rivetlogic.ecommerce.service.persistence.NotificationPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Notification in entity cache.
 *
 * @author isaiulate
 * @see Notification
 * @generated
 */
@ProviderType
public class NotificationCacheModel implements CacheModel<Notification>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationCacheModel)) {
			return false;
		}

		NotificationCacheModel notificationCacheModel = (NotificationCacheModel)obj;

		if (notificationPK.equals(notificationCacheModel.notificationPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, notificationPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{orderId=");
		sb.append(orderId);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", body=");
		sb.append(body);
		sb.append(", sender=");
		sb.append(sender);
		sb.append(", recipients=");
		sb.append(recipients);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Notification toEntityModel() {
		NotificationImpl notificationImpl = new NotificationImpl();

		notificationImpl.setOrderId(orderId);

		if (subject == null) {
			notificationImpl.setSubject(StringPool.BLANK);
		}
		else {
			notificationImpl.setSubject(subject);
		}

		if (body == null) {
			notificationImpl.setBody(StringPool.BLANK);
		}
		else {
			notificationImpl.setBody(body);
		}

		if (sender == null) {
			notificationImpl.setSender(StringPool.BLANK);
		}
		else {
			notificationImpl.setSender(sender);
		}

		if (recipients == null) {
			notificationImpl.setRecipients(StringPool.BLANK);
		}
		else {
			notificationImpl.setRecipients(recipients);
		}

		notificationImpl.resetOriginalValues();

		return notificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		orderId = objectInput.readLong();
		subject = objectInput.readUTF();
		body = objectInput.readUTF();
		sender = objectInput.readUTF();
		recipients = objectInput.readUTF();

		notificationPK = new NotificationPK(orderId, recipients);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(orderId);

		if (subject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (body == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(body);
		}

		if (sender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sender);
		}

		if (recipients == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(recipients);
		}
	}

	public long orderId;
	public String subject;
	public String body;
	public String sender;
	public String recipients;
	public transient NotificationPK notificationPK;
}