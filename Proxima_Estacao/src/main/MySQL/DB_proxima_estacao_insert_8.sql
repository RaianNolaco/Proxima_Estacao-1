
USE proxima_estacao;

desc usuario;

select * from usuario; 

INSERT INTO usuario VALUES
(DEFAULT,null,'Maria','joao','Merize','marize@hotmail.com','Admin2','11980323922',DEFAULT,'1990-08-11','00000000002'),
(DEFAULT,null,'Carlos','Alberto','Calberto','alberto@gmai.com','Admin3','11980323923',DEFAULT,'2001-11-04','00000000003' ),
(DEFAULT,null,'Felipe','Mendes','Felipense','Felipense@gmai.com','Admin4','11980323924',DEFAULT,'1994-05-05','00000000004' ),
(DEFAULT,null,'Claudio','miguel','Cladart','Cladart@gmai.com','Admin5','11980323925',DEFAULT,'2002-12-23','00000000005' ),
(DEFAULT,null,'Rodrigo','rodrigez','rodrigez','rodrigez@gmai.com','Admin6','11980323226',DEFAULT,'2005-12-19','00000000006' ),
(DEFAULT,null,'Jose','Maia','moioio','mio_332@gmai.com','Admin7','11980323127',DEFAULT,'2001-11-13','00000000007' ),
(DEFAULT,null,'Marlete','Sanchez','Marlete','marlete@hotmail.com','Admin8','11980323228',DEFAULT,'1999-04-07','00000000008' ),
(DEFAULT,null,'claudete','ferreira','Claudete','claudete@igmail.com','Admin9','11980323329',DEFAULT,'2000-09-09','00000000009' ),
(DEFAULT,null,'Mario','Bros','Super Mario','Cladart2@gmai.com','Admin10','11980323943',DEFAULT,'1998-12-24','00000000010' ),
(DEFAULT,null,'Caio','Emanoel','caio','caio@gmai.com','Admin11','21980120944',DEFAULT,'2002-12-24','00000000011' ),
(DEFAULT,null,'keplin','vinicius','Malvadao','kepio@hotmai.com','Admin12','11235445944',DEFAULT,'2000-09-18','00000000012'),
(DEFAULT,null,'Willian','Araujo','Shellos','spacewill@gmai.com','lindo','99999999999',DEFAULT,'2003-01-01','00000000013'),
(DEFAULT,null,'Willian','Arauju','Mr.Chaveiro','chaveiro@hotmai.com','Will','9923999239929',DEFAULT,'2002-11-11','00000000014');

SELECT * from usuario;
desc artista;

INSERT INTO artista VALUES 
(DEFAULT,'Sou um artista show',1,'instagram: @caioManuel'),
(DEFAULT,'Sou um artista Legal',2,'instagram: @maimai'),
(DEFAULT,'Sou um artista bunito',3,'instagram: @carlos'),
(DEFAULT,'Sou um artista delica',4,'instagram: @felipe'),
(DEFAULT,'Sou um artista gatao',5,'instagram: @Rodrizera'),
(DEFAULT,'nao sei oq escrever',6,'instagram: @n'),
(DEFAULT,'helooooo guys',7,'instagram: @instaof'),
(DEFAULT,'Bom dia a todos e a todas',8,'instagram: @hi'),
(DEFAULT,'oiiiiiiiiiiiii',9,'instagram: @oi'),
(DEFAULT,'vamo q vamo fml',10,'instagram: @zaaz');

select * from artista;

INSERT INTO tipo_categoria VALUES 
(DEFAULT,'Teatro'),
(DEFAULT,'Musica'),
(DEFAULT,'Danca'),
(DEFAULT,'Cinema'),
(DEFAULT,'Artes visuais'),
(DEFAULT,'Literatura');

INSERT INTO categoria VALUES 
(DEFAULT,'Teatro de Grupo',1),
(DEFAULT, 'Cenografia', 1),
(DEFAULT, 'Teatro de Bonecos', 1),
(DEFAULT, 'Dramaturgia', 1),
(DEFAULT, 'Circo', 1),
(DEFAULT, 'Teatro do oprimido', 1),
(DEFAULT, 'Instrumental',2),
(DEFAULT, 'Ballet classico',3),
(DEFAULT, 'Boca do lixo',4),
(DEFAULT, 'Desenho/Pintura',5),
(DEFAULT, 'Romance',6);

INSERT INTO recompensa VALUES 
(DEFAULT, 'Doar para 5 artistas',  'Doador bronze', 'NOT FOUND'),
(DEFAULT, 'Doar para 10 artistas', 'Doador prata', 'NOT FOUND'),
(DEFAULT, 'Doar para 20 artistas', 'Doador ouro',  'NOT FOUND'),
(DEFAULT, 'Doar para 50 artistas', 'Doador platina', 'NOT FOUND'),
(DEFAULT, 'Doar para 70 artistas', 'Doador mestre', 'NOT FOUND');

INSERT INTO forma_pagamento VALUES
(DEFAULT, 'PicPay'),
(DEFAULT, 'Mercado Pago'),
(DEFAULT, 'PagSeguro'),
(DEFAULT, 'Paypal'),
(DEFAULT, 'Voucher');


desc publicacao;
INSERT INTO publicacao VALUES
(DEFAULT, 'NOT FOUND','https://media.giphy.com/media/Txh1UzI7d0aqs/giphy.gif',false,'Sad',8,1),
(DEFAULT, 'NOT FOUND','https://media.giphy.com/media/Ln3D55ky9z61G1v7eB/giphy.gif',false,'Bom dia triste',8,4),
(DEFAULT, 'NOT FOUND','https://media.giphy.com/media/3oEjI8StnIv9YMtVnO/giphy.gif',false,'depresso',8,2),
(DEFAULT, 'NOT FOUND','https://media2.giphy.com/media/qQdL532ZANbjy/giphy.gif?cid=ecf05e47j8y8muj96ylwzhs7k57rzcxfz9kasa5y6sy2851u&rid=giphy.gif&ct=g',false,'Complicado',8,3);
SELECT * FROM publicacao;



desc feedback;
INSERT INTO feedback VALUES
(DEFAULT, 'Muito engraçado!','Adorei! Ri muito com meu filho!',true,6,1),
(DEFAULT, 'Calmo','Achei bem calmo',true,7,2),
(DEFAULT, 'Impressionante','Como ele consegue fazer tamanhos movimentos?',true,6,3),
(DEFAULT, 'Nem brincando','HAHAAHHAAHAH',true,8,4),
(DEFAULT, 'Profundo','Mexeu muito comigo essa arte, merece a doação',true,9,5),
(DEFAULT, 'Tocante','HEHE BOY',true,1,6);


desc doacao;
INSERT INTO doacao value
(DEFAULT,30.50,1,6,1),
(DEFAULT,60.50,2,7,2),
(DEFAULT,109,3,8,3),
(DEFAULT,90,4,9,4),
(DEFAULT,70,5,3,5);

INSERT INTO formaPag_artista VALUES 
(1,1),(2,2),(3,3),(4,4),(5,5);

INSERT INTO publicacao_categoria VALUES
(1,3),(2,7),(3,8),(4,9),(5,10),(6,11);

INSERT INTO artista_Categoria VALUES
(1,3),(2,7),(3,8),(4,9),(5,10),(5,11);

INSERT INTO usuario_recompensa VALUES
(1,1),(1,2),(1,3),(1,4),(1,5);


desc seguidores;

INSERT INTO seguidores VALUES (1,5),
(2,10),
(4,9),
(5,2),
(1,10),
(3,2);


select * from artista;
select * from usuario;




/*Select usuario_recompensa*/
select u.nome,r.nome from usuario as u	
join recompensa as r join usuario_recompensa as ur
on ur.id_recompensa = r.id_recompensa and ur.id_usuario = u.id_usuario;

/*Faz select dos apelidos dos usuarios que ganharam doaçoes */
select u.apelido FROM usuario as u join artista as a on u.id_usuario = a.id_usuario;
 
 /*Faz o select da publicacao no feed com o usuario que postou */
select u.foto_perfil,u.apelido,p.conteudo, p.descricao from publicacao as p  
join artista as a
join usuario as u 
on p.id_artista = a.id_artista and u.id_usuario = a.id_usuario;

/*Faz um select da tabela de doação é me mostra 
Quem doou , quanto do dou é para quem doou*/ 
select
u.nome as nome_doador,
u.sobrenome as sobrenome_doador,
d.valor,c.apelido_artista, c.nome_artista, c.sobrenome_artista
from usuario as u -- Dá um apelido para tabela usuario
join doacao  as d -- Dá um apelido para tabela doação
join artista as a -- Dá um apelido para tabela artista
join(-- select dentro de um join, esse select serve para pegar o apelido do artista
     select
     u.apelido    as apelido_artista,
     d.id_doacao  as id_doacao, 
     u.nome       as nome_artista,
     u.sobrenome  as sobrenome_artista
	 from usuario as u 
     join artista as a
     join doacao  as  d 
     on u.id_usuario  = a.id_usuario 
     and d.id_artista = a.id_artista) AS c
	
 on d.id_usuario  = u.id_usuario 
 and a.id_artista = d.id_artista 
 and d.id_doacao  = c.id_doacao;


SELECT u.id_usuario,a.id_artista,u.apelido,p.descricao FROM publicacao AS p 
JOIN seguidores AS s
JOIN usuario    AS u
JOIN artista    AS a 
WHERE  p.id_artista = a.id_artista
AND    s.id_artista = a.id_artista
AND    s.id_usuario = u.id_usuario 
AND    u.id_usuario = 2;

SELECT distinct s.id_artista,pu.apelido,pu.foto_perfil, p.descricao FROM seguidores as s
join publicacao as p 
join vw_post_user as pu 
where s.id_usuario = 9
AND s.id_artista = pu.id_artista
AND p.id_artista = s.id_artista;


SELECT u.id_usuario, u.apelido, a.descricao, p.descricao, p.conteudo FROM usuario AS u 
JOIN publicacao AS p
JOIN artista    AS a
ON u.id_usuario = a.id_usuario
AND p.id_artista = a.id_artista
WHERE u.id_usuario = 5;
















Select distinct * from publicacao;