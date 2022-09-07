/*
 * Establish a database view called LowCostBikesView that lists the bikes costing $200 or less. The
 * view needs to contain the bike name, brand name, and list price. Then execute a SELECT query to
 * verify the view.
 */

USE BikeStores ;
GO

CREATE VIEW LowCostBikesView
AS
	SELECT DISTINCT
	  product_name,
	  brand_name,
	  list_price

	FROM BikeStores.production.products
	INNER JOIN BikeStores.production.brands ON
		brands.brand_id = products.brand_id
	INNER JOIN BikeStores.production.stocks ON
		stocks.product_id = products.product_id
	INNER JOIN BikeStores.sales.stores ON
		stores.store_id = stocks.store_id
	WHERE list_price < 200
;
GO

SELECT
  *

FROM LowCostBikesView
; 
