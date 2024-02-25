package tech.liberatov13.lazuliapi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "descricao_basica", nullable = false, length = 75)
    private String descricaoBasica;

    @Column(name = "descricao_completa", length = 100)
    private String descricaoCompleta;

    @ManyToOne
    @JoinColumn(name = "id_tipo_produto", nullable = false)
    private TipoProduto tipoProduto;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean status;

    @JsonBackReference
    @ToString.Exclude
    @OneToOne(mappedBy = "produtoFinal")
    private Receita receita;

    @JsonBackReference
    @OneToMany(mappedBy = "produto")
    private List<CompraProduto> comprasProduto;

    @JsonIgnore
    public Double getCustoMedio() {
        if (this.comprasProduto.isEmpty() || this.comprasProduto == null) {
            return null;
        }
        Double total = 0.0;
        for (CompraProduto compraProduto : this.comprasProduto) {
            total += compraProduto.getPrecoDaUnidade();
        }
        if (total == 0.0) {
            return null;
        }
        return (total / comprasProduto.size());
    }

}
