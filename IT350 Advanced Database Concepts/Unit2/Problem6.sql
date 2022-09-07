/*
 * Establish a database view called CompanyStaffListView that lists the last name, first name,
 * and email address of the staff from all the company stores. Then execute a SELECT query to
 * verify the view.
 */

USE BikeStores ;
GO

CREATE VIEW CompanyStaffListView
AS
	SELECT
	  last_name,
	  first_name,
	  email

	FROM BikeStores.sales.staffs
;
GO

-- check view
SELECT
  *

FROM CompanyStaffListView
;
