package tech.liberatov13.lazuliapi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	public List<TipoProdutoDTO> findAll() {
		List<TipoProduto> tipos = tipoProdutoService.findAll();
		return tipos.stream().map(tipoProduto -> modelMapper.map(tipoProduto, TipoProdutoDTO.class)).toList();
	}
}
