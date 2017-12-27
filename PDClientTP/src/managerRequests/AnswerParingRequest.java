
package managerRequests;

import java.io.Serializable;

public class AnswerParingRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String name;
    private final boolean resp;

    public AnswerParingRequest(String name, boolean resp) {
        this.name = name;
        this.resp = resp;
    }

    public String getUsername() {
        return name;
    }

    public boolean isResp() {
        return resp;
    } 
}