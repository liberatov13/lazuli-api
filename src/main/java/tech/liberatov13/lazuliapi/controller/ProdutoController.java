package tech.liberatov13.lazuliapi.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(description = "Produtos obtidos com sucesso.", responseCode = "200"),
			@ApiResponse(description = "Erro ao obter produtos.", responseCode = "500")
	})
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<Produto> produtos = produtoService.findAll();
		List<ProdutoDTO> response = produtos.stream().map(produto -> modelMapper.map(produto, ProdutoDTO.class)).toList();
		return ResponseEntity.ok().body(response);
	}

	@PostMapping
	@ApiResponses(value = {
			@ApiResponse(description = "Produto salvo com sucesso.", responseCode = "201"),
			@ApiResponse(description = "Erro ao salvar produto.", responseCode = "500")
	})
	public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produtoDTO) {
		Produto produto = modelMapper.map(produtoDTO, Produto.class);
		Produto produtoSaved = produtoService.save(produto);
		ProdutoDTO response = modelMapper.map(produtoSaved, ProdutoDTO.class);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{idProduto}/desativar")
	@ApiResponses(value = {
			@ApiResponse(description = "Produto desativado com sucesso.", responseCode = "204"),
			@ApiResponse(description = "Erro ao desativar produto.", responseCode = "500")
	})
	public ResponseEntity<Void> delete(@PathVariable Long idProduto) {
		produtoService.disable(idProduto);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{idProduto}/ativar")
	@ApiResponses(value = {
			@ApiResponse(description = "Produto ativado com sucesso.", responseCode = "204"),
			@ApiResponse(description = "Erro ao ativar produto.", responseCode = "500")
	})
	public ResponseEntity<Void> activate(@PathVariable Long idProduto) {
		produtoService.activate(idProduto);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("autocomplete")
	public ResponseEntity<List<ProdutoDTO>> findByDescription(@RequestParam String term) {
		List<Produto> produtos = produtoService.findByDescription(term);
		List<ProdutoDTO> response = produtos.stream().map(produto -> modelMapper.map(produto, ProdutoDTO.class)).toList();
		return ResponseEntity.ok().body(response);
	}
}
