package br.edu.ifrs.dev2.conexao.Model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Anuncio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnuncio;

    @ManyToOne
    @JoinTable(
            name = "jogador_anuncio", joinColumns = {
            @JoinColumn(name = "anuncio_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "jogador_id")
    }
    )
    @NotNull
    private Jogador jogador;

    @ManyToOne
    @NotNull
    private Game game;
    /*
        @Embedded
        private List<Date> horaDisponivel;

     */
    @ManyToMany
    @JoinTable(
            name = "days_anuncio", joinColumns = {
            @JoinColumn(name = "anuncio_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "diasSemanas_id")
    }
    )
    private List<DaysWeek> diasSemanas;
}
