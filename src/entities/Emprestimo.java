package entities;

import java.util.Date;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Usuario usuario;
    private Estoque estoque;
    private Date dataImprestimo;
    private Date dataDevolucao;

    public Emprestimo(int id, Livro livro, Usuario usuario, Estoque estoque,
                      Date dataImprestimo, Date dataDevolucao) {
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.estoque = estoque;
        this.dataImprestimo = dataImprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Date getDataImprestimo() {
        return dataImprestimo;
    }

    public void setDataImprestimo(Date dataImprestimo) {
        this.dataImprestimo = dataImprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean emprestar() {
        if (livro.isStatus()){
            livro.setStatus(false);
            //livro.status = !livro.status
            return true;
        }
        return false;
    }

}
