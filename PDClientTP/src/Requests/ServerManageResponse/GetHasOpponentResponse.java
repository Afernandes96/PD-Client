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
public class GetHasOpponentResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private final boolean hasOpponent;
    private final String fellowName;

    public GetHasOpponentResponse(boolean hasOpponent,String fellowName) {
        this.hasOpponent = hasOpponent;
        this.fellowName = fellowName;
    }

    public boolean isHasOpponent() {
        return hasOpponent;
    }
    public String getFellowName() {
        if(fellowName == null)
            return "Unknown";
        
        return fellowName;
    }
}
