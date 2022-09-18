/*
 * Establish a database view called AverageBrandBikePriceView that lists each bike brand name and
 * associated average bike list price and list price standard deviation. Then query the view and
 * present the output in ascending order based on the bike brand name.
 */

USE BikeStores ;
GO

CREATE VIEW AverageBrandBikePriceView
AS
	SELECT
		brand_name,
		AVG(list_price) AS AvgPrice,
		STDEV(list_price) AS StdDevPrice

	FROM BikeStores.production.brands
	INNER JOIN BikeStores.production.products ON products.brand_id = brands.brand_id
	GROUP BY brand_name
;
GO

SELECT
	brand_name,
	AvgPrice,
	StdDevPrice

FROM AverageBrandBikePriceView
ORDER BY brand_name ASC
