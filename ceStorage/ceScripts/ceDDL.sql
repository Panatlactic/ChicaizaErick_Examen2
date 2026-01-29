DROP TABLE IF EXISTS gjExoTracer;
DROP TABLE IF EXISTS gjExobot;
DROP TABLE IF EXISTS gjTipoExobot;
DROP TABLE IF EXISTS gjArma;
DROP TABLE IF EXISTS gjTipoArma;
DROP TABLE IF EXISTS gjUsuario;

DROP TABLE IF EXISTS ceExoTracer;
DROP TABLE IF EXISTS ceExobot;
DROP TABLE IF EXISTS ceTipoExobot;
DROP TABLE IF EXISTS ceArma;
DROP TABLE IF EXISTS ceTipoArma;
DROP TABLE IF EXISTS ceUsuario;

CREATE TABLE IF NOT EXISTS ceUsuario (
    IdUsuario       INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre          TEXT NOT NULL,
    Username        TEXT NOT NULL UNIQUE,
    Clave           TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS ceTipoArma (
    IdTipoArma      INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre          TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS ceArma (
    IdArma              INTEGER PRIMARY KEY AUTOINCREMENT,
    IdTipoArma          INTEGER NOT NULL,
    Nombre              TEXT NOT NULL,
    FOREIGN KEY (IdTipoArma) REFERENCES ceTipoArma(IdTipoArma)
);
CREATE TABLE IF NOT EXISTS ceTipoExobot (
    IdTipoExobot INTEGER PRIMARY KEY AUTOINCREMENT,
    Nombre TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS ceExobot (
    IdExobot INTEGER PRIMARY KEY AUTOINCREMENT,
    IdTipoExobot INTEGER NOT NULL,
    IdUsuario INTEGER,
    Entrenado INTEGER DEFAULT 0,
    -- 0: No, 1: Si
    NumeroAccion INTEGER DEFAULT 0,
    IdArma INTEGER,
    FOREIGN KEY (IdTipoExobot) REFERENCES ceTipoExobot(IdTipoExobot),
    FOREIGN KEY (IdUsuario) REFERENCES ceUsuario(IdUsuario),
    FOREIGN KEY (IdArma) REFERENCES ceArma(IdArma)
);
CREATE TABLE IF NOT EXISTS ceExoTracer (
    IdExoTracer INTEGER PRIMARY KEY AUTOINCREMENT,
    IdExobot INTEGER,
    NumeroAccion INTEGER,
    EnShow TEXT,
    FOREIGN KEY (IdExobot) REFERENCES ceExobot(IdExobot)
);
-- Datos Iniciales (Seed Data)
INSERT INTO ceUsuario (Nombre, Username, Clave)
VALUES ('Patricio Michael', 'patmic', '123');
INSERT INTO ceTipoArma (Nombre)
VALUES ('Fusil / Revolver');
INSERT INTO ceTipoArma (Nombre)
VALUES ('GPS / Giroscopio');
INSERT INTO ceTipoArma (Nombre)
VALUES ('Misil / Mortero');
INSERT INTO ceTipoArma (Nombre)
VALUES ('BioSensor / BioEscaner');
INSERT INTO ceTipoArma (Nombre)
VALUES ('Laser / Bayoneta');
INSERT INTO ceTipoExobot (Nombre)
VALUES ('ExoAsalto');
INSERT INTO ceTipoExobot (Nombre)
VALUES ('ExoExplorador');
INSERT INTO ceTipoExobot (Nombre)
VALUES ('ExoInfanteria');
INSERT INTO ceTipoExobot (Nombre)
VALUES ('ExoMedico');
INSERT INTO ceTipoExobot (Nombre)
VALUES ('ExoComando');
INSERT INTO ceArma (IdTipoArma, Nombre)
VALUES (1, 'Fusil');
INSERT INTO ceArma (IdTipoArma, Nombre)
VALUES (2, 'GPS');
INSERT INTO ceArma (IdTipoArma, Nombre)
VALUES (3, 'Misil');
INSERT INTO ceArma (IdTipoArma, Nombre)
VALUES (4, 'BioSensor');
INSERT INTO ceArma (IdTipoArma, Nombre)
VALUES (5, 'Laser');