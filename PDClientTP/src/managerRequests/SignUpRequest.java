package managerRequests;

import java.io.Serializable;

public class SignUpRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String nome;
    private final String name;
    private final String password;

    public SignUpRequest(String nome, String name, String password) {
        this.nome = nome;
        this.name = nome;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return name;
    }
}
