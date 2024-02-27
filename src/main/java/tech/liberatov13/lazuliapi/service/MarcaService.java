package tech.liberatov13.lazuliapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.liberatov13.lazuliapi.domain.Marca;
import tech.liberatov13.lazuliapi.repository.MarcaRepository;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

	private final Logger logger = LoggerFactory.getLogger(MarcaService.class);

    public Marca findById(Long idMarca) {
        return marcaRepository.findById(idMarca).orElse(null);
    }

    /**
     * @return Todas as marcas com status ativo
     */
    public List<Marca> findActiveMarcas() {
        return marcaRepository.findByStatus(true);
    }

    public List<Marca> findAll() {
		try {
			return marcaRepository.findAll();
		} catch (Exception e) {
			logger.error("Ocorreu um erro ao buscar marcas", e);
			throw new RuntimeException(e);
		}
	}

    public Marca save(Marca marca) {
		try {
			marca.setNome(marca.getNome().toUpperCase());
			return marcaRepository.save(marca);
		} catch (Exception e) {
			logger.error("Ocorreu um erro ao salvar a marca de id {}", marca.getIdMarca(), e);
			throw new RuntimeException(e);
		}
	}

    public Marca update(Marca marca) {
        return this.save(marca);
    }
}
