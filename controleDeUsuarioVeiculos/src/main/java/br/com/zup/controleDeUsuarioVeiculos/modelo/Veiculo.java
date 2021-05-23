package br.com.zup.controleDeUsuarioVeiculos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private Integer ano;
	@ManyToOne
	private Usuario proprietario;

	public Veiculo() {
		
	}
	
	public Veiculo(String marca, String modelo, Integer ano, Usuario proprietario) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.proprietario = proprietario;
	}
	
	public Long getId() {
		return id;
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

	public Usuario getProprietario() {
		return proprietario;
	}

}
