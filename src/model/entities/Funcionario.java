package model.entities;

public class Funcionario {

	private Integer matricula;
	private String nome;
	private String cpf;
	private int quantidade_locacoes;
	
	public Funcionario() {
	}
	
	public Funcionario(Integer matricula, String nome, String cpf) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.quantidade_locacoes = 0;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getQuantidade_locacoes() {
		return quantidade_locacoes;
	}

	public void setQuantidade_locacoes(int quantidade_locacoes) {
		this.quantidade_locacoes = quantidade_locacoes;
	}

	@Override
	public String toString() {
		return "Funcionario: " +
				"\nmatricula=" + matricula +
				"\nnome=" + nome +
				"\ncpf=" + cpf +
				"\nquantidade_locacoes=" + quantidade_locacoes;
	}
	
}
