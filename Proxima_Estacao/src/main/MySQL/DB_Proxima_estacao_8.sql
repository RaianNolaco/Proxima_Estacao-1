-- DROP DATABASE proxima_estacao;

CREATE DATABASE proxima_estacao;

USE proxima_estacao;

#------------------------------------------------------------------------------------------------------------
#Criações das tabelas 
#------------------------------------------------------------------------------------------------------------

/*criar trigger de banimento*/
CREATE TABLE status(
 id_status   VARCHAR(4),
 descricao_status VARCHAR(200),

 CONSTRAINT pk_id_status PRIMARY KEY (id_status)
);


CREATE TABLE usuario(
    id_usuario      SMALLINT     AUTO_INCREMENT,
    foto_perfil     VARCHAR	(100),
	nome            VARCHAR (50) NOT NULL,
    sobrenome       VARCHAR (50) NOT NULL,
    apelido         VARCHAR (25) NOT NULL,
    email           VARCHAR (60) NOT NULL UNIQUE,
    senha           VARCHAR (15) NOT NULL,
    numero   	    VARCHAR (11) UNIQUE,
    id_status   	VARCHAR(4), 
    data_nascimento DATE         NOT NULL,
    cpf             VARCHAR (11) UNIQUE,
	
    CONSTRAINT pk_id_usuario PRIMARY KEY (id_usuario),
    CONSTRAINT fk_id_status  FOREIGN KEY (id_status) REFERENCES status (id_status)
);

-- CRIAR tabela de status -----

/*
 situacao VARCHAR(4) DEFAULT '1' vira da aplicação 
*/

CREATE TABLE tipo_categoria(
    id_tipo_categoria  SMALLINT NOT NULL AUTO_INCREMENT ,
    nome_tipo          VARCHAR(50),
    
    CONSTRAINT pk_id_tipo_categoria PRIMARY KEY (id_tipo_categoria)
);
-- #

CREATE TABLE categoria(
    id_categoria      SMALLINT AUTO_INCREMENT,
    nome_categoria             VARCHAR(25),
	id_tipo_categoria  SMALLINT NOT NULL,
	
    CONSTRAINT pk_id_categoria PRIMARY KEY (id_categoria),
	CONSTRAINT fk_id_tipo_categoria FOREIGN KEY (id_tipo_categoria) REFERENCES tipo_categoria (id_tipo_categoria)
	
);



CREATE TABLE artista(
	id_artista  SMALLINT     AUTO_INCREMENT,
    descricao   VARCHAR(200) ,
    id_usuario  SMALLINT     NOT NULL,
    -- seguidores  INT, -- Os seguidores sera um select 
    rede_social VARCHAR(200),
    
    
    CONSTRAINT pk_id_artista PRIMARY KEY (id_artista),
    CONSTRAINT fk_id_usuario_artista FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);

CREATE TABLE grupo(
    id_grupo        SMALLINT AUTO_INCREMENT,
    nome_grupo      VARCHAR(50)  NOT NULL,
    tag_grupo       VARCHAR(5)   NOT NULL,
    descricao_grupo VARCHAR(200),
 
	CONSTRAINT pk_id_grupo PRIMARY KEY (id_grupo)  

); 


CREATE TABLE forma_pagamento(
   id_forma_Pag SMALLINT        AUTO_INCREMENT,
   nome         VARCHAR(50)     NOT NULL, 

   CONSTRAINT pk_id_forma_pag PRIMARY KEY(id_forma_pag)
);


CREATE TABLE doacao(
   id_doacao       SMALLINT AUTO_INCREMENT,
   valor    	   DOUBLE   NOT NULL,
   id_artista      SMALLINT NOT NULL,
   id_usuario      SMALLINT NOT NULL,
   id_forma_pag    SMALLINT NOT NULL,
  
   CONSTRAINT pk_id_doacao PRIMARY KEY (id_doacao),
   CONSTRAINT fk_id_artista_doacao FOREIGN KEY (id_artista)  REFERENCES  artista (id_artista),
   CONSTRAINT fk_id_usuario_doacao FOREIGN KEY (id_usuario)  REFERENCES  usuario (id_usuario),
   CONSTRAINT fk_id_forma_pag FOREIGN KEY    (id_forma_pag)  REFERENCES  forma_pagamento (id_forma_pag)
);


CREATE TABLE publicacao(
    id_publicacao   SMALLINT      AUTO_INCREMENT,
    thumb       	VARCHAR (50), -- ---------------- Galeria de thub 
    conteudo        VARCHAR (600) NOT NULL,
    conteudo_sensi  boolean       NOT NULL,
    descricao       VARCHAR (500) ,
    visualizacao    INT,
    id_artista	    SMALLINT,
	
    CONSTRAINT pk_id_publicacao PRIMARY KEY (id_publicacao),
    CONSTRAINT fk_id_artista_publicacao FOREIGN KEY (id_artista) REFERENCES artista (id_artista)
 );
-- tabela midia



CREATE TABLE  feedback(
   id_feedback   INT     AUTO_INCREMENT,
   titulo        varchar(50)  NOT NULL ,
   comentario    varchar(600) NOT NULL,
   curtida       boolean, 
   id_usuario    smallint,
   id_publicacao smallint,
	
   CONSTRAINT pk_id_feedback PRIMARY KEY (id_feedback),
   CONSTRAINT fk_id_usuario_feed  FOREIGN KEY (id_usuario)       REFERENCES usuario (id_usuario),
   CONSTRAINT fk_id_publicacao_feed  FOREIGN KEY (id_publicacao) REFERENCES publicacao (id_publicacao)
   	 	
);


CREATE TABLE recompensa( -- -------------- Ficara marcado no usuario ?
    id_recompensa  SMALLINT     AUTO_INCREMENT,
    nome           varchar(50)  NOT NULL,
    descricao      varchar(200) NOT NULL,
    emblema        varchar(200) NOT NULL,
    
    CONSTRAINT pk_id_recompensa PRIMARY KEY (id_recompensa)
);

#------------------------------------------------------------------------------------------------------------
#--Criação tabelas filho 
#------------------------------------------------------------------------------------------------------------
CREATE TABLE grupo_artista(
   id_grupo   SMALLINT NOT NULL,
   id_artista SMALLINT NOT NULL,

   CONSTRAINT pk_id_grupo_artista PRIMARY KEY (id_grupo,id_artista),
   CONSTRAINT fk_id_grupoArtista  FOREIGN KEY (id_grupo)  REFERENCES grupo (id_grupo),
   CONSTRAINT fk_id_artistaGrupo  FOREIGN KEY (id_artista)  REFERENCES artista (id_artista)
);


CREATE TABLE artista_Categoria(
    id_artista   SMALLINT NOT NULL,
    id_categoria SMALLINT NOT NULL,

    CONSTRAINT pk_id_artista_categoria PRIMARY KEY (id_artista, id_categoria),
    CONSTRAINT fk_id_artistaCategoria  FOREIGN KEY (id_artista)   REFERENCES artista (id_artista),
    CONSTRAINT fk_id_categoriaArtista  FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE publicacao_categoria(
    id_publicacao  SMALLINT NOT NULL,
    id_categoria   SMALLINT NOT NULL,
	
    CONSTRAINT pk_id_publicacao_categoria PRIMARY KEY (id_publicacao, id_categoria),
    CONSTRAINT fk_id_categoria_publicacao FOREIGN KEY (id_publicacao) REFERENCES publicacao(id_publicacao),
    CONSTRAINT fk_id_publicacaoCategoria  FOREIGN KEY (id_categoria)  REFERENCES categoria(id_categoria)
);

CREATE TABLE usuario_recompensa(
    id_recompensa SMALLINT NOT NULL,
    id_usuario    SMALLINT NOT NULL,
	
    CONSTRAINT pk_id_usuario_recompensa PRIMARY KEY (id_recompensa, id_usuario),
    CONSTRAINT fk_id_recompensa_usuario FOREIGN KEY (id_recompensa)  REFERENCES recompensa(id_recompensa),
    CONSTRAINT fk_id_usuarioRecompensa  FOREIGN KEY (id_usuario)     REFERENCES usuario(id_usuario)
);

CREATE TABLE formaPag_artista(
     id_forma_Pag  SMALLINT NOT NULL,
	 id_artista    SMALLINT NOT NULL,
     
	 CONSTRAINT pk_id_formaPag_artista  PRIMARY KEY (id_forma_Pag,id_artista), 
	 CONSTRAINT fk_id_artista_forma_Pag FOREIGN KEY (id_forma_Pag) REFERENCES forma_pagamento (id_forma_Pag),
	 CONSTRAINT fk_id_formaPagArtista   FOREIGN KEY (id_artista)   REFERENCES artista(id_artista)
);

CREATE TABLE seguidores (
    id_artista  SMALLINT,
    id_usuario  SMALLINT,
    
    CONSTRAINT PK_id_seguidores         PRIMARY KEY (id_artista,id_usuario),
    CONSTRAINT fk_id_seguidores_usuario FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
    CONSTRAINT fk_id_seguidores_artista FOREIGN KEY (id_artista) REFERENCES artista (id_artista)
 );
 