package br.edu.ifrs.dev2.conexao.Model.dto;
import br.edu.ifrs.dev2.conexao.Model.enums.DaysWeekEnum;

import java.util.List;

public class AnuncioRequest {
    public Long idGame;
    //public List<Date> horaDisponivel;
    public List<DaysWeekEnum> diasSemanas;
}
