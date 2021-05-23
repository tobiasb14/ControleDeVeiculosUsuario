package br.com.zup.controleDeUsuarioVeiculos.DtoForm;

import br.com.zup.controleDeUsuarioVeiculos.modelo.Veiculo;

public class VeiculoDto {

	private String marca;
	private String modelo;
	private Integer ano;
	
	public VeiculoDto(Veiculo veiculo) {
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.ano = veiculo.getAno();
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Integer getAno() {
		return ano;
	}
	
}
