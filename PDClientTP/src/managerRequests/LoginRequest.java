package managerRequests;

import java.io.Serializable;

public class LoginRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String password;

    public LoginRequest(String username, String password) {
        this.name = username;
        this.password = password;
    }

    public String getUsername() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}

