package model.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Cliente;
import model.entities.Funcionario;
import model.entities.Locacao;

public class LocacaoService {
	
	public static GenericDao clienteDao = DaoFactory.createClienteDao();
	public static GenericDao funcionarioDao = DaoFactory.createFuncionarioDao();
	public static List<Cliente> clientesCache = new ArrayList<>();
	public static List<Funcionario> funcionariosCache = new ArrayList<>();

	public static Locacao instatiateLocacao(ResultSet rs) throws SQLException {
		
		Locacao locacao = new Locacao();
		
		for (Cliente clienteAux : clientesCache) {
			if (clienteAux.getCpf() == rs.getString("cpf_cliente")) {
				locacao.setCliente(clienteAux);
			} 
		}
		
		if (locacao.getCliente() == null) {
			Cliente cliente = (Cliente) clienteDao.findById(rs.getString("cpf_cliente"));
			locacao.setCliente(cliente);
			clientesCache.add(cliente);
		}
		
		for (Funcionario funcionarioAux : funcionariosCache) {
			if (funcionarioAux.getCpf() == rs.getString("mat_funcionario")) {
				locacao.setFuncionario(funcionarioAux);
			}
		}
		
		if (locacao.getFuncionario() == null) {
			Funcionario funcionario = (Funcionario) funcionarioDao.findById(rs.getInt("mat_funcionario"));
			locacao.setFuncionario(funcionario);
			funcionariosCache.add(funcionario);
		}

		locacao.setCodLocacao(rs.getInt("cod_locacao"));
		locacao.setDataInicio(LocalDate.parse(rs.getString("data_inicio")));
		locacao.setDataFim(LocalDate.parse(rs.getString("data_fim")));
		return locacao;
	}
	
}
