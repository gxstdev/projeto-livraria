package entities.usuario;

public class Administrador extends Usuario {
    private static int contadorUsuarios;
    public Administrador (String nome, String cpf, int idade, String telefone){
        super(++contadorUsuarios,nome,cpf,idade,telefone);
    }
}
