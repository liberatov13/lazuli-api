package tech.liberatov13.lazuliapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.liberatov13.lazuliapi.domain.TipoProduto;

import java.util.Optional;

@Repository
public interface TipoProdutoRepository extends JpaRepository<TipoProduto, Long> {

    Optional<TipoProduto> findByNome(String nome);
}
