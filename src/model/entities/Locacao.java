package model.entities;

import java.time.LocalDate;

public class Locacao {
	
	private int cod_locacao;
	private LocalDate data_inicio;
	private LocalDate data_fim;
	private Cliente cliente;
	private Funcionario funcionario;
	
	public Locacao(int cod_locacao, LocalDate data_inicio, LocalDate data_fim, Cliente cliente,
			Funcionario funcionario) {
		super();
		this.cod_locacao = cod_locacao;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public int getCod_locacao() {
		return cod_locacao;
	}

	public void setCod_locacao(int cod_locacao) {
		this.cod_locacao = cod_locacao;
	}

	public LocalDate getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}

	public LocalDate getData_fim() {
		return data_fim;
	}

	public void setData_fim(LocalDate data_fim) {
		this.data_fim = data_fim;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Locacao: " +
				"cod_locacao=" + cod_locacao +
				"data_inicio=" + data_inicio +
				"data_fim=" + data_fim +
				"Cliente: " + 
				"nome=" + cliente.getNome() +
				"cpf=" + cliente.getCep() +
				"Funcionario=" + 
				"nome=" + funcionario.getNome() +
				"cpf=" + funcionario.getCpf();
	}

}
