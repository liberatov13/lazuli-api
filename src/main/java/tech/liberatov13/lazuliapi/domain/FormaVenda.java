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
@Table(name = "forma_venda")
public class FormaVenda {

    @Id
    @GeneratedValue
    @Column(name = "id_forma_venda")
    private Long idFormaVenda;

    private String nome;

}
