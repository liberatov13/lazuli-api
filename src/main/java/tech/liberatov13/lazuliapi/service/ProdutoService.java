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

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    /**
     * Realiza a persistência de produto
     * @param produto Produto a ser persistido
     * @return Produto salvo
     */
    public Produto save(Produto produto) {
        try {
            produto.setIdProduto(null);
            produto.setDescricaoBasica(produto.getDescricaoBasica().toUpperCase());

            if (produto.getDescricaoCompleta() != null && !produto.getDescricaoCompleta().isBlank())
                produto.setDescricaoCompleta(produto.getDescricaoCompleta().toUpperCase());

            produto.setDataCadastro(LocalDateTime.now());

            Produto produtoSaved = produtoRepository.save(produto);
            logger.info("Produto salvo com sucesso, id: " + produtoSaved.getIdProduto());
            return produtoSaved;
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao persistir produto", e);
            throw new RuntimeException("Erro ao persistir produto", e);
        }
    }

    public Produto edit(Produto produto) {
        return save(produto);
    }

    private List<Produto> findProdutosByNomeTipoProduto(String nomeTipoProduto) throws EntityNotFoundException {
        TipoProduto tipo = tipoProdutoRepository.findByDescricao(nomeTipoProduto)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de produto com descrição \"" + nomeTipoProduto + "\" não encontrado."));
        return produtoRepository.findProdutoByTipoProduto(tipo);
    }

    private Page<Produto> findProdutosByNomeTipoProduto(String nomeTipoProduto, Pageable pageable) throws EntityNotFoundException {
        TipoProduto tipo = tipoProdutoRepository.findByDescricao(nomeTipoProduto)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de produto com descrição \"" + nomeTipoProduto + "\" não encontrado."));
        return produtoRepository.findProdutoByTipoProduto(tipo, pageable);
    }

    public Produto findById(Long idProduto) {
        return produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto com id não" + idProduto + " encontrado"));
    }

    /**
     * Realiza a ativação do produto
     * @param idProduto Id do produto a ser ativado
     * @return Produto ativado
     */
    public Produto activate(Long idProduto) {
        try {
            Produto produto = this.findById(idProduto);
            produto.setStatus(true);
            return produtoRepository.save(produto);
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao ativar produtoo produto {}", idProduto, e);
            throw new RuntimeException("Erro ao ativar o produto "+idProduto, e);
        }
    }

	/**
	 * Realiza a desativação do produto
	 * @param idProduto  Id do produto a ser desativado
	 */
    public Produto disable(Long idProduto) {
        try {
            Produto produto = this.findById(idProduto);
            produto.setStatus(false);
            return produtoRepository.save(produto);
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao desativar produtoo produto {}", idProduto, e);
            throw new RuntimeException("Erro ao desativar o produto "+idProduto, e);
        }
    }

	public List<Produto> findByDescription(String term) {
        try {
            return produtoRepository.findByDescricaoBasicaContainingIgnoreCase(term);
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao consultar produtos com a descrição \"{}\"", term, e);
            throw new RuntimeException(e);
        }
    }
}
