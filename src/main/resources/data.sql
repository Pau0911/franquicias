INSERT INTO franquicias (id, nombre)
VALUES ('4c475aa8-2e10-4975-ab93-6fb640784a89', 'Franquicia 1');
INSERT INTO franquicias (id, nombre)
VALUES ('ad9a247c-f5cc-467e-b92e-0a558b050deb', 'Franquicia 2');
INSERT INTO franquicias (id, nombre)
VALUES ('782c6530-7a24-4f77-9981-e45b1b26ed6b', 'Franquicia 3');

INSERT INTO sucursales (id, id_franquicia, nombre)
VALUES ('35911bcc-449f-4952-849c-6321f48eda10', '4c475aa8-2e10-4975-ab93-6fb640784a89', 'Sucursal 1 F1');
INSERT INTO sucursales (id, id_franquicia, nombre)
VALUES ('3e4e9212-bf4f-406b-8b9f-e5cd0e9dc871', '4c475aa8-2e10-4975-ab93-6fb640784a89', 'Sucursal 2 F1');
INSERT INTO sucursales (id, id_franquicia, nombre)
VALUES ('5a02ab88-2c0c-4b09-bd04-4ce62e6beed9', 'ad9a247c-f5cc-467e-b92e-0a558b050deb', 'Sucursal 1 F2');

INSERT INTO productos (id, id_sucursal, nombre, stock)
VALUES ('1e61fbb8-2241-489f-b3d6-5999ba27eaab', '35911bcc-449f-4952-849c-6321f48eda10', 'Producto 1 S1', 10);
INSERT INTO productos (id, id_sucursal, nombre, stock)
VALUES ('7c2f0ef2-9297-4517-9b84-26ecd8ca7604', '35911bcc-449f-4952-849c-6321f48eda10', 'Producto 2 S1', 23);
INSERT INTO productos (id, id_sucursal, nombre, stock)
VALUES ('6dc2b5e8-d30e-4259-adc0-a42945cb399e', '3e4e9212-bf4f-406b-8b9f-e5cd0e9dc871', 'Producto 1 S2', 34);
INSERT INTO productos (id, id_sucursal, nombre, stock)
VALUES ('6dc2b5e8-d30e-4259-adc0-a42945cb4865', '3e4e9212-bf4f-406b-8b9f-e5cd0e9dc871', 'Producto 2 S2', 19);
