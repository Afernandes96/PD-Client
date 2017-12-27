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
public class GetAnyMakeGroupRequestResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final boolean hasRequest;
    private final String opponentName;

    public GetAnyMakeGroupRequestResponse(boolean hasRequest, String opponentName) {
        this.hasRequest = hasRequest;
        this.opponentName = opponentName;
    }

    public boolean hasRequest() {
        return hasRequest;
    }

    public String getOpponentName() {
        return opponentName;
    }
    
    
}
