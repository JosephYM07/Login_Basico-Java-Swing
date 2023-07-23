package Class;

public class Usuario {
    private String username;
    private String password;
    private String nombres;

    public Usuario(String username, String password, String nombres) {
        this.username = username;
        this.password = password;
        this.nombres = nombres;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNombres() {
        return nombres;
    }
}
