-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Carpooling
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Carpooling` ;

-- -----------------------------------------------------
-- Schema Carpooling
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Carpooling` DEFAULT CHARACTER SET utf8 COLLATE utf8_esperanto_ci ;
USE `Carpooling` ;

-- -----------------------------------------------------
-- Table `Carpooling`.`Utente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Carpooling`.`Utente` ;

CREATE TABLE IF NOT EXISTS `Carpooling`.`Utente` (
  `idUtente` VARCHAR(15) NOT NULL,
  `nome` VARCHAR(10) NOT NULL,
  `cognome` VARCHAR(20) NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `tipoAuto` VARCHAR(20) NOT NULL,
  `PostiDisponibili` INT NOT NULL,
  PRIMARY KEY (`idUtente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Carpooling`.`Autista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Carpooling`.`Autista` ;

CREATE TABLE IF NOT EXISTS `Carpooling`.`Autista` (
  `idAutista` VARCHAR(10) NOT NULL,
  `Utente_idUtente` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idAutista`),
  INDEX `fk_Autista_Utente_idx` (`Utente_idUtente` ASC) VISIBLE,
  CONSTRAINT `fk_Autista_Utente`
    FOREIGN KEY (`Utente_idUtente`)
    REFERENCES `Carpooling`.`Utente` (`idUtente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Carpooling`.`Passeggero`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Carpooling`.`Passeggero` ;

CREATE TABLE IF NOT EXISTS `Carpooling`.`Passeggero` (
  `idPasseggero` VARCHAR(15) NOT NULL,
  `Utente_idUtente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPasseggero`),
  INDEX `fk_Passeggero_Utente1_idx` (`Utente_idUtente` ASC) VISIBLE,
  CONSTRAINT `fk_Passeggero_Utente1`
    FOREIGN KEY (`Utente_idUtente`)
    REFERENCES `Carpooling`.`Utente` (`idUtente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Carpooling`.`Feedback`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Carpooling`.`Feedback` ;

CREATE TABLE IF NOT EXISTS `Carpooling`.`Feedback` (
  `idFeedback` VARCHAR(10) NOT NULL,
  `commentoPasseggero` VARCHAR(45) NOT NULL,
  `commentoAutista` VARCHAR(45) NOT NULL,
  `valutazioneAutista` VARCHAR(45) NOT NULL,
  `valutazionePasseggero` VARCHAR(45) NOT NULL,
  `Passeggero_idPasseggero` VARCHAR(15) NOT NULL,
  `Autista_idAutista` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idFeedback`),
  INDEX `fk_Feedback_Passeggero1_idx` (`Passeggero_idPasseggero` ASC) VISIBLE,
  INDEX `fk_Feedback_Autista1_idx` (`Autista_idAutista` ASC) VISIBLE,
  CONSTRAINT `fk_Feedback_Passeggero1`
    FOREIGN KEY (`Passeggero_idPasseggero`)
    REFERENCES `Carpooling`.`Passeggero` (`idPasseggero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Feedback_Autista1`
    FOREIGN KEY (`Autista_idAutista`)
    REFERENCES `Carpooling`.`Autista` (`idAutista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Carpooling`.`Viaggio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Carpooling`.`Viaggio` ;

CREATE TABLE IF NOT EXISTS `Carpooling`.`Viaggio` (
  `idViaggio` VARCHAR(45) NOT NULL,
  `partenza` VARCHAR(20) NULL,
  `destinazione` VARCHAR(20) NULL,
  `contributo` FLOAT NULL,
  `dataOra` VARCHAR(20) NULL,
  `incassoTotale` FLOAT NULL,
  `Autista_idAutista` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idViaggio`),
  INDEX `fk_Viaggio_Autista1_idx` (`Autista_idAutista` ASC) VISIBLE,
  CONSTRAINT `fk_Viaggio_Autista1`
    FOREIGN KEY (`Autista_idAutista`)
    REFERENCES `Carpooling`.`Autista` (`idAutista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Carpooling`.`Prenotazione`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Carpooling`.`Prenotazione` ;

CREATE TABLE IF NOT EXISTS `Carpooling`.`Prenotazione` (
  `idPrenotazione` VARCHAR(15) NOT NULL,
  `costo` FLOAT NOT NULL,
  `Viaggio_idViaggio` VARCHAR(45) NOT NULL,
  `Passeggero_idPasseggero` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idPrenotazione`),
  INDEX `fk_Prenotazione_Viaggio1_idx` (`Viaggio_idViaggio` ASC) VISIBLE,
  INDEX `fk_Prenotazione_Passeggero1_idx` (`Passeggero_idPasseggero` ASC) VISIBLE,
  CONSTRAINT `fk_Prenotazione_Viaggio1`
    FOREIGN KEY (`Viaggio_idViaggio`)
    REFERENCES `Carpooling`.`Viaggio` (`idViaggio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Prenotazione_Passeggero1`
    FOREIGN KEY (`Passeggero_idPasseggero`)
    REFERENCES `Carpooling`.`Passeggero` (`idPasseggero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Carpooling`.`Utente`
-- -----------------------------------------------------
START TRANSACTION;
USE `Carpooling`;
INSERT INTO `Carpooling`.`Utente` (`idUtente`, `nome`, `cognome`, `telefono`, `email`, `tipoAuto`, `PostiDisponibili`) VALUES ('luca01', 'luca', 'de bernardo', '1237534932', 'luca@outlook.it', 'yaris', 2);
INSERT INTO `Carpooling`.`Utente` (`idUtente`, `nome`, `cognome`, `telefono`, `email`, `tipoAuto`, `PostiDisponibili`) VALUES ('marco01', 'marco', 'esposito', '1523496432', 'marco@yahoo.it', 'toyota', 4);
INSERT INTO `Carpooling`.`Utente` (`idUtente`, `nome`, `cognome`, `telefono`, `email`, `tipoAuto`, `PostiDisponibili`) VALUES ('gio01', 'giovanni', 'manna', '4326654763', 'giovanni@libero.it', 'alfa romeo', 4);
INSERT INTO `Carpooling`.`Utente` (`idUtente`, `nome`, `cognome`, `telefono`, `email`, `tipoAuto`, `PostiDisponibili`) VALUES ('ale01', 'alessandro', 'nugnes', '1335532156', 'ale@virgilio.it', 'panda', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `Carpooling`.`Autista`
-- -----------------------------------------------------
START TRANSACTION;
USE `Carpooling`;
INSERT INTO `Carpooling`.`Autista` (`idAutista`, `Utente_idUtente`) VALUES ('autista01', 'luca01');
INSERT INTO `Carpooling`.`Autista` (`idAutista`, `Utente_idUtente`) VALUES ('autista02', 'marco01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Carpooling`.`Passeggero`
-- -----------------------------------------------------
START TRANSACTION;
USE `Carpooling`;
INSERT INTO `Carpooling`.`Passeggero` (`idPasseggero`, `Utente_idUtente`) VALUES ('passeggero1', 'gio01');
INSERT INTO `Carpooling`.`Passeggero` (`idPasseggero`, `Utente_idUtente`) VALUES ('passeggero2', 'marco01');
INSERT INTO `Carpooling`.`Passeggero` (`idPasseggero`, `Utente_idUtente`) VALUES ('passeggero3', 'ale01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Carpooling`.`Feedback`
-- -----------------------------------------------------
START TRANSACTION;
USE `Carpooling`;
INSERT INTO `Carpooling`.`Feedback` (`idFeedback`, `commentoPasseggero`, `commentoAutista`, `valutazioneAutista`, `valutazionePasseggero`, `Passeggero_idPasseggero`, `Autista_idAutista`) VALUES ('feed', 'passeggero educato', 'autista prudente', '6', '7', 'passeggero1', 'autista01');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Carpooling`.`Viaggio`
-- -----------------------------------------------------
START TRANSACTION;
USE `Carpooling`;
INSERT INTO `Carpooling`.`Viaggio` (`idViaggio`, `partenza`, `destinazione`, `contributo`, `dataOra`, `incassoTotale`, `Autista_idAutista`) VALUES ('viaggio1', 'fuorigrotta', 'bagnoli', 4, '12-02-2014 12:00', 0, 'autista01');
INSERT INTO `Carpooling`.`Viaggio` (`idViaggio`, `partenza`, `destinazione`, `contributo`, `dataOra`, `incassoTotale`, `Autista_idAutista`) VALUES ('viaggio2', 'pianura', 'bacoli', 5, '12-18-2015 13:00', 0, 'autista02');

COMMIT;


-- -----------------------------------------------------
-- Data for table `Carpooling`.`Prenotazione`
-- -----------------------------------------------------
START TRANSACTION;
USE `Carpooling`;
INSERT INTO `Carpooling`.`Prenotazione` (`idPrenotazione`, `costo`, `Viaggio_idViaggio`, `Passeggero_idPasseggero`) VALUES ('prenotazione1', 4, 'viaggio1', 'passeggero1');
INSERT INTO `Carpooling`.`Prenotazione` (`idPrenotazione`, `costo`, `Viaggio_idViaggio`, `Passeggero_idPasseggero`) VALUES ('prenotazione2', 3, 'viaggio1', 'passeggero2');
INSERT INTO `Carpooling`.`Prenotazione` (`idPrenotazione`, `costo`, `Viaggio_idViaggio`, `Passeggero_idPasseggero`) VALUES ('prenotazione3', 5, 'viaggio1', 'passeggero3');

COMMIT;

