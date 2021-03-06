-- Gerado por Oracle SQL Developer Data Modeler 4.1.1.888
--   em:        2016-06-01 20:59:42 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g


CREATE TABLE ALUNO
  (
    CD_ALUNO     INTEGER IDENTITY PRIMARY KEY ,
    NR_MATRICULA INTEGER NOT NULL ,
    NM_ALUNO     VARCHAR (250) NOT NULL ,
    DS_SENHA     VARCHAR (32) ,
    VL_IRA FLOAT
  ) ;
ALTER TABLE ALUNO ADD CONSTRAINT ALUNO_PK PRIMARY KEY ( CD_ALUNO ) ;

CREATE TABLE PROFESSOR
  (
    CD_PROFESSOR INTEGER IDENTITY PRIMARY KEY ,
    NR_MATRICULA INTEGER NOT NULL ,
    NM_PROFESSOR VARCHAR (250) NOT NULL ,
    DS_SENHA     VARCHAR (32)
  ) ;


CREATE TABLE DISCIPLINA
  (
    CD_DISCIPLINA INTEGER IDENTITY PRIMARY KEY ,
    NR_DISCIPLINA INTEGER NOT NULL ,
    NM_DISCIPLINA VARCHAR (100),
    CD_DEPARTAMENTO INTEGER NOT NULL , 
    IN_OBRIGATORIA CHAR(1)
  ) ;
ALTER TABLE DISCIPLINA ADD CONSTRAINT DISCIPLINA_PK PRIMARY KEY ( CD_DISCIPLINA ) ;


CREATE TABLE HISTORICO
  (
    CD_HISTORICO    INTEGER IDENTITY PRIMARY KEY ,
    NR_ANO_SEMESTRE INTEGER ,
    CD_ALUNO        INTEGER NOT NULL ,
    CD_DISCIPLINA   INTEGER NOT NULL ,
    VL_MENCAO         CHAR (2)
  ) ;
ALTER TABLE HISTORICO ADD CONSTRAINT HISTORICO_PK PRIMARY KEY ( CD_HISTORICO ) ;

CREATE TABLE OFERTA
  (
    CD_OFERTA       INTEGER IDENTITY PRIMARY KEY ,
    CD_DISCIPLINA   INTEGER NOT NULL ,
    CD_PROFESSOR    INTEGER  NOT NULL ,
    NR_ANO_SEMESTRE VARCHAR (5), 
    DS_TURMA        VARCHAR (2),
    NR_ALUNOS       INTEGER,
  ) ;
ALTER TABLE OFERTA ADD CONSTRAINT OFERTA_PK PRIMARY KEY ( CD_OFERTA ) ;


CREATE TABLE MONITORIA
  (
    CD_MONITORIA INTEGER  NOT NULL ,
    CD_ALUNO     INTEGER  NOT NULL ,
    CD_OFERTA    INTEGER  NOT NULL ,
    NR_RANKING   INTEGER ,
    DS_TIPO      VARCHAR (20) ,
    ST_MONITORIA CHAR (2)
  ) ;
ALTER TABLE MONITORIA ADD CONSTRAINT MONITORIA_PK PRIMARY KEY ( CD_MONITORIA ) ;
  
  
CREATE TABLE DEPARTAMENTO
 (
   CD_DEPARTAMENTO  INTEGER IDENTITY PRIMARY KEY, 
   NM_DEPARTAMENTO  INTEGER NOT NULL,
   DS_DEPARTAMENTO  VARCHAR(50)
 );  
ALTER TABLE DEPARTAMENTO ADD CONSTRAINT DEPARTAMENTO_PK PRIMARY KEY ( CD_DEPARTAMENTO ) ;
  
CREATE TABLE DEFINICAO_BOLSAS
 ( 
   CD_DEFINICAO_BOLSAS INTEGER PRIMARY KEY, 
   CD_DEPARTAMENTO   INTEGER , 
   NR_ANO_SEMESTRE   INTEGER ,
   NR_BOLSA          INTEGER
 );



ALTER TABLE PROFESSOR ADD CONSTRAINT PROFESSOR_PK PRIMARY KEY ( CD_PROFESSOR ) ;

ALTER TABLE HISTORICO ADD CONSTRAINT HISTORICO_ALUNO_FK FOREIGN KEY ( CD_ALUNO ) REFERENCES ALUNO ( CD_ALUNO ) ;

ALTER TABLE HISTORICO ADD CONSTRAINT HISTORICO_DISCIPLINA_FK FOREIGN KEY ( CD_DISCIPLINA ) REFERENCES DISCIPLINA ( CD_DISCIPLINA ) ;

ALTER TABLE MONITORIA ADD CONSTRAINT MONITORIA_ALUNO_FK FOREIGN KEY ( CD_ALUNO ) REFERENCES ALUNO ( CD_ALUNO ) ;

ALTER TABLE MONITORIA ADD CONSTRAINT MONITORIA_OFERTA_FK FOREIGN KEY ( CD_OFERTA ) REFERENCES OFERTA ( CD_OFERTA ) ;

ALTER TABLE OFERTA ADD CONSTRAINT OFERTA_DISCIPLINA_FK FOREIGN KEY ( CD_DISCIPLINA ) REFERENCES DISCIPLINA ( CD_DISCIPLINA ) ;

ALTER TABLE PROFESSOR_OFERTA ADD CONSTRAINT PROFESSOR_OFERTA_OFERTA_FK FOREIGN KEY ( CD_OFERTA ) REFERENCES OFERTA ( CD_OFERTA ) ;

ALTER TABLE PROFESSOR_OFERTA ADD CONSTRAINT PROFESSOR_OFERTA_PROFESSOR_FK FOREIGN KEY ( CD_PROFESSOR ) REFERENCES PROFESSOR ( CD_PROFESSOR ) ;


-- Relat�rio do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             0
-- ALTER TABLE                             14
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
