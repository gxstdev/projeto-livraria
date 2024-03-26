import entities.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.print("\033[H\033[2J");
        //Runtime.getRuntime().exec("cls");
        Usuario usuario = new Usuario("Guilherme", "123", 24, "1", true);
        Scanner input = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();


        int opcao;
        do {
            menu();
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    inclui(biblioteca, input);
                    break;

                case 2:
                    biblioteca.consultarLivrosDisponiveis();
                    System.out.println("Digite o ID do livro que deseja pegar emprestado: ");
                    int id = input.nextInt();
                    biblioteca.emprestarLivro(biblioteca.encontrarLivroPorId(id),usuario);
                    break;

                case 3:
                    biblioteca.devolverLivro(input);
                    break;

                case 4:
                    biblioteca.consultarLivros();
                    break;
                case 7:
                    biblioteca.exibirLivrosEmprestados();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void menu() {
        System.out.println("\tMenu Principal");
        System.out.println("1. Adicionar livro");
        System.out.println("2. Emprestar livro");
        System.out.println("3. Devolver livro");
        System.out.println("4. Mostrar livros");
        System.out.println("5. Alterar livros");
        System.out.println("6. Excluir livros");
        System.out.println("7. Exibir livros emprestados");
    }

    public static void inclui(Biblioteca biblioteca, Scanner input) {
        System.out.println("Digite o Título: ");
        String titulo = input.nextLine();

        System.out.println("Digite a Editora: ");
        String editora = input.nextLine();

        System.out.println("Digite o Gênero: ");
        String genero = input.nextLine();

        System.out.println("Digite o Nome Autor: ");
        String nomeAutor = input.nextLine();

        biblioteca.addLivro(new Livro(titulo, editora, genero, nomeAutor, true));
        System.out.println("\nLivro adicionado com sucesso!");

    }


    public static void exclui(Biblioteca biblioteca, Livro livro) {
        biblioteca.removerLivro(livro);
    }


}
