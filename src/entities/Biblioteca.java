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
        livro.setId(livros.size());
        livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }
    @Override
    public String toString() {
        return "Biblioteca{" +
                "livros=" + livros +
                '}';
    }
}
