package br.com.alura.livros.model.repository;

import br.com.alura.livros.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNomeContainingIgnoreCase(String nomeAutor);
    List<Autor> findByAnoFalecimentoIsNullAndAnoNascimentoLessThanEqual(Integer ano);
    List<Autor> findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(Integer ano, Integer ano2);
}