package br.edu.ifrs.dev2.conexao.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;







@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Jogador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJogador;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @OneToMany
    private List<Anuncio> anuncios;
    
}
