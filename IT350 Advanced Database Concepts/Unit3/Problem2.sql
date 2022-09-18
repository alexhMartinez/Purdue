/*
 * Establish a database view called MaximumBrandBikePriceView that lists each bike brand and
 * associated maximum bike price. Then query the view and present the output in ascending order based
 * on the bike brand name.
 */

USE BikeStores ;
GO

CREATE VIEW MaximumBrandBikePriceView
AS
	SELECT DISTINCT
		brand_name,
		product_name,
		list_price

	FROM BikeStores.production.brands
	INNER JOIN BikeStores.production.products ON products.brand_id = brands.brand_id
;
GO

SELECT
  brand_name,
  MAX(list_price) AS MaxPrice

FROM MaximumBrandBikePriceView
GROUP BY brand_name
ORDER BY brand_name ASC
