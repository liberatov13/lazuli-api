package tech.liberatov13.lazuliapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.liberatov13.lazuliapi.domain.Embalagem;
import tech.liberatov13.lazuliapi.repository.EmbalagemRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmbalagemService {

	@Autowired
	private EmbalagemRepository embalagemRepository;

	private final Logger logger = LoggerFactory.getLogger(EmbalagemService.class);

	/**
	 * Consulta todas as embalagens cadastradas
	 * @return lista de embalagens cadastradas
	 */
	public List<Embalagem> findAll() {
		try {
			return embalagemRepository.findAll();
		} catch (Exception e) {
			logger.error("Ocorreu um erro ao buscar embalagens", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Consulta embalagem por id
	 * @param idEmbalagem id da embalagem
	 * @return embalagem encontrada
	 */
	public Embalagem findById(Long idEmbalagem) {
		try {
			return embalagemRepository.findById(idEmbalagem).orElse(null);
		} catch (Exception e) {
			logger.error("Ocorreu um erro ao buscar embalagem de id {}", idEmbalagem, e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Realiza a persistência de embalagens
	 * @param embalagem embalagem que deve ser persistida
	 * @return embalagem cadastrada
	 */
	public Embalagem save(Embalagem embalagem) {
		try {
			if (embalagem.getIdEmbalagem() != null)
				throw new IllegalArgumentException("Embalagens para cadastro não devem conter id");
			embalagem.setDataCadastro(LocalDateTime.now());
			return embalagemRepository.save(embalagem);
		} catch (Exception e) {
			logger.error("Ocorreu um erro ao salvar a embalagem", e);
			throw new RuntimeException(e);
		}
	}
}
