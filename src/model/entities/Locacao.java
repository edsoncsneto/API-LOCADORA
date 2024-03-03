package model.entities;

import java.time.LocalDate;

public class Locacao {
	
	private Integer codLocacao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Cliente cliente;
	private Funcionario funcionario;
	
	public Locacao() {
	}
	
	public Locacao(Integer codLocacao, LocalDate dataInicio, LocalDate dataFim, Cliente cliente,
			Funcionario funcionario) {
		this.codLocacao = codLocacao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	public Integer getCodLocacao() {
		return codLocacao;
	}

	public void setCodLocacao(Integer codLocacao) {
		this.codLocacao = codLocacao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
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
				"\ncodLocacao=" + codLocacao +
				"\ndataInicio=" + dataInicio +
				"\ndataFim=" + dataFim +
				"\nCliente: " + 
				"\nnome=" + cliente.getNome() +
				"\ncpf=" + cliente.getCep() +
				"\nFuncionario=" + 
				"\nnome=" + funcionario.getNome() +
				"\ncpf=" + funcionario.getCpf();
	}

}
