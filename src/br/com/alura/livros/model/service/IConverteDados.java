package br.com.alura.livros.model.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}