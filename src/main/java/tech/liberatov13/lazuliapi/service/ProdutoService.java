package tech.liberatov13.lazuliapi.service;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.liberatov13.lazuliapi.domain.Produto;
import tech.liberatov13.lazuliapi.domain.TipoProduto;
import tech.liberatov13.lazuliapi.repository.ProdutoRepository;
import tech.liberatov13.lazuliapi.repository.TipoProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

    Logger logger = LoggerFactory.getLogger(ProdutoService.class);

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private TipoProdutoRepository tipoProdutoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    /**
     * Realiza uma consulta paginada dos produtos filtrando pelo TipoProduto
     * @param tipoProduto Tipo de Produto para filtrar
     * @param paginacao Paginacao utilizada para a consulta
     * @return Produtos paginados filtrados pelo TipoProduto
     */
    public Page<Produto> findProdutoByTipoProduto(TipoProduto tipoProduto, Pageable paginacao) {
        return produtoRepository.findProdutoByTipoProduto(tipoProduto, paginacao);
    }

    public Produto save(Produto produto) {
        produto.setDescricaoBasica(produto.getDescricaoBasica().toUpperCase());
        if (produto.getDescricaoCompleta().isEmpty()) {
            produto.setDescricaoCompleta(null);
        } else {
            produto.setDescricaoCompleta(produto.getDescricaoCompleta().toUpperCase());
        }
        Produto produtoSalvo = null;
        try {
            produtoSalvo = produtoRepository.save(produto);
            logger.info("Produto salvo com sucesso, id: " + produtoSalvo.getIdProduto());
        } catch (Exception e) {
            // TODO: Avaliar a possibilidade de retornar uma Exception para o controller
            logger.warn("Erro ao persistir produto", e);
        }
        return produtoSalvo;
    }

    public Produto edit(Produto produto) {
        return save(produto);
    }

    private List<Produto> findProdutosByNomeTipoProduto(String nomeTipoProduto) throws EntityNotFoundException {
        TipoProduto tipo = tipoProdutoRepository.findByNome(nomeTipoProduto)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de produto com descrição \"" + nomeTipoProduto + "\" não encontrado."));
        return produtoRepository.findProdutoByTipoProduto(tipo);
    }

    private Page<Produto> findProdutosByNomeTipoProduto(String nomeTipoProduto, Pageable pageable) throws EntityNotFoundException {
        TipoProduto tipo = tipoProdutoRepository.findByNome(nomeTipoProduto)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de produto com descrição \"" + nomeTipoProduto + "\" não encontrado."));
        return produtoRepository.findProdutoByTipoProduto(tipo, pageable);
    }

    public Produto findById(Long idProduto) {
        return produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto com id não" + idProduto + " encontrado"));
    }

}
