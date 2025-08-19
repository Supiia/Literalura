package br.com.alura.livros.model.principal;

import br.com.alura.livros.Autor;
import br.com.alura.livros.Livro;
import br.com.alura.livros.model.repository.AutorRepository;
import br.com.alura.livros.model.repository.LivroRepository;
import br.com.alura.livros.model.service.ConsumoApi;
import br.com.alura.livros.model.service.ConverteDados;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Buscar livro por título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma

                    0 - Sair
                    """;
            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroPorTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosPorAno();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void buscarLivroPorTitulo() {
        System.out.println("Digite o título do livro:");
        var nomeLivro = leitura.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeLivro.replace(" ", "%20"));
        var dadosApi = conversor.obterDados(json, DadosAPI.class);

        Optional<DadosLivro> dadosLivro = dadosApi.results().stream().filter(l -> l.titulo().toLowerCase().contains(nomeLivro.toLowerCase())).findFirst();

        if (dadosLivro.isPresent()) {
            DadosLivro livroEncontrado = dadosLivro.get();
            DadosAutor dadosAutor = livroEncontrado.autores().get(0);

            Autor autor = new Autor(dadosAutor);
            Livro livro = new Livro(livroEncontrado);
            livro.setAutor(autor);

            autorRepository.save(autor);
            livroRepository.save(livro);

            System.out.println("Livro encontrado e salvo: ");
            System.out.println(livro);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    private void listarLivrosRegistrados() {
        livroRepository.findAll().forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        autorRepository.findAll().forEach(System.out::println);
    }

    private void listarAutoresVivosPorAno() {
        System.out.println("Digite o ano para buscar autores vivos:");
        var ano = leitura.nextInt();
        leitura.nextLine();

        List<Autor> autoresVivos = autorRepository.findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(ano, ano);
        autoresVivos.forEach(System.out::println);
    }

    private void listarLivrosPorIdioma() {
        System.out.println("Digite o idioma para buscar livros (en, pt, es):");
        var idioma = leitura.nextLine();

        List<Livro> livrosPorIdioma = livroRepository.findByIdiomaContainingIgnoreCase(idioma);
        livrosPorIdioma.forEach(System.out::println);
    }
}