# Conversor de Moedas

Este é um projeto simples de um conversor de moedas, desenvolvido em Java. Ele foi criado como parte de um desafio da Alura para consolidar o aprendizado em orientação a objetos e consumo de APIs.

## Funcionalidades
O programa permite converter valores entre diferentes moedas, obtendo as taxas de câmbio em tempo real através de uma API.

- **Conversão de Moedas:** Converte um valor de uma moeda para outra, baseando-se nas taxas atuais.

## Tecnologias Utilizadas
- **Linguagem de Programação:** Java
- **API de Câmbio:** O projeto consome uma API de conversão de moedas para obter as taxas de câmbio atualizadas. A chave da API é gerenciada de forma segura.
- **IDE:** IntelliJ IDEA

## Como Executar
Siga os passos abaixo para rodar o projeto na sua máquina local:

1.  **Pré-requisitos:**
    - Garanta que você tenha o [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) instalado (versão 11 ou superior).
    - Certifique-se de ter uma chave de API válida para a API de conversão de moedas.

2.  **Configuração do Projeto:**
    - Clone este repositório para o seu ambiente local:
      ```bash
      git clone [https://github.com/Supiia/Challengue-Conversor-de-moedas.git](https://github.com/Supiia/Challengue-Conversor-de-moedas.git)
      ```
    - Abra o projeto no seu IntelliJ IDEA.

3.  **Configuração da Chave de API:**
    - No arquivo `ConversorDeMoedas.java`, localize a linha onde a chave de API é definida:
      ```java
      private String chaveApi;
      ```
    - Substitua a chave de API `chaveApi` pela sua chave obtida do serviço de conversão.

4.  **Compilar e Rodar:**
    - A partir da IDE, compile o projeto.
    - Execute a classe `PrincipalConversorMoedas.java`.
    - O programa irá rodar no console, solicitando a entrada de dados para a conversão.

## Estrutura do Projeto
- `src/`: Contém todo o código-fonte Java.
- `src/br/com/alura/conversores/`: Pacote com as classes principais do conversor.
    - `ConversorDeMoedas.java`: Lógica principal para consumir a API e realizar a conversão.
    - `PrincipalConversorMoedas.java`: Classe principal com a função `main` para a execução do programa.

## Contribuições
Contribuições são bem-vindas! Se você encontrar um bug ou tiver uma melhoria para sugerir, sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_.

## Autor
- **Supiia** - Desenvolvedor(a)

## Licença
Este projeto está sob a licença [MIT License](https://github.com/git/git-scm.com/blob/main/MIT-LICENSE.txt).