/*
 * Create a stored procedure that presents the sales discount average and standard
 * deviation for bike brands at or above a specified discount value. The output must show
 * the brand names in alphabetical order along with the associated statistics. The
 * skeleton of the stored procedure is provided below. (Hint: The HAVING clause needs to
 * be used.)
 */

USE BikeStores;
GO
--drop  PROCEDURE GetBrandAverageSalesDiscountAboveValue
CREATE PROCEDURE GetBrandAverageSalesDiscountAboveValue
@Discount DECIMAL(4,2)
AS
  SET NOCOUNT ON;
  SELECT
	brand_name,
	AVG(discount) AS DiscAvg,
	STDEV(discount) AS DiscStdDev

  FROM BikeStores.production.brands
  INNER JOIN BikeStores.production.products ON products.brand_id = brands.brand_id
  INNER JOIN BikeStores.sales.order_items ON order_items.product_id = products.product_id
  GROUP BY brand_name
  HAVING AVG(discount) >= @Discount
  ORDER BY brand_name ASC
;

GO
EXECUTE GetBrandAverageSalesDiscountAboveValue @Discount = 0.11;
