
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
INSERT INTO k1furydb.usuario (dni, nombre, apellido, rol, peso, liga, victorias)
VALUES
("12345678A", "Alejandro", "Morales", 2, 72, 1, 10),
("23456789B", "Ricardo", "Herrera", 2, 72, 1, 8),
("34567890C", "Fernando", "Ortega", 2, 72, 1, 7),
("45678901D", "Hugo", "Mendoza", 2, 72, 1, 5),
("56789012E", "Mateo", "Salazar", 2, 72, 1, 3),
("67890123F", "Rodrigo", "Esquivel", 2, 72, 1, 2),
("78901234G", "Adrián", "Pardo", 2, 72, 1, 0),
("89012345H", "Gonzalo", "Méndez", 2, 76, 2, 12),
("90123456I", "Samuel", "Vargas", 2, 76, 2, 11),
("01234567J", "Joaquín", "Ibáñez", 2, 76, 2, 9),
("11234567K", "Marcos", "Benítez", 2, 76, 2, 6),
("22234567L", "Emiliano", "Vega", 2, 76, 2, 4),
("33234567M", "Santiago", "Peralta", 2, 76, 2, 3),
("44234567N", "Ismael", "Cabrera", 2, 76, 2, 1),
("55234567O", "Óscar", "Márquez", 2, 80, 3, 14),
("66234567P", "Raúl", "Beltrán", 2, 80, 3, 10),
("77234567Q", "Felipe", "Durán", 2, 80, 3, 9),
("88234567R", "Ignacio", "Soto", 2, 80, 3, 7),
("99234567S", "Valentín", "Olmos", 2, 80, 3, 5),
("00234567T", "Rafael", "Gallardo", 2, 80, 3, 2);




select *
from k1furydb.liga;



INSERT INTO k1furydb.registros (liga, arbitro, peleador1, peleador2, ganador)
VALUES (1, 2, 7, 8, 7),
(2, 10, 11, 12, 12),
(2, 10, 13, 14, 13);