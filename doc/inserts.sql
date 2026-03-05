
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

select *
from k1furydb.usuario;

-- INSERTS DE LIGAS
INSERT INTO k1furydb.liga(peso,fecha_inicio)
VALUES (72, now());
INSERT INTO k1furydb.liga(peso,fecha_inicio)
VALUES (76, now());
INSERT INTO k1furydb.liga(peso,fecha_inicio)
VALUES (80, now());

-- INSERTS DE PELEADOR
INSERT INTO k1furydb.usuario (nombre, apellido, rol, peso)
VALUES ("Alejandro", "Morales", 2, 72),
("Ricardo", "Herrera", 2, 72),
("Fernando", "Ortega", 2, 72),
("Hugo", "Mendoza", 2, 72),
("Mateo", "Salazar", 2, 72),
("Rodrigo", "Esquivel", 2, 72),
("Adrián", "Pardo", 2, 72),
("Gonzalo", "Méndez", 2, 76),
("Samuel", "Vargas", 2, 76),
("Joaquín", "Ibáñez", 2, 76),
("Marcos", "Benítez", 2, 76),
("Emiliano", "Vega", 2, 76),
("Santiago", "Peralta", 2, 76),
("Ismael", "Cabrera", 2, 76),
("Óscar", "Márquez", 2, 80),
("Raúl", "Beltrán", 2, 80),
("Felipe", "Durán", 2, 80),
("Ignacio", "Soto", 2, 80),
("Valentín", "Olmos", 2, 80),
("Rafael", "Gallardo", 2, 80);


select *
from k1furydb.liga;