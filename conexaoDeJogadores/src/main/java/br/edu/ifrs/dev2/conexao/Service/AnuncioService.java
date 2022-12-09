package br.edu.ifrs.dev2.conexao.Service;

import br.edu.ifrs.dev2.conexao.Model.Anuncio;
import br.edu.ifrs.dev2.conexao.Model.dto.AnuncioRequest;
import br.edu.ifrs.dev2.conexao.Model.dto.AnuncioResponse;
import br.edu.ifrs.dev2.conexao.Repository.AnuncioRepository;
import br.edu.ifrs.dev2.conexao.Repository.GameRepository;
import br.edu.ifrs.dev2.conexao.Repository.JogadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnuncioService {
    private final AnuncioRepository anuncioRepository;
    private final JogadorRepository jogadorService;
    private final GameRepository gameRepository;

    public AnuncioResponse save(AnuncioRequest anuncio) {
        var player = this.jogadorService.findById(anuncio.idJogador).orElseThrow(() -> new UsernameNotFoundException(""));
        var game = this.gameRepository.findById(anuncio.idGame).orElseThrow(() -> new UsernameNotFoundException(""));
        var auncioRequest = Anuncio.builder()
                .diasSemanas(anuncio.diasSemanas)
                .game(game)
                .jogador(player)
                .build();
        anuncioRepository.save(auncioRequest);
        return AnuncioResponse.builder().player(player.getNome())
                .game(game.getNomeGame())
                .diasSemanas(anuncio.diasSemanas)
                .build();
    }

    public List<Anuncio> listarAnuncio(){
        return anuncioRepository.findAll();
    }

}