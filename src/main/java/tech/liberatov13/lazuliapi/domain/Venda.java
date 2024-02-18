package tech.liberatov13.lazuliapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "vl_total", nullable = false)
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "id_forma_venda", nullable = false)
    private FormaVenda formaVenda;

    @ManyToMany
    @JoinTable(name = "venda_produto",
            joinColumns = {@JoinColumn(name = "id_venda")},
            inverseJoinColumns = {@JoinColumn(name = "id_produto")})
    private List<Produto> produtos;

    @ManyToOne
    @JoinColumn(name = "id_usuario_vendedor", nullable = false)
    private Usuario usuario;

    @Column(name = "dt_venda", nullable = false)
    private LocalDateTime dataVenda;

}
