CREATE SCHEMA IF NOT EXISTS `Tienda`  DEFAULT CHARACTER SET utf8mb4   COLLATE utf8mb4_0900_ai_ci ;
USE `Tienda` ;


-- --------------------------------------------------------------------------------------------------------
-- ------------------------------------------TABLA_ROLES---------------------------------------------------
-- --------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tienda`.`roles`(
	`ID_ROL` INT NOT NULL AUTO_INCREMENT,
	`NOMBRE` VARCHAR(45) NOT NULL,
    
	PRIMARY KEY (`ID_ROL`)
)
ENGINE=InnoDB   AUTO_INCREMENT=4   DEFAULT CHARACTER SET=utf8mb4   COLLATE=utf8mb4_0900_ai_ci;

-- INSERTAMOS DATOS A LA TABLA DE ROLES
INSERT INTO `roles` (`ID_ROL`,`NOMBRE`) 
	VALUES (1,'ROLE_ADMINISTRADOR');
    
INSERT INTO `roles` (`ID_ROL`,`NOMBRE`) 
	VALUES (2,'ROLE_CLIENTE');


-- --------------------------------------------------------------------------------------------------------
-- ------------------------------------------TABLA_DIRECCIONES---------------------------------------------
-- --------------------------------------------------------------------------------------------------------
CREATE TABLE DIRECCIONES(
	ID_DIRECCION INT AUTO_INCREMENT NOT NULL,
    CODIGO_POSTAL DEC(5) NOT NULL,
    LOCALIDAD VARCHAR(100) NOT NULL,
    CALLE VARCHAR(100) NOT NULL,
    NUMERO INT NOT NULL,
    PISO VARCHAR(5) NULL,
    LETRA CHAR NULL,
    
    PRIMARY KEY(ID_DIRECCION)
);


-- --------------------------------------------------------------------------------------------------------
-- ------------------------------------------TABLA_TARJETAS_BANCARIAS--------------------------------------
-- --------------------------------------------------------------------------------------------------------
CREATE TABLE TARJETAS_BANCARIAS(
	ID_TARJETA INT AUTO_INCREMENT NOT NULL,
    NUMERO_TARJETA DEC(16) NOT NULL,
    NOMBRE_TITULAR VARCHAR(50) NOT NULL,
    FECHA_CADUCIDAD DATE NOT NULL,
    CVV DEC(3) NOT NULL,
    
    PRIMARY KEY(ID_TARJETA)
);

-- --------------------------------------------------------------------------------------------------------
-- ------------------------------------------TABLA_PRODUCTOS-----------------------------------------------
-- --------------------------------------------------------------------------------------------------------
CREATE TABLE PRODUCTOS (
	ID_PRODUCTO INT AUTO_INCREMENT NOT NULL,
	NOMBRE VARCHAR(50) UNIQUE NOT NULL,
	DESCRIPCION VARCHAR(100) NOT NULL,
	PRECIO DEC(5,2) NOT NULL,
	STOCK INT NOT NULL,

	PRIMARY KEY(ID_PRODUCTO)
);

-- INSERTAMOS DATOS A LA TABLA DE PRODUCTOS
INSERT INTO PRODUCTOS
	VALUES(1, "Cama perro", "Cama suave y grande", 9.95, 10);
    
INSERT INTO PRODUCTOS
	VALUES(2, "Cama gato", "Cama suave y pequeña", 14.95, 30);
    
INSERT INTO PRODUCTOS
	VALUES(3, "Hueso perro", "Hueso de vaca", 4.95, 100);
    
INSERT INTO PRODUCTOS
	VALUES(4, "Cuerda perro", "Fibra", 7.95, 28);
    
INSERT INTO PRODUCTOS
	VALUES(5, "Correa perro", "10 metros", 12.95, 54);


-- --------------------------------------------------------------------------------------------------------
-- ------------------------------------------TABLA_USUARIOS------------------------------------------------
-- --------------------------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tienda`.`usuarios`(
	`ID_USUARIO` int NOT NULL AUTO_INCREMENT,
	`USERNAME` VARCHAR(45) UNIQUE NOT NULL,
	`EMAIL` VARCHAR(45) UNIQUE NOT NULL,
	`PASSWORD` VARCHAR(100) NOT NULL,
	`NOMBRE` VARCHAR(30) NULL DEFAULT NULL,
	`apellidos` VARCHAR(30) NULL DEFAULT NULL,
	`ENABLED` INT NOT NULL DEFAULT '1',
	`FECHA_NACIMIENTO` DATE NULL DEFAULT NULL,
    
	PRIMARY KEY (`ID_USUARIO`)
)
ENGINE=InnoDB   DEFAULT CHARACTER SET=utf8mb4   COLLATE=utf8mb4_0900_ai_ci;

-- INSERTAMOS DATOS A LA TABLA USUARIOS ROLE ADMIN --> contraseña 12345
INSERT INTO `usuarios` (`EMAIL`,`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`ENABLED`,`FECHA_NACIMIENTO`) 
	VALUES ('adrian@gmail.com','adrian','$2a$10$pqMraQkIyQHtNj4c9RH8Qui/fxABpK8BW4r39mnUcFT7J6UtuZVzW','Adrian','Alvarez',1,'1991-01-01');
    
INSERT INTO `usuarios` (`EMAIL`,`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`ENABLED`,`FECHA_NACIMIENTO`) 
	VALUES ('diego@gmail.com','diego','$2a$10$pqMraQkIyQHtNj4c9RH8Qui/fxABpK8BW4r39mnUcFT7J6UtuZVzW','Diego','Perez',1,'1994-01-01');
    
-- INSERTAMOS DATOS A LA TABLA USUARIOS ROLE CLIENTE --> contraseña 12345
INSERT INTO `usuarios` (`EMAIL`,`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`ENABLED`,`FECHA_NACIMIENTO`) 
	VALUES ('adrian_@gmail.com','adri','$2a$10$pqMraQkIyQHtNj4c9RH8Qui/fxABpK8BW4r39mnUcFT7J6UtuZVzW','Adri','Alvarez',1,'1991-01-01');
    
INSERT INTO `usuarios` (`EMAIL`,`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`ENABLED`,`FECHA_NACIMIENTO`) 
	VALUES ('diego_@gmail.com','die','$2a$10$pqMraQkIyQHtNj4c9RH8Qui/fxABpK8BW4r39mnUcFT7J6UtuZVzW','Die','Perez',1,'1994-01-01');


-- --------------------------------------------------------------------------------------------------------
-- ------------------------------------------TABLA_COMPRAS-------------------------------------------------
-- --------------------------------------------------------------------------------------------------------
CREATE TABLE COMPRAS (
	ID_COMPRA INT AUTO_INCREMENT NOT NULL,
	FECHA_DE_REALIZACION TIMESTAMP DEFAULT NOW(),
    ESTADO VARCHAR(50) NOT NULL,

	PRIMARY KEY(ID_COMPRA),
    
	ID_USUARIO INT NOT NULL,
	ID_TARJETA INT,
	ID_DIRECCION INT,
	FOREIGN KEY(ID_USUARIO) REFERENCES USUARIOS (ID_USUARIO),
	FOREIGN KEY(ID_TARJETA) REFERENCES TARJETAS_BANCARIAS (ID_TARJETA),
	FOREIGN KEY(ID_DIRECCION) REFERENCES DIRECCIONES (ID_DIRECCION)
);

-- --------------------------------------------------------------------------------------------------------
-- ----------------------------------------TABLA_LINEA_DE_COMPRAS------------------------------------------
-- --------------------------------------------------------------------------------------------------------
CREATE TABLE LINEAS_DE_COMPRA (
	ID_LINEAS_DE_COMPRA INT AUTO_INCREMENT NOT NULL,
	CANTIDAD INT NOT NULL,
	PRECIO_UNITARIO DEC(5,2),

	PRIMARY KEY(ID_LINEAS_DE_COMPRA),
    ID_COMPRA INT NOT NULL,
	ID_PRODUCTO INT NOT NULL,
	FOREIGN KEY(ID_COMPRA) REFERENCES COMPRAS (ID_COMPRA),
	FOREIGN KEY(ID_PRODUCTO) REFERENCES PRODUCTOS (ID_PRODUCTO)
);
    
    
-- --------------------------------------------------------------------------------------------------------
-- ----------------------------------------TABLAS_RENACIDAS------------------------------------------------
-- --------------------------------------------------------------------------------------------------------
CREATE TABLE USUARIO_DIRECCION(
	ID_DIRECCION INT NOT NULL,
    ID_USUARIO INT NOT NULL,
    
    PRIMARY KEY(ID_DIRECCION, ID_USUARIO),
	FOREIGN KEY(ID_DIRECCION) REFERENCES DIRECCIONES (ID_DIRECCION),
	FOREIGN KEY(ID_USUARIO) REFERENCES USUARIOS (ID_USUARIO)
);

CREATE TABLE USUARIO_TARJETA(
	ID_TARJETA INT NOT NULL,
    ID_USUARIO INT NOT NULL,
    
    PRIMARY KEY(ID_TARJETA, ID_USUARIO),
	FOREIGN KEY(ID_TARJETA) REFERENCES TARJETAS_BANCARIAS (ID_TARJETA),
	FOREIGN KEY(ID_USUARIO) REFERENCES USUARIOS (ID_USUARIO)
);

CREATE TABLE `roles_usuarios` (
	`ID_USUARIO` INT NOT NULL,
	`ID_ROL` INT NOT NULL,
    
	PRIMARY KEY (`ID_USUARIO`,`ID_ROL`),
	KEY `ID_ROL` (`ID_ROL`),
	CONSTRAINT `roles_usuarios_ibfk_1` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuarios` (`ID_USUARIO`),
	CONSTRAINT `roles_usuarios_ibfk_2` FOREIGN KEY (`ID_ROL`) REFERENCES `roles` (`ID_ROL`)
) 
ENGINE=InnoDB   DEFAULT CHARSET=utf8mb4   COLLATE=utf8mb4_0900_ai_ci;

-- INSERTAMOS DATOS A LOS ROLES_USUARIOS
INSERT INTO `roles_usuarios` (`ID_USUARIO`,`ID_ROL`) 
	VALUES (1,1);
    
INSERT INTO `roles_usuarios` (`ID_USUARIO`,`ID_ROL`) 
	VALUES (2,1);
    
INSERT INTO `roles_usuarios` (`ID_USUARIO`,`ID_ROL`) 
	VALUES (3,2);
    
INSERT INTO `roles_usuarios` (`ID_USUARIO`,`ID_ROL`) 
	VALUES (4,2);
