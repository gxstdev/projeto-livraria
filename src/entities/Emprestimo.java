package entities;

import entities.usuario.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private int id;
    private static int contadorDeEmprestimos = 0;
    private Livro livro;
    private Usuario usuario;

    private LocalDate dataEmprestimo;

    private LocalDate dataLimiteDevolucao;

    private boolean devolvido;

    private LocalDate dataDevolucao;


    public Emprestimo(Livro livro, Usuario usuario,LocalDate dataEmprestimo,LocalDate dataLimiteDevolucao) {
        this.id = ++contadorDeEmprestimos;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataLimiteDevolucao = dataLimiteDevolucao;
        this.devolvido=false;
        this.dataDevolucao=null;
    }

    public int getId() {
        return id;
    }


    public Livro getLivro() {
        return livro;
    }

    public boolean isDevolvido() {
        return devolvido;
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

    public LocalDate getDataLimiteDevolucao() {
        return dataLimiteDevolucao;
    }

    public void setDataDevolucao(LocalDate data){
        this.dataDevolucao = data;
    }

    public void setDevolvido() {
        this.devolvido = !this.devolvido;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\n\n-------------------------------\n"+
                "\nEmpréstimo Nº"+ id +
                "\nLivro: " + livro.getTitulo() +
                "\nUsuário:" + usuario.getNome() +
                "\nData de empréstimo: " + dataEmprestimo.format(formatador) +
                "\nData limite para devolução: " + dataLimiteDevolucao.format(formatador)+
                (isDevolvido()? "\nDevolvido em: " + dataDevolucao.format(formatador):"")+
                "\n-------------------------------\n";
    }
}
