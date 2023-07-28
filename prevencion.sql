CREATE DATABASE prevencion;
USE prevencion;

-- Tabla "Capacitaciones"
CREATE TABLE capacitacion (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  detalle TEXT
--  fecha date,
--  hora time,
--  lugar varchar(500),
--  duracion float,
--  cantidad int,
--  cliente_id int,
--  foreign key (cliente_id) references cliente(id)
);

-- Tabla "Usuarios"
CREATE TABLE usuario (
 id INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(50) NOT NULL,
 apellido VARCHAR(50) NOT NULL,
 correo varchar(100) not null,
 rut varchar(11) not null unique,
 tipo enum("CLIENTE", "ADMINISTRATIVO", "PROFESIONAL")
-- username varchar(100) not null,
-- password varchar(500) not null
);

CREATE TABLE administrativo (
  id int primary key AUTO_INCREMENT,
--  run varchar(11) not null,
--  nombre VARCHAR(50) not null,
--  apellido varchar(50) not null,
--  correo varchar(100) not null,
  area varchar(100),
  usuario_id int not null,
  FOREIGN key (usuario_id) REFERENCES usuario(id)
);

create table cliente (
  id int primary key AUTO_INCREMENT,
--  rut varchar(11) not null,
--  nombre VARCHAR(50) not null,
--  apellido varchar(50) not null,
--  correo varchar(100) not null,
  telefono varchar(20) not null,
--  afp varchar(50),
--  sistema_salud enum('isapre', 'fonasa'),
  direccion varchar(100),
--  comuna varchar(50),
  edad smallint,
  usuario_id int not null,
  capaci_id int,
  FOREIGN key (usuario_id) REFERENCES usuario(id),
  foreign key (capaci_id) references capacitacion(id)
);

create table profesional (
  id int primary key AUTO_INCREMENT,
--  run varchar(11) not null,
--  nombre VARCHAR(50) not null,
--  apellido varchar(50) not null,
--  correo varchar(100) not null,
  telefono varchar(20) not null,
  cargo varchar(50),
  usuario_id int not null,
  FOREIGN key (usuario_id) REFERENCES usuario(id)
);

-- Tabla "Visitas"
CREATE TABLE visita (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  fecha DATE,
  hora time,
  lugar varchar(500),
  realizado boolean,
  detalle TEXT,
  profes_id INT,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id),
  FOREIGN KEY (profes_id) REFERENCES profesional(id)
);

-- Tabla "Pagos"
CREATE TABLE pago (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  monto DECIMAL(10,2),
  fecha DATE,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Tabla "Chequeos"
CREATE TABLE chequeo (
  id INT PRIMARY KEY AUTO_INCREMENT,
  visita_id INT,
  detalle TEXT,
  estado ENUM("PENDIENTE", "COMPLETADO"),
  FOREIGN KEY (visita_id) REFERENCES visita(id)
);
/*
-- Tabla "Asesorias"
CREATE TABLE asesoria (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  detalle TEXT,
  profesional_id INT,
  cliente_id int,
  FOREIGN KEY (profesional_id) REFERENCES profesional(id),
  foreign key (cliente_id) references cliente(id)
);

-- Tabla "Accidentes"
CREATE TABLE accidente (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  fecha_accidente DATE,
  detalle TEXT,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Tabla "Asistentes"
CREATE TABLE asistente (
  capacitacion_id INT,
  usuario_id INT,
  FOREIGN KEY (capacitacion_id) REFERENCES capacitacion(id),
  FOREIGN KEY (usuario_id) REFERENCES usuario(id),
  PRIMARY KEY (capacitacion_id, usuario_id)
);
*/