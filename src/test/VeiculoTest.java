package test;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Veiculo;

public class VeiculoTest {

	public static void main(String[] args) {
		
		GenericDao veiculoDao  = DaoFactory.createVeiculoDao();
		
		System.out.println("=== TESTE 01: insert veiculo");
		Veiculo veiculo = new Veiculo("Teste56", "Teste", "Teste", "Teste", "Teste123456789101", "Teste");
		veiculoDao.insert(veiculo);
		System.out.println("Inserido! Placa da inserção: " + veiculo.getPlaca());
		System.out.println();
		
		System.out.println("=== TESTE 02: update veiculo");
		veiculo.setCor("Magenta");
		veiculoDao.update(veiculo);
		System.out.println("Atualizado! Cor do veiculo: "+ veiculo.getCor());
		System.out.println();
		
		System.out.println("=== TESTE 03: deleteById veiculo");
		veiculoDao.deleteById("Teste12");
		System.out.println("Deletado!");
		System.out.println();
		
		System.out.println("=== TESTE 04: findById veiculo");
		Object veiculo2 = veiculoDao.findById("Teste34");
		System.out.println(veiculo);
		System.out.println();
		
		System.out.println("===TESTE 05: findAll veiculo");
		List<Veiculo> list = veiculoDao.findAll();
		
		for (Veiculo veiculo3 : list) {
			System.out.println(veiculo3);
			System.out.println();
		}
		System.out.println();

	}

}
