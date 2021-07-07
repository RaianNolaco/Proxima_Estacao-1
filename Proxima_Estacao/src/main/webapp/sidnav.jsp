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