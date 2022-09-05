/*
 * Create a stored procedure that lists bikes within a specified price range. The output must
 * show the bike name, model year, and list price. The results need to be presented in
 * alphabetical order based on the bike name. The skeleton of the stored procedure is provided
 * below.
 */

USE BikeStores;
GO

CREATE PROCEDURE GetBikesByPriceRange
@MinPrice DECIMAL(10,2),
@MaxPrice DECIMAL(10,2)
AS
  SET NOCOUNT ON;
  SELECT
	product_name,
	model_year,
	list_price

  FROM BikeStores.production.products
  WHERE list_price BETWEEN @MinPrice AND @MaxPrice

  ORDER BY product_name ASC
;

GO
EXECUTE GetBikesByPriceRange @MinPrice = 6000, @MaxPrice = 12000;
