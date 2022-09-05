/*
 * Present a list of the bikes made by a company called “Haro”
 * in alphabetical order.
 */

SELECT
  product_name

FROM BikeStores.production.products products
INNER JOIN BikeStores.production.brands brands ON
  brands.brand_id = products.brand_id
WHERE brand_name = 'Haro'

ORDER BY product_name ASC
