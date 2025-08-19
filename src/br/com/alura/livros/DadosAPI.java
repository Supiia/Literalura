package br.com.alura.livros.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAPI(List<DadosLivro> results) {
}