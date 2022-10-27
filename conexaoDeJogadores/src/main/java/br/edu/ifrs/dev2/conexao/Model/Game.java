package br.edu.ifrs.dev2.conexao.Model;

import java.io.Serializable;

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
public class Game implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGame;

    @Column(name = "nomeGame", nullable = false)
    private String nomeGame;

    private String image;

    @OneToMany
    private List<Anuncio> anuncios;
    
}
