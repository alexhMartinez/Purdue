/*
 * Show bike names and the total sales amounts for transactions involving bikes
 * costing $10,000 or more. The total sales amount is the product of the bike
 * order item list price, quantity sold, and sale discount.
 */

SELECT
  product_name,
  (quantity * order_items.list_price * (1 - discount)) AS SalesAmt

FROM BikeStores.sales.order_items
INNER JOIN BikeStores.production.products ON
  products.product_id = order_items.product_id
WHERE (quantity * order_items.list_price * (1 - discount)) >= 10000

ORDER BY 2 DESC
