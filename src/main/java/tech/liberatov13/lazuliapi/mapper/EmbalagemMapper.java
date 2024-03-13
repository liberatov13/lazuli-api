package tech.liberatov13.lazuliapi.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import tech.liberatov13.lazuliapi.domain.Embalagem;
import tech.liberatov13.lazuliapi.dto.embalagem.EmbalagemRequestDTO;

public class EmbalagemMapper extends ModelMapper {
	public EmbalagemMapper() {
		super();
		this.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<EmbalagemRequestDTO, Embalagem> typeMapToEntity = this.createTypeMap(EmbalagemRequestDTO.class, Embalagem.class);
		addProdutoMapping(typeMapToEntity);
		addMarcaMapping(typeMapToEntity);
		addUnidadeMedidaMapping(typeMapToEntity);
	}

	private static void addProdutoMapping(TypeMap<EmbalagemRequestDTO, Embalagem> typeMap) {
		typeMap.addMappings(
				mapper -> mapper.map(
						EmbalagemRequestDTO::getIdProduto,
						(dest, value) -> dest.getProduto().setIdProduto((Long) value))
		);
	}

	private static void addUnidadeMedidaMapping(TypeMap<EmbalagemRequestDTO, Embalagem> typeMap) {
		typeMap.addMappings(
				mapper -> mapper.map(
						EmbalagemRequestDTO::getIdUnidadeMedida,
						(dest, value) -> dest.getUnidadeMedida().setIdUnidadeMedida((Long) value))
		);
	}

	private static void addMarcaMapping(TypeMap<EmbalagemRequestDTO, Embalagem> typeMap) {
		typeMap.addMappings(
				mapper -> mapper.map(
						EmbalagemRequestDTO::getIdMarca,
						(dest, value) -> dest.getMarca().setIdMarca((Long) value))
		);
	}
}
