package br.edu.ifrs.dev2.conexao.Data;

import br.edu.ifrs.dev2.conexao.Model.Jogador;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.edu.ifrs.dev2.conexao.Model.Jogador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalheUsuario implements UserDetails {

    private final Optional<Jogador> jogador;

    public DetalheUsuario(Optional<Jogador> jogador) {
        this.jogador = jogador;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return jogador.orElse(new Jogador()).getPassword();
    }

    @Override
    public String getUsername() {
        return jogador.orElse(new Jogador()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}