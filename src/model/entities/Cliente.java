package model.entities;

public class Cliente {
	
	private String cpf;
	private String nome;
	private String cnh;
	private String bairro;
	private String numero;
	private String logradouro;
	private String cidade;
	private String uf;
	private String cep;
	
	public Cliente() {
	}
	
	public Cliente(String cpf, String nome, String cnh, String bairro, String numero, String logradouro, String cidade,
			String uf, String cep) {
		this.cpf = cpf;
		this.nome = nome;
		this.cnh = cnh;
		this.bairro = bairro;
		this.numero = numero;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Cliente: "
				+ "\ncpf=" + cpf +
				"\nnome=" + nome +
				"\ncnh=" + cnh +
				"\nbairro=" + bairro +
				"\nnumero=" + numero +
				"\nlogradouro=" + logradouro +
				"\ncidade=" + cidade +
				"\nuf=" + uf +
				"\ncep=" + cep;
	}

}
