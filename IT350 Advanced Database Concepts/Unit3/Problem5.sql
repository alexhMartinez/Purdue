/*
 * Establish a database view called TotalBikesSoldPerStateView that shows the cumulative bike sales
 * per state. The view needs to show the state name along with the bike sales quantity. Then query
 * the view and present the output in ascending order based on state.
 */

USE BikeStores ;
GO

CREATE VIEW TotalBikesSoldPerStateView
AS
	SELECT
		state,
		SUM(quantity) AS NumBikeSold

	FROM BikeStores.sales.order_items
	INNER JOIN BikeStores.sales.orders ON orders.order_id = order_items.order_id
	INNER JOIN BikeStores.sales.stores ON stores.store_id = orders.store_id
	GROUP BY state
;
GO

SELECT
	state,
	NumBikeSold

FROM TotalBikesSoldPerStateView
ORDER BY state ASC
