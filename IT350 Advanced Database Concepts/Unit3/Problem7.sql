/*
 * Create a stored procedure that lists the average, standard deviation, maximum, and
 * minimum list prices for a specified bike brand. The output must show the brand name
 * along with the aggregated results. The results need to be presented in ascending order
 * based on the store name. The skeleton of the stored procedure is provided below.
 */

USE BikeStores;
GO

CREATE PROCEDURE GetBrandListPriceStatistics
@BrandName VARCHAR(255)
AS
  SET NOCOUNT ON;
  SELECT
	brand_name,
	AVG(list_price) AS PriceAvg,
	STDEV(list_price) AS PriceStdDev,
	MAX(list_price) AS PriceMax,
	MIN(list_price) AS PriceMin

  FROM BikeStores.sales.stores
  INNER JOIN BikeStores.production.stocks ON stocks.store_id = stores.store_id
  INNER JOIN BikeStores.production.products ON products.product_id = stocks.product_id
  INNER JOIN BikeStores.production.brands ON brands.brand_id = products.brand_id
	WHERE brand_name = @BrandName
  GROUP BY brand_name
;

GO
EXECUTE GetBrandListPriceStatistics @BrandName = 'Trek';
