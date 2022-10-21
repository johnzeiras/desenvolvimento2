package br.edu.ifrs.dev2.conexao.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGame;


    @Column(name = "nomeGame", nullable = false)
    private String nomeGame;

    @Column(name = "idAnuncio", nullable = false)
    private int idAnuncio;

    @Column(name = "idJogador", nullable = false)
    private int idJogador;


    private List<Anuncio> anuncios = new ArrayList();
    
}
