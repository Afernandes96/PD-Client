/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.clientmngresponses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henri
 */
public class GetAuthenticatedUsersResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<String> connectedUsers;
    private final List<String> firstFellow;
    private final List<String> secondFellow;

    public GetAuthenticatedUsersResponse(List<String> connectedUsers, List<String> firstFellow, List<String> secondFellow) {
        this.firstFellow = new ArrayList<>(firstFellow);
        this.secondFellow = new ArrayList<>(secondFellow);
        this.connectedUsers = new ArrayList<>(connectedUsers);
    }

    public List<String> getFirstFellow() {
        return firstFellow;
    }

    public List<String> getSecondFellow() {
        return secondFellow;
    }

    public List<String> getConnectedUsers() {
        return connectedUsers;
    }
    
    public boolean isEmpty(){
        return firstFellow.isEmpty();
    }
}
