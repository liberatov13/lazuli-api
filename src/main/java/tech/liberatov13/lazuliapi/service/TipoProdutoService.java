package tech.liberatov13.lazuliapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.liberatov13.lazuliapi.domain.TipoProduto;
import tech.liberatov13.lazuliapi.repository.TipoProdutoRepository;

import java.util.List;

@Service
public class TipoProdutoService {

    @Autowired
    TipoProdutoRepository tipoProdutoRepository;

    Logger logger = LoggerFactory.getLogger(TipoProdutoService.class);

    public List<TipoProduto> findAll() {
        try {
            return tipoProdutoRepository.findAll();
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao consultar os tipos de produtos", e);
            throw new RuntimeException(e);
        }
    }

    public TipoProduto findById(Long idTipoProduto) {
        return tipoProdutoRepository.findById(idTipoProduto).orElse(null);
    }

    /**
     * Realiza a persistência de um novo tipo de produto
     * @param tipoProduto - O objeto que deve ser persistido
     * @return TipoProduto criado
     */
    public TipoProduto save(TipoProduto tipoProduto) {
        try {
            tipoProduto.setIdTipoProduto(null);
            tipoProduto.setDescricao(tipoProduto.getDescricao().toUpperCase());
            return tipoProdutoRepository.save(tipoProduto);
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao persistir o tipo de produto", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Busca o tipo de produto pela descrição
     * @param descricao texto que deve ser utilizado na busca
     * @return TipoProduto correspondente à descrição ou null caso não encontre
     */
    public TipoProduto findByNome(String descricao) {
        try {
            return tipoProdutoRepository.findByDescricao(descricao).orElse(null);
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao consultar o tipo de produto pela descrição: {}", descricao, e);
            throw new RuntimeException(e);
        }
    }
}
