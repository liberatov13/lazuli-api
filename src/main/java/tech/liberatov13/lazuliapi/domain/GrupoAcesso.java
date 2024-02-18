package tech.liberatov13.lazuliapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "grupo_acesso")
public class GrupoAcesso {

    @Id
    @GeneratedValue
    private Long idGrupoAcesso;

    @Column(nullable = false, length = 75)
    private String nome;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean status;

    @ToString.Exclude
    @ManyToMany(mappedBy = "gruposAcessos", fetch = FetchType.EAGER)
    private List<Usuario> usuarios;

}
