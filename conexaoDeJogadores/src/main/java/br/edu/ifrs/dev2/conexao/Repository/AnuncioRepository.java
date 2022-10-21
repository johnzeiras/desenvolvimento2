package br.edu.ifrs.dev2.conexao.Repository;
import br.edu.ifrs.dev2.conexao.Model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
    
}
