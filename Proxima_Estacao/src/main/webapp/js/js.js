/*Função destinada a abrir a lista de entretenimento*/
function func(obj) {
    var hq = document.querySelectorAll(".hq .parte, .hq .parte-reversa");
    var jogo = document.querySelectorAll(".jogo .parte, .jogo .parte-reversa");
    var desenho = document.querySelectorAll(".desenho .parte, .desenho .parte-reversa");
    var filme = document.querySelectorAll(".filme .parte, .filme .parte-reversa");

    if (obj.id === "clickHq") {
        var u = hq;
    } else if (obj.id === "clickJogo") {
        var u = jogo;
    } else if (obj.id === "clickDesenho") {
        var u = desenho;
    } else if (obj.id === "clickFilme") {
        var u = filme;
    }

    for (var i = 0; i < u.length; i++) {
        if (u[i].style.display != "flex") {
            u[i].style.display = "flex";
        }
        else {
            u[i].style.display = "none";
        }
    }
}

function saibaMais(obj) {
    var bannerViagem = document.getElementsByClassName('viagem')
    var bannerPessoal = document.getElementsByClassName('pessoal')
    var bannerProfi = document.getElementsByClassName('profissional')
    
    var imgViagem = document.getElementById("img_viagem")
    var tituloViagem = document.getElementById("titulo_viagem")
    
    var imgPessoal = document.getElementById("img_pessoal")
    var tituloPessoal = document.getElementById("titulo_pessoal")
    
    var imgProfi = document.getElementById("img_profi")
    var tituloProfi = document.getElementById("titulo_profi")
    
    var botaoViagem = document.getElementById("viagem_saiba")
    var botaoPessoal = document.getElementById("pessoal_saiba")
    var botaoProfi = document.getElementById("profi_saiba")
    
    var brasil = document.getElementsByClassName("brasil")
    var pessoal = document.getElementsByClassName("sonho_pessoal")
    var profi = document.getElementsByClassName("sonho_profi")

    if(obj.id === "viagem_saiba"){
        var banner = bannerViagem;
        var u = brasil;
        var img = imgViagem
        var titulo = tituloViagem
        var botao = botaoViagem 
    }else if(obj.id === "pessoal_saiba"){
        var banner = bannerPessoal;
        var u = pessoal;
        var img = imgPessoal
        var titulo = tituloPessoal
        var botao = botaoPessoal 
    }else if(obj.id === "profi_saiba"){
        var banner = bannerProfi;
        var u = profi;
        var img = imgProfi
        var titulo = tituloProfi
        var botao = botaoProfi
    
    }

    for (var i = 0; i < banner.length; i++) {
        img.style.display = "none"
        titulo.style.display = "none"
        botao.style.display = "none"
        banner[i].style.display = "flex"
        u[i].style.display = "flex"

    }
}

function fecharBanner(obj) {
    var banner = document.getElementsByClassName('banner')

    var bannerViagem = document.getElementsByClassName('viagem')
    var bannerPessoal = document.getElementsByClassName('pessoal')
    var bannerProfi = document.getElementsByClassName('profissional')

    var imgViagem = document.getElementById("img_viagem")
    var tituloViagem = document.getElementById("titulo_viagem")
    
    var imgPessoal = document.getElementById("img_pessoal")
    var tituloPessoal = document.getElementById("titulo_pessoal")
    
    var imgProfi = document.getElementById("img_profi")
    var tituloProfi = document.getElementById("titulo_profi")

    var botaoViagem = document.getElementById("viagem_saiba")
    var botaoPessoal = document.getElementById("pessoal_saiba")
    var botaoProfi = document.getElementById("profi_saiba")
    
    var brasil = document.getElementsByClassName("brasil")
    var canada = document.getElementsByClassName("canada")
    var america = document.getElementsByClassName("america")
    var outro = document.getElementsByClassName("outro")
    var pessoal = document.getElementsByClassName("sonho_pessoal")
    var profi = document.getElementsByClassName("sonho_profi")

    if (obj.id === "fechar_brasil") {
        var u = brasil
        var b = bannerViagem
        var botao = botaoViagem 
        var img = imgViagem
        var titulo = tituloViagem
        
    } else if (obj.id === "fechar_canada") {
        var u = canada
        var b = bannerViagem
        var botao = botaoViagem 
        var img = imgViagem
        var titulo = tituloViagem
        
    } else if (obj.id === "fechar_america") {
        var u = america
        var b = bannerViagem
        var botao = botaoViagem 
        var img = imgViagem
        var titulo = tituloViagem
        
    } else if (obj.id === "fechar_outro") {
        var u = outro
        var b = bannerViagem
        var botao = botaoViagem 
        var img = imgViagem
        var titulo = tituloViagem
        
    } else if (obj.id === "fechar_pessoal") {
        var u = pessoal
        var b = bannerPessoal
        var botao = botaoPessoal 
        var img = imgPessoal
        var titulo = tituloPessoal
        
    } else if (obj.id === "fechar_profi") {
        var u = profi
        var b = bannerProfi
        var botao = botaoProfi
        var img = imgProfi
        var titulo = tituloProfi
       
    }

    for (var i = 0; i < banner.length; i++) {
        img.style.display = "flex"
        titulo.style.display = "flex"
        botao.style.display = "flex"
        b[i].style.display = "flex"
        u[i].style.display = "none"
        banner[i].style.justifyContent = "center";
    }

}

function proximoPais(obj) {

    var banner = document.getElementsByClassName("viagem");
    var brasil = document.getElementsByClassName("brasil")
    var canada = document.getElementsByClassName("canada")
    var america = document.getElementsByClassName("america")
    var outro = document.getElementsByClassName("outro")

    if (obj.id === "proximo_brasil") {
        var u = brasil;
        var v = canada;
    } else if (obj.id === "proximo_canada") {
        var u = canada;
        var v = america;
    } else if (obj.id === "proximo_america") {
        var u = america;
        var v = outro;
    } else if (obj.id === "proximo_outro") {
        var u = outro;
        var v = brasil;
    } else if (obj.id === "anterior_brasil") {
        var u = brasil;
        var v = outro;
    } else if (obj.id === "anterior_canada") {
        var u = canada;
        var v = brasil;
    } else if (obj.id === "anterior_america") {
        var u = america;
        var v = canada;
    } else if (obj.id === "anterior_outro") {
        var u = outro;
        var v = america;
    }

    for (var i = 0; i < banner.length; i++) {

        u[i].style.display = "none";
        v[i].style.display = "flex";
    }
}
