package br.edu.ifrs.dev2.conexao.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.edu.ifrs.dev2.conexao.Model.dto.AnuncioResponse;
import br.edu.ifrs.dev2.conexao.Model.dto.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.dev2.conexao.Model.Game;
import br.edu.ifrs.dev2.conexao.Model.Jogador;
import br.edu.ifrs.dev2.conexao.Repository.GameRepository;
import br.edu.ifrs.dev2.conexao.Repository.JogadorRepository;


@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game salvarGame(Game game){
        return gameRepository.save(game);
    }

    public List<GameResponse> listargGames(){
        return gameRepository.findAll()
                .stream()
                .map(game ->
                        GameResponse.builder()
                                .idGame(game.getIdGame())
                                .nomeGame(game.getNomeGame())
                                .image(game.getImage())
                                .anuncios(game.getAnuncios()
                                        .stream()
                                        .map(anuncio -> AnuncioResponse.builder()
                                                .player(anuncio.getJogador().getNome())
                                                .diasSemanas(anuncio.getDiasSemanas())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build()
                ).collect(Collectors.toList());
    }

    public GameResponse pesquisarGamePorId(Long id){
        var game = gameRepository.findById(id).get();
       return GameResponse.builder()
                .idGame(game.getIdGame())
                .nomeGame(game.getNomeGame())
                .image(game.getImage())
                .anuncios(game.getAnuncios()
                        .stream()
                        .map(anuncio -> AnuncioResponse.builder()
                                .player(anuncio.getJogador().getNome())
                                .diasSemanas(anuncio.getDiasSemanas())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public Optional<Game> pesquisarGame(Long id){
        return gameRepository.findById(id);
    }

    public void removerGame(Long id){
        gameRepository.deleteById(id);
    }

}