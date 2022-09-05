/*
 * Provide a distinct list of the states in alphabetical order where the
 * company’s customers reside.
 */

SELECT DISTINCT
  state

FROM BikeStores.sales.customers
ORDER BY state ASC
