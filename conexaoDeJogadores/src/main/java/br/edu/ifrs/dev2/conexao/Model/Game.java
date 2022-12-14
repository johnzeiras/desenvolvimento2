package br.edu.ifrs.dev2.conexao.Model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Game implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGame;

    @Column(name = "nomeGame", nullable = false)
    @NotNull
    @NotBlank(message = "Digite um nome válido para o jogo")
    private String nomeGame;

    @NotNull
    private String image;

    @OneToMany
    private List<Anuncio> anuncios;
    
}
