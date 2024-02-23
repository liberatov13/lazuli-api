package tech.liberatov13.lazuliapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.liberatov13.lazuliapi.domain.TipoProduto;
import tech.liberatov13.lazuliapi.repository.TipoProdutoRepository;

import java.util.List;

@Service
public class TipoProdutoService {

    @Autowired
    TipoProdutoRepository tipoProdutoRepository;

    public List<TipoProduto> findAll() {
        return tipoProdutoRepository.findAll();
    }

    public TipoProduto findById(Long idTipoProduto) {
        return tipoProdutoRepository.findById(idTipoProduto).orElse(null);
    }

    public TipoProduto salvar(TipoProduto tipoProduto) {
        tipoProduto.setDescricao(tipoProduto.getDescricao().toUpperCase());
        return tipoProdutoRepository.save(tipoProduto);
    }

    /**
     * Busca o tipo de produto de acordo com o nome
     * @param nomeTipoProduto nome que deve ser buscado
     * @return TipoProduto correspondente ao nome ou null caso não encontre
     */
    public TipoProduto findByNome(String nomeTipoProduto) {
        return tipoProdutoRepository.findByDescricao(nomeTipoProduto).orElse(null);
    }
}
