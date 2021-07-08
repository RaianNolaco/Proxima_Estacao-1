package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import model.beans.Publicacao;
import model.beans.Status;
import model.beans.Usuario;
import model.dao.PublicacaoDAO;
import model.dao.UsuarioDAO;

@WebServlet(urlPatterns = { "/UsuarioController", "/loginUsuario", "/cadastroUsuario"})
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
		}else if(action.equals("/cadastroUsuario")) {
			cadastroUsuario(request, response);
		}
	}
	
	protected void loginUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		HttpSession session = request.getSession();	
		
		usuario.setEmail(request.getParameter("usuarioEmail"));
		usuario.setSenha(request.getParameter("usuarioSenha"));

		if(dao.login(usuario)){
			session.setAttribute("idUsuario", usuario.getIdUsuario());
			response.sendRedirect("HTML/loading.html");
		}else{
			response.sendRedirect("HTML/login.html");
		}	
	}
	
	protected void cadastroUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		HttpSession session = request.getSession();	
		
		
		Status status = new Status();
		status.setId_status(1);
		
		
		usuario.setNomeUsuario(request.getParameter("nomeUsuario"));
		usuario.setSobrenomeUsuario(request.getParameter("sobrenomeUsuario"));
		usuario.setApelido(request.getParameter("apelidoUsuario"));
		usuario.setEmail(request.getParameter("emailUsuario"));
		usuario.setSenha(request.getParameter("senhaUsuario"));
		usuario.setNumero(request.getParameter("usuarioTelefone"));
		usuario.setIdStatus(status);
		System.out.println(request.getParameter("aniversarioUsuario"));
		Date dataFormatada = usuario.converteData(request.getParameter("aniversarioUsuario"));
		
		System.out.println(dataFormatada);
		usuario.setData_nascimento(dataFormatada);
		
		if(dao.inserirUsuario(usuario)){
			response.sendRedirect("HTML/loading.html");
		}else{
			response.sendRedirect("HTML/cadastro.html");
		}	
	}
	
	
}
