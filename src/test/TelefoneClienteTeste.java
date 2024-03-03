package test;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Cliente;
import model.entities.TelefoneCliente;

public class TelefoneClienteTeste {

	public static void main(String[] args) {
		
		GenericDao tcDao = DaoFactory.createTelefoneClienteDao();
		GenericDao clienteDao = DaoFactory.createClienteDao();

		System.out.println("=== TESTE 01: insert telefoneCliente");
		Cliente cliente = (Cliente) clienteDao.findById("11111111111");
		TelefoneCliente telefoneCliente = new TelefoneCliente(cliente, "87999994315");
		//tcDao.insert(telefoneCliente);
		System.out.println("TelefoneCliente inserido! Telefone: " + telefoneCliente.getTelefone());
		System.out.println();
		
		System.out.println("=== TESTE 02: update telefoneCliente");
		telefoneCliente.setTelefone("87999994311");
		tcDao.update(telefoneCliente);
		System.out.println("Atualizado! Novo telefone: " + telefoneCliente.getTelefone());
		System.out.println();
		
		System.out.println("=== TESTE 03: deleteById telefoneCliente");
		//tcDao.deleteById("44433322288");
		System.out.println("Deletado!");
		System.out.println();
		
		System.out.println("=== TESTE 04: findById");
		TelefoneCliente tc = (TelefoneCliente) tcDao.findById("11111111111");
		System.out.println(tc);
		System.out.println();
		
		System.out.println("=== TESTE 03: findAll");
		List<TelefoneCliente> list = tcDao.findAll();
		for (TelefoneCliente tc1 : list) {
			System.out.println(tc1);
			System.out.println();
		}
	}

}
