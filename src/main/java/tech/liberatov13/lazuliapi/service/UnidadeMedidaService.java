package tech.liberatov13.lazuliapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.liberatov13.lazuliapi.domain.UnidadeMedida;
import tech.liberatov13.lazuliapi.repository.UnidadeMedidaRepository;

import java.util.List;

@Service
public class UnidadeMedidaService {

    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    public List<UnidadeMedida> findAll() {
        return unidadeMedidaRepository.findAll();
    }

    public UnidadeMedida findById(Long idUnidadeMedida) {
        return unidadeMedidaRepository.findById(idUnidadeMedida).orElse(null);
    }
}
