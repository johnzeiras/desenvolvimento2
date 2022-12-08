package br.edu.ifrs.dev2.conexao.Controller;

import br.edu.ifrs.dev2.conexao.Model.dto.AnuncioRequest;
import br.edu.ifrs.dev2.conexao.Model.dto.AnuncioResponse;
import br.edu.ifrs.dev2.conexao.Service.AnuncioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anuncio")
@RequiredArgsConstructor
public class AnuncioController {

    private final AnuncioService anuncioService;

    @PostMapping
    public AnuncioResponse postAnuncio(@RequestBody AnuncioRequest anuncio) {
        return this.anuncioService.save(anuncio);
   }
   @GetMapping
   @ResponseStatus(HttpStatus.OK)
   public List<Anuncio> listaAnuncio(){
       return anuncioService.listarAnuncio();
   }
   
}
