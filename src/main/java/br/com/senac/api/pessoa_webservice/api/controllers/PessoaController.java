package br.com.senac.api.pessoa_webservice.api.controllers;

import br.com.senac.api.pessoa_webservice.api.entidades.Pessoa;
import br.com.senac.api.pessoa_webservice.api.repositorios.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Pessoa>>listarPessoas() {
        List<Pessoa> pessoaRetorno = pessoaRepository.findAll();

        return ResponseEntity.ok().body(pessoaRetorno);
    }

    @PostMapping("/criar")
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa novaPessoa = pessoaRepository.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable("id") Long id, @RequestBody Pessoa pessoaAtualizada) {
        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        pessoaAtualizada.setId(id);
        Pessoa pessoa = pessoaRepository.save(pessoaAtualizada);
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable("id") Long id) {
        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        pessoaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
