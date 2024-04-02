package entities.Menu;

import entities.Biblioteca;
import entities.Livro;
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
            System.out.println("5. Buscar livro específico");
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
                biblioteca.emprestarLivro(input, usuario);
                break;
            case 3:
                biblioteca.devolverLivro(input, usuario);
                break;
            case 4:
                biblioteca.consultarLivrosDisponiveis();
                break;
            case 5:
                menuBusca(input);
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    public void menuBusca( Scanner scanner) {
        int opcao;
        do {
            System.out.println("\t Busca");
            System.out.println("1. Por autor");
            System.out.println("2. Por título");
            System.out.println("3. Por editora");
            System.out.println("4. Por ISBN");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção de busca: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do autor:");
                    String autor = scanner.nextLine();
                     biblioteca.exibirLivroPorAutor(autor);
                    break;
                case 2:
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();
                    biblioteca.buscarPorTitulo(titulo);

                    break;
                case 3:
                    System.out.println("Digite o nome da editora:");
                    String editora = scanner.nextLine();
                   biblioteca.exibirLivroPorEditora(editora);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}
