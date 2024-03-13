package tech.liberatov13.lazuliapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.liberatov13.lazuliapi.domain.Marca;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    @Override
    List<Marca> findAll();

    List<Marca> findByStatus(Boolean status);

	List<Marca> findByNomeContainsIgnoreCase(String term);
}
