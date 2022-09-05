/*
 * Problem 1: Create a stored procedure that lists the last
 * name, first name, and email address of the staff from
 * all the company stores. The output needs to be in
 * alphabetical order based on the last name then by the
 * first name. The skeleton of the stored procedure is
 * provided below.
 */

USE BikeStores;
GO

CREATE PROCEDURE GetCompanyStaffList
AS
  SET NOCOUNT ON;
  SELECT
	last_name,
	first_name,
	email

  FROM BikeStores.sales.staffs
  ORDER BY last_name, first_name ASC
;

GO
EXECUTE GetCompanyStaffList;
