/*
 * Create a stored procedure that lists mountain bikes for a specified brand. The output must
 * show the bike name, model year, and list price. The results need to be presented in
 * alphabetical order based on the bike name. The skeleton of the stored procedure is provided
 * below.
 */

USE BikeStores;
GO

CREATE PROCEDURE GetMountainBikesByBrand
@Brand VARCHAR(255)
AS
  SET NOCOUNT ON;
  SELECT
	product_name,
	model_year,
	list_price

  FROM BikeStores.production.products
  INNER JOIN BikeStores.production.brands ON
	brands.brand_id = products.brand_id
  WHERE brand_name = @Brand
;

GO
EXECUTE GetMountainBikesByBrand @Brand = 'Haro';
