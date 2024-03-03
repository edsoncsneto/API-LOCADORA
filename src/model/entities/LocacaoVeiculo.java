package model.entities;

public class LocacaoVeiculo {
	
	Locacao locacao;
	Veiculo veiculo;
	
	public LocacaoVeiculo() {
	}
	
	public LocacaoVeiculo(Locacao locacao, Veiculo veiculo) {
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
				 "\nlocacao=" + locacao.getCodLocacao() +
				 "\nveiculo=" + veiculo.getPlaca();
	}

}
