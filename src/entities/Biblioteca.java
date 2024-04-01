package entities;

import entities.usuario.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros;
    private List<Emprestimo> emprestimos;


    public Biblioteca() {
    //coloquei alguns livros direto na arrayList para fins de teste, já que não temos persistência de dados
        livros = new ArrayList<>(){{
            add(new Livro("A Guerra dos Tronos", "Leya", "Fantasia", "George R. R. Martin", true));
            add(new Livro("O Senhor dos Anéis", "HarperCollins", "Fantasia", "J.R.R. Tolkien", true));
            add(new Livro("1984", "Companhia das Letras", "Ficção Científica", "George Orwell", true));
            add(new Livro("Dom Quixote", "Saraiva", "Romance", "Miguel de Cervantes", true));
            add(new Livro("O Pequeno Príncipe", "Agir", "Infantil", "Antoine de Saint-Exupéry", true));
        }};
        emprestimos = new ArrayList<>();

    }

    public List<Livro> getLivros() {
        return livros;
    }

    private void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void emprestarLivro(Scanner input,Usuario usuario) {
        consultarLivrosDisponiveis();
        System.out.print("Digite o ID do livro que deseja pegar emprestado: ");
        int id = input.nextInt();
        Livro livroEmprestado = encontrarLivroPorId(id);
        if (livroEmprestado != null && livroEmprestado.isStatus()) {
            livroEmprestado.setStatus(false);

            emprestimos.add(new Emprestimo(livroEmprestado, usuario,LocalDate.now(),LocalDate.now().plusDays(7)));

            System.out.println(emprestimos.get(0));
            System.out.printf("Você pegou emprestado o livro %s!%n", livroEmprestado.getTitulo());
        } else {
            System.out.println("Não foi possível pegar o livro emprestado.");
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

    public void exibirLivrosEmprestados(Usuario usuario) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario)) {
                System.out.println(emprestimo);
            }
        }
    }

    public void devolverLivro(Scanner input,Usuario usuario) {
        exibirLivrosEmprestados(usuario);
        System.out.print("Insira o ID do emprestimo:");
        int idEmprestimo = input.nextInt();


        for(Emprestimo emprestimo:emprestimos){
            if(idEmprestimo == emprestimo.getId() && !emprestimo.isDevolvido()){
                emprestimo.getLivro().setStatus(true);
                emprestimo.setDevolvido();
                emprestimo.setDataDevolucao(LocalDate.now());
                System.out.println("\n\nLivro devolvido à biblioteca!\n");
                return;
            }
        }


        System.out.println("\n\nLivro não encontrado!\n");

    }

    public  void incluirLivro( Scanner input) {
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



    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "livros=" + livros +
                '}';
    }
}



