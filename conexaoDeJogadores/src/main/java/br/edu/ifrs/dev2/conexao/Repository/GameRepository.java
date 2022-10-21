package br.edu.ifrs.dev2.conexao.Repository;
import br.edu.ifrs.dev2.conexao.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}
