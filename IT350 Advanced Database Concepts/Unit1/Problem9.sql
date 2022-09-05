/*
 * Display the full names of all staff personnel in First_Name, “ ” , Last_Name
 * format. Use the built-in CONCAT() function for this query.
 */

SELECT DISTINCT
  CONCAT(first_name,' ',last_name) AS 'Staff Name'

FROM BikeStores.sales.staffs
ORDER BY 1 ASC
