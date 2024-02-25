package tech.liberatov13.lazuliapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProdutoDTO {
	private Long idProduto;;
	private String descricaoBasica;
	private String descricaoCompleta;
	private TipoProdutoDTO tipoProduto;;
	private LocalDate dataCadastro;
	private Boolean status;
}
