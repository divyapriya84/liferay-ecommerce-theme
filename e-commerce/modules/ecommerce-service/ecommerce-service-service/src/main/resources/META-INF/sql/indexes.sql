create index IX_11014B9A on rivetlogic_ecommerce_Notification (orderId);

create index IX_1D44DDA4 on rivetlogic_ecommerce_ShoppingOrder (groupId, orderStatus[$COLUMN_LENGTH:75$]);
create index IX_419C748C on rivetlogic_ecommerce_ShoppingOrder (orderStatus[$COLUMN_LENGTH:75$], userId);

create index IX_D4121772 on rivetlogic_ecommerce_ShoppingOrderItem (orderId, productId[$COLUMN_LENGTH:75$]);