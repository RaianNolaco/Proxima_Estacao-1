<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import= "model.beans.Usuario"  %> 
    <%@ page import= "model.beans.Publicacao"  %> 
    <%@ page import= "model.beans.Artista"  %> 
    <%@ page import= "model.dao.PublicacaoDAO" %>  
    <%@ page import= "java.util.ArrayList"  %>
    
    	<%PublicacaoDAO pubdao = new PublicacaoDAO(); 
    		   Artista artista = new Artista(); 
    		   Usuario usuario = new Usuario();
    		   int idUsuario = (Integer) session.getAttribute("idUsuario");
    		   usuario.setIdUsuario(idUsuario);
    		   
    		   %>   		 
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="theme-color" content="#9d4edd">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/styleK.css">
    <link rel="icon" href='../image/logo-removebg-preview.png' type="image/x-icon">
    <title>Index_proxima_estação</title>
    <script src="../js/jswiil.js"></script>
</head>
<body>
    <header class="cabecalho">
    
        <div class="boxLogo">
            <a href="homeK.jsp">
                <img src="../image/train.png" alt="">
             </a>
        </div>

        <div class="boxtexto">
            <form action="" class="search-bar" >
                <input type="search" id="txtBusca" class="search-text">
            </form>
            <i class="fas fa-search"></i>
        </div>
            

        <div class="boxIcones">
            <ul>
                <li>
                    <a href="" id="tempo">
                        <i class="fas fa-cloud-sun"></i>
                    </a>
                </li>
                <li>
                    <span  onclick="showCaixa()">
                        <img src="../image/Kepler.jpg" alt="">
                    </span>

                    <div id="CaixaDeCoc">
                        <ul>
                            <li>
                                <a href="perfil.html">
                                    Perfil
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    configurações
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    adicionar contas
                                </a>
                            </li>
                        </ul>
                        <ul>
                            <li>
                                <a href="">
                                    Suporte
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    Feedback
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    privacidade e segurança
                                </a>
                            </li>
                        </ul>
                        <div>
                            <h5>PROXIMA ESTAÇÃO</h5>
                            <h6>2021 - Proa</h6>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </header>

<nav class="sidnav">
    <ul>
        <li>
            <a href="descubra.html">
                <img src="../image/terra.png" alt="">
            </a>
        </li>
        <li>
            <button onclick="showN()">
                <img src="../image/notificacao.png" alt="">
            </button>
            <div id="caixaDeNot">
                <article class="caixaDeNot_Box">
                    <div></div>
                    <h3>notificações</h3>
                    <div></div>
                    <h3>Missões</h3>
                </article>
                <div class="conteudo">
                    <picture>
                        <img src="../image/medalha_de_fogo" alt="">
                    </picture>
                    <div class="Missao">
                        <h6>
                            0/1
                        </h6>
                        <h5>
                             Pegando Fogo!
                        </h5>
                        <p>
                            Conquiste <span>5 seguidores</span>
                        </p>
                    </div>
                </div>
                <div class="conteudo">
                    <picture>
                        <img src="../image/medalha_de_feed_cheio" alt="">
                    </picture>

                    <div class="Missao">
                        <h6>
                            0/1
                        </h6>
                        <h5>
                             Pegando Fogo!
                        </h5>
                        <p>
                            Conquiste <span>5 seguidores</span>
                        </p>
                    </div>
                </div>
                <div class="conteudo">
                    <picture>
                        <img src="../image/dinheiro.png" alt="">
                    </picture>

                    <div class="Missao">
                        <h6>
                            0/1
                        </h6>
                        <h5>
                             Pegando Fogo!
                        </h5>
                        <p>
                            Conquiste <span>5 seguidores</span>
                        </p>
                    </div>
                </div>
            </div>
        </li>
        <li>
            <a href="homeK.html">
                <img src="../image/home.png" alt="">
            </a>
        </li>
        <li>
            <button onclick="showP()">
                <img src="../image/plus.png" alt="">
            </button>
            <div id="caixaDeAdd">
                <button onclick="showP()">
                    <i class="far fa-times-circle"></i>
                </button>
                <h2>
                    Faça uma publicação
                </h2>
                <form method="POST" class="add">
                    <label for="file">
                        <p>
                            digite algo
                        </p>

                        <hr>
        
                        <img src="../image/plus.png" alt="">
                    </label>
                    <input type="file" name="uploadfile" id="file" required>
        
                    <fieldset class="grupo" >
                        <input type="checkbox" name="Musica" id=" Musica">
                        <label for="Musica">Musica</label>
                        <input type="checkbox" name="Dança" id=" Dança">
                        <label for="Dança">Dança</label>
                        <input type="checkbox" name="Teatro" id=" Teatro">
                        <label for="Teatro">Teatro</label>
                        <input type="checkbox" name="Cinema" id="Cinema">
                        <label for="Cinema">Cinema</label>
                        <input type="checkbox" name="Literatura" id="Literatura">
                        <label for="Literatura">Literatura</label>
                        <input type="checkbox" name="artes_visuais" id="artes_visuais">
                        <label for="artes_visuais">Artes Visuais</label>
                    </fieldset>
                    <input type="submit" value="enviar">
                    <input type="reset" value="cancelar">
                </form>    
            </div>
        </li>
        <li>
            <a href="inspirações.html">
               <img src="../image/bookmark.png" alt="">
            </a>
        </li>
    </ul>
</nav>

    <main class="principal">
        <section class="home">
            <div class="boxCategoria">
                <ul>
                    <li>
                        <a href="" id="musica">Musica</a>
                    </li>
                    <li>
                        <a href="" id="dança">Dança</a>
                    </li>
                    <li>
                        <a href="" id="teatro">Teatro</a>
                    </li>
                    <li>
                        <a href="" id="cinema">Cinema</a>
                    </li>
                    <li>
                        <a href="" id="literatura">Literatura</a>
                    </li>
                    <li>
                        <a href="" id="artes_visuais">Artes visuais</a>
                    </li>
                </ul>
            </div>

            <div class="titulo">
                <h1>home</h1>
                <h2>Conteúdo de pessoas que admira</h2>
            </div>

            <div class="linha">
                <hr>
            </div>


			<!-- Aqui William -->
			<%for (Publicacao pub : pubdao.listarPublicacaoSeguidor(usuario)){%>
            <section class="caixaDeFeed">
                <div class="centro">
                    <div class="publicacao">
                        <div class="headerDaPub">
                            <div class="FotoDePerfil">
                                <img src="<%=pub.getId_artista().getId_usuario().getFotoPerfil()%>" alt="">
                                <div class="miniCaixa">
                                   <header class="miniCaixaHeader">
                                        <div class="caixaDeFoto">
                                            <img src="../image/Captura de tela 2021-05-27 225422 let.png" alt="">
                                        </div>
                                        <div class="miniHeaderNome">

                                            <h3>
                                                <%=pub.getId_artista().getId_usuario().getApelido()%>
                                            </h3>

                                        </div>
                                   </header>
                                    <div class="caixaDeNumeros">

                                        <span id="numerosDePublicacao">
                                            6 publicações
                                        </span>

                                        <span id="numerosDe">
                                            2mil admiradores
                                        </span>
                                        
                                        <span>
                                            150 admirados
                                        </span>

                                    </div>

                                    <div class="miniCaixaDePub">
                                        <div>
                                            <a href="">
                                                <img src="../image/brisa.jpg" alt="">
                                            </a>
                                        </div>
                                        <div>
                                            <a href="">
                                                <img src="../image/7171.jpg" alt="">
                                            </a>
                                        </div>
                                        <div>
                                            <a href="">
                                                <img src="../image/Caída del cabello, piel seca y otras señales de que tienes problemas de tiroides.jpg" alt="">
                                            </a>
                                        </div>
                                    </div>
                                    <div class="miniCaixaBtn">
                                        <button>
                                            doar
                                        </button>
                                        <button>
                                            admirar
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <div class="headerNome">
                                <h3>
                                    <%=pub.getId_artista().getId_usuario().getApelido()%>
                                </h3>
                                <div class="descricao">
                                    <p id="descricao">
                                        <%=pub.getDescricao()%>
                                    </p>
                                    <div id="categorias">
                                        <a href="">
                                            Musica
                                        </a>
                                    </div>
                                </div>
                                <i class="fas fa-ellipsis-h" onclick="showO ()">
                                </i>
                                <div class="boxOption" id="Option">
                                    <button id="denuciar" onclick="showD ()">
                                        Denuciar
                                    </button>
                                    <div class="linha">
                                        <hr>
                                    </div>
                                    <div class="boxDenuciar" id="Denunciar">
                                        <p>
                                            Em qual destas opções sua denuncia se encaixa ?
                                        </p>
                                        <form>
                                            <input type="checkbox" name="plagio" id="plagio">
                                            <label for="plagio">Plagio</label>
                                            <input type="checkbox" name="NSFW" id="NFSFW">
                                            <label for="NSFW">NSFW</label>
                                            <input type="checkbox" name="Spam" id="Spam">
                                            <label for="Spam">Spam</label>
                                            <input type="checkbox" name="Dicurso de odio" id="DiscursoDeOdio">
                                            <label for="DiscursoDeOdio">Discurso de odio</label>
                                            <input type="checkbox" name="Falsa" id="Falsa">
                                            <label for="Falsa">Falsa identidade</label>

                                            <input type="submit" value="Denuciar">
                                        </form>
                                    </div>
                                    <button id="Salvar">
                                        Salvar inspiração 
                                    </button>
                                </div>
                            </div>
                        </div>

                        <div class="PubImagem">
                            <img src="<%=pub.getConteudo()%>" alt="">
                        </div>

                        <div class="botoes">
                            <i class="far fa-heart" id="curtir" onclick= "curtir () " ></i>

                            <i class="far fa-comment"></i>

                            <i class="far fa-paper-plane">
                                <div class="caixaDeCompartilhar">

                                </div>
                            </i>
                        </div>
                    </div>

                    <div class="linha">
                        <hr>
                    </div>
                </div>
            </section> <!-- Até aqui kkkkkkkkkk -->
            <%}%> 
        </section>
    </main>
     <script src="https://kit.fontawesome.com/babea0d443.js" crossorigin="anonymous"></script>
</body>
</html>