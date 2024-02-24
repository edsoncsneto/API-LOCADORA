package application;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Veiculo;

public class Program {

	public static void main(String[] args) {
		
		GenericDao veiculoDao  = DaoFactory.createVeiculoDao();
		
		System.out.println("=== TESTE 01: insert veiculo");
		Veiculo veiculo = new Veiculo("Teste56", "Teste", "Teste", "Teste", "Teste123456789101", "Teste");
		veiculoDao.insert(veiculo);
		System.out.println("Inserido! Placa da inserção: " + veiculo.getPlaca());
		
		
	}

}
