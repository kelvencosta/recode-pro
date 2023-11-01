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



@WebServlet("/EditarController")
public class EditarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDAO cdao;
		
		
		String nomeCliente = request.getParameter("nome");
		
		try {
			cdao = new ClienteDAO();
			Cliente  cliente = cdao.getDadosCliente(nomeCliente);
			request.setAttribute("cliente", cliente);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editar.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente clienteEditato = new Cliente();
	
		clienteEditato.setCod(Integer.parseInt(request.getParameter("cod")));
		clienteEditato.setNome(request.getParameter("nome"));
		clienteEditato.setCpf(request.getParameter("cpf"));
		clienteEditato.setRg(request.getParameter("rg"));
		clienteEditato.setTel(request.getParameter("tel"));
		clienteEditato.setEmail(request.getParameter("email"));
		clienteEditato.setSenha(request.getParameter("senha"));
		
		
		ClienteDAO cdao;
		try {
			cdao = new ClienteDAO();
			cdao.atualizarCliente(clienteEditato);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		response.sendRedirect("ListarController?nome=" + clienteEditato.getNome());
	}
}
