package br.com.zup.controleDeUsuarioVeiculos.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.controleDeUsuarioVeiculos.DtoForm.VeiculoDto;
import br.com.zup.controleDeUsuarioVeiculos.DtoForm.VeiculoForm;
import br.com.zup.controleDeUsuarioVeiculos.Repository.UsuarioRepository;
import br.com.zup.controleDeUsuarioVeiculos.Repository.VeiculoRepository;
import br.com.zup.controleDeUsuarioVeiculos.modelo.Veiculo;


@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public ResponseEntity<VeiculoDto> cadastrarVeiculo(VeiculoForm form, UriComponentsBuilder uriBuilder) {
		Veiculo veiculo = form.converter(usuarioRepository);
		veiculoRepository.save(veiculo);
		URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
	}

}
