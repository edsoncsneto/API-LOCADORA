package model.entities;

public class Veiculo {
	
	private String placa;
	private String cor;
	private String marca;
	private String categoria;
	private String chassi;
	private String modelo;
	
	public Veiculo() {
	}
	
	public Veiculo(String placa, String cor, String marca, String categoria, String chassi, String modelo) {
		this.placa = placa;
		this.cor = cor;
		this.marca = marca;
		this.categoria = categoria;
		this.chassi = chassi;
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Veiculo: " +
				"\nplaca=" + placa +
				"\ncor=" + cor +
				"\nmarca=" + marca +
				"\ncategoria=" + categoria +
				"\nchassi=" + chassi +
				"\nmodelo=" + modelo;
	}
	
	

}
