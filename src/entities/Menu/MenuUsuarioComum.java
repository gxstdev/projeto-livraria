package entities.Menu;

import entities.Biblioteca;
import entities.usuario.Usuario;
import interfaces.Menu;

import java.util.Scanner;

class MenuUsuarioComum implements Menu {
    private Biblioteca biblioteca;
    private Usuario usuario;
    private Scanner input;

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
                visualizarEmprestimos();
                break;
            case 2:
                emprestarLivro();
                break;
            case 3:
                devolverLivro();
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
