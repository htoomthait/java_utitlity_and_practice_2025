-- Make sure no NULLs exist before applying the NOT NULL constraint
UPDATE tbl_employees SET last_name = 'Unknown' WHERE last_name IS NULL;

-- Alter the column to NOT NULL
ALTER TABLE tbl_employees
MODIFY last_name VARCHAR(100) NOT NULL;