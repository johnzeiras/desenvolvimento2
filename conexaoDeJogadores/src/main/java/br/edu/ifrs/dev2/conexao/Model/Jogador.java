package br.edu.ifrs.dev2.conexao.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogador;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "Digite um nome válido")
    @NotNull
    @Size(max=40)
    private String nome;

    @Column(name = "email", nullable = false)
    @NotNull
    @NotBlank (message = "Digite um e-mail válido")
    @Email(message = "E-mail inválido")
    private String email;

    @Column(name = "telefone", nullable = false)
    @NotNull
    @NotBlank (message = "O campo telefone é obrigatório")
    @Size (min = 10, max = 11)
    private String telefone;

    @OneToMany
    private List<Anuncio> anuncios;

    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    private String password;

}
