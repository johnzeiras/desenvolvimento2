package br.edu.ifrs.dev2.conexao.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifrs.dev2.conexao.Model.Jogador;


public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    
}
