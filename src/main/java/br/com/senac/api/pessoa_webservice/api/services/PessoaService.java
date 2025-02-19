package br.com.senac.api.pessoa_webservice.api.services;

import br.com.senac.api.pessoa_webservice.api.entidades.Pessoa;
import br.com.senac.api.pessoa_webservice.api.repositorios.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa){
        try{
            Pessoa pessoaResult = pessoaRepository.save(pessoa);

            return pessoaResult;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
