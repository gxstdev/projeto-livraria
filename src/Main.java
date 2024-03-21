import entities.Emprestimo;
import entities.Estoque;
import entities.Livro;
import entities.Usuario;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Livro l1 = new Livro(0, "Livro 1", "E1", "Fic",
                "Autor 1", true);

        Usuario u1 = new Usuario("Gabriela",
                "0000-000", 25, "00000");

        Estoque estoque1 = new Estoque();

        Date dtEmprestimo = new Date();

        Date dtDevolucao = new Date();

        Emprestimo emprestimo = new Emprestimo(0, l1, u1, estoque1,
                dtEmprestimo, dtDevolucao);

        System.out.printf("Deseja pegar o livro %s? Y/N", l1.getTitulo());
        char opt = input.nextLine().charAt(0);

        System.out.printf("Status inicial livro: %s%n", l1.isStatus());

        if (opt == 'Y'){
            if (emprestimo.emprestar()){
                System.out.println("Livro emprestado!");
            }else {
                System.out.println("Livro indisponível!");
            }
        }

        System.out.printf("Livro depois de emprestado: %s",l1.isStatus());
    }
}
