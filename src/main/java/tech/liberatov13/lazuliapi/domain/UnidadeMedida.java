package tech.liberatov13.lazuliapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "unidade_medida")
public class UnidadeMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidadeMedida;

    @Column(nullable = false, length = 15)
    private String nome;

    @Column(length = 5)
    private String simbolo;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean status;

}
