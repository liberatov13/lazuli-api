package tech.liberatov13.lazuliapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.liberatov13.lazuliapi.domain.Produto;
import tech.liberatov13.lazuliapi.domain.TipoProduto;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAll();

    Page<Produto> findAll(Pageable pageable);

    List<Produto> findProdutoByTipoProduto(TipoProduto tipoProduto);

    Page<Produto> findProdutoByTipoProduto(TipoProduto tipoProduto, Pageable pageable);


}
