package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;


@WebServlet("/ListarController")
public class ListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome"); 
		
		Cliente cliente = new Cliente();
	    ClienteDAO cdao;
		
	    try {
			cdao = new ClienteDAO();
			cliente = cdao.getDadosCliente(nome);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    request.setAttribute("cliente", cliente);
	    
		RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
		dispatcher.forward(request, response);
	}
}
