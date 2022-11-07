package br.edu.ifrs.dev2.conexao.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.dev2.conexao.Model.Jogador;
import br.edu.ifrs.dev2.conexao.Repository.JogadorRepository;


@Service
public class JogadorService {
    @Autowired
    private JogadorRepository jogadorRepository;

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