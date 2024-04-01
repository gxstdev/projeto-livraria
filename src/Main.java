

import entities.Biblioteca;
import entities.Livro;
import entities.Menu.MenuAdmin;
import entities.Menu.MenuUsuarioComum;
import entities.usuario.Administrador;
import entities.usuario.Usuario;
import entities.usuario.UsuarioComum;
import interfaces.Menu;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.print("\033[H\033[2J");
        //Runtime.getRuntime().exec("cls");

        final Scanner input = new Scanner(System.in);
        Usuario usuario = cadastrarUsuario(input);
        Biblioteca biblioteca = new Biblioteca();
        Menu menu;

        if(usuario instanceof Administrador){
            menu = new MenuAdmin(biblioteca,usuario,input);
        }else {

            menu = new MenuUsuarioComum(biblioteca, usuario, input);
        }

        menu.exibirMenu();
        input.close();
    }

    public static void menuUsuarioComum() {
        System.out.println("\tMenu Principal");
        System.out.println("1. Adicionar livro");
        System.out.println("2. Emprestar livro");
        System.out.println("3. Devolver livro");
        System.out.println("4. Mostrar livros");
        System.out.println("5. Alterar livros");
        System.out.println("6. Excluir livros");
        System.out.println("7. Exibir livros emprestados");
    }

    public static Usuario cadastrarUsuario(Scanner sc) {
        int opcao, idade;
        String nomeUsuario, telefone, cpf;
        System.out.print("Tipos de usuário: \n1.Administrador \n2.Comum\nInsira o tipo de usuário: ");
        opcao = sc.nextInt();
        sc.nextLine();

        System.out.print("Insira o nome de usuário: ");
        nomeUsuario = sc.nextLine();

        System.out.print("Insira o CPF: ");
        cpf = sc.nextLine();

        System.out.print("Insira o telefone: ");
        telefone=sc.nextLine();

        System.out.print("Insira a idade: ");
        idade= sc.nextInt();

        if (opcao == 1) {
            return new Administrador(nomeUsuario,cpf,idade,telefone);
        }
        return new UsuarioComum(nomeUsuario,cpf,idade,telefone);
    }





}
