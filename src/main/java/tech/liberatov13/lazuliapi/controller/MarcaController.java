package tech.liberatov13.lazuliapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.liberatov13.lazuliapi.domain.Marca;
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
				.map((marca) -> modelMapper.map(marca, MarcaDTO.class))
				.toList();
		return ResponseEntity.ok(marcasDTO);
	}

	@PostMapping
	public ResponseEntity<MarcaDTO> save(@RequestBody MarcaDTO marcaDTO) {
		Marca marcaSaved = marcaService.save(modelMapper.map(marcaDTO, Marca.class));
		MarcaDTO marcaDTOSaved = modelMapper.map(marcaSaved, MarcaDTO.class);
		return ResponseEntity.ok(marcaDTOSaved);
	}
}
