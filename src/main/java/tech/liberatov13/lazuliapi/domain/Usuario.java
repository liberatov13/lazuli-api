package tech.liberatov13.lazuliapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private Long idUsuario;

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @Column(name = "nome_usuario", nullable = false, length = 45)
    private String nomeUsuario;

    @Column(name = "senha", length = 100)
    private String senha;

    @Column(nullable = false)
    private Boolean status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_grupo",
            joinColumns = {@JoinColumn(name = "id_usuario")},
            inverseJoinColumns = {@JoinColumn(name = "id_grupo")})
    private List<GrupoAcesso> gruposAcessos;

}
