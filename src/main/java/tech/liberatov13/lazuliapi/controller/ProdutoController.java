package tech.liberatov13.lazuliapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.liberatov13.lazuliapi.domain.Produto;
import tech.liberatov13.lazuliapi.dto.ProdutoDTO;
import tech.liberatov13.lazuliapi.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	private final ModelMapper modelMapper = new ModelMapper();

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<Produto> produtos = produtoService.findAll();
		List<ProdutoDTO> response = produtos.stream().map(produto -> modelMapper.map(produto, ProdutoDTO.class)).toList();
		return ResponseEntity.ok().body(response);
	}

	@PutMapping("/{idProduto}/desativar")
	public ResponseEntity<Void> delete(@PathVariable Long idProduto) {
		produtoService.disable(idProduto);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{idProduto}/ativar")
	public ResponseEntity<Void> activate(@PathVariable Long idProduto) {
		produtoService.activate(idProduto);
		return ResponseEntity.noContent().build();
	}
}