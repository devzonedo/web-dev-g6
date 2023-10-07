-- SQL    C R U D  
-- Insert query 

INSERT INTO tbl_pet_category (category) VALUES ('CAT');
INSERT INTO tbl_pet_category (category) VALUES ('DOG');

-- Select query 
SELECT * FROM tbl_pet_category;
SELECT category FROM tbl_pet_category;
SELECT * FROM tbl_pet_category WHERE id = 2 ;

-- update query 
UPDATE tbl_pet_category SET category = 'BIRD' WHERE id = 2;

-- delete query 
DELETE FROM tbl_pet_category WHERE id = 2;