package entities;

public class Livro {
    private int id;
    private static int contadorLivros =0;
    private String titulo;
    private String editora;
    private String genero;
    private String nomeAutor;
    private boolean status;

    public Livro(String titulo, String editora,
                 String genero, String nomeAutor, boolean status) {
        this.id = ++contadorLivros;
        this.titulo = titulo;
        this.editora = editora;
        this.genero = genero;
        this.nomeAutor = nomeAutor;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", editora='" + editora + '\'' +
                ", genero='" + genero + '\'' +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

