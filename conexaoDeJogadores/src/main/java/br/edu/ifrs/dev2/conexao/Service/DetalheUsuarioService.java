package br.edu.ifrs.dev2.conexao.Service;

import br.edu.ifrs.dev2.conexao.Data.DetalheUsuario;
import br.edu.ifrs.dev2.conexao.Model.Jogador;
import br.edu.ifrs.dev2.conexao.Repository.JogadorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsuarioService implements UserDetailsService {

    private final JogadorRepository jogador;

    public DetalheUsuarioService(JogadorRepository jogador) {
        this.jogador = jogador;
    }

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        Optional<Jogador> usuario = jogador.findByLogin(nome);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + nome + "] não encontrado");
        }

        return new DetalheUsuario(usuario);
    }
}