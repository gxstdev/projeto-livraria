package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void addLivro(Livro livro) {

        livros.add(livro);
    }

    public void emprestarLivro(Scanner input){
        consultarLivros();
        System.out.println("Digite o ID do livro que deseja pegar emprestado: ");
        int id = input.nextInt();
        for (Livro livro : getLivros()){
            if (livro.getId() == id){
                livro.setStatus(false);
                System.out.printf("Você pegou emprestado o livro %s!", livro);
            }
        }
    }

    public void consultarLivros(){
        System.out.println("Livros na biblioteca:");
        for (Livro livro : getLivros()) {
            System.out.println("ID: " + livro.getId());
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Edição: " + livro.getEditora());
            System.out.println("Gênero: " + livro.getGenero());
            System.out.println("Autor: " + livro.getNomeAutor());
            System.out.println("Disponível: " + (livro.isStatus() ? "Sim" : "Não"));
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
