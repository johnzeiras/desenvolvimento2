package br.edu.ifrs.dev2.conexao.Model.dto;

import br.edu.ifrs.dev2.conexao.Model.DaysWeek;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioResponse {
    public String player;
    public String idDiscord;
    //public List<Date> horaDisponivel;
    public List<DaysWeek> diasSemanas;
}
