package managerRequests;

import java.io.Serializable;

public class MakeParingRequest implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String user;

    public MakeParingRequest(String name, String user) {
        this.name = name;
        this.user = user;
    }

    public String getUsername() {
        return name;
    }

    public String getFellowName() {
        return user;
    }
}

