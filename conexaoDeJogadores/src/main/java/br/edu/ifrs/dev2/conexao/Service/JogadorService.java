package br.edu.ifrs.dev2.conexao.Service;

import br.edu.ifrs.dev2.conexao.Model.Jogador;
import br.edu.ifrs.dev2.conexao.Repository.JogadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class JogadorService {
    private final JogadorRepository jogadorRepository;

    public UserDetails loadByUsername(String login) throws UsernameNotFoundException {
        Jogador person = this.jogadorRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Não Autenticação"));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        UserDetails user = new User(person.getLogin(), person.getPassword(), null);
        return user;
    }

    public Jogador salvarJogador(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listarJogador(){
        return jogadorRepository.findAll();
    }

    public Jogador pesquisarJogadorPorId(Long id){
        return jogadorRepository.findById(id).get();
    }

    public Optional<Jogador> pesquisarJogador(Long id){
        return jogadorRepository.findById(id);
    }

    public void removerJogador(Long id){
        jogadorRepository.deleteById(id);
    }

}