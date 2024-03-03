package model.entities;

public class TelefoneCliente {
	
	private Cliente cliente;
	private String telefone;
	
	public TelefoneCliente() {
	}
	
	public TelefoneCliente(Cliente cliente, String telefone) {
		super();
		this.cliente = cliente;
		this.telefone = telefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "TelefoneCliente: "
				+ "\ncliente=" + cliente +
				"\n\ntelefone=" + telefone;
	}

}
