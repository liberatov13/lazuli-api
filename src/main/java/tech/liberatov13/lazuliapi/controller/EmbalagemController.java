package tech.liberatov13.lazuliapi.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.liberatov13.lazuliapi.domain.Embalagem;
import tech.liberatov13.lazuliapi.dto.embalagem.EmbalagemRequestDTO;
import tech.liberatov13.lazuliapi.dto.embalagem.EmbalagemResponseDTO;
import tech.liberatov13.lazuliapi.mapper.EmbalagemMapper;
import tech.liberatov13.lazuliapi.service.EmbalagemService;

import java.util.List;

@RestController
@RequestMapping("/embalagens")
public class EmbalagemController {
	@Autowired
	private EmbalagemService embalagemService;

	private final ModelMapper modelMapper = new EmbalagemMapper();

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(description = "Embalagens encontradas", responseCode = "200"),
			@ApiResponse(description = "Erro ao buscar embalagens", responseCode = "500")
	})
	public ResponseEntity<List<EmbalagemResponseDTO>> findAll() {
		List<Embalagem> embalagens = embalagemService.findAll();
		List<EmbalagemResponseDTO> responseBody = embalagens.stream()
				.map(embalagem -> modelMapper.map(embalagem, EmbalagemResponseDTO.class))
				.toList();
		return ResponseEntity.ok(responseBody);
	}

	@GetMapping(value = "/{idEmbalagem}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(description = "Embalagem encontrada", responseCode = "200"),
			@ApiResponse(description = "Embalagem não encontrada", responseCode = "404"),
			@ApiResponse(description = "Erro ao buscar a embalagem", responseCode = "500")
	})
	public ResponseEntity<EmbalagemResponseDTO> findById(@PathVariable Long idEmbalagem) {
		Embalagem embalagem = embalagemService.findById(idEmbalagem);
		if (embalagem == null)
			return ResponseEntity.notFound().build();
		EmbalagemResponseDTO responseBody = modelMapper.map(embalagem, EmbalagemResponseDTO.class);
		return ResponseEntity.ok(responseBody);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(description = "Embalagem criada", responseCode = "201"),
			@ApiResponse(description = "Erro ao criar embalagem", responseCode = "500")
	})
	public ResponseEntity<EmbalagemResponseDTO> create(@Valid @RequestBody EmbalagemRequestDTO embalagem) {
		Embalagem data = modelMapper.map(embalagem, Embalagem.class);
		Embalagem embalagemCreated = embalagemService.save(data);
		EmbalagemResponseDTO responseBody = modelMapper.map(embalagemCreated, EmbalagemResponseDTO.class);
		return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
	}
}
