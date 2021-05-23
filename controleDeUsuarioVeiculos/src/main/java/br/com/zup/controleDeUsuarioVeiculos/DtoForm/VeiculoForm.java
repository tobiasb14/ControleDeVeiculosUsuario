package br.com.zup.controleDeUsuarioVeiculos.DtoForm;

import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zup.controleDeUsuarioVeiculos.Repository.UsuarioRepository;
import br.com.zup.controleDeUsuarioVeiculos.modelo.Usuario;
import br.com.zup.controleDeUsuarioVeiculos.modelo.Veiculo;

public class VeiculoForm {

	@NotEmpty
	private String marca;
	@NotEmpty
	private String modelo;
	@Min(value = 1980)
	private int ano;
	@NotNull
	private Long idProprietario;

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAno() {
		return ano;
	}

	public Long getIdProprietario() {
		return idProprietario;
	}

	public Veiculo converter(UsuarioRepository usuarioRepository) {
		
		Optional<Usuario> optional = usuarioRepository.findById(idProprietario);
		
		if (optional.isPresent()) {
			return new Veiculo(marca, modelo, ano, optional.get()); 
		}
		return null;
	}

}
