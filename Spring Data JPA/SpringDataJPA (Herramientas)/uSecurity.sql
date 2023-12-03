
CREATE SCHEMA IF NOT EXISTS `Security` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `Security` ;

-- -----------------------------------------------------
-- Table `productosbd`.`familias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Security`.`familias` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

/*
-- Query: SELECT * FROM productosbd.familias
LIMIT 0, 1000

-- Date: 2022-02-25 13:52
*/
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (1,'bebidas');
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (2,'ropa');
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (3,'zapatos');
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (4,'comida');
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (5,'ferreteria');
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (6,'deportes desde postman');
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (18,'modificada la familia desde PUT');
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (21,'teclados desde postman');
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (22,'ordenadores desde postman');
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (25,'espejos');
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (26,'portatiles');
INSERT INTO `familias` (`codigo`,`descripcion`) VALUES (27,'escuelas edix');
-- -----------------------------------------------------
-- Table `productosbd`.`perfiles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Security`.`perfiles` (
  `ID_PERFIL` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_PERFIL`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

/*
-- Query: SELECT * FROM productosbd.perfiles
LIMIT 0, 1000

-- Date: 2022-02-25 13:53
*/
INSERT INTO `perfiles` (`ID_PERFIL`,`NOMBRE`) VALUES (1,'ROLE_ADMINISTRADOR');
INSERT INTO `perfiles` (`ID_PERFIL`,`NOMBRE`) VALUES (2,'ROLE_GESTOR');
INSERT INTO `perfiles` (`ID_PERFIL`,`NOMBRE`) VALUES (3,'ROLE_CLIENTE');
-- -----------------------------------------------------
-- Table `productosbd`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Security`.`productos` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `precio_unitario` DECIMAL(11,2) NULL DEFAULT NULL,
  `codigo_familia` INT NOT NULL,
  `marca` VARCHAR(15) NULL DEFAULT NULL,
  `color` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `codigo_familia` (`codigo_familia` ASC),
  CONSTRAINT `productos_ibfk_1`
    FOREIGN KEY (`codigo_familia`)
    REFERENCES `Security`.`familias` (`codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 32
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

/*
-- Query: SELECT * FROM productosbd.productos
LIMIT 0, 1000

-- Date: 2022-02-25 13:53
*/
INSERT INTO `productos` (`codigo`,`descripcion`,`precio_unitario`,`codigo_familia`,`marca`,`color`) VALUES (2,'fanta',1.00,1,'fanta','naranja');
INSERT INTO `productos` (`codigo`,`descripcion`,`precio_unitario`,`codigo_familia`,`marca`,`color`) VALUES (3,'mirinda',0.50,1,'mirinda','limon');
INSERT INTO `productos` (`codigo`,`descripcion`,`precio_unitario`,`codigo_familia`,`marca`,`color`) VALUES (4,'pantalon',24.00,2,'levis','azul');
INSERT INTO `productos` (`codigo`,`descripcion`,`precio_unitario`,`codigo_familia`,`marca`,`color`) VALUES (5,'camisa',23.00,2,'dustin','azul');
INSERT INTO `productos` (`codigo`,`descripcion`,`precio_unitario`,`codigo_familia`,`marca`,`color`) VALUES (6,'chaleco',124.00,2,'dustin','negro');
INSERT INTO `productos` (`codigo`,`descripcion`,`precio_unitario`,`codigo_familia`,`marca`,`color`) VALUES (9,'blusa blanca',0.80,2,'nisu','blanco');
INSERT INTO `productos` (`codigo`,`descripcion`,`precio_unitario`,`codigo_familia`,`marca`,`color`) VALUES (11,'espejo plano',100.00,25,'necor','madera');
INSERT INTO `productos` (`codigo`,`descripcion`,`precio_unitario`,`codigo_familia`,`marca`,`color`) VALUES (13,'espejo liso',12.00,25,'necor','madera');
INSERT INTO `productos` (`codigo`,`descripcion`,`precio_unitario`,`codigo_familia`,`marca`,`color`) VALUES (21,'chaqueta',100.00,2,'uyyy','tostado');
INSERT INTO `productos` (`codigo`,`descripcion`,`precio_unitario`,`codigo_familia`,`marca`,`color`) VALUES (26,'cerveza',1.00,1,'mahou','amarillito');

-- -----------------------------------------------------
-- Table `productosbd`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Security`.`usuarios` (
  `USERNAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `NOMBRE` VARCHAR(30) NULL DEFAULT NULL,
  `apellidos` VARCHAR(30) NULL DEFAULT NULL,
  `DIRECCION` VARCHAR(100) NULL DEFAULT NULL,
  `ENABLED` INT NOT NULL DEFAULT '1',
  `FECHA_REGISTRO` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`USERNAME`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

/*
-- Query: SELECT * FROM productosbd.usuarios
LIMIT 0, 1000

-- Date: 2022-02-25 13:54
*/
INSERT INTO `usuarios` (`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`DIRECCION`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('amalia','{noop}amalia','amalia','sanchez','sevilla',1,'2021-06-01');
INSERT INTO `usuarios` (`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`DIRECCION`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('cacaito@fp.com','cacaito','cacaito','lopez','madrid',1,'2021-06-01');
INSERT INTO `usuarios` (`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`DIRECCION`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('eva@fp.com','{noop}evita','eva','perez','calle jazmin 20, sevilla',1,'2021-02-01');
INSERT INTO `usuarios` (`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`DIRECCION`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('javier@fp.com','{noop}javierito','javier','perez','Madrid',1,'2021-06-01');
INSERT INTO `usuarios` (`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`DIRECCION`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('ramon@fp.com','{noop}ramoncin','ramon','chu','Madrid',1,'2021-06-01');
INSERT INTO `usuarios` (`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`DIRECCION`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('ricardo@fp.com','{noop}ricardito','ricardo','moreno','Cadiz',1,'2021-06-01');
INSERT INTO `usuarios` (`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`DIRECCION`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('sara@fp.com','{noop}sarita','sara','martinez','calle rosal 10, madrid',1,'2021-03-01');
INSERT INTO `usuarios` (`USERNAME`,`PASSWORD`,`NOMBRE`,`apellidos`,`DIRECCION`,`ENABLED`,`FECHA_REGISTRO`) VALUES ('tomas@fp.com','{noop}tomasin','tomas','escudero','calle alamin 30, madrid',1,'2021-01-01');

-- -----------------------------------------------------
-- Table `productosbd`.`usuario_perfiles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Security`.`usuario_perfiles` (
  `USERNAME` VARCHAR(45) NOT NULL,
  `ID_PERFIL` INT NOT NULL,
  PRIMARY KEY (`USERNAME`, `ID_PERFIL`),
  INDEX `ID_PERFIL` (`ID_PERFIL` ASC),
  CONSTRAINT `usuario_perfiles_ibfk_1`
    FOREIGN KEY (`USERNAME`)
    REFERENCES `Security`.`usuarios` (`USERNAME`),
  CONSTRAINT `usuario_perfiles_ibfk_2`
    FOREIGN KEY (`ID_PERFIL`)
    REFERENCES `Security`.`perfiles` (`ID_PERFIL`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

/*
-- Query: SELECT * FROM productosbd.usuario_perfiles
LIMIT 0, 1000

-- Date: 2022-02-25 13:54
*/
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('amalia',1);
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('cacaito@fp.com',1);
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('javier@fp.com',1);
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('ramon@fp.com',1);
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('ricardo@fp.com',1);
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('tomas@fp.com',1);
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('cacaito@fp.com',2);
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('eva@fp.com',2);
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('javier@fp.com',2);
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('ricardo@fp.com',2);
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('tomas@fp.com',2);
INSERT INTO `usuario_perfiles` (`USERNAME`,`ID_PERFIL`) VALUES ('sara@fp.com',3);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
