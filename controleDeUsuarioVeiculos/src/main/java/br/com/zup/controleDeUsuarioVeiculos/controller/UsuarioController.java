package br.com.zup.controleDeUsuarioVeiculos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.controleDeUsuarioVeiculos.DtoForm.UsuarioDto;
import br.com.zup.controleDeUsuarioVeiculos.DtoForm.UsuarioForm;
import br.com.zup.controleDeUsuarioVeiculos.DtoForm.VeiculoListaDto;
import br.com.zup.controleDeUsuarioVeiculos.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
		
		return usuarioService.cadastrarUsuario(form, uriBuilder);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<VeiculoListaDto>> listarVeiculosPorUsuario(@PathVariable Long id) {
		
		return usuarioService.listarVeiculosPorUsuario(id);
	}
}
