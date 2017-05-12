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

package com.rivetlogic.ecommerce.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingOrderItem}.
 * </p>
 *
 * @author isaiulate
 * @see ShoppingOrderItem
 * @generated
 */
@ProviderType
public class ShoppingOrderItemWrapper implements ShoppingOrderItem,
	ModelWrapper<ShoppingOrderItem> {
	public ShoppingOrderItemWrapper(ShoppingOrderItem shoppingOrderItem) {
		_shoppingOrderItem = shoppingOrderItem;
	}

	@Override
	public Class<?> getModelClass() {
		return ShoppingOrderItem.class;
	}

	@Override
	public String getModelClassName() {
		return ShoppingOrderItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemId", getItemId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("productId", getProductId());
		attributes.put("orderId", getOrderId());
		attributes.put("quantity", getQuantity());
		attributes.put("price", getPrice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String productId = (String)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}
	}

	@Override
	public ShoppingOrderItem toEscapedModel() {
		return new ShoppingOrderItemWrapper(_shoppingOrderItem.toEscapedModel());
	}

	@Override
	public ShoppingOrderItem toUnescapedModel() {
		return new ShoppingOrderItemWrapper(_shoppingOrderItem.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _shoppingOrderItem.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _shoppingOrderItem.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _shoppingOrderItem.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _shoppingOrderItem.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ShoppingOrderItem> toCacheModel() {
		return _shoppingOrderItem.toCacheModel();
	}

	/**
	* Returns the price of this Shopping Order Item.
	*
	* @return the price of this Shopping Order Item
	*/
	@Override
	public double getPrice() {
		return _shoppingOrderItem.getPrice();
	}

	@Override
	public int compareTo(ShoppingOrderItem shoppingOrderItem) {
		return _shoppingOrderItem.compareTo(shoppingOrderItem);
	}

	/**
	* Returns the quantity of this Shopping Order Item.
	*
	* @return the quantity of this Shopping Order Item
	*/
	@Override
	public int getQuantity() {
		return _shoppingOrderItem.getQuantity();
	}

	@Override
	public int hashCode() {
		return _shoppingOrderItem.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _shoppingOrderItem.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ShoppingOrderItemWrapper((ShoppingOrderItem)_shoppingOrderItem.clone());
	}

	/**
	* Returns the product ID of this Shopping Order Item.
	*
	* @return the product ID of this Shopping Order Item
	*/
	@Override
	public java.lang.String getProductId() {
		return _shoppingOrderItem.getProductId();
	}

	@Override
	public java.lang.String toString() {
		return _shoppingOrderItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _shoppingOrderItem.toXmlString();
	}

	/**
	* Returns the create date of this Shopping Order Item.
	*
	* @return the create date of this Shopping Order Item
	*/
	@Override
	public Date getCreateDate() {
		return _shoppingOrderItem.getCreateDate();
	}

	/**
	* Returns the modified date of this Shopping Order Item.
	*
	* @return the modified date of this Shopping Order Item
	*/
	@Override
	public Date getModifiedDate() {
		return _shoppingOrderItem.getModifiedDate();
	}

	/**
	* Returns the item ID of this Shopping Order Item.
	*
	* @return the item ID of this Shopping Order Item
	*/
	@Override
	public long getItemId() {
		return _shoppingOrderItem.getItemId();
	}

	/**
	* Returns the order ID of this Shopping Order Item.
	*
	* @return the order ID of this Shopping Order Item
	*/
	@Override
	public long getOrderId() {
		return _shoppingOrderItem.getOrderId();
	}

	/**
	* Returns the primary key of this Shopping Order Item.
	*
	* @return the primary key of this Shopping Order Item
	*/
	@Override
	public long getPrimaryKey() {
		return _shoppingOrderItem.getPrimaryKey();
	}

	@Override
	public void persist() {
		_shoppingOrderItem.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_shoppingOrderItem.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this Shopping Order Item.
	*
	* @param createDate the create date of this Shopping Order Item
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_shoppingOrderItem.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_shoppingOrderItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_shoppingOrderItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_shoppingOrderItem.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the item ID of this Shopping Order Item.
	*
	* @param itemId the item ID of this Shopping Order Item
	*/
	@Override
	public void setItemId(long itemId) {
		_shoppingOrderItem.setItemId(itemId);
	}

	/**
	* Sets the modified date of this Shopping Order Item.
	*
	* @param modifiedDate the modified date of this Shopping Order Item
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_shoppingOrderItem.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_shoppingOrderItem.setNew(n);
	}

	/**
	* Sets the order ID of this Shopping Order Item.
	*
	* @param orderId the order ID of this Shopping Order Item
	*/
	@Override
	public void setOrderId(long orderId) {
		_shoppingOrderItem.setOrderId(orderId);
	}

	/**
	* Sets the price of this Shopping Order Item.
	*
	* @param price the price of this Shopping Order Item
	*/
	@Override
	public void setPrice(double price) {
		_shoppingOrderItem.setPrice(price);
	}

	/**
	* Sets the primary key of this Shopping Order Item.
	*
	* @param primaryKey the primary key of this Shopping Order Item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_shoppingOrderItem.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_shoppingOrderItem.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the product ID of this Shopping Order Item.
	*
	* @param productId the product ID of this Shopping Order Item
	*/
	@Override
	public void setProductId(java.lang.String productId) {
		_shoppingOrderItem.setProductId(productId);
	}

	/**
	* Sets the quantity of this Shopping Order Item.
	*
	* @param quantity the quantity of this Shopping Order Item
	*/
	@Override
	public void setQuantity(int quantity) {
		_shoppingOrderItem.setQuantity(quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingOrderItemWrapper)) {
			return false;
		}

		ShoppingOrderItemWrapper shoppingOrderItemWrapper = (ShoppingOrderItemWrapper)obj;

		if (Objects.equals(_shoppingOrderItem,
					shoppingOrderItemWrapper._shoppingOrderItem)) {
			return true;
		}

		return false;
	}

	@Override
	public ShoppingOrderItem getWrappedModel() {
		return _shoppingOrderItem;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _shoppingOrderItem.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _shoppingOrderItem.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_shoppingOrderItem.resetOriginalValues();
	}

	private final ShoppingOrderItem _shoppingOrderItem;
}