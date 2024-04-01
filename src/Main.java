import entities.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.print("\033[H\033[2J");
        //Runtime.getRuntime().exec("cls");
        Scanner input = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        Livro l1 = new Livro(0, "Livro 1", "E1", "Fic",
                "Autor 1", true);

        int opcao;
        do{
            menu();
            opcao = input.nextInt();
            switch(opcao){
                case 1:
                    inclui(biblioteca, l1);
                    break;

                case 2:
                    altera();
                    break;

                case 3:
                    exclui();
                    break;

                case 4:
                    consulta(biblioteca);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
    }
    public static void menu(){
        System.out.println("\tCadastrar livro");
        System.out.println("1. Adicionar livro");
        System.out.println("2. Emprestar livro");
        System.out.println("3. Devolver livro");
        System.out.println("4. Mostrar livros");
    }
    public static void inclui(Biblioteca biblioteca, Livro livro){
        biblioteca.addLivro(livro);
    }

    public static void altera(){
        System.out.println("Você entrou no método Altera.");
    }

    public static void exclui(){
        System.out.println("Você entrou no método Exclui.");
    }

    public static void consulta(Biblioteca biblioteca){
        System.out.println(biblioteca);
    }
}
