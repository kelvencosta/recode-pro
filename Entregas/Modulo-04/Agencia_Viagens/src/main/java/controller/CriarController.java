package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet("/CriarController")
public class CriarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setRg(request.getParameter("rg"));
		cliente.setTel(request.getParameter("tel"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.criarCliente(cliente);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("ListarController?nome=" + cliente.getNome());
	}
}
