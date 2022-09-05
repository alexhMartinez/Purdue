/*
 * Select customer records for customers residing in the 14450 zip code.
 */

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
WHERE zip_code = 14450
