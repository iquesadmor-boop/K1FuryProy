
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

select *
from k1furydb.liga;