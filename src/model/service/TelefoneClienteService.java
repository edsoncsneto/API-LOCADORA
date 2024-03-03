package model.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Cliente;
import model.entities.TelefoneCliente;

public class TelefoneClienteService {
	
	public static GenericDao clienteDao = DaoFactory.createClienteDao();

	public static TelefoneCliente instatiateTelefoneCliente(ResultSet rs) throws SQLException {
		Cliente cliente = (Cliente) clienteDao.findById(rs.getString("cpf_cliente"));
		TelefoneCliente telefoneCliente = new TelefoneCliente();
		
		telefoneCliente.setTelefone(rs.getString("telefone"));
		telefoneCliente.setCliente(cliente);
		return telefoneCliente;
	}
	
}
