/*
 * Establish a database view called UnshippedRowlettBikesOrdersView that lists the orders that have
 * not been shipped. The view needs to contain the order ID, customer first name, customer last name,
 * and order date. Unshipped orders are signified by order_status = 1. Then execute a SELECT query to
 * verify the view.
 */

USE BikeStores ;
GO

CREATE VIEW UnshippedRowlettBikesOrdersView
AS
	SELECT
	  order_id,
	  first_name,
	  last_name,
	  order_date

	FROM BikeStores.sales.orders
	INNER JOIN BikeStores.sales.customers ON
		customers.customer_id = orders.customer_id
	INNER JOIN BikeStores.sales.stores ON
		stores.store_id = orders.store_id
	WHERE order_status = 1
	AND LOWER(store_name) = 'rowlett bikes'
	ORDER BY order_id ASC
;
GO

SELECT
  *

FROM UnshippedRowlettBikesOrdersView
; 
