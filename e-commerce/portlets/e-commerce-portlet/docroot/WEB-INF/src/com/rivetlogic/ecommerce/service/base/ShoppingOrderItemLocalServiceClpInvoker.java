/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.rivetlogic.ecommerce.service.base;

import com.rivetlogic.ecommerce.service.ShoppingOrderItemLocalServiceUtil;

import java.util.Arrays;

/**
 * @author isaiulate
 * @generated
 */
public class ShoppingOrderItemLocalServiceClpInvoker {
	public ShoppingOrderItemLocalServiceClpInvoker() {
		_methodName0 = "addShoppingOrderItem";

		_methodParameterTypes0 = new String[] {
				"com.rivetlogic.ecommerce.model.ShoppingOrderItem"
			};

		_methodName1 = "createShoppingOrderItem";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteShoppingOrderItem";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteShoppingOrderItem";

		_methodParameterTypes3 = new String[] {
				"com.rivetlogic.ecommerce.model.ShoppingOrderItem"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchShoppingOrderItem";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getShoppingOrderItem";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getShoppingOrderItems";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getShoppingOrderItemsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateShoppingOrderItem";

		_methodParameterTypes15 = new String[] {
				"com.rivetlogic.ecommerce.model.ShoppingOrderItem"
			};

		_methodName40 = "getBeanIdentifier";

		_methodParameterTypes40 = new String[] {  };

		_methodName41 = "setBeanIdentifier";

		_methodParameterTypes41 = new String[] { "java.lang.String" };

		_methodName46 = "findByOrderId";

		_methodParameterTypes46 = new String[] { "long" };

		_methodName47 = "findByOrderAndProductId";

		_methodParameterTypes47 = new String[] { "long", "java.lang.String" };

		_methodName48 = "createOrderItem";

		_methodParameterTypes48 = new String[] { "long" };

		_methodName49 = "updateOrderItem";

		_methodParameterTypes49 = new String[] {
				"com.rivetlogic.ecommerce.model.ShoppingOrderItem"
			};

		_methodName51 = "saveOrderItem";

		_methodParameterTypes51 = new String[] {
				"java.lang.String", "long", "float"
			};

		_methodName52 = "saveOrderItemsByProductId";

		_methodParameterTypes52 = new String[] {
				"java.util.List", "com.rivetlogic.ecommerce.model.ShoppingOrder"
			};

		_methodName53 = "saveOrderItemsByProductId";

		_methodParameterTypes53 = new String[] {
				"java.util.List", "com.rivetlogic.ecommerce.model.ShoppingOrder",
				"java.util.Map"
			};

		_methodName54 = "saveOrderItemByProductId";

		_methodParameterTypes54 = new String[] {
				"java.lang.String",
				"com.rivetlogic.ecommerce.model.ShoppingOrder", "float"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.addShoppingOrderItem((com.rivetlogic.ecommerce.model.ShoppingOrderItem)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.createShoppingOrderItem(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.deleteShoppingOrderItem(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.deleteShoppingOrderItem((com.rivetlogic.ecommerce.model.ShoppingOrderItem)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.fetchShoppingOrderItem(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.getShoppingOrderItem(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.getShoppingOrderItems(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.getShoppingOrderItemsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.updateShoppingOrderItem((com.rivetlogic.ecommerce.model.ShoppingOrderItem)arguments[0]);
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			ShoppingOrderItemLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.findByOrderId(((Long)arguments[0]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.findByOrderAndProductId(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.createOrderItem(((Long)arguments[0]).longValue());
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return ShoppingOrderItemLocalServiceUtil.updateOrderItem((com.rivetlogic.ecommerce.model.ShoppingOrderItem)arguments[0]);
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			ShoppingOrderItemLocalServiceUtil.saveOrderItem((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Float)arguments[2]).floatValue());

			return null;
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			ShoppingOrderItemLocalServiceUtil.saveOrderItemsByProductId((java.util.List<java.lang.String>)arguments[0],
				(com.rivetlogic.ecommerce.model.ShoppingOrder)arguments[1]);

			return null;
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			ShoppingOrderItemLocalServiceUtil.saveOrderItemsByProductId((java.util.List<java.lang.String>)arguments[0],
				(com.rivetlogic.ecommerce.model.ShoppingOrder)arguments[1],
				(java.util.Map<java.lang.String, java.lang.Float>)arguments[2]);

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			ShoppingOrderItemLocalServiceUtil.saveOrderItemByProductId((java.lang.String)arguments[0],
				(com.rivetlogic.ecommerce.model.ShoppingOrder)arguments[1],
				((Float)arguments[2]).floatValue());

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
}