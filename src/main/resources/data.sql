INSERT INTO TA_MUSICSTYLE (id,nombre,activado) VALUES (1,'Rock',true);
INSERT INTO TA_MUSICSTYLE (id,nombre,activado) VALUES (2,'Pop',true);
INSERT INTO TA_MUSICSTYLE (id,nombre,activado) VALUES (3,'Clásica',true);
INSERT INTO TA_MUSICSTYLE (id,nombre,activado) VALUES (4,'Salsa',true);
INSERT INTO TA_MUSICSTYLE (id,nombre,activado) VALUES (5,'Ambiental',false);
INSERT INTO TA_MUSICSTYLE (id,nombre,activado) VALUES (6,'Electronica',true);

INSERT INTO TA_SURVEYMUSICFAV (fecha_creacion, email, id_musicstyle) VALUES (CURRENT_TIMESTAMP,'random@gmail.com',5);
INSERT INTO TA_SURVEYMUSICFAV (fecha_creacion, email, id_musicstyle) VALUES (CURRENT_TIMESTAMP,'random@gmail.com',1);
INSERT INTO TA_SURVEYMUSICFAV (fecha_creacion, email, id_musicstyle) VALUES (CURRENT_TIMESTAMP,'random@gmail.com',2);
INSERT INTO TA_SURVEYMUSICFAV (fecha_creacion, email, id_musicstyle) VALUES (CURRENT_TIMESTAMP,'random@gmail.com',3);
INSERT INTO TA_SURVEYMUSICFAV (fecha_creacion, email, id_musicstyle) VALUES (CURRENT_TIMESTAMP,'random@gmail.com',1);
INSERT INTO TA_SURVEYMUSICFAV (fecha_creacion, email, id_musicstyle) VALUES (CURRENT_TIMESTAMP,'random@gmail.com',1);
INSERT INTO TA_SURVEYMUSICFAV (fecha_creacion, email, id_musicstyle) VALUES (CURRENT_TIMESTAMP,'random@gmail.com',4);
INSERT INTO TA_SURVEYMUSICFAV (fecha_creacion, email, id_musicstyle) VALUES (CURRENT_TIMESTAMP,'random@gmail.com',4);
INSERT INTO TA_SURVEYMUSICFAV (fecha_creacion, email, id_musicstyle) VALUES (CURRENT_TIMESTAMP,'random@gmail.com',6);
INSERT INTO TA_SURVEYMUSICFAV (fecha_creacion, email, id_musicstyle) VALUES (CURRENT_TIMESTAMP,'random@gmail.com',6);


SELECT B.nombre AS musica, COUNT(*) AS cantidad
	FROM TA_SURVEYMUSICFAV A 
	JOIN TA_MUSICSTYLE B ON (A.ID_MUSICSTYLE = B.ID)
	GROUP BY B.nombre;