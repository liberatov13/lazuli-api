package tech.liberatov13.lazuliapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.liberatov13.lazuliapi.domain.Embalagem;

@Repository
public interface EmbalagemRepository extends JpaRepository<Embalagem, Long> {
}
