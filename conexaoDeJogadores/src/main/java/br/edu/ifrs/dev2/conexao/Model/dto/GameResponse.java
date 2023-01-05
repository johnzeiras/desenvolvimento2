package br.edu.ifrs.dev2.conexao.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GameResponse {

    private Long idGame;

    private String nomeGame;

    private String image;

    private List<AnuncioResponse> anuncios;
}
