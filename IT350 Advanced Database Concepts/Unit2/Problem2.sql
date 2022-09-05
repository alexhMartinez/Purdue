/*
 * Create a stored procedure that lists the customers from
 * a specified zip code. The skeleton of the stored
 * procedure is provided below.
 */

USE BikeStores;
GO

CREATE PROCEDURE GetCustomersByZipCode
@ZipCode VARCHAR(5)
AS
  SET NOCOUNT ON;
  SELECT
	customer_id,
	first_name,
	last_name,
	phone,
	email,
	street,
	city,
	state,
	zip_code

  FROM BikeStores.sales.customers
  WHERE zip_code = @ZipCode
;

GO
EXECUTE GetCustomersByZipCode @ZipCode = '75115';
