package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Cliente;

public class ClienteService {
	
	public static Cliente instatiateCliente(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setBairro(rs.getString("bairro"));
		cliente.setCep(rs.getString("cep"));
		cliente.setCidade(rs.getString("cidade"));
		cliente.setCnh(rs.getString("cnh"));
		cliente.setCpf(rs.getString("cpf"));
		cliente.setLogradouro(rs.getString("logradouro"));
		cliente.setNome(rs.getString("nome"));
		cliente.setNumero(rs.getString("numero"));
		cliente.setUf(rs.getString("uf"));
		
		return cliente;
	}

}
