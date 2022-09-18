/*
 * Create a stored procedure that lists the stock quantity for each bike category at a
 * specified store. The output must show the bike category and stock quantity value. The
 * results need to be presented in ascending order based on the bike category. The
 * skeleton of the stored procedure is provided below.
 */

USE BikeStores;
GO

CREATE PROCEDURE GetCategoryStockQuantityForStore
@StoreName VARCHAR(255)
AS
  SET NOCOUNT ON;
  SELECT
	category_name,
	SUM(quantity) AS NumBikes

  FROM BikeStores.production.products
  INNER JOIN BikeStores.production.categories ON categories.category_id = products.category_id
  INNER JOIN BikeStores.production.stocks ON stocks.product_id = products.product_id
  INNER JOIN BikeStores.sales.stores ON stores.store_id = stocks.store_id
  WHERE store_name = @StoreName
  GROUP BY category_name
  ORDER BY category_name ASC
;

GO
EXECUTE GetCategoryStockQuantityForStore @StoreName = 'Santa Cruz Bikes';
