package br.com.zup.controleDeUsuarioVeiculos.DtoForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.zup.controleDeUsuarioVeiculos.modelo.Usuario;

public class UsuarioForm {

	@NotEmpty
	private String nome;
	@NotEmpty
	@Column(unique = true)
	private String email;
	@NotEmpty
	@Column(unique = true)
	@Length(min=11, max=11)
	private String cpf;
	@NotEmpty
	@Length(min=8, max=8)
	private String dataNascimento;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public Usuario converter() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDate nascimento = LocalDate.parse(dataNascimento, formato);
		return new Usuario(nome, email, cpf, nascimento);
	}

}
