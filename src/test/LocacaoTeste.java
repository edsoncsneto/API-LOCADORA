package test;

import java.time.LocalDate;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Cliente;
import model.entities.Funcionario;
import model.entities.Locacao;

public class LocacaoTeste {

	public static void main(String[] args) {
		
		GenericDao clienteDao = DaoFactory.createClienteDao();
		GenericDao funcionarioDao = DaoFactory.createFuncionarioDao();
		GenericDao locacaoDao = DaoFactory.createLocacaoDao();
		
		System.out.println("=== TESTE 01: insert locacao");
		Cliente cliente = (Cliente) clienteDao.findById("33322211155");
		Funcionario funcionario = (Funcionario) funcionarioDao.findById(7);
		Locacao locacao = new Locacao(12, LocalDate.parse("2024-03-04"), LocalDate.parse("2024-03-10"), cliente, funcionario);
//		locacaoDao.insert(locacao);
		System.out.println("Locação inserida! Código da locacação: " + locacao.getCodLocacao());
		System.out.println();
		
		System.out.println("=== TESTE 02: update locacao");
		locacao.setDataInicio(LocalDate.parse("2024-03-05"));
		locacaoDao.update(locacao);
		System.out.println(locacao);
		System.out.println("Atualizado! Nova data de início: " + locacao.getDataInicio());
		System.out.println();
		
		System.out.println("=== TESTE 03: deleteById locacao");
//		locacaoDao.deleteById(7);
		System.out.println("Deletado!");
		System.out.println();
		
		System.out.println("=== TESTE 04: findById locacao");
		Locacao locacao2 = (Locacao) locacaoDao.findById(2);
		System.out.println(locacao2);
		System.out.println();
		
		System.out.println("=== TESTE 05: findAll locacao");
		List<Locacao> list = locacaoDao.findAll();
		for (Locacao locacao3 : list) {
			System.out.println(locacao3);
			System.out.println();
			
		}
	}
	
}
