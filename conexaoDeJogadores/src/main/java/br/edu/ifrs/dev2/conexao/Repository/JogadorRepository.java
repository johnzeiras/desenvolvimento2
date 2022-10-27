package br.edu.ifrs.dev2.conexao.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifrs.dev2.conexao.Model.Jogador;


public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    public Optional<Jogador> findByLogin(String login);
}
