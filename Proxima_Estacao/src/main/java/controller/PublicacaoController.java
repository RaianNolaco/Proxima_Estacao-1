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
import model.dao.PublicacaoDAO;

@WebServlet(urlPatterns = { "/PublicacaoController", "/publicacoes"})
public class PublicacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Publicacao pub = new Publicacao();
	PublicacaoDAO  dao = new PublicacaoDAO();
	
    public PublicacaoController() {
       super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		if(action.equals("/publicacoes")) {
			publicacoes(request, response);
		}
	}

	protected void publicacoes(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
//		List<Publicacao> listaPublicacao = dao.listarPublicacao();
//		// Encaminhar a lista ao documento livro.jsp
//		request.setAttribute("publicacoes", listaPublicacao);
		RequestDispatcher rd = request.getRequestDispatcher("html/homeK.html");
		rd.forward(request, response);
	}

}
