package entities.usuario;

public class UsuarioComum extends Usuario{
    private static int contadorUsuarios=0;
    public UsuarioComum (String nome, String cpf, int idade, String telefone){
        super(++contadorUsuarios,nome,cpf,idade,telefone);
    }
}
