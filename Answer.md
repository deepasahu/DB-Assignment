
1. Explain the relationship between the "Product" and "Product_Category" entities from the above diagram.
   
Ans:
Product and Product_Category will have a one to many and has a reationship. We will keep 'id' column of Product_Category as a foreign key.


2. How could you ensure that each product in the "Product" table has a valid category assigned to it?
   
Ans:
create table product_cat(id int PRIMARY KEY, name varchar(30),
   descr text,
   cr_at timestamp,
   mod_at timestamp,
   del_at timestamp);


INSERT INTO product_cat (id, name, descr, cr_at, mod_at, del_at)
VALUES (1, 'Smartphone', 'Smart phone', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO product_cat (id, name, descr, cr_at, mod_at, del_at)
VALUES (2, 'Books', 'Books', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
   
INSERT INTO product_cat (id, name, descr, cr_at, mod_at, del_at)
VALUES (3, 'Stationary', 'Stationary', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

CREATE INDEX idx_product_cat_id ON product_cat(id);

--Indexing will suport for foreign key constraints.

CREATE TABLE product (
    Id INT NOT NULL PRIMARY KEY,
    name varchar(20),
    descr text,
    sku varchar(20),
    cat_id int Not null,
    in_id int,
    price decimal,
    dis_id int,
    cr_at timestamp,
    mod_at timestamp,
    del_at timestamp,
    CONSTRAINT fk_cat FOREIGN KEY (cat_id) REFERENCES product_cat(id)
   );

CONSTRAINT fk_cat is a foreign key constraint.
FOREIGN KEY (cat_id) specifies that the cat_id column in the product table is a foreign key.
REFERENCES product_cat(id) indicates that cat_id references the id column in the product_cat table.
Therefore, This foreign key constraint ensures that the cat_id values in the product table must exist in the id column of the product_cat table, effectively enforcing the relationship between the two tables.
