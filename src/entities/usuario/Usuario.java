package entities.usuario;

import java.util.Objects;

public abstract class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;


    public Usuario(int id,String nome, String cpf, int idade, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public boolean equals(Usuario usuario) {

        return this.id == usuario.id;
    }


}

