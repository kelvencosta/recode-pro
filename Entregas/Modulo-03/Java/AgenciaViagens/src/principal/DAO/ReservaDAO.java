package principal.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import principal.Conexao;
import principal.Reserva;

public class ReservaDAO {
	private Connection conexao;
	Reserva reserva = new Reserva();
	
	public ReservaDAO() {
		try {

			conexao = Conexao.conectar();

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}
	
	
	 public void criarReserva(Reserva reserva) {
		 if (reserva.getCliente() != null) {
			
	        String sql = "INSERT INTO reservas (Data_reserva, Data_viagem, Cod_Cliente, Cod_Destino) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	        	
	            stmt.setDate(1, new Date(reserva.getDataReserva().getTime()));
	            stmt.setTimestamp(2, new java.sql.Timestamp(reserva.getDataViagem().getTime()));
	            stmt.setInt(3, reserva.getCliente().getCod());
	            stmt.setInt(4, reserva.getDestino().getCod());
	            stmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 }
	    }
	 
	 public void obterInformacoesReserva() {
	        String sql = "SELECT d.Nome AS NomeDestino, r.Data_viagem FROM reservas r " +
	                     "INNER JOIN destinos d ON r.Cod_Destino = d.Cod_Destino";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            ResultSet resultado = stmt.executeQuery();

	            while (resultado.next()) {
	                String nomeDestino = resultado.getString("NomeDestino");
	                java.sql.Date dataViagem = resultado.getDate("Data_viagem");

	                System.out.printf("Destino: %s, Data de Viagem: %s%n%n", nomeDestino, dataViagem);
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