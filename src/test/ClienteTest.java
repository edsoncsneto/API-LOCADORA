package test;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Cliente;

public class ClienteTest {
	
	public static void main(String[] args) {
		
		GenericDao clienteDao = DaoFactory.createClienteDao();
		
		System.out.println("=== TESTE 01: insert cliente");
		Cliente cliente = new Cliente("11111111111", "Teste", "1111111111", "Bairro", "1", "Logradouro", "Cidade", "UF", "11111111");
//		clienteDao.insert(cliente);
		System.out.println("Inserido! CPF: " + cliente.getCpf());
		System.out.println();
		
		System.out.println("=== TESTE 02: update cliente");
		cliente.setNome("Edson Costa");
		clienteDao.update(cliente);
		System.out.println("Atualizado! Nome do cliente: " + cliente.getNome());
		System.out.println();
		
		System.out.println("=== TESTE 03: deleteById cliente");
//		clienteDao.deleteById();
		System.out.println("Deletado!");
		System.out.println();
		
		System.out.println("=== TESTE 04: findById cliente");
		Object cliente2 = clienteDao.findById("12345678901");
		System.out.println(cliente2);
		System.out.println();
		
		System.out.println("=== TESTE 05: findAll cliente");
		List<Cliente> list = clienteDao.findAll();
		
		for(Cliente cliente3 : list) {
			System.out.println(cliente3);
			System.out.println();
		}
		System.out.println();
		
	}

}
