package entities.Menu;

import entities.Biblioteca;
import entities.usuario.Usuario;
import interfaces.Menu;

import java.util.Scanner;

public class MenuUsuarioComum implements Menu {
   final private Biblioteca biblioteca;
    final private Usuario usuario;
     final private Scanner input;

    public MenuUsuarioComum(Biblioteca biblioteca, Usuario usuario, Scanner input) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;
        this.input = input;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\tMenu Usuário Comum");
            System.out.println("1. Visualizar meus empréstimos");
            System.out.println("2. Emprestar livro");
            System.out.println("3. Devolver livro");
            System.out.println("4. Mostrar livros disponíveis");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();
            selecionarOpcao(opcao);
        } while (opcao != 0);
    }

    public void selecionarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("\nHistórico de livros emprestados: \n\n");
                biblioteca.exibirLivrosEmprestados(usuario);
                break;
            case 2:
                biblioteca.emprestarLivro(input,usuario);
                break;
            case 3:
                biblioteca.devolverLivro(input,usuario);
                break;
            case 4:
                biblioteca.consultarLivrosDisponiveis();
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
