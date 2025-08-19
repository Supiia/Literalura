package br.com.alura.livros.model.repository;

import br.com.alura.livros.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdiomaContainingIgnoreCase(String idioma);
}