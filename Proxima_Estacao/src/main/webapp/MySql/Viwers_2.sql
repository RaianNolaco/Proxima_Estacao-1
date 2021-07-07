CREATE VIEW vw_usuario AS
SELECT usuario.id_usuario,
       usuario.nome,
       usuario.sobrenome,
       usuario.apelido
FROM usuario;     
 
select * from vw_usuario;

CREATE VIEW vw_post_seguidor AS
SELECT u.id_usuario,a.id_artista,u.apelido,p.descricao FROM publicacao AS p 
JOIN seguidores AS s
JOIN usuario    AS u
JOIN artista    AS a 
WHERE  p.id_artista = a.id_artista
AND    s.id_artista = a.id_artista
AND    s.id_usuario = u.id_usuario 
AND    u.id_usuario = 2;

select * from vw_post_seguidor;
drop view vw_post_user;

create view vw_post_user as
select u.foto_perfil,u.apelido,p.conteudo, p.descricao, a.id_artista, u.id_usuario from publicacao as p  
join artista as a
join usuario as u 
on p.id_artista = a.id_artista and u.id_usuario = a.id_usuario;

create view vw_public_seguidor as
SELECT distinct s.id_artista,pu.apelido,pu.foto_perfil, p.descricao FROM seguidores as s
join publicacao as p 
join vw_post_user as pu 
where s.id_artista = pu.id_artista
AND p.id_artista = s.id_artista;

select * from vw_public_seguidor;

select * from usuario;
-- bom dia 

-- deixa em uma hordem aleatoria
select * from usuario order by rand();

