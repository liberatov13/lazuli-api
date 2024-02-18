package tech.liberatov13.lazuliapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.liberatov13.lazuliapi.domain.Usuario;
import tech.liberatov13.lazuliapi.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> buscarPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    @Override
    public Optional<Usuario> findByNomeUsuario(String nomeUsuario) {
        return usuarioRepository.findByNomeUsuario(nomeUsuario);
    }
}
