package br.edu.ifrs.dev2.conexao.Model.dto;

import br.edu.ifrs.dev2.conexao.Model.DaysWeek;

import java.util.Date;
import java.util.List;

public class AnuncioRequest {
    public Long idGame;
    public Long idJogador;
    //public List<Date> horaDisponivel;
    public List<DaysWeek> diasSemanas;
}
