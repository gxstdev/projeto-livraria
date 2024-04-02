package entities.Menu;

import com.sun.tools.javac.Main;
import entities.Biblioteca;
import entities.usuario.Usuario;
import interfaces.Menu;

import java.util.Scanner;

public class MenuAdmin implements Menu {
    final private Biblioteca biblioteca;
    final private Usuario usuario;
    final private Scanner input;

    public MenuAdmin(Biblioteca biblioteca, Usuario usuario, Scanner input) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;
        this.input = input;
    }

    public void exibirMenu() {

        int opcao;
        do {
            System.out.println("\tMenu Administrativo");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Remover livro");
            System.out.println("3. Alterar livro");
            System.out.println("4. Visualizar livros");
            System.out.println("5. Visualizar empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            opcao = verificarOpcao(biblioteca, opcao);
            input.nextLine();
            selecionarOpcao(opcao);
        } while (opcao != 0);
    }

    public static int verificarOpcao(Biblioteca biblioteca, int opcao){
        if (opcao > 1 && biblioteca.getLivros().isEmpty()){
            System.out.println("\nAção não pode ser realizada! Ainda não existem livros cadastrados.\n");
            return 6;
        }
        return opcao;
    }
    public void selecionarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                biblioteca.incluirLivro(input);
                break;
            case 2:
                biblioteca.removerLivro(input);
                break;
            case 3:
                biblioteca.alterarLivro(input);
                break;
            case 4:
                biblioteca.consultarLivros();
                break;
            case 5:
                biblioteca.exibirTodosOsEmprestimos();
                break;
            case 6:
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }
}
