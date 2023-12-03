create database Clientes_Proyectos_Empleados;
use Clientes_Proyectos_Empleados;

create table clientes
( cif varchar(10) not null primary key,
nombre varchar(20) not null,
apellidos varchar(45) not null,
domicilio varchar(100),
facturacion_anual dec (15,2),
numero_empleados int
);
INSERT INTO `Clientes_Proyectos_Empleados`.`clientes` (`cif`, `nombre`, `apellidos`, `domicilio`, `facturacion_anual`, `numero_empleados`) 
	VALUES ('A22222222', 'Carlos', 'March', 'Madrid', '12000000', '1500');
INSERT INTO `Clientes_Proyectos_Empleados`.`clientes` (`cif`, `nombre`, `apellidos`, `domicilio`, `facturacion_anual`, `numero_empleados`) 
	VALUES ('B33333333', 'Sara', 'Varas', 'Sevilla', '1500000', '345');

create table productos
( id_producto int auto_increment primary key,
descripcion_larga varchar(100) not null,
descripcion_breve varchar(30),
precio_unitario dec(9,2),
stock int
);

INSERT INTO `Clientes_Proyectos_Empleados`.`productos` (`id_producto`, `descripcion_larga`, `descripcion_breve`, `precio_unitario`, `stock`) 
	VALUES ('1', 'Camisa blanca Mujer talla XS verde', 'Camisa verde Mujer', '34', '50');
INSERT INTO `Clientes_Proyectos_Empleados`.`productos` (`id_producto`, `descripcion_larga`, `descripcion_breve`, `precio_unitario`, `stock`) 
	VALUES ('2', 'Camisa blanca Mujer talla XS ', 'Camisa blanca Mu XS', '45', '50');
create table departamentos
(id_depar int primary key,
nombre varchar(45) not null,
direccion varchar(100),
jefe_depar int
);
insert into departamentos 
values(10,'Gestion Personas','Madrid',NULL),
(20,'Software','Madrid',NULL),
(30,'Hardware','Madrid',NULL),
(40,'Financiero','Sevilla',NULL);
create table perfiles
( id_perfil int not null auto_increment primary key,
nombre varchar(20)
);
insert into perfiles
(nombre)
	values('Control de Gestion'),('Jefe de Proyecto'), ('Operativo'),('Recusos Humanos');
    
create table empleados 
( id_empl int not null auto_increment primary key,
nombre varchar(20) not null,
apellidos varchar(45) not null,
correo varchar(100) not null unique,
password varchar(50) not null,
salario dec (9,2),
fecha_ingreso date,
fecha_nacimiento date,
id_perfil int not null,
id_depar int not null,
foreign key(id_depar) references departamentos(id_depar),
foreign key(id_perfil) references perfiles (id_perfil)
);
INSERT INTO `Clientes_Proyectos_Empleados`.`empleados`VALUES ('100', 'esteban', 'Diaz', 'ediaz@tt.com', 'esteban','90000', '1990-01-12', '1977-02-12', '4', '10');
INSERT INTO `Clientes_Proyectos_Empleados`.`empleados` VALUES ('101', 'Sara', 'Hernandez', 'shernandez@tt.com','sara', '45000', '2005-07-07', '1987-05-15', '4', '10');
INSERT INTO `Clientes_Proyectos_Empleados`.`empleados` VALUES ('114', 'Rafael', 'Raphaelly', 'rraphaelly@tt.com','rafael', '78000', '2005-09-07', '1977-02-18', '2', '20');
INSERT INTO `Clientes_Proyectos_Empleados`.`empleados`  VALUES ('115', 'Carlos', 'Koo', 'ckoo@tt.com','carlos', '33000', '2015-09-07', '1983-02-04', '3', '20');
INSERT INTO `Clientes_Proyectos_Empleados`.`empleados`  VALUES ('116', 'Carmen', 'Baida', 'cbaida@tt.com','carmen', '32000', '2015-09-08', '1983-12-04', '3', '20');
INSERT INTO `Clientes_Proyectos_Empleados`.`empleados`  VALUES ('117', 'Alejandro', 'Himuro', 'ahimuro@tt.com','alejandro', '25000', '2015-09-09', '1984-12-04', '3', '20');
INSERT INTO `Clientes_Proyectos_Empleados`.`empleados` VALUES ('118', 'Eva', 'Colmenares', 'ecolmenares@tt.com','eva', '25000', '2015-09-09', '1984-12-04', '3', '20');
INSERT INTO `Clientes_Proyectos_Empleados`.`empleados` VALUES ('119', 'Eva', 'Tobias', 'etobias@tt.com','eva', '25000', '2015-09-09', '1984-12-04', '3', '20');
INSERT INTO `Clientes_Proyectos_Empleados`.`empleados`  VALUES ('120', 'Raquel', 'Oliva', 'roliva@tt.com','raquel', '38000', '2015-09-09', '1982-04-21', '1', '40');

alter table departamentos add foreign key(jefe_depar) references empleados(id_empl);
update departamentos set jefe_depar = 100 where id_depar=10;
update departamentos set jefe_depar = 114 where id_depar=20;
update departamentos set jefe_depar = 120 where id_depar=40;


-- drop table proyectos;
create table proyectos
( id_proyecto varchar(10) not null primary key,
descripcion varchar(45) not null,
fecha_inicio date,
fecha_fin_previsto date,
fecha_fin_real date,
venta_previsto dec(11,2),
costes_previsto dec(11,2),
coste_real dec (11,2),
estado varchar(15),
jefe_proyecto int,
cif varchar(10) not null,
foreign key(cif) references clientes(cif)
);

INSERT INTO `Clientes_Proyectos_Empleados`.`proyectos` (`id_proyecto`, `descripcion`, `fecha_inicio`, `fecha_fin_previsto`, `fecha_fin_real`, `venta_previsto`, `costes_previsto`, `coste_real`, `estado`, `jefe_proyecto`, `cif`) VALUES ('FOR2020001', 'Formacion de habilidades directivas', '2020-01-15', '2020-07-31', '2020-07-31', '50000', '30000', '315000', 'TERMINADO', '114', 'A22222222');
INSERT INTO `Clientes_Proyectos_Empleados`.`proyectos` (`id_proyecto`, `descripcion`, `fecha_inicio`, `fecha_fin_previsto`, `fecha_fin_real`, `venta_previsto`, `costes_previsto`, `coste_real`, `estado`, `jefe_proyecto`, `cif`) VALUES ('FOR2021001', 'Formacion de jefes de proyecto', '2021-09-15', '2021-12-31', null, '50000', '30000', null, 'ACTIVO', '114', 'A22222222');
INSERT INTO `Clientes_Proyectos_Empleados`.`proyectos` (`id_proyecto`, `descripcion`, `fecha_inicio`, `fecha_fin_previsto`, `fecha_fin_real`, `venta_previsto`, `costes_previsto`, `coste_real`, `estado`, `jefe_proyecto`, `cif`) VALUES ('FOR2021002', 'Formacion de jefes de proyecto', '2021-09-15', '2021-12-31', null, '50000', '30000', null, 'ACTIVO', '114', 'A22222222');

create table proyecto_con_empleados
( numero_orden int auto_increment primary key,
id_proyecto varchar(10) not null,
id_empl int not null,
horas_asignadas int not null,
fecha_incorporacion date,
foreign key(id_proyecto) references proyectos(id_proyecto),
foreign key(id_empl) references empleados(id_empl)
);
INSERT INTO `Clientes_Proyectos_Empleados`.`proyecto_con_empleados` (`numero_orden`, `id_proyecto`, `id_empl`, `horas_asignadas`, `fecha_incorporacion`) VALUES ('1', 'FOR2020001', '115', '45', '2020-01-16');
INSERT INTO `Clientes_Proyectos_Empleados`.`proyecto_con_empleados` (`numero_orden`, `id_proyecto`, `id_empl`, `horas_asignadas`, `fecha_incorporacion`) VALUES ('2', 'FOR2020001', '116', '30', '2020-01-17');
INSERT INTO `Clientes_Proyectos_Empleados`.`proyecto_con_empleados` (`numero_orden`, `id_proyecto`, `id_empl`, `horas_asignadas`, `fecha_incorporacion`) VALUES ('3', 'FOR2021001', '117', '54', '2021-10-11');
INSERT INTO `Clientes_Proyectos_Empleados`.`proyecto_con_empleados` (`numero_orden`, `id_proyecto`, `id_empl`, `horas_asignadas`, `fecha_incorporacion`) VALUES ('4', 'FOR2021001', '118', '100', '2021-10-14');

create table proyecto_con_productos
( numero_orden int auto_increment primary key,
id_proyecto varchar(10) not null,
id_producto int not null,
cantidad int not null,
precio_asignado dec(9,2) not null,
foreign key(id_proyecto) references proyectos(id_proyecto),
foreign key(id_producto) references productos(id_producto)
);

INSERT INTO `Clientes_Proyectos_Empleados`.`proyecto_con_productos` (`numero_orden`, `id_proyecto`, `id_producto`, `cantidad`, `precio_asignado`) VALUES ('1', 'FOR2020001', '1', '4', '34');
INSERT INTO `Clientes_Proyectos_Empleados`.`proyecto_con_productos` (`numero_orden`, `id_proyecto`, `id_producto`, `cantidad`, `precio_asignado`) VALUES ('2', 'FOR2020001', '2', '256', '30');
INSERT INTO `Clientes_Proyectos_Empleados`.`proyecto_con_productos` (`numero_orden`, `id_proyecto`, `id_producto`, `cantidad`, `precio_asignado`) VALUES ('3', 'FOR2021001', '1', '500', '30');

alter table proyectos add foreign key(jefe_proyecto)  references empleados(id_empl);


create table facturas
( id_factura varchar(15) not null primary key,
descripcion varchar(45) not null,
id_proyecto varchar(10) not null,
foreign key(id_proyecto) references proyectos(id_proyecto)
);

INSERT INTO `Clientes_Proyectos_Empleados`.`facturas` (`id_factura`, `descripcion`, `id_proyecto`) VALUES ('F2020001', 'Formacion a cliente 1', 'FOR2020001');

 -- drop user 'uproyectos_2022;
create user 'uproyectos' identified by 'uproyectos';
grant all privileges on Clientes_Proyectos_Empleados.* to  'uproyectos';
 