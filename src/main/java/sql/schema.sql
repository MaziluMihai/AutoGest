CREATE TABLE Utilizator(
    id_utilizator INTEGER(10),
    email VARCHAR(50) NOT NULL UNIQUE,
    parola VARCHAR(50) ,
    tip_utilizator VARCHAR(30 ) NOT NULL default 'ADMIN',
    nume VARCHAR(30) NOT NULL,
    prenume VARCHAR(30 ) ,
    functia VARCHAR(30 ) ,
    telefon VARCHAR(11)  ,
    data_creare_cont  DATE ,
    data_ultimului_login DATE ,
    CONSTRAINT utilizatori_pk PRIMARY KEY(id_utilizator)   
);