package tech.liberatov13.lazuliapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.liberatov13.lazuliapi.domain.UnidadeMedida;
import tech.liberatov13.lazuliapi.repository.UnidadeMedidaRepository;

import java.util.List;

@Service
public class UnidadeMedidaService {

    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    Logger logger = LoggerFactory.getLogger(UnidadeMedidaService.class);

    public List<UnidadeMedida> findAll() {
        try {
            return unidadeMedidaRepository.findAll();
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao buscar as unidades de medida", e);
            throw new RuntimeException(e);
        }
    }

    public UnidadeMedida findById(Long idUnidadeMedida) {
        try {
            return unidadeMedidaRepository.findById(idUnidadeMedida).orElse(null);
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao buscar a unidade de medida de id {}",idUnidadeMedida, e);
            throw new RuntimeException(e);
        }
    }

    public void delete(Long idUnidadeMedida) {
        try {
            unidadeMedidaRepository.deleteById(idUnidadeMedida);
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao deletar a unidade de medida de id {}",idUnidadeMedida, e);
            throw new RuntimeException(e);
        }
    }
}
