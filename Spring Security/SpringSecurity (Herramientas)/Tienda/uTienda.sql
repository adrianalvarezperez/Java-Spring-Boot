CREATE DATABASE Tienda;	-- CREAMOS LA BASE DE DATOS
USE Tienda;				-- USAMOS ESTA BASE DE DATOS


-- --------------------------------------------------------------------------------------------------------
-- ----------------------------------------------ROLES-----------------------------------------------------
-- --------------------------------------------------------------------------------------------------------

CREATE TABLE ROLES(
	ID_ROL INT NOT NULL,
	NOMBRE VARCHAR(50) NOT NULL,	-- CLIENTE O ADMIN

	PRIMARY KEY(ID_ROL)
);

INSERT INTO ROLES
	VALUES(1, "CLIENTE");
    
INSERT INTO ROLES
	VALUES(2, "ADMIN");


-- --------------------------------------------------------------------------------------------------------
-- ------------------------------------------------USUARIOS------------------------------------------------
-- --------------------------------------------------------------------------------------------------------

-- CREACION DE LA TABLA USUARIOS
CREATE TABLE USUARIOS(
	ID_USUARIO INT AUTO_INCREMENT NOT NULL,
	NOMBRE VARCHAR(50) NOT NULL,
	APELLIDOS VARCHAR(100) NOT NULL,
	FECHA_NACIMIENTO DATE NOT NULL,
	EMAIL VARCHAR(50) UNIQUE NOT NULL,
	CONTRASEÑA VARCHAR(50) NOT NULL,

	PRIMARY KEY(ID_USUARIO),
    ID_ROL INT NOT NULL,
    FOREIGN KEY(ID_ROL) REFERENCES ROLES(ID_ROL)
);

-- INSERTAMOS DATOS DE USUARIOS
INSERT INTO USUARIOS
	VALUES(1, "Pepe", "Cuesta", '1967-06-18', "pepito@gmail.com", "pepito1967", 1);
    
INSERT INTO USUARIOS
	VALUES(2, "Maria", "Lopez", '1978-09-25', "maria@gmail.com", "maria1978", 2);
    
INSERT INTO USUARIOS
	VALUES(3, "Jacinto", "Perez", '1985-01-29', "jacinto@gmail.com", "jacinto1985", 1);
    
INSERT INTO USUARIOS
	VALUES(4, "Laura", "Blanco", '1995-12-10', "laura@gmail.com", "laura1995", 1);


-- --------------------------------------------------------------------------------------------------------
-- ----------------------------------------------DIRECCIONES-----------------------------------------------
-- --------------------------------------------------------------------------------------------------------

-- CREACION DE LA TABLA DIRECCIONES
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


-- INSERTAMOS DATOS DE DIRECCIONES
INSERT INTO DIRECCIONES
	VALUES(1, 15000, "MADRID", "Gran vía", 28, "5", 'D');
    
INSERT INTO DIRECCIONES
	VALUES(2, 15001, "MADRID", "Chamberrí", 54, "9", 'F');
    
INSERT INTO DIRECCIONES
	VALUES(3, 45000, "BARCELONA", "Gran Vía", 67, "1", 'A');
    
INSERT INTO DIRECCIONES
	VALUES(4, 28000, "BILBAO", "Gran Vía", 35, "3", 'C');
    
    
-- --------------------------------------------------------------------------------------------------------
-- ------------------------------------------TARJETAS BANCARIAS--------------------------------------------
-- --------------------------------------------------------------------------------------------------------


-- CREACION DE LA TABLA TARJETAS BANCARIAS
CREATE TABLE TARJETAS_BANCARIAS(
	ID_TARJETA INT AUTO_INCREMENT NOT NULL,
    NUMERO_TARJETA DEC(16) NOT NULL,
    NOMBRE_TITULAR VARCHAR(50) NOT NULL,
    FECHA_CADUCIDAD DATE NOT NULL,
    CVV DEC(3) NOT NULL,
    
    PRIMARY KEY(ID_TARJETA)
);


-- INSERTAMOS DATOS DE TARJETAS
INSERT INTO TARJETAS_BANCARIAS
	VALUES(1, 2347982376346529, "Pepe Cuesta", '2028-05-01', 234);	-- MES Y AÑO SOLO
    
    
INSERT INTO TARJETAS_BANCARIAS
	VALUES(2, 0198237476545678, "Maria Lopez", '2025-08-01', 345);
    
    
INSERT INTO TARJETAS_BANCARIAS
	VALUES(3, 0923847591273684, "Jacinto Perez", '2024-09-01', 987);
    
    
INSERT INTO TARJETAS_BANCARIAS
	VALUES(4, 1234876129387461, "Laura Blanco", '2030-01-01', 546);
    
    
-- --------------------------------------------------------------------------------------------------------
-- ----------------------------------------------PRODUCTOS-------------------------------------------------
-- --------------------------------------------------------------------------------------------------------

-- CREACION DE LA TABLA PRODUCTOS
CREATE TABLE PRODUCTOS (
	ID_PRODUCTO INT AUTO_INCREMENT NOT NULL,
	NOMBRE VARCHAR(50) UNIQUE NOT NULL,
	DESCRIPCION VARCHAR(100) NOT NULL,
	PRECIO DEC(5,2) NOT NULL,
	STOCK INT NOT NULL,

	PRIMARY KEY(ID_PRODUCTO)
);

-- INSERTAMOS DATOS DE PRODUCTOS
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
-- ------------------------------------------------COMPRAS-------------------------------------------------
-- --------------------------------------------------------------------------------------------------------

-- CREACION DE LA TABLA COMPRAS
CREATE TABLE COMPRAS (
	ID_COMPRA INT AUTO_INCREMENT NOT NULL,
	FECHA_DE_REALIZACION TIMESTAMP DEFAULT NOW(),
    ESTADO VARCHAR(50) NOT NULL,

	PRIMARY KEY(ID_COMPRA),
    
	ID_USUARIO INT NOT NULL,
	ID_TARJETA INT NOT NULL,
	ID_DIRECCION INT NOT NULL,
	FOREIGN KEY(ID_USUARIO) REFERENCES USUARIOS (ID_USUARIO),
	FOREIGN KEY(ID_TARJETA) REFERENCES TARJETAS_BANCARIAS (ID_TARJETA),
	FOREIGN KEY(ID_DIRECCION) REFERENCES DIRECCIONES (ID_DIRECCION)
);

-- INSERTAMOS DATOS DE LA COMPRA
INSERT INTO COMPRAS
	(ID_COMPRA, ESTADO, ID_USUARIO, ID_TARJETA, ID_DIRECCION)
	VALUES(1, "COMPRADO", 1, 1, 1);
    
INSERT INTO COMPRAS
	(ID_COMPRA, ESTADO, ID_USUARIO, ID_TARJETA, ID_DIRECCION)
	VALUES(2, "CARRITO", 3, 3, 3);


-- --------------------------------------------------------------------------------------------------------
-- ----------------------------------------LINEA DE COMPRAS------------------------------------------------
-- --------------------------------------------------------------------------------------------------------

-- CREACION DE LA TABLA LINEA DE COMPRAS
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

INSERT INTO LINEAS_DE_COMPRA
	VALUES(1, 1, 9.95, 1, 1);
    
    
-- --------------------------------------------------------------------------------------------------------
-- ------------------------------------TABLAS RENACIDAS N:N------------------------------------------------
-- --------------------------------------------------------------------------------------------------------

-- CREACION DE LA TABLA USUARIO_DIRECCION
CREATE TABLE USUARIO_DIRECCION(
	ID_DIRECCION INT NOT NULL,
    ID_USUARIO INT NOT NULL,
    
    PRIMARY KEY(ID_DIRECCION, ID_USUARIO),
	FOREIGN KEY(ID_DIRECCION) REFERENCES DIRECCIONES (ID_DIRECCION),
	FOREIGN KEY(ID_USUARIO) REFERENCES USUARIOS (ID_USUARIO)
);


-- CREACION DE LA TABLA USUARIO_TARJETA
CREATE TABLE USUARIO_TARJETA(
	ID_TARJETA INT NOT NULL,
    ID_USUARIO INT NOT NULL,
    
    PRIMARY KEY(ID_TARJETA, ID_USUARIO),
	FOREIGN KEY(ID_TARJETA) REFERENCES TARJETAS_BANCARIAS (ID_TARJETA),
	FOREIGN KEY(ID_USUARIO) REFERENCES USUARIOS (ID_USUARIO)
);


CREATE USER utienda IDENTIFIED BY 'utienda';
	grant all privileges on Tienda.* to  utienda; 
	FLUSH PRIVILEGES;