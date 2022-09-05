/*
 * Update the amount of stock for the bike with product_id = 198 at the store
 * with store_id = 2. The new stock amount should be 20.
 */

UPDATE BikeStores.production.stocks
SET quantity = 20
WHERE store_id = 2 AND product_id = 198
;

SELECT
  *

FROM BikeStores.production.stocks
WHERE store_id = 2
AND product_id = 198
