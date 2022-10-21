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
public class Jogador implements Serializable {

     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idJogador;

    
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    private List<Anuncio> anuncios = new ArrayList();
    
}
