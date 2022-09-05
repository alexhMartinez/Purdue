/*
 * Display the bike names and list prices for bikes costing $5,000 or more.
 * Order the results in descending order based on the list price.
 */

SELECT
  product_name,
  list_price

FROM BikeStores.production.products
WHERE list_price >= 5000

ORDER BY list_price DESC
