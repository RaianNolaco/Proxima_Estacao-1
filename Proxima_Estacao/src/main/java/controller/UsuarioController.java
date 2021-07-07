package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Publicacao;
import model.beans.Usuario;
import model.dao.PublicacaoDAO;
import model.dao.UsuarioDAO;

@WebServlet(urlPatterns = { "/UsuarioController", "/loginUsuario"})
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Usuario usuario = new Usuario();
	UsuarioDAO  dao = new UsuarioDAO();
	PublicacaoDAO  pudao = new PublicacaoDAO();
	
    public UsuarioController() {
       super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		if(action.equals("/loginUsuario")) {
			loginUsuario(request, response);
		}
	}
	
	
	protected void publicacoes(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		List<Publicacao> listaPubs = pudao.listarPublicacao();
		// Encaminhar a lista ao documento livro.jsp
		request.setAttribute("publicacoes", listaPubs);
		RequestDispatcher rd = request.getRequestDispatcher("HTML/loading.html");
		rd.forward(request, response);
	}

	protected void loginUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		usuario.setEmail(request.getParameter("usuarioEmail"));
		usuario.setSenha(request.getParameter("usuarioSenha"));

		
		
		if(dao.login(usuario)){
			System.out.println(usuario.getEmail());
			response.sendRedirect("publicacoes");
		}else{
			   System.out.println("<script type=\"text/javascript\">");
			   System.out.println("alert('User or password incorrect');");
			   System.out.println("location='index.jsp';");
			   System.out.println("</script>");
		}	
	}
	
	
}
