
public class Cadastro {

    private String nome;
    private String sobrenome;
    private String email;
    private String permiss;

    public Cadastro(String nome, String sobrenome, String email, String permisss) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.permiss = permisss;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getPermiss() {
        return permiss;
    }

    public String toString() {
        return "Nome completo: " + nome + " " + sobrenome + "; Email: " + email + "; Permissão: " + permiss + ".";
    }
}
