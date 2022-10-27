package br.edu.ifrs.dev2.conexao.Service;
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

}