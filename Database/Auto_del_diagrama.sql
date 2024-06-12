-- MySQL Script generated by MySQL Workbench
-- Mon Jun 10 18:09:45 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuari`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuari` (
  `idUsuari` INT NOT NULL,
  `Nom` VARCHAR(45) NULL,
  `Cognom` VARCHAR(45) NULL,
  `Correu` VARCHAR(45) NULL,
  `Telèfon` INT NULL,
  `Data_alta` DATE NULL,
  `Rol` VARCHAR(45) NULL,
  `Contrasenya` VARCHAR(45) NULL,
  `Categoria_client` VARCHAR(45) NULL,
  `Entitat` VARCHAR(45) NULL,
  `Doc_client_logo` LONGBLOB NULL,
  PRIMARY KEY (`idUsuari`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Admin` (
  `Usuari_idUsuari` INT NOT NULL,
  PRIMARY KEY (`Usuari_idUsuari`),
  CONSTRAINT `fk_Admin_Usuari1`
    FOREIGN KEY (`Usuari_idUsuari`)
    REFERENCES `mydb`.`Usuari` (`idUsuari`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Admin_Usuari1_idx` ON `mydb`.`Admin` (`Usuari_idUsuari` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`Servei`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Servei` (
  `idServei` INT NOT NULL,
  `Nom_servei` VARCHAR(45) NULL,
  `Categoria_servei` VARCHAR(45) NULL,
  `Descripcio_servei` LONGTEXT NULL,
  `Document_servei` LONGBLOB NULL,
  `Admin_Usuari_idUsuari` INT NOT NULL,
  PRIMARY KEY (`idServei`, `Admin_Usuari_idUsuari`),
  CONSTRAINT `fk_Servei_Admin1`
    FOREIGN KEY (`Admin_Usuari_idUsuari`)
    REFERENCES `mydb`.`Admin` (`Usuari_idUsuari`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Servei_Admin1_idx` ON `mydb`.`Servei` (`Admin_Usuari_idUsuari` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`Doc_tecnic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Doc_tecnic` (
  `idDoc_tecnic` INT NOT NULL,
  `Nom_doctecnic` VARCHAR(45) NULL,
  `Categoria_doctecnic` VARCHAR(45) NULL,
  `Descripcio_doctecnic` LONGTEXT NULL,
  `Link_doctecnic` VARCHAR(45) NULL,
  `Document_tecnic` LONGBLOB NULL,
  `Admin_Usuari_idUsuari` INT NOT NULL,
  PRIMARY KEY (`idDoc_tecnic`, `Admin_Usuari_idUsuari`),
  CONSTRAINT `fk_Doc_tecnic_Admin1`
    FOREIGN KEY (`Admin_Usuari_idUsuari`)
    REFERENCES `mydb`.`Admin` (`Usuari_idUsuari`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Doc_tecnic_Admin1_idx` ON `mydb`.`Doc_tecnic` (`Admin_Usuari_idUsuari` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`Projecte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Projecte` (
  `idProjecte` INT NOT NULL,
  `Titol` VARCHAR(45) NULL,
  `Descripció` LONGTEXT NULL,
  `Categoria` VARCHAR(45) NULL,
  `Data_projecte` DATE NULL,
  `Data_creació` DATE NULL,
  `Localitzacio` VARCHAR(45) NULL,
  `Document_projecte` LONGBLOB NULL,
  `Usuari_idUsuari` INT NOT NULL,
  `Admin_Usuari_idUsuari` INT NOT NULL,
  PRIMARY KEY (`idProjecte`, `Usuari_idUsuari`, `Admin_Usuari_idUsuari`),
  CONSTRAINT `fk_Projecte_Usuari1`
    FOREIGN KEY (`Usuari_idUsuari`)
    REFERENCES `mydb`.`Usuari` (`idUsuari`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Projecte_Admin1`
    FOREIGN KEY (`Admin_Usuari_idUsuari`)
    REFERENCES `mydb`.`Admin` (`Usuari_idUsuari`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Projecte_Usuari1_idx` ON `mydb`.`Projecte` (`Usuari_idUsuari` ASC) VISIBLE;

CREATE INDEX `fk_Projecte_Admin1_idx` ON `mydb`.`Projecte` (`Admin_Usuari_idUsuari` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`Comentaris`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Comentaris` (
  `idComentari` VARCHAR(45) NOT NULL,
  `text` VARCHAR(45) NULL,
  `datetime` VARCHAR(45) NULL,
  `Usuari_idUsuari` INT NOT NULL,
  `Projecte_idProjecte` INT NOT NULL,
  `Projecte_Usuari_idUsuari` INT NOT NULL,
  `Projecte_Admin_Usuari_idUsuari` INT NOT NULL,
  PRIMARY KEY (`idComentari`, `Usuari_idUsuari`, `Projecte_idProjecte`, `Projecte_Usuari_idUsuari`, `Projecte_Admin_Usuari_idUsuari`),
  CONSTRAINT `fk_Comentaris_Usuari1`
    FOREIGN KEY (`Usuari_idUsuari`)
    REFERENCES `mydb`.`Usuari` (`idUsuari`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentaris_Projecte1`
    FOREIGN KEY (`Projecte_idProjecte` , `Projecte_Usuari_idUsuari` , `Projecte_Admin_Usuari_idUsuari`)
    REFERENCES `mydb`.`Projecte` (`idProjecte` , `Usuari_idUsuari` , `Admin_Usuari_idUsuari`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Comentaris_Usuari1_idx` ON `mydb`.`Comentaris` (`Usuari_idUsuari` ASC) VISIBLE;

CREATE INDEX `fk_Comentaris_Projecte1_idx` ON `mydb`.`Comentaris` (`Projecte_idProjecte` ASC, `Projecte_Usuari_idUsuari` ASC, `Projecte_Admin_Usuari_idUsuari` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`Document_Projecte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Document_Projecte` (
  `idDocument_Projecte` INT NOT NULL,
  `Nom_doc` VARCHAR(45) NULL,
  `Tipus_doc` VARCHAR(45) NULL,
  `Descripcio_doc` VARCHAR(45) NULL,
  `Data_doc` DATE NULL,
  `Projecte_idProjecte` INT NOT NULL,
  `Projecte_Usuari_idUsuari` INT NOT NULL,
  `Projecte_Admin_Usuari_idUsuari` INT NOT NULL,
  PRIMARY KEY (`idDocument_Projecte`, `Projecte_idProjecte`, `Projecte_Usuari_idUsuari`, `Projecte_Admin_Usuari_idUsuari`),
  CONSTRAINT `fk_Document_Projecte_Projecte1`
    FOREIGN KEY (`Projecte_idProjecte` , `Projecte_Usuari_idUsuari` , `Projecte_Admin_Usuari_idUsuari`)
    REFERENCES `mydb`.`Projecte` (`idProjecte` , `Usuari_idUsuari` , `Admin_Usuari_idUsuari`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Document_Projecte_Projecte1_idx` ON `mydb`.`Document_Projecte` (`Projecte_idProjecte` ASC, `Projecte_Usuari_idUsuari` ASC, `Projecte_Admin_Usuari_idUsuari` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
