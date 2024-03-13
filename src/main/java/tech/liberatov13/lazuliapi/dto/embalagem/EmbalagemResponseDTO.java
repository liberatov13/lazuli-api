package tech.liberatov13.lazuliapi.dto.embalagem;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import tech.liberatov13.lazuliapi.dto.MarcaDTO;
import tech.liberatov13.lazuliapi.dto.ProdutoDTO;
import tech.liberatov13.lazuliapi.dto.UnidadeMedidaDTO;

import java.time.LocalDateTime;

@Data
public class EmbalagemResponseDTO {
	private Long idEmbalagem;
	@JsonProperty("produto")
	private ProdutoDTO produto;
	@JsonProperty("marca")
	private MarcaDTO marca;
	private Double quantidade;
	private UnidadeMedidaDTO unidadeMedida;
	private String codigoEan;
	private LocalDateTime dataCadastro;
}
