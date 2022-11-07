package br.edu.ifrs.dev2.conexao.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.ifrs.dev2.conexao.Model.Jogador;
import br.edu.ifrs.dev2.conexao.Repository.JogadorRepository;
import br.edu.ifrs.dev2.conexao.Service.JogadorService;

@RestController
@RequestMapping("/Jogador")
public class JogadorController {
    //CASO JWT NAO FUNCIONE
    private int details_code = 0;
	//CASO JWT NAO FUNCIONE
	private String details_message = "";
    @Autowired
    private final JogadorRepository jogadorRepository;

    private final PasswordEncoder encoder;

    @Autowired
    private JogadorService jogadorService;

    public JogadorController(JogadorRepository jogadorRepository, PasswordEncoder encoder) {
        this.jogadorRepository = jogadorRepository;
        this.encoder = encoder;
    }


    //VALIDA USANDO JWT 
    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login, @RequestParam String password) {

        Optional<Jogador> optUsuario = jogadorRepository.findByLogin(login);
        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Jogador usuario = optUsuario.get();
        boolean valid = encoder.matches(password, usuario.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }

   //SALVA USANDO JWT 
    @PostMapping("/salvar")
    public ResponseEntity<Jogador> salvar(@RequestBody Jogador usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(jogadorRepository.save(usuario));
    }

   


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogador salvaJogador(@RequestBody Jogador jogador){
        return jogadorService.salvarJogador(jogador);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Jogador> listaJogador(){
        return jogadorService.listarJogador();
    }


    @GetMapping("/{jogadorId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Jogador> buscar(@PathVariable Long jogadorID) {
        Jogador jogador = jogadorService.pesquisarJogadorPorId(jogadorID);

        if (jogador != null) {
            return ResponseEntity.ok(jogador);
        }

        return ResponseEntity.notFound().build();
    }


	// DELETA JOGADOR SEM LAMBDA
    @DeleteMapping("/{jogadorId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Jogador> remover(@PathVariable Long jogadorID) {
        try {
            Optional<Jogador> jogador = jogadorService.pesquisarJogador(jogadorID);

            if (jogador != null) {
                jogadorService.removerJogador(jogadorID);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }



// DELETE USANDO LAMBDA SÓ DESCOMENTAR E TESTAR PARA FUNCIONAR IMPORTAR LIBS SE FOR PRECISO	
    // @DeleteMapping("/{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void removerJogador(Long id){
    //     jogadorService.pesquisarJogador(id)
    //         .map(jogador ->{
    //             jogadorService.removerJogador(jogador.getIdJogador());
    //             return Void.TYPE;
    //         }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado."));
    // }


	//METODO PARA ATUALIZAR 
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void AtualizarJogador(@PathVariable("id") Long id, @RequestBody Jogador jogador){
        jogadorService.pesquisarJogador(id)
        .map(jogadorBase ->{
            modelMapper.map(jogador, jogadorBase);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado."));
    }


   //SALVA JOGADOR MODO PADRÃO  
// @PostMapping
// @ResponseStatus(HttpStatus.CREATED)
// public Jogador salvar(@RequestBody Jogador jogador){
//     return jogadorService.salvarJogador(jogador);
//     }


    
	// @PostMapping
	// @RequestMapping("/Login")
	// public String validaLogin ( String token) throws Exception{
	// 	try{
    //     boolean autorizado =  validaToken(token);
	// 		if(autorizado)
	// 	    return "MANDA PRA TELA INICIAL";	
    //         else
    //         return "ERRO NO LOGIN USUARIO NÃO AUTORIZADO";		
	// 	}
	// 	catch (Exception e) {
	// 		return "ERRO NO LOGIN MOTIVO "+ e;
	// 	}
	// 	finally {
	// 		System.out.println("ok");
	// 	}
	// }



    //MÉTODO PARA VALIDAÇÃO FEITO NA MÃO CASO NÃO CONSIGA RODAR USANDO JWT
    // public boolean validaToken(String token) throws Exception {
	// 	DBConnectionManager db = DBConnectionManager.getInstance(); // conexão com MYSQL
	// 	Connection con = db.getConnection("validaToken", false);
	// 	ResultSet rs = null;
	// 	PreparedStatement pstmt = null;		
	// 	try{
	// 		String usuToken = "";
	// 		pstmt = con.prepareStatement("SELECT usuToken FROM tokens");
	// 		rs = pstmt.executeQuery();
	// 		if(rs.next())
    //         usuToken = rs.getString("usuToken");
			
	// 		if(token == null || !token.equals(usuToken)) {
	// 			this.details_message = "Não autorizado!";
	// 			this.details_code = 401;
	// 			return false;
	// 		}
				
	// 		return true;
			
	// 	}catch(Exception e){
	// 		this.details_message = "Problema ao validar token: " + e;
	// 		this.details_code = 500;
	// 		return false;
	// 	}finally{
	// 		System.out.println("ok");
	// 		db.freeConnection(con,"validaToken");
	// 	}
	// }
}