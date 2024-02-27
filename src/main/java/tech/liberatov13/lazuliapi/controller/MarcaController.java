package tech.liberatov13.lazuliapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.liberatov13.lazuliapi.dto.MarcaDTO;
import tech.liberatov13.lazuliapi.service.MarcaService;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	private final ModelMapper modelMapper = new ModelMapper();

	@GetMapping
	public ResponseEntity<List<MarcaDTO>> findAll() {
		List<MarcaDTO> marcasDTO = marcaService.findAll()
				.stream()
				.map((element) -> modelMapper.map(element, MarcaDTO.class))
				.toList();
		return ResponseEntity.ok(marcasDTO);
	}
}
