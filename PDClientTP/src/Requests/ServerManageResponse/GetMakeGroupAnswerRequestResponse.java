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
public class GetMakeGroupAnswerRequestResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final boolean answer;
    private final String opponentName;

    public GetMakeGroupAnswerRequestResponse(boolean answer, String opponentName) {
        this.answer = answer;
        this.opponentName = opponentName;
    }

    public boolean isAnswer() {
        return answer;
    }

    public String getOpponentName() {
        return opponentName;
    }
    
    
}
