package br.edu.ifrs.dev2.conexao.Controller;

import br.edu.ifrs.dev2.conexao.Model.Anuncio;
import br.edu.ifrs.dev2.conexao.Model.dto.AnuncioRequest;
import br.edu.ifrs.dev2.conexao.Model.dto.AnuncioResponse;
import br.edu.ifrs.dev2.conexao.Service.AnuncioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("anuncio")
@RequiredArgsConstructor
public class AnuncioController {

    private final AnuncioService anuncioService;

    @PostMapping
    public AnuncioResponse postAnuncio(@RequestBody @Valid AnuncioRequest anuncio) {
        return this.anuncioService.save(anuncio);
   }
   @GetMapping
   @ResponseStatus(HttpStatus.OK)
   public List<Anuncio> listaAnuncio(){
       return anuncioService.listarAnuncio();
   }
   
}
