package br.edu.ifrs.dev2.conexao.Controller;

import br.edu.ifrs.dev2.conexao.Model.Game;
import br.edu.ifrs.dev2.conexao.Repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
public class GameController {

    private final GameRepository gameRepository;

    @PostMapping
    public Game saveGame(@RequestBody Game gameSave) {
        return this.gameRepository.save(gameSave);
    }
}