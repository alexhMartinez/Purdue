/*
 * List the first and last names of staff members whose manager is Mireya Copeland.
 */

SELECT
  first_name,
  last_name

FROM BikeStores.sales.staffs
WHERE store_id = 1 --store that miraya manages
AND manager_id IS NOT NULL
AND manager_id != 1 --id for manager profile
