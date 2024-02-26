package test;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.GenericDao;
import model.entities.Funcionario;

public class FuncionarioTest {

	public static void main(String[] args) {
		
		GenericDao funcionarioDao = DaoFactory.createFuncionarioDao();	
		
		System.out.println("=== TESTE 01: insert funcionario");
		Funcionario funcionario = new Funcionario(null, "TesteCPF", "09102071435");
		funcionarioDao.insert(funcionario);
		System.out.println("Inserido! Matricula do funcionario: " + funcionario.getMatricula());
		System.out.println();
		
		System.out.println("=== TESTE 02: update funcionario");
		funcionario.setCpf("09102071436");
		funcionario.setNome("Edson Costa");
//		funcionarioDao.update(funcionario);
		System.out.println("Atualizado! CPF e nome do funcionario: " + funcionario.getCpf() + funcionario.getNome());
		System.out.println();

		System.out.println("=== TESTE 03: deleteById funcionario");
//		funcionarioDao.deleteById(4);
		System.out.println("Deletado!");
		System.out.println();
		
		System.out.println("=== TESTE 04: getById funcionario");
		Object funcionarioF = funcionarioDao.findById(10); //Juliana Oliveira
		System.out.println(funcionarioF);
		System.out.println();
		
		System.out.println("===TESTE 05: findAll funcionario");
		List<Funcionario> list = funcionarioDao.findAll();
		for(Funcionario f : list) {
			System.out.println(f);
			System.out.println();
		}
		
	}

}
