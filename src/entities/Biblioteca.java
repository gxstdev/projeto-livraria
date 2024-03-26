package entities;

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

    public void addLivro(Livro livro) {

        livros.add(livro);
    }

    public void emprestarLivro(Livro livroEmprestado, Usuario usuario) {

        if (livroEmprestado != null && livroEmprestado.isStatus()) {
            livroEmprestado.setStatus(false);

            emprestimos.add(new Emprestimo(livroEmprestado, usuario));
            System.out.printf("Você pegou emprestado o livro %s!", livroEmprestado.getTitulo());
        }else {
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

    public void consultarLivrosDisponiveis(){
        for (Livro livro : livros){
            if(livro.isStatus()){
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

    public void exibirLivrosEmprestados(){
        for(Emprestimo emprestimo : emprestimos){
            System.out.println(emprestimo.getLivro());
        }
    }

    public void devolverLivro(Scanner input) {
        System.out.print("Insira o ID do livro:");
       int idLivro= input.nextInt();
       for(Livro livro : livros){
           if(idLivro == livro.getId()){
               livro.setStatus(true);
           }
       }

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



