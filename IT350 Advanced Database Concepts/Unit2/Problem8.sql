/*
 * Establish a database view called LowRowlettBikesInventoryView that lists the bikes with stock
 * levels less than 2 at the Rowlett Bikes store. The view needs to contain the bike name, brand
 * name, and stock quantity amount. Then execute a SELECT query to verify the view.
 */

USE BikeStores ;
GO

CREATE VIEW LowRowletteBikesInventory
AS
	SELECT
	  product_name,
	  brand_name,
	  quantity

	FROM BikeStores.production.products
	INNER JOIN BikeStores.production.brands ON
		brands.brand_id = products.brand_id
	INNER JOIN BikeStores.production.stocks ON
		stocks.product_id = products.product_id
	INNER JOIN BikeStores.sales.stores ON
		stores.store_id = stocks.store_id
	WHERE LOWER(store_name) = 'rowlett bikes'
	AND quantity < 2
;
GO

SELECT
  *

FROM LowRowletteBikesInventory
; 
