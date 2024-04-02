package entities;

import entities.usuario.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private final List<Livro> livros;
    private final List<Emprestimo> emprestimos;

    public Biblioteca() {
        //coloquei alguns livros direto na arrayList para fins de teste, já que não temos persistência de dados
        livros = new ArrayList<>() /*{{
            add(new Livro("A Guerra dos Tronos", "Leya", "Fantasia", "George R. R. Martin", true));
            add(new Livro("O Senhor dos Anéis", "HarperCollins", "Fantasia", "J.R.R. Tolkien", true));
            add(new Livro("1984", "Companhia das Letras", "Ficção Científica", "George Orwell", true));
            add(new Livro("Dom Quixote", "Saraiva", "Romance", "Miguel de Cervantes", true));
            add(new Livro("O Pequeno Príncipe", "Agir", "Infantil", "Antoine de Saint-Exupéry", false));
        }}*/;
        emprestimos = new ArrayList<>();

    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void emprestarLivro(Scanner input, Usuario usuario) {
        consultarLivrosDisponiveis();
        System.out.print("Digite o ID do livro que deseja pegar emprestado: ");
        int id = input.nextInt();
        Livro livroEmprestado = encontrarLivroPorId(id);
        if (livroEmprestado != null && livroEmprestado.isStatus()) {
            livroEmprestado.setStatus(false);

            emprestimos.add(new Emprestimo(livroEmprestado, usuario, LocalDate.now(), LocalDate.now().plusDays(7)));

            System.out.println(emprestimos.get(0));
            System.out.printf("Você pegou emprestado o livro %s!%n", livroEmprestado.getTitulo());
        } else {
            System.out.println("Não foi possível pegar o livro emprestado.\n");
        }
    }

    public void consultarLivros() {
        System.out.println("Livros na biblioteca:");
        for (Livro livro : this.livros) {
            System.out.println("\n\n----------------------------------");
            System.out.println("ID: " + livro.getId());
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Edição: " + livro.getEditora());
            System.out.println("Gênero: " + livro.getGenero());
            System.out.println("Autor: " + livro.getNomeAutor());
            System.out.println("Disponível: " + (livro.isStatus() ? "Sim" : "Não"));
            System.out.println("\n\n----------------------------------");

        }
    }

    public void consultarLivrosDisponiveis() {
        for (Livro livro : livros) {
            if (livro.isStatus()) {
                System.out.println(livro);
            }
        }
    }

    public Livro encontrarLivroPorId(int id) {
        for (Livro livro : getLivros()) {
            if (id == livro.getId()) {
                return livro;
            }
        }
        return null;
    }

    public void exibirLivroPorAutor(String autor) {
        for (Livro livro : livros) {
            if (livro.getNomeAutor().equalsIgnoreCase(autor)) {
                System.out.println(livro);
            }
        }
    }

    public void exibirLivroPorEditora(String editora) {
        for (Livro livro : livros) {
            if (livro.getEditora().equalsIgnoreCase(editora)) {
                System.out.println(livro);
            }
        }
    }

    public void buscarPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(livro);
            }
        }
    }

    public void exibirLivrosEmprestados(Usuario usuario) {
        if (emprestimos.isEmpty()) {
            System.out.println("Você ainda não pegou livros emprestados.\n");
        } else {
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getUsuario().equals(usuario)) {
                    System.out.println(emprestimo);
                }
            }
        }
    }

    public void exibirTodosOsEmprestimos() {
        emprestimos.forEach(System.out::println);
    }

    public void devolverLivro(Scanner input, Usuario usuario) {
        exibirLivrosEmprestados(usuario);
        System.out.print("Insira o ID do emprestimo:");
        int idEmprestimo = input.nextInt();

        for (Emprestimo emprestimo : emprestimos) {
            if (idEmprestimo == emprestimo.getId() && !emprestimo.isDevolvido()) {
                emprestimo.getLivro().setStatus(true);
                emprestimo.setDevolvido();
                emprestimo.setDataDevolucao(LocalDate.now());
                System.out.println("\n\nLivro devolvido à biblioteca!\n");
                return;
            }
        }
        System.out.println("\n\nLivro não encontrado!\n");

    }

    public void incluirLivro(Scanner input) {
        System.out.println("Digite o Título: ");
        String titulo = input.nextLine();

        System.out.println("Digite a Editora: ");
        String editora = input.nextLine();

        System.out.println("Digite o Gênero: ");
        String genero = input.nextLine();

        System.out.println("Digite o Nome Autor: ");
        String nomeAutor = input.nextLine();

        this.addLivro(new Livro(titulo, editora, genero, nomeAutor, true));
        System.out.println("\nLivro adicionado com sucesso!");

    }

    public void removerLivro(Scanner input) {
        this.consultarLivros();
        int idLivro;
        System.out.println("Informe o ID de um livro para exluir: ");
        idLivro = input.nextInt();

        Livro livroExclusao = encontrarLivroPorId(idLivro);

        while (livroExclusao == null) {
            System.out.printf("Não existe nenhum livro com o ID : %s\n", idLivro);
            System.out.println("Informe o ID de um livro para exluir: ");
            idLivro = input.nextInt();
            livroExclusao = encontrarLivroPorId(idLivro);
        }

        if (!livroExclusao.isStatus()) {
            System.out.printf("Não foi possível realizar a Exclusão\n" +
                    "O livro '%s' está emprestado no momento", livroExclusao.getTitulo());
            return;
        }

        livros.remove(livroExclusao);
        System.out.println("Livro excluído com sucesso!");

    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "livros=" + livros +
                '}';
    }

    public void alterarLivro(Scanner input) {
    }
}
