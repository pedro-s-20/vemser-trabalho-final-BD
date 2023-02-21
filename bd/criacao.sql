--CREATE USER TRAB_FINAL IDENTIFIED BY oracle;
--GRANT CONNECT TO TRAB_FINAL;
--GRANT CONNECT, RESOURCE, DBA TO TRAB_FINAL;
--GRANT CREATE SESSION TO TRAB_FINAL;
--GRANT DBA TO TRAB_FINAL;
--GRANT CREATE VIEW, CREATE PROCEDURE, CREATE SEQUENCE to TRAB_FINAL;
--GRANT UNLIMITED TABLESPACE TO TRAB_FINAL;
--GRANT CREATE MATERIALIZED VIEW TO TRAB_FINAL;
--GRANT CREATE TABLE TO TRAB_FINAL;
--GRANT GLOBAL QUERY REWRITE TO TRAB_FINAL;
--GRANT SELECT ANY TABLE TO TRAB_FINAL;


CREATE TABLE ENDERECO (
	id_endereco NUMBER(10) PRIMARY KEY,
	logradouro varchar2(255) NOT null,
	cep char(9) NOT NULL,
	numero number(8) NOT NULL,
	complemento varchar2(100)			
)

CREATE TABLE contato (
	id_contato NUMBER(10) PRIMARY KEY,
	telefone1 varchar2(11) NOT NULL,
	telefone2 varchar2(11),
	telefone3 varchar2(11)
);

CREATE TABLE USUARIO (
	id_usuario NUMBER(10) PRIMARY KEY,
	id_endereco NUMBER(10),
	id_contato NUMBER(10),
	nome varchar2(255) NOT NULL,
	cpf char(11) UNIQUE NOT NULL,
	email varchar2(300) NOT NULL UNIQUE,
	senha varchar2(300) NOT NULL,
	CONSTRAINT FK_USARIO_CONTATO FOREIGN KEY (id_contato) REFERENCES Contato (id_contato),
	CONSTRAINT FK_USARIO_ENDERECO FOREIGN KEY (id_endereco) REFERENCES ENDERECO (id_endereco)	
);

CREATE TABLE Administrativo (
	id_administrativo NUMBER(10) PRIMARY KEY,
	id_usuario number(10) NOT NULL,
	CONSTRAINT FK_ADMINISTRATIVO_USUARIO FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario)
)

CREATE TABLE Convenio (
	id_convenio number(10) PRIMARY KEY,
	cadastro_orgao_regulador varchar2(40) NOT NULL,
	taxa_abatimento decimal(2,4) NOT NULL
)

CREATE TABLE Cliente (
	id_cliente number(10) PRIMARY KEY,	
	id_convenio NUMBER(10),	
	id_usuario number(10) NOT null,
	CONSTRAINT FK_CLIENTE_USUARIO FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario),
	CONSTRAINT FK_CLIENTE_CONVENIO FOREIGN KEY (id_convenio) REFERENCES Convenio (id_convenio)
)

CREATE TABLE Especialidade (
	id_especialidade NUMBER(10) PRIMARY KEY,
	nome varchar2(60) NOT NULL,
	valor decimal(10,2) NOT NULL
)


CREATE TABLE Medico (
	id_medico NUMBER(10) PRIMARY KEY,
	id_usuario number(10) NOT NULL,
	id_especialidade number(10) NOT NULL,
	crm varchar2(13) UNIQUE NOT NULL,		
	CONSTRAINT FK_MEDICO_USUARIO FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario),
	CONSTRAINT FK_MEDICO_ESPECIALIDADE FOREIGN KEY (id_especialidade) REFERENCES Especialidade (id_especialidade)
)


CREATE TABLE Agendamento (
	id_agendamento NUMBER(10) PRIMARY KEY,	
	id_medico number(10) NOT NULL,
	id_cliente number(10) NOT NULL,
	data_horario DATE NOT NULL,
	exame varchar2(40),
	tratamento varchar2(40),
	CONSTRAINT FK_AGENDAMENTO_MEDICO FOREIGN KEY (id_medico) REFERENCES MEDICO (id_medico),
	CONSTRAINT FK_AGENDAMENTO_CLIENTE FOREIGN KEY (id_cliente) REFERENCES CLIENTE (id_cliente)
)


