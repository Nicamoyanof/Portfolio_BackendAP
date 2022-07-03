# Portfolio_BackendAP
# AQUI SE ENCUENTRA EL SCRIPT DE LA BASE DE DATOS

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fullstack_ap
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fullstack_ap
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fullstack_ap` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `fullstack_ap` ;

-- -----------------------------------------------------
-- Table `fullstack_ap`.`educaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fullstack_ap`.`educaciones` (
  `id_instituto` INT NOT NULL AUTO_INCREMENT,
  `nombre_instituto` VARCHAR(100) NULL DEFAULT NULL,
  `titulo_instituto` VARCHAR(100) NULL DEFAULT NULL,
  `logo` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id_instituto`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fullstack_ap`.`habilidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fullstack_ap`.`habilidades` (
  `id_habilidad` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `logo` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id_habilidad`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fullstack_ap`.`proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fullstack_ap`.`proyectos` (
  `id_proyecto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `img_proyecto` VARCHAR(1000) NULL DEFAULT NULL,
  `link_github` VARCHAR(400) NULL DEFAULT NULL,
  PRIMARY KEY (`id_proyecto`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fullstack_ap`.`habilidades_proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fullstack_ap`.`habilidades_proyectos` (
  `id_hab_pro` INT NOT NULL AUTO_INCREMENT,
  `id_habilidad` INT NULL DEFAULT NULL,
  `id_proyecto` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_hab_pro`),
  INDEX `id_habilidad` (`id_habilidad` ASC) VISIBLE,
  INDEX `id_proyecto` (`id_proyecto` ASC) VISIBLE,
  CONSTRAINT `habilidades_proyectos_ibfk_1`
    FOREIGN KEY (`id_habilidad`)
    REFERENCES `fullstack_ap`.`habilidades` (`id_habilidad`),
  CONSTRAINT `habilidades_proyectos_ibfk_2`
    FOREIGN KEY (`id_proyecto`)
    REFERENCES `fullstack_ap`.`proyectos` (`id_proyecto`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fullstack_ap`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fullstack_ap`.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(250) NULL DEFAULT NULL,
  `pass` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fullstack_ap`.`personas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fullstack_ap`.`personas` (
  `id_persona` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NULL DEFAULT NULL,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `apellido` VARCHAR(50) NULL DEFAULT NULL,
  `profesion` VARCHAR(100) NULL DEFAULT NULL,
  `ciudad` VARCHAR(100) NULL DEFAULT NULL,
  `pais` VARCHAR(50) NULL DEFAULT NULL,
  `descripcion` VARCHAR(500) NULL DEFAULT NULL,
  `img_perfil` VARCHAR(1000) NULL DEFAULT NULL,
  `img_banner` VARCHAR(1000) NULL DEFAULT NULL,
  `img_banner_M` VARCHAR(1000) NULL DEFAULT NULL,
  `logo` VARCHAR(1000) NULL DEFAULT NULL,
  `email` VARCHAR(250) NULL DEFAULT NULL,
  `linkedin` VARCHAR(500) NULL DEFAULT NULL,
  `github` VARCHAR(400) NULL DEFAULT NULL,
  PRIMARY KEY (`id_persona`),
  INDEX `id_usuario` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `personas_ibfk_1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `fullstack_ap`.`usuarios` (`id_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fullstack_ap`.`personas_estudios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fullstack_ap`.`personas_estudios` (
  `id_personas_estudios` INT NOT NULL AUTO_INCREMENT,
  `id_persona` INT NULL DEFAULT NULL,
  `id_instituto` INT NULL DEFAULT NULL,
  `anio_inicio` INT NULL DEFAULT NULL,
  `anio_final` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_personas_estudios`),
  INDEX `id_persona` (`id_persona` ASC) VISIBLE,
  INDEX `id_instituto` (`id_instituto` ASC) VISIBLE,
  CONSTRAINT `personas_estudios_ibfk_1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `fullstack_ap`.`personas` (`id_persona`),
  CONSTRAINT `personas_estudios_ibfk_2`
    FOREIGN KEY (`id_instituto`)
    REFERENCES `fullstack_ap`.`educaciones` (`id_instituto`))
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fullstack_ap`.`personas_habilidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fullstack_ap`.`personas_habilidades` (
  `id_per_hab` INT NOT NULL AUTO_INCREMENT,
  `id_persona` INT NULL DEFAULT NULL,
  `id_habilidad` INT NULL DEFAULT NULL,
  `porcentaje` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_per_hab`),
  INDEX `id_persona` (`id_persona` ASC) VISIBLE,
  INDEX `id_habilidad` (`id_habilidad` ASC) VISIBLE,
  CONSTRAINT `personas_habilidades_ibfk_1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `fullstack_ap`.`personas` (`id_persona`),
  CONSTRAINT `personas_habilidades_ibfk_2`
    FOREIGN KEY (`id_habilidad`)
    REFERENCES `fullstack_ap`.`habilidades` (`id_habilidad`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fullstack_ap`.`personas_proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fullstack_ap`.`personas_proyectos` (
  `id_per_hab` INT NOT NULL AUTO_INCREMENT,
  `id_persona` INT NULL DEFAULT NULL,
  `id_proyecto` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_per_hab`),
  INDEX `id_persona` (`id_persona` ASC) VISIBLE,
  INDEX `id_proyecto` (`id_proyecto` ASC) VISIBLE,
  CONSTRAINT `personas_proyectos_ibfk_1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `fullstack_ap`.`personas` (`id_persona`),
  CONSTRAINT `personas_proyectos_ibfk_2`
    FOREIGN KEY (`id_proyecto`)
    REFERENCES `fullstack_ap`.`proyectos` (`id_proyecto`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
