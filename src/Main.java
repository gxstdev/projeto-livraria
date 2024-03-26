import entities.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.print("\033[H\033[2J");
        //Runtime.getRuntime().exec("cls");
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

                    biblioteca.emprestarLivro(input);
                    break;

                case 3:
                    //exclui(biblioteca);
                    break;

                case 4:
                    biblioteca.consultarLivros();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void menu() {
        System.out.println("\tCadastrar livro");
        System.out.println("1. Adicionar livro");
        System.out.println("2. Emprestar livro");
        System.out.println("3. Devolver livro");
        System.out.println("4. Mostrar livros");
        System.out.println("5. Alterar livros");
        System.out.println("6. Excluir livros");
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
    }


    public static void exclui(Biblioteca biblioteca, Livro livro) {
        biblioteca.removerLivro(livro);
    }


}
