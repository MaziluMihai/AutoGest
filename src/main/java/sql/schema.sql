CREATE TABLE Utilizator(
    id_utilizator INTEGER(10) NOT NULL AUTO_INCREMENT,
    email VARCHAR(50) NOT NULL UNIQUE,
    parola VARCHAR(50) ,
    tip_utilizator VARCHAR(30 ) NOT NULL DEFAULT 'ADMIN',
    nume VARCHAR(30) NOT NULL,
    prenume VARCHAR(30 ) ,
    functia VARCHAR(30 ) ,
    telefon VARCHAR(11)  ,
    data_creare_cont  DATETIME DEFAULT NULL ,
    data_ultimului_login DATETIME DEFAULT NULL ,
    CONSTRAINT UTILIZATOR_PK PRIMARY KEY(id_utilizator)   
);


CREATE TABLE Vehicul(
    id_vehicul INTEGER(10) NOT NULL AUTO_INCREMENT,
    id_utilizator INTEGER(10) NOT NULL UNIQUE,
    status_vehicul VARCHAR(30) ,
    numar_inmatriculare VARCHAR(30) NOT NULL UNIQUE ,
    marca VARCHAR(50) NOT NULL,
    modelul VARCHAR(50) ,
    tip VARCHAR(50) ,
    motorizare VARCHAR(30) NOT NULL,
    an_fabricatiei INTEGER(4),
    consumul_normal INTEGER(4) ,
    CONSTRAINT vehicul_pk PRIMARY KEY(id_vehicul),
    CONSTRAINT vehicul_utilizator_fk FOREIGN KEY(id_utilizator) REFERENCES utilizator(id_utilizator)  
);


