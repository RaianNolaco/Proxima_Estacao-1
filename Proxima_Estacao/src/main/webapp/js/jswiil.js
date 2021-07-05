function showCaixa () {

    var caixa = document.getElementById("CaixaDeCoc");
    if (caixa.style.display != "flex")
    {
        caixa.style.display = "flex";
    } else
    {
        caixa.style.display = "none";
    }
}   
function showP () {

    var pub = document.getElementById("caixaDeAdd");
    if (pub.style.display != "flex")
    {
        pub.style.display = "flex";
    } else
    {
        pub.style.display = "none";
    }
} 
function showN () {

    var not = document.getElementById("caixaDeNot");
    if (not.style.display != "flex")
    {
        not.style.display = "flex";
    } else
    {
        not.style.display = "none";
    }
} 
function curtir () {
    var curtir = document.getElementById("curtir");
    if (curtir.style.color != "gray"){
        curtir.style.color = "gray";
    }
    else{
        curtir.style.color = "red"
    }
}
function showO () {

    var opt = document.getElementById("Option");
    if (opt.style.display != "flex")
    {
        opt.style.display = "flex";
    } else
    {
        opt.style.display = "none";
    }
} 
function showD () {

    var denu = document.getElementById("Denunciar");
    if (denu.style.display != "flex")
    {
        denu.style.display = "flex";
    } else
    {
        denu.style.display = "none";
    }
}  