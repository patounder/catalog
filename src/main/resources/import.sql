INSERT INTO product (sku, name, brand, size, price) VALUES ('FAL-8406270', '500 Zapatilla Urbana Mujer', 'NEW BALANCE', '37', 42990.00);
INSERT INTO product (sku, name, brand, size, price) VALUES ('FAL-881952283', 'Bicicleta Baltoro Aro 29', 'JEEP', 'ST', 399990.00);
INSERT INTO product (sku, name, brand, size, price) VALUES ('FAL-8818985', 'Camisa manga corta hombre', 'BASEMENT', 'M', 24990.00);

INSERT INTO product_image (is_principal, url, product_sku) VALUES (true, 'https://url1', 'FAL-8406270');
INSERT INTO product_image (is_principal, url, product_sku) VALUES (false, 'https://url4', 'FAL-8406270');
INSERT INTO product_image (is_principal, url, product_sku) VALUES (true, 'https://url1', 'FAL-881952283');
INSERT INTO product_image (is_principal, url, product_sku) VALUES (true, 'https://url1', 'FAL-8818985');
