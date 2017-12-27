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
public class GetNotFinishedGamesResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<String> opponentName;

    public GetNotFinishedGamesResponse(List<String> opponentName) {
        this.opponentName = new ArrayList<>(opponentName);
    }

    public List<String> getOpponentName() {
        return opponentName;
    }
}
