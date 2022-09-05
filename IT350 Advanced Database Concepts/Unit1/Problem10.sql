/*
 * Show the bikes that have zero stock at the Texas (TX) store.
 */

SELECT
  products.product_name,
  stores.state,
  stocks.quantity

FROM BikeStores.production.stocks
INNER JOIN BikeStores.sales.stores ON
  stores.store_id = stocks.store_id
LEFT JOIN BikeStores.production.products ON
  products.product_id = stocks.product_id
WHERE quantity = 0
AND LOWER(stores.state) = 'tx'

ORDER BY products.product_name ASC
