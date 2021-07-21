package br.com.zup.controleDeUsuarioVeiculos.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.controleDeUsuarioVeiculos.DtoForm.UsuarioDto;
import br.com.zup.controleDeUsuarioVeiculos.DtoForm.UsuarioForm;
import br.com.zup.controleDeUsuarioVeiculos.DtoForm.VeiculoListaDto;
import br.com.zup.controleDeUsuarioVeiculos.Repository.UsuarioRepository;
import br.com.zup.controleDeUsuarioVeiculos.modelo.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public ResponseEntity<UsuarioDto> cadastrarUsuario(UsuarioForm form, UriComponentsBuilder uriBuilder) {
		
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);
		URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}

	public ResponseEntity<List<VeiculoListaDto>> listarVeiculosPorUsuario(Long id) {

		Optional<Usuario> optional = usuarioRepository.findById(id);
		
		if (optional.isPresent()) {
		
			return ResponseEntity.ok(VeiculoListaDto.converter(optional.get().getVeiculos()));
		}
	
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id não encontrado");
	}

	
}
