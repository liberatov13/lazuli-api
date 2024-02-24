package tech.liberatov13.lazuliapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.liberatov13.lazuliapi.domain.TipoProduto;
import tech.liberatov13.lazuliapi.dto.TipoProdutoDTO;
import tech.liberatov13.lazuliapi.service.TipoProdutoService;

import java.util.List;

@RestController
@RequestMapping("/tipos-produto")
public class TipoProdutoController {

	@Autowired
	private TipoProdutoService tipoProdutoService;

	private final ModelMapper modelMapper = new ModelMapper();

	@GetMapping
	public ResponseEntity<List<TipoProdutoDTO>> findAll() {
		List<TipoProduto> tipos = tipoProdutoService.findAll();
		List<TipoProdutoDTO> responseDTO = tipos.stream().map(tipoProduto -> modelMapper.map(tipoProduto, TipoProdutoDTO.class)).toList();
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TipoProdutoDTO> save(@RequestBody TipoProdutoDTO tipoProdutoDTO) {
		TipoProduto tipoProduto = modelMapper.map(tipoProdutoDTO, TipoProduto.class);
		tipoProduto = tipoProdutoService.save(tipoProduto);
		return new ResponseEntity<>(modelMapper.map(tipoProduto, TipoProdutoDTO.class), HttpStatus.CREATED);
	}
}
