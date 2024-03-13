package tech.liberatov13.lazuliapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "embalagem")
public class Embalagem {
	@Id
	@Column(name = "id_embalagem")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmbalagem;

	@ManyToOne()
	@JoinColumn(name = "id_produto", nullable = false)
	private Produto produto;

	@ManyToOne()
	@JoinColumn(name = "id_marca", nullable = false)
	private Marca marca;

	@Column(nullable = false)
	private Double quantidade;

	@ManyToOne
	@JoinColumn(name = "id_unidade_medida", nullable = false)
	private UnidadeMedida unidadeMedida;

	@Column(name = "ean", length = 20)
	private String codigoEan;

	@Column(name = "dt_cadastro", nullable = false)
	private LocalDateTime dataCadastro;

	@Column(name = "dt_atualizacao")
	private LocalDateTime dataAtualizacao;
}
