package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Destino;

public class DestinoDAO {
	private Connection conexao;

	public DestinoDAO() {
		try {

			conexao = Conexao.conectar();

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}
	
	public List<Destino> listarDestinos() {

		List<Destino> destinos = new ArrayList<>();

		String sql = "SELECT * FROM destinos";

		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

			ResultSet resultado = stmt.executeQuery();

			while (resultado.next()) {

				Destino destino = new Destino();

				destino.setCod(resultado.getInt("Cod_Destino"));

				destino.setNome(resultado.getString("Nome"));

				destino.setPais(resultado.getString("Pais"));
				
				destino.setValor(resultado.getDouble("Valor"));

				destinos.add(destino);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return destinos;

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