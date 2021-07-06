package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Usuario;
import model.dao.UsuarioDAO;

@WebServlet(urlPatterns = { "/UsuarioController", "/login"})
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Usuario usuario = new Usuario();
	UsuarioDAO  dao = new UsuarioDAO();
	
    public UsuarioController() {
       super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		if(action.equals("/login")) {
			loginUsuario(request, response);
		}
	}

	protected void loginUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		usuario.setEmail(request.getParameter("emailUsuario"));
		usuario.setSenha(request.getParameter("senhaUsuario"));
		
		if(dao.login(usuario)){
			response.sendRedirect("publicacoes");
		}else{
			System.out.println("ERRRROOOOPUB");
		}	
	}
}
