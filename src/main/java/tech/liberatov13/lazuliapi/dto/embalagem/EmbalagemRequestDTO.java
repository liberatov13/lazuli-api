package tech.liberatov13.lazuliapi.dto.embalagem;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.EAN;

@Data
public class EmbalagemRequestDTO {
	@NotNull(message = "O produto deve ser informado")
	@Positive
	@JsonProperty("produto")
	private Long idProduto;

	@NotNull(message = "A marca deve ser informada")
	@Positive(message = "A marca informada está inválida")
	@JsonProperty("marca")
	private Long idMarca;

	@NotNull(message = "A quantidade deve ser informada")
	@Positive(message = "A quantidade deve ser maior que zero")
	private Double quantidade;

	@NotNull(message = "A unidade de medida deve ser informada")
	@Positive(message = "A unidade de medida informada está inválida")
	@JsonProperty("unidadeMedida")
	private Long idUnidadeMedida;

	@EAN(message = "O código EAN informado está inválido")
	private String codigoEan;
}
