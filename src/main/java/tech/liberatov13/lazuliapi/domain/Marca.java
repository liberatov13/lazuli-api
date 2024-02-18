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
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarca;

    @Column(nullable = false, length = 75)
    private String nome;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean status;

}
