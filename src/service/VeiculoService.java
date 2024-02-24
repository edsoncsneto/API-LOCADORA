package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Veiculo;

public class VeiculoService {
	
	public static Veiculo instatiateVeiculo(ResultSet rs) throws SQLException {
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca(rs.getString("placa"));
		veiculo.setCor(rs.getString("cor"));
		veiculo.setMarca(rs.getString("marca"));
		veiculo.setCategoria(rs.getString("categoria"));
		veiculo.setChassi(rs.getString("chassi"));
		veiculo.setModelo(rs.getString("modelo"));
		return veiculo;
	}

}
