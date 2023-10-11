package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import principal.Cliente;
import principal.Conexao;

public class ClienteDAO {
	private Connection conexao;

	public ClienteDAO() {
		try {

			conexao = Conexao.conectar();

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public void criarCliente(Cliente cliente) {
		String sql = "INSERT INTO clientes (Nome, CPF, RG, Telefone, Email) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getRg());
			stmt.setString(4, cliente.getTel());
			stmt.setString(5, cliente.getEmail());

			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public Cliente mostrarDados(String nome) {
		
		Cliente cliente = null;
		
		String sql = "SELECT * FROM clientes" + " WHERE nome = ?";
			
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

				stmt.setString(1, nome);

				ResultSet resultado = stmt.executeQuery();

				if (resultado.next()) {

					cliente = new Cliente();

					cliente.setCod(resultado.getInt("Cod_Cliente"));

					cliente.setNome(resultado.getString("nome"));

					cliente.setCpf(resultado.getString("CPF"));
					
					cliente.setRg(resultado.getString("RG"));
					
					cliente.setTel(resultado.getString("Telefone"));
					
					cliente.setEmail(resultado.getString("Email"));

				}

			} catch (SQLException e) {

				e.printStackTrace();

			}

			return cliente;

		}
	
	public int obterCodigoClientePorCPF(String cpf) {
	    String sql = "SELECT Cod_Cliente FROM clientes WHERE CPF = ?";
	    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        stmt.setString(1, cpf);
	        ResultSet resultado = stmt.executeQuery();
	        if (resultado.next()) {
	            return resultado.getInt("Cod_Cliente");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1; // Retorna -1 se o cliente não for encontrado
	}

	public int obterUltimoCodigoCliente() {
	    String sql = "SELECT MAX(Cod_Cliente) as MaxCod FROM clientes";
	    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        ResultSet resultado = stmt.executeQuery();
	        if (resultado.next()) {
	            return resultado.getInt("MaxCod");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1; // Retorna -1 se não houver clientes no banco de dados
	}

	
	public Cliente mostrarDadosPorCPF(String cpf) {
	    Cliente cliente = null;

	    String sql = "SELECT * FROM clientes WHERE CPF = ?";

	    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        stmt.setString(1, cpf);
	        ResultSet resultado = stmt.executeQuery();

	        if (resultado.next()) {
	            cliente = new Cliente();
	            cliente.setCod(resultado.getInt("Cod_Cliente"));
	            cliente.setNome(resultado.getString("Nome"));
	            cliente.setCpf(resultado.getString("CPF"));
	            cliente.setRg(resultado.getString("RG"));
	            cliente.setTel(resultado.getString("Telefone"));
	            cliente.setEmail(resultado.getString("Email"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return cliente;
	}
	
	public int obterCodigoClientePorNome(String nome) {
	    String sql = "SELECT Cod_Cliente FROM clientes WHERE Nome = ?";
	    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        stmt.setString(1, nome);
	        ResultSet resultado = stmt.executeQuery();
	        if (resultado.next()) {
	            return resultado.getInt("Cod_Cliente");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1; // Retorna -1 se o cliente não for encontrado
	}

	
	public int deletarConta(String nome, String cpf) {
	    String sqlDeleteReservas = "DELETE FROM reservas WHERE Cod_Cliente = ?";
	    String sqlDeleteCliente = "DELETE FROM clientes WHERE Nome = ? AND CPF = ?";

	    int linhasAfetadas = 0;

	    try (PreparedStatement stmtDeleteReservas = conexao.prepareStatement(sqlDeleteReservas);
	         PreparedStatement stmtDeleteCliente = conexao.prepareStatement(sqlDeleteCliente)) {

	        // Primeiro, deletamos as reservas associadas ao cliente
	        stmtDeleteReservas.setInt(1, obterCodigoClientePorNome(nome));
	        linhasAfetadas += stmtDeleteReservas.executeUpdate();

	        // Em seguida, deletamos o cliente
	        stmtDeleteCliente.setString(1, nome);
	        stmtDeleteCliente.setString(2, cpf);
	        linhasAfetadas += stmtDeleteCliente.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return linhasAfetadas;
	}

	
	public void atualizarCliente(Cliente cliente) {
	    String sql = "UPDATE clientes SET Nome = ?, CPF = ?, RG = ?, Telefone = ?, Email = ? WHERE Cod_Cliente = ?";

	    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        stmt.setString(1, cliente.getNome());
	        stmt.setString(2, cliente.getCpf());
	        stmt.setString(3, cliente.getRg());
	        stmt.setString(4, cliente.getTel());
	        stmt.setString(5, cliente.getEmail());
	        stmt.setInt(6, cliente.getCod());

	        int linhasAfetadas = stmt.executeUpdate();

	        if (linhasAfetadas > 0) {
	            System.out.println("Cliente atualizado com sucesso.");
	        } else {
	            System.out.println("Não foi possível atualizar o cliente.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void fecharConexao() {
		try {
			if (conexao != null && !conexao.isClosed()) {

				conexao.close();

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}
}
