/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.clientmngresponses;

import java.io.Serializable;

/**
 *
 * @author henri
 */
public class GetIsLoggedInResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final boolean isLoggenIn;

    public GetIsLoggedInResponse(boolean isLoggenIn) {
        this.isLoggenIn = isLoggenIn;
    }
    
    public boolean isIsLoggenIn() {
        return isLoggenIn;
    }
}
