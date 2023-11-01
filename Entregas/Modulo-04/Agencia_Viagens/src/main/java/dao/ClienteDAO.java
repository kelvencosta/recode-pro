package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;
import model.Cliente;


public class ClienteDAO {
	private Connection connection;
	private String sql;

	public ClienteDAO() throws SQLException {
		connection = DatabaseConnection.createConnection();
	}

	public void criarCliente(Cliente cliente) {
		 sql = "INSERT INTO clientes (Nome, CPF, RG, Telefone, Email, Senha) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getRg());
			stmt.setString(4, cliente.getTel());
			stmt.setString(5, cliente.getEmail());
			stmt.setString(6, cliente.getSenha());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Cliente getDadosCliente(String nome) {
		
		Cliente cliente = null;
		
		sql = "SELECT * FROM clientes" + " WHERE nome = ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {

				stmt.setString(1, nome);

				ResultSet resultado = stmt.executeQuery();

				if (resultado.next()) {

					cliente = new Cliente();
					
					cliente.setCod(resultado.getInt("cod_cliente"));
					cliente.setNome(resultado.getString("nome"));
					cliente.setCpf(resultado.getString("CPF"));
					cliente.setRg(resultado.getString("RG"));
					cliente.setTel(resultado.getString("Telefone"));
					cliente.setEmail(resultado.getString("Email"));
					cliente.setSenha(resultado.getString("Senha"));

				}

			} catch (SQLException e) {

				e.printStackTrace();

			}
			
			return cliente;

		}

	
	public void atualizarCliente(Cliente cliente) {
	    sql = "UPDATE clientes SET Nome = ?, CPF = ?, RG = ?, Telefone = ?, Email = ?, Senha = ? WHERE Cod_Cliente = ?";
	   
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, cliente.getNome());
	        stmt.setString(2, cliente.getCpf());
	        stmt.setString(3, cliente.getRg());
	        stmt.setString(4, cliente.getTel());
	        stmt.setString(5, cliente.getEmail());
	        stmt.setString(6, cliente.getSenha());
	        stmt.setInt(7, cliente.getCod());
	        
		    stmt.executeUpdate();
	        

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void deletarConta(int cod) {
	    String sqlDeleteCliente = "DELETE FROM clientes WHERE Cod_Cliente = ?";

	    try (
	         PreparedStatement stmtDeleteCliente = connection.prepareStatement(sqlDeleteCliente)) {

	        stmtDeleteCliente.setInt(1, cod);
	        stmtDeleteCliente.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
