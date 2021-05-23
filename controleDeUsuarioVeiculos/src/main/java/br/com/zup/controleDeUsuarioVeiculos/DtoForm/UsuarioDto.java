package br.com.zup.controleDeUsuarioVeiculos.DtoForm;

import br.com.zup.controleDeUsuarioVeiculos.modelo.Usuario;

public class UsuarioDto {

	private Long id;
	private String nome;
	private String cpf;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
}
