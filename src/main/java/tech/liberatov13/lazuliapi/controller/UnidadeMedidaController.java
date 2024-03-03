package tech.liberatov13.lazuliapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.liberatov13.lazuliapi.domain.UnidadeMedida;
import tech.liberatov13.lazuliapi.dto.UnidadeMedidaDTO;
import tech.liberatov13.lazuliapi.service.UnidadeMedidaService;

import java.util.List;

@RestController
@RequestMapping("/unidades-medida")
public class UnidadeMedidaController {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private UnidadeMedidaService unidadeMedidaService;

	@GetMapping
	public ResponseEntity<List<UnidadeMedidaDTO>> findAll() {
		List<UnidadeMedida> unidades = unidadeMedidaService.findAll();
		List<UnidadeMedidaDTO> responseBody = unidades.stream()
				.map(unidade -> modelMapper.map(unidade, UnidadeMedidaDTO.class))
				.toList();
		return ResponseEntity.ok(responseBody);
	}
}
