/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.clientmngresponses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author henri
 */
public class GetHistoryGamesResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<String> opponentName;
    private final List<Integer> score;

    public GetHistoryGamesResponse(List<String> opponentName, List<Integer> score) {
        this.opponentName = new ArrayList<>(opponentName);
        this.score = new ArrayList<>(score);
    }

    public List<String> getOpponentName() {
        return opponentName;
    }

    public List<Integer> getScore() {
        return score;
    }
    
    
}
