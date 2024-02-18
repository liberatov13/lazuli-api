package tech.liberatov13.lazuliapi.service;

import tech.liberatov13.lazuliapi.domain.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> buscarPorId(Long idUsuario);

    Optional<Usuario> findByNomeUsuario(String nomeUsuario);
}
