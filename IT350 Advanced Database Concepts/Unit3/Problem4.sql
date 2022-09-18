/*
 * Establish a database view called NumberOfCustomersPerStateView that lists the number of customers
 * in each state. The view needs to show the state name along with the customer amount. Then query
 * the view and present the output in ascending order based on state.
 */

USE BikeStores ;
GO

CREATE VIEW NumberOfCustomersPerStateView
AS
	SELECT
		state,
		COUNT(DISTINCT(customer_id)) AS NumCustomers

	FROM BikeStores.sales.customers
	GROUP BY state
;
GO

SELECT
	state,
	NumCustomers

FROM NumberOfCustomersPerStateView
ORDER BY state ASC
