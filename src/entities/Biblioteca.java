package entities;

import entities.usuario.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros;
    private List<Emprestimo> emprestimos;
    private List<Usuario> usuarios;

    public Biblioteca() {

        livros = new ArrayList<>();
        emprestimos = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    private void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void emprestarLivro(Livro livroEmprestado, Usuario usuario) {

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
            System.out.println("ID: " + livro.getId());
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Edição: " + livro.getEditora());
            System.out.println("Gênero: " + livro.getGenero());
            System.out.println("Autor: " + livro.getNomeAutor());
            System.out.println("Disponível: " + (livro.isStatus() ? "Sim" : "Não"));
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

    public void exibirLivrosEmprestados() {
        for (Emprestimo emprestimo : emprestimos) {
            Livro livro = emprestimo.getLivro();
            if (!livro.isStatus()) {
                System.out.println(emprestimo.getLivro());
            }
        }
    }

    public void devolverLivro(Scanner input) {
        System.out.print("Insira o ID do livro:");
        int idLivro = input.nextInt();
        for (Livro livro : livros) {
            if (idLivro == livro.getId()) {
                livro.setStatus(true);
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



