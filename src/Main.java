public class Main {
    public static void main(String[] args) {
        
        FazerLogin login = new FazerLogin();

        String permissao = login.fazerLogin();

        if (permissao != null && permissao.equals("admin")) {
            new MenuAdministrador().exibirMenu();
        } else if (permissao != null && permissao.equals("usuario")) {
            new MenuUsuario().exibirMenu();
        } else {
            System.out.println("Falha no login ou permissão inválida.");
        }
    }
}
