<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
if(session.getAttribute("erroUser") != null)
{
    out.println("<script type=\"text/javascript\">");
    out.println("alert('Senha ou Email invalidos!');");
    out.println("</script>");
    session.invalidate();
}
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css">
<link rel="icon" href='image/logo-removebg-preview.png'
	type="image/x-icon">
<link
	href="https://fonts.googleapis.com/css?family=Raleway&display=swap"
	rel="stylesheet">
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<link rel="stylesheet" href="html/loading.html">
<title>Pagina de login</title>
</head>
<body class="pagina_login">

	<p>
		Seja bem-vindo, passageiro... <br> Acomode-se no seu acento e
		aproveite a viajem.
	</p>

	<div class="login">
		<h1>Logue em sua conta,</h1>

		<form action="loginUsuario" method="POST">
			<input type="email" name="usuarioEmail" placeholder="Seu E-mail"
				maxlength="60" required> <input type="password"
				name="usuarioSenha" placeholder="Sua senha" maxlength="15" required>
			<div>
				<a href="#">Esqueci minha senha</a>
			</div>

			<div class="logar">
				<input type="submit" value="Embarcar">
			</div>

			<p class="por">
				N�o � passageiro? <a href="html/cadastro.html">Registre-se</a>
			</p>
		</form>
	</div>
</body>
</html>