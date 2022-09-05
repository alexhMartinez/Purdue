/*
 * Create a stored procedure that lists the top five priced bikes at a specified store. The
 * output must show the bike name, model year, and list price. The results need to be presented
 * in descending price order. The skeleton of the stored procedure is provided below.
 */

USE BikeStores;
GO

CREATE PROCEDURE GetTopFivePricedBikesByStoreName
@StoreName VARCHAR(255)
AS
  SET NOCOUNT ON;
  SELECT DISTINCT
	products.product_name,
	products.model_year,
	products.list_price

  FROM BikeStores.production.products
  INNER JOIN BikeStores.sales.order_items ON
	order_items.product_id = products.product_id
  INNER JOIN BikeStores.sales.orders ON
    orders.order_id = order_items.order_id
  INNER JOIN BikeStores.sales.stores ON
    stores.store_id = orders.store_id
  WHERE stores.store_name = @StoreName
  ORDER BY products.list_price DESC
  OFFSET 0 ROWS
  FETCH NEXT 5 ROWS ONLY
;

GO
EXECUTE GetTopFivePricedBikesByStoreName @StoreName = 'Baldwin Bikes';
