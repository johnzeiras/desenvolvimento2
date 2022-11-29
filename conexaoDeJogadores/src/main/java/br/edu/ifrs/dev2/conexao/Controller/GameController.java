package br.edu.ifrs.dev2.conexao.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import br.edu.ifrs.dev2.conexao.Service.GameService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.ifrs.dev2.conexao.Model.Game;

@RestController
@RequestMapping("/Game")
public class GameController {


    @Autowired
    private GameService gameService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game salvaGame(@RequestBody Game game){
        return gameService.salvarGame(game);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Game> listaJogador(){
        return gameService.listargGames();
    }

    @GetMapping("/{gameId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Game> buscar(@PathVariable Long gameID) {
        Game game = gameService.pesquisarGamePorId(gameID);

        if (game != null) {
            return ResponseEntity.ok(game);
        }

        return ResponseEntity.notFound().build();
    }

    	// DELETA JOGADOR SEM LAMBDA
        @DeleteMapping("/{gameId}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public ResponseEntity<Game> remover(@PathVariable Long gameID) {
            try {
                Game game = gameService.pesquisarGamePorId(gameID);
    
                if (game != null) {
                    gameService.removerGame(gameID);
                    return ResponseEntity.noContent().build();
                }
                return ResponseEntity.notFound().build();
            } catch (DataIntegrityViolationException e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }
    // DELETA GAME USANDO LAMBDA SÓ DESCOMENTAR E TESTAR PARA FUNCIONAR IMPORTAR LIBS SE FOR PRECISO	
    // @DeleteMapping("/{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void removerJogador(Long id){
    //     gameService.pesquisarGame(id)
    //         .map(game ->{
    //             gameService.removerGame(game.getIdGame());
    //             return Void.TYPE;
    //         }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game não encontrado."));
    // }

	//METODO PARA ATUALIZAR GAME lambda
    // @PutMapping("/{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void AtualizarGame(@PathVariable("id") Long id, @RequestBody Game game){
    //     gameService.pesquisarGame(id)
    //     .map(gameBase ->{
    //         modelMapper.map(game, gameBase);
    //         return Void.TYPE;
    //     }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game não encontrado."));
    // }

}