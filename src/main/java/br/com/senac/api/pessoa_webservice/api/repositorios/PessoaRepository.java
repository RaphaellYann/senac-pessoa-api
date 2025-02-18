package br.com.senac.api.pessoa_webservice.api.repositorios;


import br.com.senac.api.pessoa_webservice.api.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
