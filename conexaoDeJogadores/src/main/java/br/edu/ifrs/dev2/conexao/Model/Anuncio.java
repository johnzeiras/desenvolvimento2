package br.edu.ifrs.dev2.conexao.Model;

import java.io.Serializable;
import java.sql.Date;
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
public class Anuncio  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnuncio;
    
    @Column(name = "idJogador", nullable = false)
    private int idJogador;

    @Column(name = "idGame", nullable = false)
    private int idGame;

    @Column(name = "idJogador", nullable = false)
    private Date horaDisponivel;

    private List<String> diasSemanas = new ArrayList();
}
