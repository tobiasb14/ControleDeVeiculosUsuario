package br.com.zup.controleDeUsuarioVeiculos.controller;

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
import br.com.zup.controleDeUsuarioVeiculos.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;

	@PostMapping
	public ResponseEntity<VeiculoDto> cadastrarVeiculo(@RequestBody @Valid VeiculoForm form, UriComponentsBuilder uriBuilder) {
		
		return veiculoService.cadastrarVeiculo(form, uriBuilder);
	}
}
