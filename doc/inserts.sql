
-- INSERTS DEL ROL CON LOS TIPOS DE ROLES QUE HAY

INSERT INTO k1furydb.rol (nombre)
VALUES ("Usuario");
INSERT INTO k1furydb.rol (nombre)
VALUES ("Peleador");
INSERT INTO k1furydb.rol (nombre)
VALUES ("Arbitro");
INSERT INTO k1furydb.rol (nombre)
VALUES ("Administrador");


select *
from k1furydb.rol;


-- INSERTS DE USUARIO CON LOS ADMINISTRADORES
INSERT INTO k1furydb.usuario (nombre,contraseña,rol)
VALUES ("admin", "admin",4);
INSERT INTO k1furydb.usuario (nombre,contraseña,rol)
VALUES ("admin1", "admin1",4);
INSERT INTO k1furydb.usuario (nombre,contraseña,rol)
VALUES ("admin2", "admin2",4);
INSERT INTO k1furydb.usuario (nombre,contraseña,rol)
VALUES ("javier", "fabo",3);
select *
from k1furydb.usuario;

-- INSERTS DE LIGAS
INSERT INTO k1furydb.liga(nombre,peso,fecha_inicio)
VALUES ("Liga72Kg",72, now());
INSERT INTO k1furydb.liga(nombre,peso,fecha_inicio)
VALUES ("Liga76Kg",76, now());
INSERT INTO k1furydb.liga(nombre,peso,fecha_inicio)
VALUES ("Liga80Kg",80, now());

-- INSERTS DE PELEADOR
INSERT INTO k1furydb.usuario (nombre, apellido, rol, peso, liga)
VALUES ("Alejandro", "Morales", 2, 72,1),
("Ricardo", "Herrera", 2, 72,1),
("Fernando", "Ortega", 2, 72,1),
("Hugo", "Mendoza", 2, 72,1),
("Mateo", "Salazar", 2, 72,1),
("Rodrigo", "Esquivel", 2, 72,1),
("Adrián", "Pardo", 2, 72,1),
("Gonzalo", "Méndez", 2, 76,2),
("Samuel", "Vargas", 2, 76,2),
("Joaquín", "Ibáñez", 2, 76,2),
("Marcos", "Benítez", 2, 76,2),
("Emiliano", "Vega", 2, 76,2),
("Santiago", "Peralta", 2, 76,2),
("Ismael", "Cabrera", 2, 76,2),
("Óscar", "Márquez", 2, 80,3),
("Raúl", "Beltrán", 2, 80,3),
("Felipe", "Durán", 2, 80,3),
("Ignacio", "Soto", 2, 80,3),
("Valentín", "Olmos", 2, 80,3),
("Rafael", "Gallardo", 2, 80,3);


select *
from k1furydb.liga;



INSERT INTO k1furydb.registros (liga, arbitro, peleador1, peleador2, ganador)
VALUES (1, 2, 7, 8, 7),
(2, 10, 11, 12, 12),
(2, 10, 13, 14, 13);