package tech.liberatov13.lazuliapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.liberatov13.lazuliapi.domain.Produto;
import tech.liberatov13.lazuliapi.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> findAll() {
		return produtoService.findAll();
	}
}
