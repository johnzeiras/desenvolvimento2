package br.edu.ifrs.dev2.conexao.Model;

import java.io.Serializable;
import java.sql.Date;
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
public class Anuncio  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnuncio;

    @ManyToOne
    private Jogador jogador;

    @ManyToOne
    private Game game;

    private Date horaDisponivel;

    @ManyToMany
    private List<DaysWeek> diasSemanas;
}
