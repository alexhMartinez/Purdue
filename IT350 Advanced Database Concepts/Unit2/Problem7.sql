/*
 * Establish a database view called BuffaloCustomersView that lists the last name, first name,
 * and email address of customers that live in the city of Buffalo, NY. Then execute a SELECT
 * query to verify the view.
 */

USE BikeStores ;
GO

CREATE VIEW BuffaloCustomersView
AS
	SELECT
	  last_name,
	  first_name,
	  email

	FROM BikeStores.sales.customers
	-- lower set to remove string match issues
	WHERE LOWER(state) = 'ny'
	AND LOWER(city) = 'buffalo'
;
GO

SELECT
  *

FROM BuffaloCustomersView
; 
