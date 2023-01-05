package br.edu.ifrs.dev2.conexao.Model.enums;

import br.edu.ifrs.dev2.conexao.Model.DaysWeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DaysWeekEnum {
    SEGUNDA_FEIRA("SEGUNDA_FEIRA"),
    TERCA_FEIRA("TERCA_FEIRA"),
    QUARTA_FEIRA("QUARTA_FEIRA"),
    QUINTA_FEIRA("QUINTA_FEIRA"),
    SEXTA_FEIRA("SEXTA_FEIRA"),
    SABADO("SABADO"),
    DOMINGO("DOMINGO");

    private final String formatted;

    DaysWeekEnum(String formatted) {
        this.formatted = formatted;
    }

    @Override
    public String toString() {
        return formatted;
    }

    public static List<DaysWeek> fromEnum(List<DaysWeek> daysWeeks, List<DaysWeekEnum> list) {
        List<DaysWeek> days = new ArrayList<>(0);
        for (DaysWeekEnum day : list) {
            daysWeeks.forEach(daySelected -> {
                if (daySelected.getDay().equals(day.toString())) {
                    days.add(daySelected);
                }
            });
        }
        return days;
    }
}
