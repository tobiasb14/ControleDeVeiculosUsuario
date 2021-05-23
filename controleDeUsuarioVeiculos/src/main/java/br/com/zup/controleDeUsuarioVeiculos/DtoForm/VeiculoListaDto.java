package br.com.zup.controleDeUsuarioVeiculos.DtoForm;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.controleDeUsuarioVeiculos.modelo.Veiculo;

public class VeiculoListaDto {

	private String marca;
	private String modelo;
	private String ano;
	private String diaRodizio;
	private boolean rodizioAtivo;
	
	public VeiculoListaDto(Veiculo veiculo) {
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.ano = veiculo.getAno().toString();
		this.diaRodizio = defineDiaRodizio();
		this.rodizioAtivo = verificarRodizo();
		
	}
	
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getAno() {
		return ano;
	}

	public String getDiaRodizio() {
		return diaRodizio;
	}

	public boolean isRodizioAtivo() {
		return rodizioAtivo;
	}	
	
	private String defineDiaRodizio() {
		switch (this.ano.substring(this.ano.length()-1)) {
		case "0": case "1":
			return DayOfWeek.MONDAY.toString();
		case "2": case "3":
			return DayOfWeek.TUESDAY.toString();
		case "4": case "5":
			return DayOfWeek.WEDNESDAY.toString();
		case "6": case "7":
			return DayOfWeek.THURSDAY.toString();
		case "8": case "9":
			return DayOfWeek.FRIDAY.toString();
		default:
			return "";
		}
	}
	
	private boolean verificarRodizo() {
		if (LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SATURDAY) || LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SUNDAY) 
				|| LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.valueOf(this.diaRodizio))) {
			return true;
		}
		
		return false;
	}
	
	public static List<VeiculoListaDto> converter(List<Veiculo> veiculosDoUsuario) {
		return veiculosDoUsuario.stream().map(VeiculoListaDto::new).collect(Collectors.toList());
	}
	
}
