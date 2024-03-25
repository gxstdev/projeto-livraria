package entities;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "livros=" + livros +
                '}';
    }
}
