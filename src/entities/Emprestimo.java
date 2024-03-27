package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Emprestimo {
    private int id;
    private static int contadorDeEmprestimos = 0;
    private Livro livro;
    private Usuario usuario;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;


    public Emprestimo(Livro livro, Usuario usuario,LocalDate dataEmprestimo,LocalDate dataDevolucao) {
        this.id = ++contadorDeEmprestimos;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }


    public Livro getLivro() {
        return livro;
    }


    public Usuario getUsuario() {
        return usuario;
    }



    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\n\n-------------------------------\n"+
                "\nEmpréstimo Nº"+ id +
                "\nLivro: " + livro.getTitulo() +
                "\nUsuário:" + usuario.getNome() +
                "\nData de empréstimo: " + dataEmprestimo.format(formatador) +
                "\nData de devolução: " + dataDevolucao.format(formatador)+
                "\n-------------------------------\n";
    }
}
