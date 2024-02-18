package tech.liberatov13.lazuliapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.liberatov13.lazuliapi.domain.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select user from Usuario user where user.nomeUsuario = :nomeUsuario")
    Optional<Usuario> findByNomeUsuario(String nomeUsuario);

}
