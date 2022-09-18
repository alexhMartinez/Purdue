/*
 * Create a stored procedure that lists the bike categories with minimum list prices
 * below a specified value. The output must show the bike category and associated minimum
 * list price. The results need to be presented in ascending order based on the bike
 * category. The skeleton of the stored procedure is provided below. (Hint: The HAVING
 * clause needs to be used.)
 */

USE BikeStores;
GO

CREATE PROCEDURE GetBikeCategoriesWithMinPriceBelowValue
@Price DECIMAL(10,2)
AS
  SET NOCOUNT ON;
  SELECT
	category_name,
	MIN(list_price) AS MinListPrice

  FROM BikeStores.production.categories
  INNER JOIN BikeStores.production.products ON products.category_id = categories.category_id
  GROUP BY category_name
  HAVING MIN(list_price) < @Price
  ORDER BY category_name
;

GO
EXECUTE GetBikeCategoriesWithMinPriceBelowValue @Price = 500;
