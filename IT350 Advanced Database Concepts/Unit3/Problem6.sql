/*
 * Create a stored procedure that lists the stock quantity at each store for a specified
 * bike brand. The output must show the store name and stock quantity value. The results
 * need to be presented in ascending order based on the store name. The skeleton of the
 * stored procedure is provided below.
 */

USE BikeStores;
GO

CREATE PROCEDURE GetStoreBrandStockQuantity
@BrandName VARCHAR(255)
AS
  SET NOCOUNT ON;
  SELECT
	store_name,
	SUM(quantity) AS StockAmt

  FROM BikeStores.sales.stores
  INNER JOIN BikeStores.production.stocks ON stocks.store_id = stores.store_id
  INNER JOIN BikeStores.production.products ON products.product_id = stocks.product_id
  INNER JOIN BikeStores.production.brands ON brands.brand_id = products.brand_id
  WHERE brand_name = @BrandName
  GROUP BY store_name
  ORDER BY store_name ASC
;

GO
EXECUTE GetStoreBrandStockQuantity @BrandName = 'Trek';
