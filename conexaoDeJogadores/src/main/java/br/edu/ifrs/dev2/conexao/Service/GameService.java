package br.edu.ifrs.dev2.conexao.Service;
import java.util.List;
import java.util.Optional;

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

    public List<Game> listargGames(){
        return gameRepository.findAll();
    }

    public Game pesquisarGamePorId(Long id){
        return gameRepository.findById(id).get();
    }

    public Optional<Game> pesquisarGame(Long id){
        return gameRepository.findById(id);
    }

    public void removerGame(Long id){
        gameRepository.deleteById(id);
    }

}