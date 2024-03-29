package tech.liberatov13.lazuliapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue
    @Column(name = "id_fornecedor")
    private Long idFornecedor;

    @OneToOne
    @JoinColumn(name = "id_pessoa", nullable = false)
    private Pessoa pessoa;

    @ToString.Exclude
    @OneToMany(mappedBy = "fornecedor")
    private List<Compra> compras;

}
