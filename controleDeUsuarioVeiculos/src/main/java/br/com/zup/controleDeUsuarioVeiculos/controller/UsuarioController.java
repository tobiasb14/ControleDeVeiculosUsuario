package br.com.zup.controleDeUsuarioVeiculos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.controleDeUsuarioVeiculos.DtoForm.UsuarioDto;
import br.com.zup.controleDeUsuarioVeiculos.DtoForm.UsuarioForm;
import br.com.zup.controleDeUsuarioVeiculos.DtoForm.VeiculoListaDto;
import br.com.zup.controleDeUsuarioVeiculos.Repository.UsuarioRepository;
import br.com.zup.controleDeUsuarioVeiculos.modelo.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
		
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<VeiculoListaDto>> listarVeiculosPorUsuario(@PathVariable Long id) {
		
		Optional<Usuario> optional = usuarioRepository.findById(id);
		
		if (optional.isPresent()) {
		
			return ResponseEntity.ok(VeiculoListaDto.converter(optional.get().getVeiculos()));
		}
	
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado");
	}
}
