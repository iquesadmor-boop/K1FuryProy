CREATE TABLE IF NOT EXISTS k1furydb.rol (
	id int AUTO_INCREMENT,
    nombre varchar(30) DEFAULT NULL,

    primary key(id)
);

CREATE TABLE IF NOT EXISTS k1furydb.usuario (
	id int AUTO_INCREMENT,
    nombre varchar(30) DEFAULT NULL,
    apellido varchar(30) DEFAULT NULL,
    contraseña varchar(30) DEFAULT NULL,
    rol int,
    peso int,

    primary key(id),
    foreign key (rol) references k1furydb.rol (id)
    on delete cascade
    on update no action
);


CREATE TABLE IF NOT EXISTS k1furydb.liga (
	id int AUTO_INCREMENT,
    peso varchar(30) DEFAULT NULL,
    fecha_inicio date default null,
    fecha_fin date default null,
    campeon int default null,
    activa boolean default true,

    primary key(id),
    foreign key (campeon) references k1furydb.usuario (id)
);

CREATE TABLE IF NOT EXISTS k1furydb.registros (
	id int AUTO_INCREMENT,
    peso int not null,
    arbitro int not null,
    peleador1  int not null,
    peleador2  int not null,
    ganador int not null,

    primary key (id),
    foreign key (peleador1) references k1furydb.usuario (id),
    foreign key (peleador2) references k1furydb.usuario (id),
    foreign key (ganador) references k1furydb.usuario (id),
    foreign key (arbitro) references k1furydb.usuario (id)
);