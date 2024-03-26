package entities;

import java.util.Date;

public class Emprestimo {
    private int id;
    private static int contadorDeEmprestimos = 0;
    private Livro livro;
    private Usuario usuario;


    public Emprestimo(Livro livro, Usuario usuario) {
        this.id = ++contadorDeEmprestimos;
        this.livro = livro;
        this.usuario = usuario;
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



//    public Date getDataEmprestimo() {
//        return dataEmprestimo;
//    }
//
//    public void setDataEmprestimo(Date dataEmprestimo) {
//        this.dataEmprestimo = dataEmprestimo;
//    }
//
//    public Date getDataDevolucao() {
//        return dataDevolucao;
//    }
//
//    public void setDataDevolucao(Date dataDevolucao) {
//        this.dataDevolucao = dataDevolucao;
//    }


}
