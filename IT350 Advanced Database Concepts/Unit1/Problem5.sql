/*
 * The company is now selling bikes from a company called GT Bicycles.
 * Enter a new record into the database to reflect this change.
 */

SET IDENTITY_INSERT BikeStores.production.brands ON;

INSERT INTO BikeStores.production.brands (
  brand_id,
  brand_name
)
VALUES (
  10,
  'GT Bicycles'
)
;

SELECT
  *

FROM BikeStores.production.brands
WHERE brand_id = 10
