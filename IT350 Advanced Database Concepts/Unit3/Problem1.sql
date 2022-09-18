/*
 * Establish a database view called TotalBikesSoldView that lists each bike name and associated total
 * quantity sold. Then query the view to show the top ten bikes sold. Present the output in
 * descending order based on total bikes sold.
 */

USE BikeStores ;
GO

CREATE VIEW TotalBikesSoldView
AS
	SELECT
		product_name,
		quantity

	FROM BikeStores.sales.order_items
	INNER JOIN BikeStores.production.products ON products.product_id = order_items.product_id

	-- categories names could be pulled in to note bike or bicycle, but all are a bike type
	--INNER JOIN BikeStores.production.categories ON categories.category_id = products.category_id
;
GO

SELECT
	product_name,
	SUM(quantity) AS TotalSold

FROM TotalBikesSoldView
GROUP BY product_name
ORDER BY TotalSold DESC
	OFFSET 0 ROWS
	FETCH NEXT 10 ROWS ONLY
