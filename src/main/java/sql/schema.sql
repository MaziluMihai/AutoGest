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

