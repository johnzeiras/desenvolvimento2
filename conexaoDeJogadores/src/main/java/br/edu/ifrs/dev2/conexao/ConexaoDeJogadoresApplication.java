package br.edu.ifrs.dev2.conexao;

import br.edu.ifrs.dev2.conexao.Model.DaysWeek;
import br.edu.ifrs.dev2.conexao.Model.enums.DaysWeekEnum;
import br.edu.ifrs.dev2.conexao.Repository.DaysWeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class ConexaoDeJogadoresApplication implements ApplicationRunner {

    @Autowired
    private final DaysWeekRepository daysWeekRepository;

    public static void main(String[] args) {
        SpringApplication.run(ConexaoDeJogadoresApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (this.daysWeekRepository.findAll().size() == 0) {
            var daysWeek = Arrays.asList(DaysWeekEnum.SEGUNDA_FEIRA,
                    DaysWeekEnum.TERCA_FEIRA,
                    DaysWeekEnum.QUARTA_FEIRA,
                    DaysWeekEnum.QUINTA_FEIRA,
                    DaysWeekEnum.SEXTA_FEIRA,
                    DaysWeekEnum.SABADO,
                    DaysWeekEnum.DOMINGO);
            daysWeek.stream()
                    .map(day -> new DaysWeek(null, day.name())).toList()
                    .forEach(this.daysWeekRepository::save);
        }
    }
}
