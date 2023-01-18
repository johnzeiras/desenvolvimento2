package br.edu.ifrs.dev2.conexao.Service;

import br.edu.ifrs.dev2.conexao.Model.Anuncio;
import br.edu.ifrs.dev2.conexao.Model.dto.AnuncioRequest;
import br.edu.ifrs.dev2.conexao.Model.dto.AnuncioResponse;
import br.edu.ifrs.dev2.conexao.Model.enums.DaysWeekEnum;
import br.edu.ifrs.dev2.conexao.Repository.AnuncioRepository;
import br.edu.ifrs.dev2.conexao.Repository.DaysWeekRepository;
import br.edu.ifrs.dev2.conexao.Repository.GameRepository;
import br.edu.ifrs.dev2.conexao.Repository.JogadorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnuncioService {
    private final AnuncioRepository anuncioRepository;
    private final JogadorRepository jogadorService;
    private final GameRepository gameRepository;
    private final JogadorService userDetails;
    private final DaysWeekRepository daysWeekRepository;


    public AnuncioResponse save(AnuncioRequest anuncio) {
        var player = this.jogadorService.findByLogin(this.userDetails.getUserName())
                .orElseThrow(() -> new UsernameNotFoundException(""));
        var game = this.gameRepository.findById(anuncio.idGame)
                .orElseThrow(() -> new UsernameNotFoundException(""));
        var daysWeek = DaysWeekEnum.fromEnum(this.daysWeekRepository.findAll(), anuncio.diasSemanas);

        var auncioRequest = Anuncio.builder()
                .diasSemanas(daysWeek)
                .game(game)
                .jogador(player)
                .build();
        anuncioRepository.save(auncioRequest);
        game.getAnuncios().add(auncioRequest);
        this.gameRepository.save(game);
        return AnuncioResponse.builder()
                .player(player.getNome())
                .diasSemanas(daysWeek)
                .idDiscord(player.getIdDiscord())
                .build();
    }

    public List<Anuncio> listarAnuncio(){
        return anuncioRepository.findAll();
    }

}