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
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue
    private Long idCliente;

    @OneToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private Pessoa pessoa;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean status;

}
