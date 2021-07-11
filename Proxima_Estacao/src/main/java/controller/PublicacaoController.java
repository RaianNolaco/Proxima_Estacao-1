package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.Publicacao;
import model.beans.Usuario;
import model.dao.PublicacaoDAO;

@WebServlet(urlPatterns = { "/PublicacaoController", "/home", "/loading"})
public class PublicacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Publicacao pub = new Publicacao();
	PublicacaoDAO  dao = new PublicacaoDAO();
	Usuario usuario = new Usuario();
	
    public PublicacaoController() {
       super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String action = request.getServletPath();
		System.out.println(action);
		
		if(action.equals("/home")) {
			publicacoes(request,response);
		}else if(action.equals("/loading")){
			request.getRequestDispatcher("HTML/loading.html").forward(request, response);
		}
	
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void publicacoes(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		HttpSession session = request.getSession();	
		dao = new PublicacaoDAO();		

		int idUsuario = (Integer) session.getAttribute("idUsuario");
		usuario.setIdUsuario(idUsuario);
		System.out.println(idUsuario);
		List<Publicacao> listaPubs = dao.listarPublicacaoSeguidor(usuario);
		// Encaminhar a lista ao documento homeK.jsp
		request.setAttribute("home", listaPubs);
		RequestDispatcher rd = request.getRequestDispatcher("HTML/homeK.jsp");
		rd.forward(request, response);	
	}

}
