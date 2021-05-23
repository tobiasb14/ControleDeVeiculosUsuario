package br.com.zup.controleDeUsuarioVeiculos.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.controleDeUsuarioVeiculos.DtoForm.VeiculoDto;
import br.com.zup.controleDeUsuarioVeiculos.DtoForm.VeiculoForm;
import br.com.zup.controleDeUsuarioVeiculos.Repository.UsuarioRepository;
import br.com.zup.controleDeUsuarioVeiculos.Repository.VeiculoRepository;
import br.com.zup.controleDeUsuarioVeiculos.modelo.Veiculo;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	public ResponseEntity<VeiculoDto> cadastrarVeiculo(@RequestBody @Valid VeiculoForm form, UriComponentsBuilder uriBuilder) {
		
		Veiculo veiculo = form.converter(usuarioRepository);
		veiculoRepository.save(veiculo);
		URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
	}
}
