package model.entities;

public class LocacaoVeiculo {
	
	Locacao locacao;
	Veiculo veiculo;
	
	public LocacaoVeiculo(Locacao locacao, Veiculo veiculo) {
		super();
		this.locacao = locacao;
		this.veiculo = veiculo;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public String toString() {
		return "LocacaoVeiculo: " +
				 "locacao=" + locacao.getCod_locacao() +
				 "veiculo=" + veiculo.getPlaca();
	}

}
