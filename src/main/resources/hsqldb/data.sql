-- Copyright 2016-2018 Diffblue Limited. All rights reserved.
-- Sample data for testing / demo purposes

-- Categories
INSERT INTO categories(name) VALUES ('Food');
INSERT INTO categories(name) VALUES ('Treats');
INSERT INTO categories(name) VALUES ('Toys');
INSERT INTO categories(name) VALUES ('Clothes');

-- Collections
INSERT INTO collections(name) VALUES ('Deer');
INSERT INTO collections(name) VALUES ('Gluten Free');
INSERT INTO collections(name) VALUES ('Pup Friendly');
INSERT INTO collections(name) VALUES ('100% Beef');
INSERT INTO collections(name) VALUES ('Salmon');
INSERT INTO collections(name) VALUES ('Chicken');
INSERT INTO collections(name) VALUES ('Chew Safe');
INSERT INTO collections(name) VALUES ('Outside Friendly');
INSERT INTO collections(name) VALUES ('Dog Safe');

-- -- Products
-- INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD086',(SELECT id from categories where name='Food'),(SELECT id from collections where name='Deer Food'),'Dog Food', '17.5','100% Fresh Dog Food Made to Order','dogfood.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD056',(SELECT id from categories where name='Food'),(SELECT id from collections where name='Gluten Free'),'Dog Food', '17.5','100% Fresh Dog Food Made to Order','dogfood.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD087',(SELECT id from categories where name='Food'),(SELECT id from collections where name='Pup Friendly'),'Dog Food', '17.5','100% Fresh Dog Food Made to Order','dogfood.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD088',(SELECT id from categories where name='Food'),(SELECT id from collections where name='100% Beef'),'Dog Food', '17.5','100% Fresh Dog Food Made to Order','dogfood.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD033',(SELECT id from categories where name='Food'),(SELECT id from collections where name='Salmon'),'Dog Food', '17.5','100% Fresh Dog Food Made to Order','dogfood.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD024',(SELECT id from categories where name='Food'),(SELECT id from collections where name='Deer'),'Dog Food', '17.5','100% Fresh Dog Food Made to Order','dogfood.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD007',(SELECT id from categories where name='Food'),(SELECT id from collections where name='Chew Safe'),'Dog Food', '17.5','100% Fresh Dog Food Made to Order','dogfood.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD054',(SELECT id from categories where name='Food'),(SELECT id from collections where name='Outside Friendly'),'Dog Food', '17.5','100% Fresh Dog Food Made to Order','dogfood.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD057',(SELECT id from categories where name='Food'),(SELECT id from collections where name='Dog Safe'),'Dog Food', '17.5','100% Fresh Dog Food Made to Order','dogfood.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD051',(SELECT id from categories where name='Treats'),(SELECT id from collections where name='Deer'),'Dog Treats', '5.5','Dog Treats For Every Occasion ','dogtreat.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD077',(SELECT id from categories where name='Treats'),(SELECT id from collections where name='Gluten Free'),'Dog Treats', '5.5','Dog Treats For Every Occasion ','dogtreat.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD034',(SELECT id from categories where name='Treats'),(SELECT id from collections where name='Pup Friendly'),'Dog Treats', '5.5','Dog Treats For Every Occasion ','dogtreat.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD085',(SELECT id from categories where name='Treats'),(SELECT id from collections where name='100% Beef'),'Dog Treats', '5.5','Dog Treats For Every Occasion ','dogtreat.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD099',(SELECT id from categories where name='Treats'),(SELECT id from collections where name='Salmon'),'Dog Treats', '5.5','Dog Treats For Every Occasion ','dogtreat.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD066',(SELECT id from categories where name='Treats'),(SELECT id from collections where name='Deer'),'Dog Treats', '5.5','Dog Treats For Every Occasion ','dogtreat.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD044',(SELECT id from categories where name='Treats'),(SELECT id from collections where name='Chew Safe'),'Dog Treats', '5.5','Dog Treats For Every Occasion ','dogtreat.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD097',(SELECT id from categories where name='Treats'),(SELECT id from collections where name='Outside Friendly'),'Dog Treats', '5.5','Dog Treats For Every Occasion ','dogtreat.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD023',(SELECT id from categories where name='Treats'),(SELECT id from collections where name='Dog Safe'),'Dog Treats', '5.5','Dog Treats For Every Occasion ','dogtreat.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD090',(SELECT id from categories where name='Clothes'),(SELECT id from collections where name='Deer'),'Dog Clothes', '10.5','Dog Clothes to Make Your Dog Look Even Better','dogclothes.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD005',(SELECT id from categories where name='Clothes'),(SELECT id from collections where name='Gluten Free'),'Dog Clothes', '10.5','Dog Clothes to Make Your Dog Look Even Better','dogclothes.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD052',(SELECT id from categories where name='Clothes'),(SELECT id from collections where name='Pup Friendly'),'Dog Clothes', '10.5','Dog Clothes to Make Your Dog Look Even Better','dogclothes.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD078',(SELECT id from categories where name='Clothes'),(SELECT id from collections where name='100% Beef'),'Dog Clothes', '10.5','Dog Clothes to Make Your Dog Look Even Better','dogclothes.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD059',(SELECT id from categories where name='Clothes'),(SELECT id from collections where name='Deer'),'Dog Clothes', '10.5','Dog Clothes to Make Your Dog Look Even Better','dogclothes.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD016',(SELECT id from categories where name='Clothes'),(SELECT id from collections where name='Chew Safe'),'Dog Clothes', '10.5','Dog Clothes to Make Your Dog Look Even Better','dogclothes.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD083',(SELECT id from categories where name='Clothes'),(SELECT id from collections where name='Dog Safe'),'Dog Clothes', '10.5','Dog Clothes to Make Your Dog Look Even Better','dogclothes.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD094',(SELECT id from categories where name='Toys'),(SELECT id from collections where name='Deer'),'Dog Toys', '7.5','Dog Toys To Keep Your Pup Distracted','dogtoys.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD068',(SELECT id from categories where name='Toys'),(SELECT id from collections where name='Gluten Free'),'Dog Toys', '7.5','Dog Toys To Keep Your Pup Distracted','dogtoys.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD012',(SELECT id from categories where name='Toys'),(SELECT id from collections where name='Pup Friendly'),'Dog Toys', '7.5','Dog Toys To Keep Your Pup Distracted','dogtoys.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD070',(SELECT id from categories where name='Toys'),(SELECT id from collections where name='100% Beef'),'Dog Toys', '7.5','Dog Toys To Keep Your Pup Distracted','dogtoys.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD010',(SELECT id from categories where name='Toys'),(SELECT id from collections where name='Salmon'),'Dog Toys', '7.5','Dog Toys To Keep Your Pup Distracted','dogtoys.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD038',(SELECT id from categories where name='Toys'),(SELECT id from collections where name='Salmon'),'Dog Clothes', '10.5','Dog Clothes to Make Your Dog Look Even Better','dogtoys.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD003',(SELECT id from categories where name='Toys'),(SELECT id from collections where name='Deer'),'Dog Toys', '7.5','Dog Toys To Keep Your Pup Distracted','dogtoys.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD028',(SELECT id from categories where name='Toys'),(SELECT id from collections where name='Chew Safe'),'Dog Toys', '7.5','Dog Toys To Keep Your Pup Distracted','dogtoys.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD058',(SELECT id from categories where name='Toys'),(SELECT id from collections where name='Outside Friendly'),'Dog Clothes', '10.5','Dog Clothes to Make Your Dog Look Even Better','dogtoys.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD089',(SELECT id from categories where name='Toys'),(SELECT id from collections where name='Outside Friendly'),'Dog Toys', '7.5','Dog Toys To Keep Your Pup Distracted','dogtoys.jpg');
INSERT INTO products(sku, category_id, collection_id, name, price, description, photo) VALUES ('PROD073',(SELECT id from categories where name='Toys'),(SELECT id from collections where name='Dog Safe'),'Dog Toys', '7.5','Dog Toys To Keep Your Pup Distracted','dogtoys.jpg');
